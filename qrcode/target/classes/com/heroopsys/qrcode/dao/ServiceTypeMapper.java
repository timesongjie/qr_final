package com.heroopsys.qrcode.dao;

import com.heroopsys.qrcode.entity.ServiceType;

public interface ServiceTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ServiceType record);

    int insertSelective(ServiceType record);

    ServiceType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ServiceType record);

    int updateByPrimaryKey(ServiceType record);
}