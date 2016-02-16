package com.heroopsys.qrcode.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.heroopsys.qrcode.dao.DeviceMapper;
import com.heroopsys.qrcode.entity.Device;
import com.heroopsys.qrcode.entity.DeviceExample;
import com.heroopsys.qrcode.entity.DeviceExample.Criteria;
import com.heroopsys.qrcode.util.Pager;

@Service
public class DeviceService {

	@Resource
	private DeviceMapper deviceMapper;

	public void list(Device device, Pager<Device> pager) throws Exception {
		DeviceExample example = new DeviceExample();
		if (device != null) {
			Criteria criteria = example.createCriteria();
			if (!StringUtils.isEmpty(device.getDeviceQrcode())) {
				// criteria.andDeviceCodeEqualTo(device.getDeviceQrcode());
				criteria.andDeviceQrcodeLike(device.getDeviceQrcode());
			}
			if (!StringUtils.isEmpty(device.getDeviceCode())) {
				criteria.andDeviceCodeLike(device.getDeviceCode());
			}
			if (!StringUtils.isEmpty(device.getProjectName())) {
				criteria.andProjectNameLike(device.getProjectName());
			}
			if (!StringUtils.isEmpty(device.getProjectLeader())) {
				criteria.andProjectLeaderLike(device.getProjectLeader());
			}
			if (!StringUtils.isEmpty(device.getClientName())) {
				criteria.andClientNameLike(device.getClientName());
			}
			if (!StringUtils.isEmpty(device.getSimPhone())) {
				criteria.andSimPhoneLike(device.getSimPhone());
			}
			if (StringUtils.isNotBlank(device.getContractPoint())) {
				criteria.andContractPointLike(device.getContractPoint());
			}
			// ....可以按照条件新增
		}
		example.setOrderByClause("debug_date desc");
		pager.setTotal(deviceMapper.countByExample(example));
		pager.setDataList(deviceMapper.selectByExampleAndPager(example, pager));
	}

	public void addOrUpdateDevice(Device device) {
		if (device.getId() != null) {
			deviceMapper.updateByPrimaryKey(device);
		} else {
			deviceMapper.insert(device);
		}
	}

	public List<Device> findByQrcode(Device device) {
		DeviceExample example = new DeviceExample();
		example.createCriteria().andDeviceQrcodeEqualTo(
				device.getDeviceQrcode());
		return deviceMapper.selectByExampleAndPager(example, null);
	}

	public List<Device> findByDevice(Device device) {
		DeviceExample example = new DeviceExample();
		Criteria criteria = example.createCriteria();
		if (device.getDeviceQrcode() != null) {
			criteria.andDeviceQrcodeEqualTo(device.getDeviceQrcode());
		}
		if (device.getId() != null) {
			criteria.andIdEqualTo(device.getId());
		}
		return deviceMapper.selectByExampleAndPager(example, null);
	}

	public Device findById(Integer id) {
		return deviceMapper.selectByPrimaryKey(id);
	}
}
