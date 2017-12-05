package com.goal.dto;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class OrderDTO extends AbstractDTO{
	/**
	 * 用户id
	 */
	private String userId;
	
	/**
	 * 订单配送方式
	 */
	private String deliveryWay;
	
	/**
	 * 是否使用优惠券
	 */
	private String isCouponUsed;
	
	/**
	 * 发票种类
	 */
	private String invoiceType;
	
	/**
	 * 订单状态
	 */
	private String orderStatus;
	
	/**
	 * 订单商品数量
	 */
	private String cmdCount;
	
	/**
	 * 订单备注
	 */
	private String comment;
	/*
	 * return value1 - 订单号
	 */
	private String orderNumber;

	/*
	 * return value2 - 是否为合法order
	 */
	private boolean isValidatedOrder;

	/*
	 * return value3 - 订单总价
	 */
	private String totalPrice;

	/**
	 * 订单商品列表
	 */
	private List<OrderCmdDTO> orderCmdList;
	
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public boolean isValidatedOrder() {
		return isValidatedOrder;
	}

	public void setValidatedOrder(boolean isValidatedOrder) {
		this.isValidatedOrder = isValidatedOrder;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public static void main(String[] args) {
		OrderDTO dto = new OrderDTO();
		dto.setOrderNumber("1234");
		System.out.println(dto);
	}
}
