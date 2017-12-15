package com.goal.dto;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class OrderDTO extends AbstractDTO{
	/**
	 * 订单id
	 */
	private String orderId;
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
	
	/**
	 * return value1 - 订单号
	 */
	private String orderNumber;

	/**
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
	
	/**
	 * 订单地址
	 */
	private OrderAddressDTO orderAddress;
	
	/**
	 * 订单价格详情列表
	 */
	private List<OrderPriceDetailDTO> priceDetailList;
	
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
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDeliveryWay() {
		return deliveryWay;
	}

	public void setDeliveryWay(String deliveryWay) {
		this.deliveryWay = deliveryWay;
	}

	public String getIsCouponUsed() {
		return isCouponUsed;
	}

	public void setIsCouponUsed(String isCouponUsed) {
		this.isCouponUsed = isCouponUsed;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getCmdCount() {
		return cmdCount;
	}

	public void setCmdCount(String cmdCount) {
		this.cmdCount = cmdCount;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<OrderCmdDTO> getOrderCmdList() {
		return orderCmdList;
	}

	public void setOrderCmdList(List<OrderCmdDTO> orderCmdList) {
		this.orderCmdList = orderCmdList;
	}

	public OrderAddressDTO getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(OrderAddressDTO orderAddress) {
		this.orderAddress = orderAddress;
	}

	public List<OrderPriceDetailDTO> getPriceDetailList() {
		return priceDetailList;
	}

	public void setPriceDetailList(List<OrderPriceDetailDTO> priceDetailList) {
		this.priceDetailList = priceDetailList;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public static void main(String[] args) {
		OrderDTO dto = new OrderDTO();
		dto.setOrderNumber("1234");
		System.out.println(dto);
	}
}
