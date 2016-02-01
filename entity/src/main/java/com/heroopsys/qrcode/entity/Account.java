package com.heroopsys.qrcode.entity;

/**
 * Created by time on 15-12-14.
 */
public class Account {

    private Long id;
    private String name;
    private String password;
    private Byte status;
    private String phoneNumber;
    private String perms;

    public Account() {

    }

    public Account(String name, String password) {
	this.password = password;
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Byte getStatus() {
	return status;
    }

    public void setStatus(Byte status) {
	this.status = status;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getPhoneNumber() {
	return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
    }

    public String getPerms() {
	return perms;
    }

    public void setPerms(String perms) {
	this.perms = perms;
    }

}
