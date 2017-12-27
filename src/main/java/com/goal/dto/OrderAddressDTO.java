package com.goal.dto;

/**
 * 订单地址DTO
 * @author lizhiwei
 *
 */
public class OrderAddressDTO extends AbstractDTO{
	/**
	 * 订单地址id
	 */
	private String id;
	
	/**
	 * 订单id
	 */
	private String orderId;
	/**
	 * 收货人
	 */
	private String receiver;
	
	/**
	 * 电话
	 */
	private String telephone;
	
	/**
	 * 省
	 */
	private String province;

	/**
	 * 市
	 */
	private String city;
	
	/**
	 * 街道
	 */
	private String street;
	

	/**
	 * 邮编
	 */
	private String zipCode;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getReceiver() {
		return receiver;
	}


	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	
}
