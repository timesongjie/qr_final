package com.heroopsys.qrcode;

import java.util.List;

import junit.framework.Assert;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.heroopsys.qrcode.dao.AccountMapper;
import com.heroopsys.qrcode.dao.DeviceMapper;
import com.heroopsys.qrcode.entity.Account;
import com.heroopsys.qrcode.entity.Device;
import com.heroopsys.qrcode.entity.DeviceExample;
import com.heroopsys.qrcode.entity.DeviceExample.Criteria;
import com.heroopsys.qrcode.util.Pager;

/**
 * Created by time on 15-12-14.
 */
public class MapperTest {
    private ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "spring*.xml" });
    private SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) ctx.getBean("sqlSessionFactory");

    private AccountMapper accountMapper = (AccountMapper) ctx.getBean("accountMapper");

    private DeviceMapper deviceMapper = (DeviceMapper) ctx.getBean("deviceMapper");

    @Test
    public void mapperTest() {
	// SqlSession session = sqlSessionFactory.openSession();
	// Account account = new Account();
	// account.setName("hello");
	// account.setPassword("123456");
	// session.getMapper(AccountMapper.class).addAccount(account);
	// Integer count = 0;
	Account account = new Account();
	account.setName("hello");
	// count = accountMapper.count(account);
	// System.out.println(count);

	Pager<Account> pager = new Pager<Account>();
	pager.setPage(1);
	pager.setRows(20);
	accountMapper.listAllByPager(account, pager);
    }

    @Test
    public void deviceMapperTest() {
	Device device = new Device();
	device.setProjectLeader("lucy");
	DeviceExample example = new DeviceExample();
	if (device != null) {
	    Criteria criteria = example.createCriteria();
	    if (device.getDeviceCode() != null) {
		criteria.andDeviceCodeEqualTo(device.getDeviceCode());
	    }
	    if (device.getProjectName() != null) {
		criteria.andProjectNameEqualTo(device.getProjectName());
	    }
	    if (device.getProjectLeader() != null) {
		criteria.andProjectLeaderEqualTo(device.getProjectLeader());
	    }
	    if (device.getClientName() != null) {
		criteria.andClientNameEqualTo(device.getClientName());
	    }
	    if (device.getSimPhone() != null) {
		criteria.andSimPhoneEqualTo(device.getSimPhone());
	    }
	}
	
	Pager<Device> page = new Pager<Device>();
	page.setRows(1);
	page.setOffset(20);
	deviceMapper.countByExample(example);
	List<Device> devices = deviceMapper.selectByExampleAndPager(example,page);
	Assert.assertNotNull(devices);
	Assert.assertEquals(1, devices.size());
    }

}
