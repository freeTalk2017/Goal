package com.goal.dto;

/**
 * 订单价格详情DTO
 * @author lizhiwei
 *
 */
public class OrderPriceDetailDTO extends AbstractDTO{
	/**
	 * 订单价格详情id
	 */
	private String id;
	
	/**
	 * 详情键
	 */
	private String detailKey;
	

	/**
	 * 详情名称
	 */
	private String detailName;
	
	/**
	 * 详情值
	 */
	private String detailValue;
	
	/**
	 * 详情数量
	 */
	private String amount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDetailKey() {
		return detailKey;
	}

	public void setDetailKey(String detailKey) {
		this.detailKey = detailKey;
	}

	public String getDetailName() {
		return detailName;
	}

	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}

	public String getDetailValue() {
		return detailValue;
	}

	public void setDetailValue(String detailValue) {
		this.detailValue = detailValue;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
}
