package com.uyoung.core.api.model;

import java.util.Date;

/**
 * Desc:
 * <p/>Date: 2015-11-18
 * <br/>Time: 11:47
 * <br/>User: ylzhu
 */
public class DictCity {
    private int id;
    private String cityId;
    private String cnName;
    private String enName;
    /**
     * 经度
     */
    private String lon;
    /**
     * 纬度
     */
    private String lat;
    /**
     * 父城市ID
     */
    private int pid;

    private Date createTime;

    private Date updateTime;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
