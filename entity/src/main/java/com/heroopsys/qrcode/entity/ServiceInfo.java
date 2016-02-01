package com.heroopsys.qrcode.entity;

import java.util.Date;

public class ServiceInfo {
    private Integer id;

    private Integer serviceTypeId;

    private String deviceCode;

    private String serviceName;

    private Date serviceDate;

    private String serviceLocation;

    private String serviceContent;

    private String bak;

    private ServiceType serviceType;

    private String projectName;

    private Date sserviceDate;

    private Date eserviceDate;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Integer getServiceTypeId() {
	return serviceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
	this.serviceTypeId = serviceTypeId;
    }

    public String getDeviceCode() {
	return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
	this.deviceCode = deviceCode == null ? null : deviceCode.trim();
    }

    public String getServiceName() {
	return serviceName;
    }

    public void setServiceName(String serviceName) {
	this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public Date getServiceDate() {
	return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
	this.serviceDate = serviceDate;
    }

    public String getServiceLocation() {
	return serviceLocation;
    }

    public void setServiceLocation(String serviceLocation) {
	this.serviceLocation = serviceLocation == null ? null : serviceLocation.trim();
    }

    public String getServiceContent() {
	return serviceContent;
    }

    public void setServiceContent(String serviceContent) {
	this.serviceContent = serviceContent == null ? null : serviceContent.trim();
    }

    public String getBak() {
	return bak;
    }

    public void setBak(String bak) {
	this.bak = bak == null ? null : bak.trim();
    }

    public ServiceType getServiceType() {
	return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
	this.serviceType = serviceType;
    }

    public String getProjectName() {
	return projectName;
    }

    public void setProjectName(String projectName) {
	this.projectName = projectName;
    }

    public Date getSserviceDate() {
	return sserviceDate;
    }

    public void setSserviceDate(Date sserviceDate) {
	this.sserviceDate = sserviceDate;
    }

    public Date getEserviceDate() {
	return eserviceDate;
    }

    public void setEserviceDate(Date eserviceDate) {
	this.eserviceDate = eserviceDate;
    }

}