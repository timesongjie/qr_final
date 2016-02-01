package com.heroopsys.qrcode.entity;

import java.util.Date;

public class Notice {
    private Integer id;

    private String notice;

    private Date addDate;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getNotice() {
	return notice;
    }

    public void setNotice(String notice) {
	this.notice = notice == null ? null : notice.trim();
    }

    public Date getAddDate() {
	return addDate;
    }

    public void setAddDate(Date addDate) {
	this.addDate = addDate;
    }
}