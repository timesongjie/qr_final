package com.heroopsys.qrcode.util;

import java.io.Serializable;

public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    private String msg;

    private boolean success;

    public Result() {

    }

    /**
     * @param msg
     * @param success
     */
    public Result(String msg, boolean success) {
	super();
	this.msg = msg;
	this.success = success;
    }

    public String getMsg() {
	return msg;
    }

    public void setMsg(String msg) {
	this.msg = msg;
    }

    public boolean isSuccess() {
	return success;
    }

    public void setSuccess(boolean success) {
	this.success = success;
    }

}
