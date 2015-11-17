package com.uyoung.web.controller;

import com.uyoung.core.api.service.SignService;
import com.uyoung.core.third.qiniu.QiNiuAccessTokenFactory;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Desc:
 * <p/>Date: 2015-11-17
 * <br/>Time: 17:20
 * <br/>User: ylzhu
 */
@Controller
public class CommonController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private SignService signService;


    @RequestMapping(value = "/common/qnUpToken", method = RequestMethod.POST)
    @ResponseBody
    public String getQNUpToken(long timestamp, String deviceId, String sign) {
        if (StringUtils.isBlank(deviceId) || StringUtils.isBlank(sign)) {
            return buildInvalidParamJson();
        }
        if (!signService.checkQNTokenSign(timestamp, deviceId, sign)) {
            return buildInvalidParamJson();
        }
        try {
            return buildSuccessJson(QiNiuAccessTokenFactory.getInstance().getDefaultUpToken());
        } catch (Exception e) {
            LOGGER.error("#Get QN upToken error.Cause:", e);
            return buildExceptionJson();
        }
    }
}
