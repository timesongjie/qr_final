package com.heroopsys.qrcode.api.bo;

/**
 * Created by time on 15-12-22.
 */
public class IUser {
    private String userName;
    private Byte[] enable;// 修改产品权限/添加产品权限/追加产品权限

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public Byte[] getEnable() {
	return enable;
    }

    public void setEnable(Byte[] enable) {
	this.enable = enable;
    }
}
