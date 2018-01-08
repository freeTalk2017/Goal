package com.goal.dto;

/**
 * 数据库返回sku DTO
 * @author lizhiwei
 *
 */
public class SkuQueryResultDTO extends AbstractDTO{
	/** 单品id **/
	private String skuId;

	/** 单品价格 **/
	private int price;

	/** 单品详情id **/
	private String skuDetailId;
	
	/** 属性顺序 **/
	private int index;

	/** 属性key **/
	private String paramKey;

	/** 属性值 **/
	private String paramValue;

	/** 父属性id **/
	private String pId;

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSkuDetailId() {
		return skuDetailId;
	}

	public void setSkuDetailId(String skuDetailId) {
		this.skuDetailId = skuDetailId;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getParamKey() {
		return paramKey;
	}

	public void setParamKey(String paramKey) {
		this.paramKey = paramKey;
	}

	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}
	
}
