package com.heroopsys.qrcode.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.heroopsys.qrcode.entity.ServiceExample;
import com.heroopsys.qrcode.entity.ServiceInfo;
import com.heroopsys.qrcode.util.Pager;

public interface ServiceMapper {
    int countByExample(@Param("example") ServiceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ServiceInfo record);

    int insertSelective(ServiceInfo record);

    List<ServiceInfo> selectByExampleAndPager(@Param("example") ServiceExample example,
	    @Param("page") Pager<ServiceInfo> page);

    ServiceInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ServiceInfo record);

    int updateByPrimaryKey(ServiceInfo record);

    List<ServiceInfo> selectByDeviceCode(String deviceCode);

}