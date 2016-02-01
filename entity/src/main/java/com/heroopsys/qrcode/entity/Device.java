package com.heroopsys.qrcode.entity;

import java.util.Date;
import java.util.List;

public class Device {
    private Integer id;

    private String deviceCode;

    private String deviceModel;

    private String deviceQrcode;

    private String projectName;

    private String projectLeader;

    private String projectOthers;

    private Date debugDate;

    private Date finishDate;

    private String contractPoint;

    private String clientName;

    private String clientSite;

    private String client;

    private String clientTel;

    private String activationCode;

    private String activationCode2;

    private String activationCode3;

    private String activationCode4;

    private String wlan;

    private String simPhone;

    private String simFee;

    private String bak;

    private List<ServiceInfo> services;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getDeviceCode() {
	return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
	this.deviceCode = deviceCode == null ? null : deviceCode.trim();
    }

    public String getDeviceModel() {
	return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
	this.deviceModel = deviceModel == null ? null : deviceModel.trim();
    }

    public String getDeviceQrcode() {
	return deviceQrcode;
    }

    public void setDeviceQrcode(String deviceQrcode) {
	this.deviceQrcode = deviceQrcode == null ? null : deviceQrcode.trim();
    }

    public String getProjectName() {
	return projectName;
    }

    public void setProjectName(String projectName) {
	this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectLeader() {
	return projectLeader;
    }

    public void setProjectLeader(String projectLeader) {
	this.projectLeader = projectLeader == null ? null : projectLeader.trim();
    }

    public String getProjectOthers() {
	return projectOthers;
    }

    public void setProjectOthers(String projectOthers) {
	this.projectOthers = projectOthers == null ? null : projectOthers.trim();
    }

    public Date getDebugDate() {
	return debugDate;
    }

    public void setDebugDate(Date debugDate) {
	this.debugDate = debugDate;
    }

    public Date getFinishDate() {
	return finishDate;
    }

    public void setFinishDate(Date finishDate) {
	this.finishDate = finishDate;
    }

    public String getContractPoint() {
	return contractPoint;
    }

    public void setContractPoint(String contractPoint) {
	this.contractPoint = contractPoint == null ? null : contractPoint.trim();
    }

    public String getClientName() {
	return clientName;
    }

    public void setClientName(String clientName) {
	this.clientName = clientName == null ? null : clientName.trim();
    }

    public String getClientSite() {
	return clientSite;
    }

    public void setClientSite(String clientSite) {
	this.clientSite = clientSite == null ? null : clientSite.trim();
    }

    public String getClient() {
	return client;
    }

    public void setClient(String client) {
	this.client = client == null ? null : client.trim();
    }

    public String getClientTel() {
	return clientTel;
    }

    public void setClientTel(String clientTel) {
	this.clientTel = clientTel == null ? null : clientTel.trim();
    }

    public String getActivationCode() {
	return activationCode;
    }

    public void setActivationCode(String activationCode) {
	this.activationCode = activationCode == null ? null : activationCode.trim();
    }

    public String getActivationCode2() {
	return activationCode2;
    }

    public void setActivationCode2(String activationCode2) {
	this.activationCode2 = activationCode2 == null ? null : activationCode2.trim();
    }

    public String getActivationCode3() {
	return activationCode3;
    }

    public void setActivationCode3(String activationCode3) {
	this.activationCode3 = activationCode3 == null ? null : activationCode3.trim();
    }

    public String getActivationCode4() {
	return activationCode4;
    }

    public void setActivationCode4(String activationCode4) {
	this.activationCode4 = activationCode4 == null ? null : activationCode4.trim();
    }

    public String getWlan() {
	return wlan;
    }

    public void setWlan(String wlan) {
	this.wlan = wlan == null ? null : wlan.trim();
    }

    public String getSimPhone() {
	return simPhone;
    }

    public void setSimPhone(String simPhone) {
	this.simPhone = simPhone == null ? null : simPhone.trim();
    }

    public String getSimFee() {
	return simFee;
    }

    public void setSimFee(String simFee) {
	this.simFee = simFee == null ? null : simFee.trim();
    }

    public String getBak() {
	return bak;
    }

    public void setBak(String bak) {
	this.bak = bak == null ? null : bak.trim();
    }

    public List<ServiceInfo> getServices() {
	return services;
    }

    public void setServices(List<ServiceInfo> services) {
	this.services = services;
    }

}