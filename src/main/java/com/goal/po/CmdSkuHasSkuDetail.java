package com.goal.po;

import java.util.Date;

public class CmdSkuHasSkuDetail {
    private String skuId;

    private String skuDetailId;

    private Integer index;

    private Date createTsp;

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId == null ? null : skuId.trim();
    }

    public String getSkuDetailId() {
        return skuDetailId;
    }

    public void setSkuDetailId(String skuDetailId) {
        this.skuDetailId = skuDetailId == null ? null : skuDetailId.trim();
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Date getCreateTsp() {
        return createTsp;
    }

    public void setCreateTsp(Date createTsp) {
        this.createTsp = createTsp;
    }
}