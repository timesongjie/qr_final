package com.heroopsys.qrcode.util;

public class SqlUtil {

	public static String getLikeCondition(String condition) {
		return "%" + condition + "%";
	}
}
