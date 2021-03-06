package com.uyoung.web.handler;

import com.uyoung.core.api.bean.ActivityConditionBean;
import com.uyoung.core.api.enums.ActivityScheduleTypeEnum;
import com.uyoung.core.api.enums.ActivitySignUpStatusEnum;
import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.core.api.enums.ActivityTypeEnum;
import com.uyoung.core.api.model.ActivityInfo;
import com.uyoung.core.api.model.ActivitySignUp;
import com.uyoung.core.api.model.UserInfo;
import com.uyoung.core.api.schedule.ActivityScheduleTask;
import com.uyoung.core.api.schedule.ActivityTaskScheduler;
import com.uyoung.core.api.service.ActivityInfoService;
import com.uyoung.core.api.service.ActivitySignUpService;
import com.uyoung.core.api.service.UserInfoService;
import com.uyoung.core.base.bean.Page;
import com.uyoung.web.vo.ActivityInfoVo;
import com.uyoung.web.vo.ActivityStatusVo;
import com.uyoung.web.vo.ActivityTypeVo;
import com.uyoung.web.vo.SignUpUserVo;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User: KennyZhu
 * Date: 15/10/12
 * Desc:
 */
@Service("activityInfoHandler")
public class ActivityInfoHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityInfoHandler.class);
    @Autowired
    private ActivityInfoService activityInfoService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private ActivitySignUpService signUpService;

    @Autowired
    private ActivityTaskScheduler schedule;

    /**
     * 批量获取活动信息
     *
     * @param page
     * @param pageSize
     * @param statusEnum
     * @param uid
     * @return
     */
    public Page<ActivityInfoVo> getPageByStatus(int page, int pageSize, ActivityStatusEnum statusEnum, Integer uid) {
        Page<ActivityInfoVo> result = new Page<>();
        result.setPageSize(pageSize);
        result.setPageNum(page);
        Page<ActivityInfo> activityInfoPage = activityInfoService.getPageByStatus(page, pageSize, statusEnum, uid);
        if (activityInfoPage == null || CollectionUtils.isEmpty(activityInfoPage.getDataList())) {
            return result;
        }
        result.setDataList(convertToVoList(activityInfoPage.getDataList()));
        return result;
    }

    private void buildAvatarUrl(ActivityInfoVo activityInfoVo, Map<Integer, UserInfo> userInfoMap) {
        if (userInfoMap.get(activityInfoVo.getOriUserId()) != null) {
            activityInfoVo.setOriUserNickName(userInfoMap.get(activityInfoVo.getOriUserId()).getNickName());
            activityInfoVo.setOriUserAvatarUrl(userInfoMap.get(activityInfoVo.getOriUserId()).getAvatarUrl());
        } else {
            LOGGER.warn("#Can not found userInfo by userId:" + activityInfoVo.getOriUserId());
        }
    }

    public ActivityInfoVo getActivityInfoById(int id) {
        ActivityInfo info = activityInfoService.getById(id);
        if (info == null) {
            return null;
        }
        ActivityInfoVo result = new ActivityInfoVoBuilder(info).buildBase().buildDetail().buildOriUserInfo().getInfoVo();
        result.setSignUpUserList(buildSignUpUserVosByActivityId(id));
        return result;
    }

    /**
     * 构建活动相关的报名用户
     *
     * @param activityId
     * @return
     */
    public List<SignUpUserVo> buildSignUpUserVosByActivityId(Integer activityId) {
        List<ActivitySignUp> signUps = signUpService.getListByActivityId(activityId);
        if (CollectionUtils.isEmpty(signUps)) {
            Collections.emptyList();
        }
        LOGGER.info("#Get signUps by activityId:" + activityId + " return size:" + signUps.size());
        List<SignUpUserVo> result = new ArrayList<>(signUps.size());
        List<Integer> uidList = new ArrayList<>(signUps.size());
        for (ActivitySignUp signUp : signUps) {
            uidList.add(signUp.getUserId());
        }
        Map<Integer, UserInfo> userInfoMap = userInfoService.getMapByIdList(uidList);
        if (userInfoMap == null || userInfoMap.size() == 0) {
            return Collections.emptyList();
        }

        for (ActivitySignUp signUp : signUps) {
            UserInfo userInfo = userInfoMap.get(signUp.getUserId());
            LOGGER.info("#Get UserInfo by userId :" + signUp.getUserId() + " return :" + userInfo);
            if (userInfo != null) {
                SignUpUserVo signUpUserVo = new SignUpUserVo();
                signUpUserVo.setAvatar(userInfoMap.get(signUp.getUserId()).getAvatarUrl());
                signUpUserVo.setNickName(userInfo.getNickName());
                signUpUserVo.setUid(userInfo.getId());
                signUpUserVo.setIsConfirm(ActivitySignUpStatusEnum.CONFIRM.getStatus() == signUp.getStatus());
                result.add(signUpUserVo);
            }
        }
        LOGGER.info("#Get signUps by activityId:" + activityId + " return size:" + userInfoMap.size() + " result size is " + result.size());
        return result;
    }

    /**
     * 获取所有活动类型
     *
     * @return
     */
    public List<ActivityTypeVo> getAllActivityTypes() {
        List<ActivityTypeVo> result = new ArrayList<>(ActivityTypeEnum.values().length);
        for (ActivityTypeEnum typeEnum : ActivityTypeEnum.values()) {
            result.add(new ActivityTypeVo(typeEnum));
        }
        return result;
    }

    /**
     * 获取所有活动状态
     *
     * @return
     */
    public List<ActivityStatusVo> getAllActivityStatus() {
        List<ActivityStatusVo> result = new ArrayList<>(ActivityStatusEnum.values().length);
        for (ActivityStatusEnum statusEnum : ActivityStatusEnum.values()) {
            result.add(new ActivityStatusVo(statusEnum));
        }
        return result;
    }

    /**
     * 创建活动
     *
     * @param activityInfo
     * @return
     */
    public void createActivity(ActivityInfo activityInfo) {
        int createResult = activityInfoService.add(activityInfo);
        if (createResult == 0) {
            return;
        }
        ActivitySignUp activitySignUp = new ActivitySignUp();
        activitySignUp.setActivityId(activityInfo.getId());
        activitySignUp.setUserId(activityInfo.getOriUserId());
        activitySignUp.setStatus(ActivitySignUpStatusEnum.SUCCESS.getStatus());
        signUpService.add(activitySignUp);
        try {
            schedule.add(new ActivityScheduleTask(activityInfo, ActivityScheduleTypeEnum.BEGIN));
        } catch (Exception e) {
            LOGGER.error("#Add to scheduler error.Task is " + activityInfo.toString());
        }
    }

    /**
     * 根据条件获取所有的
     *
     * @param conditionBean
     * @param page
     * @param pageSize
     * @return
     */
    public Page<ActivityInfoVo> getPageByCondition(ActivityConditionBean conditionBean, int page, int pageSize) {
        Page<ActivityInfoVo> result = new Page<>();
        result.setPageSize(pageSize);
        result.setPageNum(page);
        Page<ActivityInfo> activityInfoPage = activityInfoService.getPageByCondition(conditionBean, page, pageSize);
        if (activityInfoPage == null || CollectionUtils.isEmpty(activityInfoPage.getDataList())) {
            LOGGER.warn("#Get pageByCondition return empty.ConditionBean is " + conditionBean + " page is " + page + " pageSize is " + pageSize);
            return result;
        }
        result.setDataList(convertToVoList(activityInfoPage.getDataList()));
        return result;
    }

    public List<ActivityInfoVo> convertToVoList(List<ActivityInfo> infoList) {
        if (CollectionUtils.isEmpty(infoList)) {
            return Collections.emptyList();
        }
        Set<Integer> oriUserIds = infoList.stream().map(activityInfo -> activityInfo.getOriUserId()).collect(Collectors.toSet());
        List<ActivityInfoVo> activityInfoVos = new ArrayList<>(infoList.size());
        //获取用户信息
        Map<Integer, UserInfo> userInfoMap = userInfoService.getMapByIdList(new ArrayList<>(oriUserIds));
        for (ActivityInfo activityInfo : infoList) {
            ActivityInfoVo infoVo = new ActivityInfoVoBuilder(activityInfo).buildBase().getInfoVo();
            buildAvatarUrl(infoVo, userInfoMap);
            activityInfoVos.add(infoVo);
        }
        return activityInfoVos;
    }

    /**
     * @param infoList
     * @return
     */
    public Map<Integer, ActivityInfoVo> convertToVoMap(List<ActivityInfo> infoList) {
        if (CollectionUtils.isEmpty(infoList)) {
            return Collections.emptyMap();
        }
        List<ActivityInfoVo> infoVoList = convertToVoList(infoList);

        if (CollectionUtils.isEmpty(infoVoList)) {
            return Collections.emptyMap();
        }
        return infoVoList.stream().collect(Collectors.toMap(ActivityInfoVo::getId, activityInfoVo -> activityInfoVo));
    }
}
