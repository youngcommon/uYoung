package com.uyoung.web.vo;

/**
 * User: KennyZhu
 * Date: 15/10/12
 * Desc:
 */
public class ActivityInfoVo {
    private int id;
    private int oriUserId;
    private String title;
    private String activityTypeDesc;
    private int needNum;
    private int day;
    private int mon;
    private String weekDesc;
    private String fromTime;
    private String toTime;
    private String address;
    private String oriUserAvatarUrl;
    private String local;
    private String statusDesc;
    private int feeType;


    private String description;
    private int realNum;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMon() {
        return mon;
    }

    public void setMon(int mon) {
        this.mon = mon;
    }

    public String getWeekDesc() {
        return weekDesc;
    }

    public void setWeekDesc(String weekDesc) {
        this.weekDesc = weekDesc;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public String getOriUserAvatarUrl() {
        return oriUserAvatarUrl;
    }

    public void setOriUserAvatarUrl(String oriUserAvatarUrl) {
        this.oriUserAvatarUrl = oriUserAvatarUrl;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }


    public String getActivityTypeDesc() {
        return activityTypeDesc;
    }

    public void setActivityTypeDesc(String activityTypeDesc) {
        this.activityTypeDesc = activityTypeDesc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFeeType() {
        return feeType;
    }

    public void setFeeType(int feeType) {
        this.feeType = feeType;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNeedNum() {
        return needNum;
    }

    public void setNeedNum(int needNum) {
        this.needNum = needNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOriUserId() {
        return oriUserId;
    }

    public void setOriUserId(int oriUserId) {
        this.oriUserId = oriUserId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRealNum() {
        return realNum;
    }

    public void setRealNum(int realNum) {
        this.realNum = realNum;
    }
}
