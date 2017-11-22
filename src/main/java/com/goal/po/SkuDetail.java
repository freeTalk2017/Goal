package com.goal.po;

import java.util.Date;

public class SkuDetail {
    private String id;

    private String tCmdSkuId;

    private String paramKey;

    private String paramValue;

    private String paramDesc;

    private Date changeTsp;

    private Date createTsp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String gettCmdSkuId() {
        return tCmdSkuId;
    }

    public void settCmdSkuId(String tCmdSkuId) {
        this.tCmdSkuId = tCmdSkuId == null ? null : tCmdSkuId.trim();
    }

    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey == null ? null : paramKey.trim();
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue == null ? null : paramValue.trim();
    }

    public String getParamDesc() {
        return paramDesc;
    }

    public void setParamDesc(String paramDesc) {
        this.paramDesc = paramDesc == null ? null : paramDesc.trim();
    }

    public Date getChangeTsp() {
        return changeTsp;
    }

    public void setChangeTsp(Date changeTsp) {
        this.changeTsp = changeTsp;
    }

    public Date getCreateTsp() {
        return createTsp;
    }

    public void setCreateTsp(Date createTsp) {
        this.createTsp = createTsp;
    }
}