package com.uyoung.core.api.service;

import com.uyoung.core.api.bean.ActivityConditionBean;
import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.core.api.model.ActivityInfo;
import com.uyoung.core.api.schedule.ActivityScheduleTask;
import com.uyoung.core.base.bean.Page;

import java.util.List;
import java.util.Map;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
public interface ActivityInfoService {

    /**
     * 分页获取活动信息
     *
     * @param pageNum    页码
     * @param pageSize   每页数量
     * @param statusEnum see {@link ActivityStatusEnum}
     * @param oriUid     可为空
     * @return
     */
    public Page<ActivityInfo> getPageByStatus(int pageNum, int pageSize, ActivityStatusEnum statusEnum, Integer oriUid);

    /**
     * 根据条件查询活动信息
     *
     * @param conditionBean
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<ActivityInfo> getPageByCondition(ActivityConditionBean conditionBean, int pageNum, int pageSize);

    /**
     * 获取详情
     *
     * @param id
     * @return
     */
    public ActivityInfo getById(int id);

    /**
     * 创建活动
     *
     * @param activityInfo
     * @return
     */
    public int add(ActivityInfo activityInfo);

    /**
     * 删除活动
     *
     * @param activityId
     * @return
     */
    public int deleteById(Integer activityId);

    /**
     * @param activityInfo
     * @return
     */
    public int updateById(ActivityInfo activityInfo);

    /**
     * 更新活动状态
     *
     * @param activityId
     * @param activityStatusEnum
     * @return
     */
    public int updateStatusById(Integer activityId, ActivityStatusEnum activityStatusEnum);

    /**
     * 取消活动
     *
     * @param uid
     * @param activityId
     * @return
     */
    public int cancel(Integer uid, Integer activityId);

    /**
     * 批量获取活动信息
     *
     * @param idList
     * @return
     */
    public List<ActivityInfo> getListByIdList(List<Integer> idList);


    /**
     * 批量获取活动信息
     *
     * @param idList
     * @return
     */
    public Map<Integer, ActivityInfo> getMapByIdList(List<Integer> idList);


    /**
     * 批量获取指定状态的数据
     *
     * @return
     */
    public List<ActivityInfo> getAllActivityInfoByStatus(List<ActivityStatusEnum> statusList);


    /**
     * @param activityInfos
     * @return
     */
    public List<ActivityScheduleTask> wrapActivityScheduleTask(List<ActivityInfo> activityInfos);


}
