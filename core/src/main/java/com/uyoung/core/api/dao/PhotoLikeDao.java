package com.uyoung.core.api.dao;

import com.uyoung.core.api.model.PhotoLike;

public interface PhotoLikeDao {

    int deleteByPrimaryKey(Integer id);

    int deleteByUidPhotoId(Integer uid, Integer photoId);

    int insert(PhotoLike record);

    PhotoLike getById(Integer id);

    int updateById(PhotoLike record);
}