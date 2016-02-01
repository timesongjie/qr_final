package com.heroopsys.qrcode.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.heroopsys.qrcode.entity.Notice;
import com.heroopsys.qrcode.util.Pager;

public interface NoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);

    int countByNotice(Notice notice);

    List<Notice> selectByNotice(@Param("notice") Notice notice, @Param("page") Pager<Notice> pager);

    Notice getNewest();
}