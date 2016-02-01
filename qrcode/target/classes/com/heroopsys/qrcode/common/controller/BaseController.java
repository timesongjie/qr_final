package com.heroopsys.qrcode.common.controller;

import java.util.Map;

import org.springframework.ui.Model;

public class BaseController {

    public void doClear(Model model, String key) {
	Map map = (Map) model;
	map.remove(key);
    };
}
