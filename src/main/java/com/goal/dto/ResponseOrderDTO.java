package com.goal.dto;

/**
 * 创建order成功返回dto
 * @author lizhiwei
 *
 */
public class ResponseOrderDTO extends AbstractDTO{
	private String orderId;
	
	private boolean isValidateOrder;
	
	private String totalPrice;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public boolean isValidateOrder() {
		return isValidateOrder;
	}

	public void setValidateOrder(boolean isValidateOrder) {
		this.isValidateOrder = isValidateOrder;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
}
