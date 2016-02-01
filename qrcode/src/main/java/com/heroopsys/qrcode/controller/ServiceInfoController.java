package com.heroopsys.qrcode.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.heroopsys.qrcode.common.controller.BaseController;
import com.heroopsys.qrcode.common.converter.DateEditor;
import com.heroopsys.qrcode.entity.ServiceInfo;
import com.heroopsys.qrcode.service.ServiceInfoService;
import com.heroopsys.qrcode.util.Grid;
import com.heroopsys.qrcode.util.Pager;

@Controller
@RequestMapping("/serviceInfo")
public class ServiceInfoController extends BaseController{

    @Resource
    private ServiceInfoService serviceInfoService;
    private Logger log = LoggerFactory.getLogger(ServiceInfoController.class);
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Grid<ServiceInfo> list(Integer page, Integer rows, ServiceInfo serviceInfo, Model model) {
	if (page == null) {
	    page = 1;
	}
	if (rows == null) {
	    rows = 20;
	}
	Pager<ServiceInfo> pager = new Pager<ServiceInfo>();
	pager.setPage(page);
	pager.setRows(rows);
	Grid<ServiceInfo> grid = new Grid<ServiceInfo>();
	try {
	    serviceInfoService.list(serviceInfo,pager);
	} catch (Exception e) {
	    e.printStackTrace();
	    log.error("查询设备服务信息报错，联系管理员!" + e.getMessage());
	} finally {
	    doClear(model, "serviceInfo");
	}
	grid.setRows(pager.getDataList());
	grid.setTotal(pager.getTotal());
	return grid;
    };
    
    @InitBinder  
    protected void initBinder(HttpServletRequest request,  
                                  ServletRequestDataBinder binder) throws Exception {  
        //对于需要转换为Date类型的属性，使用DateEditor进行处理  
        binder.registerCustomEditor(Date.class, new DateEditor());  
    }  
}
