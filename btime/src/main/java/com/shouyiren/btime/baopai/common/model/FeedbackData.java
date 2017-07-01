package com.shouyiren.btime.baopai.common.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:45
 * email:727933147@qq.com
 */
public class FeedbackData
        implements Serializable {
    private static final long serialVersionUID = 2970289985227834838L;
    private Date createtime;
    private Long id;
    private Integer processby;
    private Date processtime;
    private String remark;
    private String reply;
    private Integer status;
    private String text;
    private Integer type;
    private Long uid;
    private String url;

    public Date getCreatetime() {
        return this.createtime;
    }

    public Long getId() {
        return this.id;
    }

    public Integer getProcessby() {
        return this.processby;
    }

    public Date getProcesstime() {
        return this.processtime;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getReply() {
        return this.reply;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getText() {
        return this.text;
    }

    public Integer getType() {
        return this.type;
    }

    public Long getUid() {
        return this.uid;
    }

    public String getUrl() {
        return this.url;
    }

    public void setCreatetime(Date paramDate) {
        this.createtime = paramDate;
    }

    public void setId(Long paramLong) {
        this.id = paramLong;
    }

    public void setProcessby(Integer paramInteger) {
        this.processby = paramInteger;
    }

    public void setProcesstime(Date paramDate) {
        this.processtime = paramDate;
    }

    public void setRemark(String paramString) {
        this.remark = paramString;
    }

    public void setReply(String paramString) {
        this.reply = paramString;
    }

    public void setStatus(Integer paramInteger) {
        this.status = paramInteger;
    }

    public void setText(String paramString) {
        this.text = paramString;
    }

    public void setType(Integer paramInteger) {
        this.type = paramInteger;
    }

    public void setUid(Long paramLong) {
        this.uid = paramLong;
    }

    public void setUrl(String paramString) {
        this.url = paramString;
    }
}

