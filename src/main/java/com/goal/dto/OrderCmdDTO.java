package com.goal.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class OrderCmdDTO {
	/**
	 * id
	 */
	private String id;
	
    /**
     * 商品id
     */
	private String cmdId;
	
	/**
	 * 单品id
	 */
	private String cmdSkuId;
	
	/**
	 * 商品下单时单价
	 */
	private String cmdPrice;
	
	/**
	 * 商品数量
	 */
	private String cmdCount;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCmdId() {
		return cmdId;
	}

	public void setCmdId(String cmdId) {
		this.cmdId = cmdId;
	}

	public String getCmdPrice() {
		return cmdPrice;
	}

	public void setCmdPrice(String cmdPrice) {
		this.cmdPrice = cmdPrice;
	}

	public String getCmdCount() {
		return cmdCount;
	}

	public void setCmdCount(String cmdCount) {
		this.cmdCount = cmdCount;
	}

	public String getCmdSkuId() {
		return cmdSkuId;
	}

	public void setCmdSkuId(String cmdSkuId) {
		this.cmdSkuId = cmdSkuId;
	}
	

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
