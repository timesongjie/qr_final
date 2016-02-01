package com.heroopsys.qrcode.common.vo;

import org.apache.commons.lang.StringUtils;

public class Result<T> {
    private Byte status;//0 成功 1失败

    private String msg = StringUtils.EMPTY;

    private T data;

    public String getMsg() {
	return msg;
    }

    public void setMsg(String msg) {
	this.msg = msg;
    }

    public Byte getStatus() {
	return status;
    }

    public void setStatus(Byte status) {
	this.status = status;
    }

    public T getData() {
	return data;
    }

    public void setData(T data) {
	this.data = data;
    }

}
