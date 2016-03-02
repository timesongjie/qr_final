package com.heroopsys.qrcode.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
public class ServiceInfoController extends BaseController {

	@Resource
	private ServiceInfoService serviceInfoService;
	private Logger log = LoggerFactory.getLogger(ServiceInfoController.class);

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Grid<ServiceInfo> list(Integer page, Integer rows,
			ServiceInfo serviceInfo, Model model) {
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
			serviceInfoService.list(serviceInfo, pager);
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

	@RequestMapping(value = "export")
	public String download(ServiceInfo serviceInfo, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName="
				+ getFileName(serviceInfo));
		OutputStream os = null;
		HSSFWorkbook hb = null;
		try {
			os = response.getOutputStream();
			hb = serviceInfoService.getExcel(serviceInfo);
			if (hb != null) {
				hb.write(os);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (hb != null) {
				try {
					hb.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	private String getFileName(ServiceInfo serviceInfo) {
		return String.valueOf(new Date().getTime())+".xls";
	}

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		// 对于需要转换为Date类型的属性，使用DateEditor进行处理
		binder.registerCustomEditor(Date.class, new DateEditor());
	}
}
