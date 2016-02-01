package com.heroopsys.qrcode.common.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heroopsys.qrcode.entity.Account;

public class ObjectMappingCustomer extends ObjectMapper {
    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = -9041338519064361476L;

    public ObjectMappingCustomer() {
	super();
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	super.setDateFormat(df);
	super.setSerializationInclusion(Include.NON_NULL);
	super.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
