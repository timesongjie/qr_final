package com.heroopsys.qrcode.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.heroopsys.qrcode.util.MD5Util;
import com.heroopsys.qrcode.util.Pager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.heroopsys.qrcode.api.bo.INotice;
import com.heroopsys.qrcode.api.bo.IUser;
import com.heroopsys.qrcode.common.converter.JacksonUtil;
import com.heroopsys.qrcode.common.vo.Result;
import com.heroopsys.qrcode.entity.Account;
import com.heroopsys.qrcode.entity.Device;
import com.heroopsys.qrcode.entity.Notice;
import com.heroopsys.qrcode.entity.ServiceInfo;
import com.heroopsys.qrcode.entity.ServiceType;
import com.heroopsys.qrcode.service.AccountService;
import com.heroopsys.qrcode.service.DeviceService;
import com.heroopsys.qrcode.service.NoticeService;
import com.heroopsys.qrcode.service.ServiceInfoService;

/**
 * Created by time on 15-12-22.
 */
@Controller
@RequestMapping("/api")
public class ApiController {

	@Resource
	private DeviceService deviceService;
	@Resource
	private AccountService accountService;
	@Resource
	private ServiceInfoService serviceInfoService;
	@Resource
	private NoticeService noticeService;
	private Logger log = LoggerFactory.getLogger(ApiController.class);

	@RequestMapping("/auth")
	public Result<IUser> login(String name, String pwd) {
		Result<IUser> result = new Result<IUser>();
		try {
			Account account = new Account();
			account.setName(name);
			account.setPassword(MD5Util.MD5(pwd));
			account = accountService.findByAccount(account);
			if (account == null || account.getId() == null) {
				result.setStatus((byte) 1);
				result.setMsg("登陆失败!");
			} else {
				IUser user = new IUser();
				user.setUserName(name);
				String perm = account.getPerms();
				user.setEnable(new Byte[] { Byte.valueOf(perm.charAt(0) + ""),
						Byte.valueOf(perm.charAt(1) + ""),
						Byte.valueOf(perm.charAt(2) + "") });
				result.setData(user);
				result.setStatus((byte) 0);
				result.setMsg("登陆成功!");
			}
		} catch (Exception e) {
			log.error("登录失败" + e.getMessage());
			result.setStatus((byte) 1);
			result.setMsg("登陆异常!");
		}
		return result;
	}

	@RequestMapping("/notice")
	public Result<INotice> notice() {
		Result<INotice> result = new Result<INotice>();
		result.setStatus((byte) 0);
		result.setMsg("获取公告成功!");
		Notice notice = noticeService.getNewest();
		INotice inotice = new INotice();
		inotice.setNotice(notice.getNotice());
		result.setData(inotice);
		return result;
	}

	@RequestMapping("/service")
	public Result<List<ServiceType>> service() {
		Result<List<ServiceType>> result = new Result<List<ServiceType>>();
		result.setStatus((byte) 0);
		result.setMsg("获取服务类型成功!");
		List<ServiceType> types = new ArrayList<ServiceType>();
		ServiceType type = new ServiceType();
		type.setServiceType("售前");
		type.setId(1);
		types.add(type);
		ServiceType type2 = new ServiceType();
		type2.setServiceType("售中");
		type2.setId(2);
		types.add(type2);
		ServiceType type3 = new ServiceType();
		type3.setServiceType("售后");
		type3.setId(3);
		types.add(type3);
		result.setData(types);
		return result;
	}

	@RequestMapping("/device/{qrcode}")
	public Result<Device> device(@PathVariable String qrcode) {
		Result<Device> result = new Result<Device>();
		Device device = new Device();
		device.setDeviceQrcode(qrcode);
		// List<Device> devices = deviceService.findByQrcode(device);
		List<Device> devices = deviceService.findByDevice(device);
		if (!CollectionUtils.isEmpty(devices)) {
			result.setStatus((byte) 0);
			result.setMsg("获取设备成功!");
			result.setData(devices.get(0));
			// List<ServiceInfo> services = new ArrayList<ServiceInfo>();
			// ServiceInfo sevice = new ServiceInfo();
			// sevice.setServiceType(new ServiceType());
			// services.add(sevice);
			// device.setServices(services);
		} else {
			result.setStatus((byte) 1);
			result.setMsg("设备不存在!");
		}
		return result;
	}

	@RequestMapping(value = "/device/{page}/{row}", method = RequestMethod.POST)
	public Result<Pager<Device>> devices(HttpServletRequest request,
			@PathVariable("row") int row, @PathVariable("page") int pageIndex) {
		Result<Pager<Device>> result = new Result<Pager<Device>>();
		String data = request.getParameter("data");
		Pager<Device> page = new Pager<Device>();
		try {
			page.setRows(row);
			page.setPage(pageIndex);
			Device device = null;
			if (data != null) {
				device = JacksonUtil.readValue(data, Device.class);
			}
			deviceService.list(device, page);
			result.setData(page);
			result.setStatus((byte) 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 追加产品信息
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = ("/device"), method = RequestMethod.POST)
	public Result addDevice(HttpServletRequest request) {
		Result result = new Result();
		String data = request.getParameter("data");
		try {
			Device device = JacksonUtil.readValue(data, Device.class);
			// 新增时检查是否设备ID已经绑定了二维码
			if (device != null && StringUtils.isEmpty(device.getId())) {
				if (deviceService.isExist(device.getDeviceCode())) {
					result.setStatus((byte) 2);
					return result;
				}
			}
			deviceService.addOrUpdateDevice(device);
			result.setStatus((byte) 0);
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus((byte) 1);
		}
		return result;
	}

	/**
	 * 追加服务信息
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = ("/device/service"), method = RequestMethod.POST)
	public Result addDeviceService(HttpServletRequest request) {
		Result result = new Result();
		String data = request.getParameter("data");
		try {
			ServiceInfo service = JacksonUtil
					.readValue(data, ServiceInfo.class);
			serviceInfoService.addOrUpdateService(service);
			result.setStatus((byte) 0);
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus((byte) 1);
		}
		return result;
	}
}
