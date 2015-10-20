package com.uyoung.core.api.service;

import com.uyoung.core.api.model.ActivitySignUp;

import java.util.List;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
public interface ActivitySignUpService {

    public int add(ActivitySignUp activitySignUp);

    public ActivitySignUp getById(int id);

    public int updateById(ActivitySignUp activitySignUp);

    List<ActivitySignUp> getListByActivityId(Integer activityId);
}
