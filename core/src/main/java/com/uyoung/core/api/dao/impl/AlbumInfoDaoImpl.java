package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.dao.AlbumInfoDao;
import com.uyoung.core.api.model.AlbumInfo;
import com.uyoung.core.base.bean.Page;
import com.uyoung.core.base.dao.BaseDao;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Repository
public class AlbumInfoDaoImpl extends BaseDao<AlbumInfo> implements AlbumInfoDao {
    @Override
    public int deleteById(Integer id) {
        return delete("deleteById", id);
    }

    @Override
    public int insert(AlbumInfo record) {
        return insert("insert", record);
    }

    @Override
    public AlbumInfo getById(Integer id) {
        return selectOne("getById", id);
    }

    @Override
    public List<AlbumInfo> getListByActivityId(Integer activityId) {
        return selectList("getListByActivityId", activityId);
    }

    @Override
    public int updateById(AlbumInfo record) {
        return update("updateById", record);
    }

    @Override
    public Page<AlbumInfo> getPageByCreateUserId(Integer cuid, Integer page, Integer pageSize) {
        Map<String, Object> param = new HashMap<>();
        param.put("cuid", cuid);
        if (page == null || pageSize == null) {
            return selectPage("getPageByCreateUserId", param, RowBounds.DEFAULT);
        }
        int offset = pageSize * (page - 1) + 1;
        return selectPage("getPageByCreateUserId", param, new RowBounds(offset, pageSize));
    }

    @Override
    public int incLikeCount(Integer id) {
        return update("incLikeCount", id);
    }

    @Override
    public int decLikeCount(Integer id) {
        return update("decLikeCount", id);
    }

    @Override
    public int incViewCount(Integer id) {
        return update("incViewCount", id);
    }

    @Override
    public int updateFirstPhotoUrl(Integer id, String firstUrl) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        paramMap.put("firstPhotoUrl", firstUrl);
        return update("updateFirstPhotoUrl", paramMap);
    }

    @Override
    public List<AlbumInfo> getAllAlbumCount() {
        return selectList("getAllAlbumCount");
    }

    @Override
    public int updateTotalPhotoCount(Integer id, int totalCount) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        paramMap.put("totalCount", totalCount);
        return update("updateTotalPhotoCount", paramMap);
    }
}
