package com.goal.po;

import java.util.Date;

public class OrderAddress {
    private String id;

    private String orderId;

    private String receiver;

    private String telephone;

    private String province;

    private String city;

    private String street;

    private String zipCode;

    private Date changeTsp;

    private Date createTsp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    public Date getChangeTsp() {
        return changeTsp;
    }

    public void setChangeTsp(Date changeTsp) {
        this.changeTsp = changeTsp;
    }

    public Date getCreateTsp() {
        return createTsp;
    }

    public void setCreateTsp(Date createTsp) {
        this.createTsp = createTsp;
    }
}