package com.goal.form;

import com.goal.wxpay.WXPayConstants.SignType;

public class PrepayForm {


	private String appId;
	private String timeStamp;
	private String nonceStr;
	private String package_pre;
	private SignType signType;
	private String paySign;
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getNonceStr() {
		return nonceStr;
	}
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	public String getPackage_pre() {
		return package_pre;
	}
	public void setPackage_pre(String package_pre) {
		this.package_pre = package_pre;
	}
	public SignType getSignType() {
		return signType;
	}
	public void setSignType(SignType signType) {
		this.signType = signType;
	}
	public String getPaySign() {
		return paySign;
	}
	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}
	
	@Override
	public String toString() {
		return "PrepayForm [appId=" + appId + ", timeStamp=" + timeStamp + ", nonceStr=" + nonceStr + ", package_pre="
				+ package_pre + ", signType=" + signType + ", paySign=" + paySign + "]";
	}
}
