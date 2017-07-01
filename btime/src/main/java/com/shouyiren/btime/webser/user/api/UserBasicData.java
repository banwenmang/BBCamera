package com.shouyiren.btime.webser.user.api;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:53
 * email:727933147@qq.com
 */

public class UserBasicData
        implements Serializable {
    private static final long serialVersionUID = 7119532819551540937L;

    /**
     * 账号类型
     */
    private Integer accountType;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 城市
     */
    private String city;

    /**
     * 描述
     */
    private String des;

    /**
     * 邮箱
     */
    private String email;

    /**
     *
     */
    private String gender;

    /**
     *
     */
    private Boolean geoEnabled;

    /**
     * 最后登录
     */
    private Date lastLogin;

    /**
     * 地址
     */
    private String location;

    /**
     * 最大 TODO
     */
    private Long maxSpace;

    /**
     * 名字
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 省
     */
    private String province;

    /**
     * 密码
     */
    private String pwd;

    /**
     * deviceId
     */
    private Long regDeviceid;

    /**
     * 时间
     */
    private Date regTime;
    private Integer regappid;
    private String screenName;

    /**
     * 状态
     */
    private Integer status;

    /**
     * Imei
     */
    private Long uid;
    private Long usedSpace;

    public Integer getAccountType() {
        return this.accountType;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public String getCity() {
        return this.city;
    }

    public String getDes() {
        return this.des;
    }

    public String getEmail() {
        return this.email;
    }

    public String getGender() {
        return this.gender;
    }

    public Boolean getGeoEnabled() {
        return this.geoEnabled;
    }

    public Date getLastLogin() {
        return this.lastLogin;
    }

    public String getLocation() {
        return this.location;
    }

    public Long getMaxSpace() {
        return this.maxSpace;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getProvince() {
        return this.province;
    }

    public String getPwd() {
        return this.pwd;
    }

    public Integer getRegAppid() {
        return this.regappid;
    }

    public Long getRegDeviceid() {
        return this.regDeviceid;
    }

    public Date getRegTime() {
        return this.regTime;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public Integer getStatus() {
        return this.status;
    }

    public Long getUID() {
        return this.uid;
    }

    public Long getUsedSpace() {
        return this.usedSpace;
    }

    public void setAccountType(Integer paramInteger) {
        this.accountType = paramInteger;
    }

    public void setAvatar(String paramString) {
        this.avatar = paramString;
    }

    public void setBirthday(Date paramDate) {
        this.birthday = paramDate;
    }

    public void setCity(String paramString) {
        this.city = paramString;
    }

    public void setDes(String paramString) {
        this.des = paramString;
    }

    public void setEmail(String paramString) {
        this.email = paramString;
    }

    public void setGender(String paramString) {
        this.gender = paramString;
    }

    public void setGeoEnabled(Boolean paramBoolean) {
        this.geoEnabled = paramBoolean;
    }

    public void setLastLogin(Date paramDate) {
        this.lastLogin = paramDate;
    }

    public void setLocation(String paramString) {
        this.location = paramString;
    }

    public void setMaxSpace(Long paramLong) {
        this.maxSpace = paramLong;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setPhone(String paramString) {
        this.phone = paramString;
    }

    public void setProvince(String paramString) {
        this.province = paramString;
    }

    public void setPwd(String paramString) {
        this.pwd = paramString;
    }

    public void setRegAppid(Integer paramInteger) {
        this.regappid = paramInteger;
    }

    public void setRegDeviceid(Long paramLong) {
        this.regDeviceid = paramLong;
    }

    public void setRegTime(Date paramDate) {
        this.regTime = paramDate;
    }

    public void setScreenName(String paramString) {
        this.screenName = paramString;
    }

    public void setStatus(Integer paramInteger) {
        this.status = paramInteger;
    }

    public void setUID(Long paramLong) {
        this.uid = paramLong;
    }

    public void setUsedSpace(Long paramLong) {
        this.usedSpace = paramLong;
    }
}

