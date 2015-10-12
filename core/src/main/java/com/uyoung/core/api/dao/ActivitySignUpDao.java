package com.uyoung.core.api.dao;

import com.uyoung.core.api.model.ActivitySignUp;

public interface ActivitySignUpDao {

    int deleteByPrimaryKey(Integer id);

    int insert(ActivitySignUp record);

    ActivitySignUp getById(Integer id);

    int updateById(ActivitySignUp record);
}