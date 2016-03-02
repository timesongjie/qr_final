package com.heroopsys.qrcode.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.heroopsys.qrcode.dao.ServiceMapper;
import com.heroopsys.qrcode.entity.ServiceExample;
import com.heroopsys.qrcode.entity.ServiceExample.Criteria;
import com.heroopsys.qrcode.entity.ServiceInfo;
import com.heroopsys.qrcode.util.Pager;

@Service
public class ServiceInfoService {

	@Resource
	private ServiceMapper serviceMapper;

	public void addOrUpdateService(
			com.heroopsys.qrcode.entity.ServiceInfo service) {
		if (service.getId() == null) {
			serviceMapper.insert(service);
		} else {
			serviceMapper.updateByPrimaryKey(service);
		}
	}

	public void list(com.heroopsys.qrcode.entity.ServiceInfo service,
			Pager<com.heroopsys.qrcode.entity.ServiceInfo> pager) {
		ServiceExample example = new ServiceExample();
		if (service != null) {
			Criteria criteria = example.createCriteria();
			if (service.getSserviceDate() != null
					&& service.getEserviceDate() != null) {
				criteria.andServiceDateBetween(service.getSserviceDate(),
						service.getEserviceDate());
			}
			if (StringUtils.isNotBlank(service.getProjectName())) {
				criteria.andProjectNameLike("%" + service.getProjectName()
						+ "%");
			}
			// ....可以按照条件新增
		}
		pager.setTotal(serviceMapper.countByExample(example));
		pager.setDataList(serviceMapper.selectByExampleAndPager(example, pager));
	}

	public HSSFWorkbook getExcel(ServiceInfo service) {
		HSSFWorkbook hb = createExcel();
		ServiceExample example = new ServiceExample();
		if (service != null) {
			Criteria criteria = example.createCriteria();
			if (service.getSserviceDate() != null
					&& service.getEserviceDate() != null) {
				criteria.andServiceDateBetween(service.getSserviceDate(),
						service.getEserviceDate());
			}
			if (StringUtils.isNotBlank(service.getProjectName())) {
				criteria.andProjectNameLike("%" + service.getProjectName()
						+ "%");
			}
			// ....可以按照条件新增
		}
		List<ServiceInfo> infos = serviceMapper.selectByExampleAndPager(
				example, null);
		if (!CollectionUtils.isEmpty(infos)) {
			HSSFSheet sheet = hb.getSheetAt(0);
			ServiceInfo info = null;
			for (int i = 0; i < infos.size(); i++) {
				HSSFRow row = sheet.createRow((int) i + 1);
				info = infos.get(i);
				// 第四步，创建单元格，并设置值
				row.createCell(0).setCellValue(info.getProjectName());
				row.createCell(1).setCellValue(
						new SimpleDateFormat("yyyy-mm-dd").format(info
								.getServiceDate()));
				row.createCell(2).setCellValue(info.getServiceLocation());
				row.createCell(3).setCellValue(
						getServiceType(info.getServiceTypeId()));
				row.createCell(4).setCellValue(info.getServiceContent());
				row.createCell(5).setCellValue(info.getBak());
			}
		}
		return hb;
	}

	private String getServiceType(Integer value) {
		if (value == 1) {
			return "售前";
		} else if (value == 2) {
			return "售中";
		} else if (value == 3) {
			return "售后";
		}
		return null;
	}

	private HSSFWorkbook createExcel() {
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("sheet1");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("项目名称");
		cell.setCellStyle(style);
		cell = row.createCell(1);
		cell.setCellValue("服务时间");
		cell.setCellStyle(style);
		cell = row.createCell(2);
		cell.setCellValue("服务地点");
		cell.setCellStyle(style);
		cell = row.createCell(3);
		cell.setCellValue("服务类型");
		cell.setCellStyle(style);
		cell = row.createCell(4);
		cell.setCellValue("服务内容");
		cell.setCellStyle(style);
		cell = row.createCell(5);
		cell.setCellValue("备注");
		cell.setCellStyle(style);
		return wb;
	}
}
