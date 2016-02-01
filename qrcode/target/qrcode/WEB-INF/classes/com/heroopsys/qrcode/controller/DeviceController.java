package com.heroopsys.qrcode.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.heroopsys.qrcode.common.controller.BaseController;
import com.heroopsys.qrcode.entity.Device;
import com.heroopsys.qrcode.service.DeviceService;
import com.heroopsys.qrcode.util.Grid;
import com.heroopsys.qrcode.util.Pager;
import com.heroopsys.qrcode.util.Result;

@Controller
@RequestMapping("/device")
public class DeviceController extends BaseController {

    @Resource
    private DeviceService deviceService;
    private Logger log = LoggerFactory.getLogger(DeviceController.class);

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Grid<Device> list(Integer page, Integer rows, Device device, Model model) {
	if (page == null) {
	    page = 1;
	}
	if (rows == null) {
	    rows = 20;
	}
	Pager<Device> pager = new Pager<Device>();
	pager.setPage(page);
	pager.setRows(rows);
	Grid<Device> grid = new Grid<Device>();
	try {
	    deviceService.list(device, pager);
	} catch (Exception e) {
	    e.printStackTrace();
	    log.error("查询设备列表报错，联系管理员!" + e.getMessage());
	} finally {
	    doClear(model, "device");
	}
	grid.setRows(pager.getDataList());
	grid.setTotal(pager.getTotal());
	return grid;
    }

    @RequestMapping(value = "/{id}")
    public String device(@PathVariable Integer id, String forward, Model model) {
//	model.addAttribute("device", deviceService.findById(id));
	Device device = new Device();
        device.setId(id);
        List<Device> list = deviceService.findByDevice(device);
	if (!CollectionUtils.isEmpty(list)){
            model.addAttribute("device",list.get(0));
        }
	if ("view".equals(forward)) {
	    return "/device/deviceView";
	} else if ("edit".equals(forward)) {
	    return "/device/deviceEdit";
	}
	return null;
    }
    @RequestMapping(method = RequestMethod.POST)
    public Result updatedevice(Device device, Model model) {
	deviceService.addOrUpdateDevice(device);
	doClear(model, "device");
	return new Result("更新成功!", true);
    }
}
