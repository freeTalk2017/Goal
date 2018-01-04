package com.goal.dto;

import java.util.List;

/**
 * 单品dto
 * @author lizhiwei
 *
 */
public class SkuDTO extends AbstractDTO{
	/** id **/
	private String id;

	/** 商品id **/
	private String cmdId;
	
	/** 单品价格 **/
	private int price;
	
	/** 关键字 **/
	private String keyWord;
	
	/** 库存 **/
	private int stock;
	
	/** 属性列表 **/
	private List<SkuDetailDTO> skuDetailList;

	
	public SkuDTO() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public List<SkuDetailDTO> getSkuDetailList() {
		return skuDetailList;
	}

	public void setSkuDetailList(List<SkuDetailDTO> skuDetailList) {
		this.skuDetailList = skuDetailList;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getCmdId() {
		return cmdId;
	}

	public void setCmdId(String cmdId) {
		this.cmdId = cmdId;
	}
	
	
}
