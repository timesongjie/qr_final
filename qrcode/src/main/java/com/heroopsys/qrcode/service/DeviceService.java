package com.heroopsys.qrcode.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.heroopsys.qrcode.dao.DeviceMapper;
import com.heroopsys.qrcode.entity.Device;
import com.heroopsys.qrcode.entity.DeviceExample;
import com.heroopsys.qrcode.entity.DeviceExample.Criteria;
import com.heroopsys.qrcode.util.Pager;
import com.heroopsys.qrcode.util.SqlUtil;

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
				criteria.andDeviceQrcodeLike(SqlUtil.getLikeCondition(device.getDeviceQrcode()));
			}
			if (!StringUtils.isEmpty(device.getDeviceCode())) {
				criteria.andDeviceCodeLike(SqlUtil.getLikeCondition(device.getDeviceCode()));
			}
			if (!StringUtils.isEmpty(device.getProjectName())) {
				criteria.andProjectNameLike(SqlUtil.getLikeCondition(device.getProjectName()));
			}
			if (!StringUtils.isEmpty(device.getProjectLeader())) {
				criteria.andProjectLeaderLike(SqlUtil.getLikeCondition(device.getProjectLeader()));
			}
			if (!StringUtils.isEmpty(device.getClientName())) {
				criteria.andClientNameLike(SqlUtil.getLikeCondition(device.getClientName()));
			}
			if (!StringUtils.isEmpty(device.getSimPhone())) {
				criteria.andSimPhoneLike(SqlUtil.getLikeCondition(device.getSimPhone()));
			}
			if (StringUtils.isNotBlank(device.getContractPoint())) {
				criteria.andContractPointLike(SqlUtil.getLikeCondition(device.getContractPoint()));
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

	public boolean isExist(String deviceCode) {
		DeviceExample device = new DeviceExample();
		Criteria criteria = device.createCriteria();
		criteria.andDeviceCodeEqualTo(deviceCode);
		List<Device> devices = deviceMapper.selectByExampleAndPager(device, null);
		if(CollectionUtils.isEmpty(devices)){
			return false;
		}
		return true;
	}
	
}
