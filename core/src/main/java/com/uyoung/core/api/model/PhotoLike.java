package com.uyoung.core.api.model;

import java.util.Date;

public class PhotoLike {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_photo_like.id
     *
     * @mbggenerated Sat Sep 19 17:42:07 CST 2015
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_photo_like.photo_id
     *
     * @mbggenerated Sat Sep 19 17:42:07 CST 2015
     */
    private Integer photoId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_photo_like.user_id
     *
     * @mbggenerated Sat Sep 19 17:42:07 CST 2015
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_photo_like.create_time
     *
     * @mbggenerated Sat Sep 19 17:42:07 CST 2015
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_photo_like.update_time
     *
     * @mbggenerated Sat Sep 19 17:42:07 CST 2015
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_photo_like.id
     *
     * @return the value of tb_photo_like.id
     *
     * @mbggenerated Sat Sep 19 17:42:07 CST 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_photo_like.id
     *
     * @param id the value for tb_photo_like.id
     *
     * @mbggenerated Sat Sep 19 17:42:07 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_photo_like.photo_id
     *
     * @return the value of tb_photo_like.photo_id
     *
     * @mbggenerated Sat Sep 19 17:42:07 CST 2015
     */
    public Integer getPhotoId() {
        return photoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_photo_like.photo_id
     *
     * @param photoId the value for tb_photo_like.photo_id
     *
     * @mbggenerated Sat Sep 19 17:42:07 CST 2015
     */
    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_photo_like.user_id
     *
     * @return the value of tb_photo_like.user_id
     *
     * @mbggenerated Sat Sep 19 17:42:07 CST 2015
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_photo_like.user_id
     *
     * @param userId the value for tb_photo_like.user_id
     *
     * @mbggenerated Sat Sep 19 17:42:07 CST 2015
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_photo_like.create_time
     *
     * @return the value of tb_photo_like.create_time
     *
     * @mbggenerated Sat Sep 19 17:42:07 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_photo_like.create_time
     *
     * @param createTime the value for tb_photo_like.create_time
     *
     * @mbggenerated Sat Sep 19 17:42:07 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_photo_like.update_time
     *
     * @return the value of tb_photo_like.update_time
     *
     * @mbggenerated Sat Sep 19 17:42:07 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_photo_like.update_time
     *
     * @param updateTime the value for tb_photo_like.update_time
     *
     * @mbggenerated Sat Sep 19 17:42:07 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}