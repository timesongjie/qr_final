package com.heroopsys.qrcode.entity;

public class ServiceType {
    private Integer id;

    private String serviceType;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getServiceType() {
	return serviceType;
    }

    public void setServiceType(String serviceType) {
	this.serviceType = serviceType == null ? null : serviceType.trim();
    }
}