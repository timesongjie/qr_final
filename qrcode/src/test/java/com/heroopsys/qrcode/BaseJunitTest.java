package com.heroopsys.qrcode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// 使用junit4进行测试
@ContextConfiguration({ "/*.xml" })
public class BaseJunitTest {

    private static final ObjectMapper objMapper = new ObjectMapper();

    static {
	objMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    public static ObjectMapper getObjMapper() {
	return objMapper;
    }

}