package com.heroopsys.qrcode.common.converter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtil {

    private static ObjectMapper mapper = new ObjectMappingCustomer();

    public static String objectTStr(Object obj) throws Exception {
	return mapper.writeValueAsString(obj);
    }

    public static <T> T readValue(String jsonStr, Class<T> valueType) throws Exception {
	return mapper.readValue(jsonStr, valueType);
    }

}
