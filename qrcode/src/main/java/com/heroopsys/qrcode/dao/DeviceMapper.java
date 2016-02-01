package com.heroopsys.qrcode.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.heroopsys.qrcode.entity.Device;
import com.heroopsys.qrcode.entity.DeviceExample;
import com.heroopsys.qrcode.util.Pager;

public interface DeviceMapper {
    int countByExample(@Param("example") DeviceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Device record);

    int insertSelective(Device record);

    List<Device> selectByExampleAndPager(@Param("example") DeviceExample example, @Param("page") Pager<Device> page);

    Device selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
}