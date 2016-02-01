package com.heroopsys.qrcode.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.heroopsys.qrcode.dao.NoticeMapper;
import com.heroopsys.qrcode.entity.Notice;
import com.heroopsys.qrcode.util.Pager;

@Service
public class NoticeService {

    @Resource
    private NoticeMapper noticeMapper;

    public void list(Notice notice, Pager<Notice> pager) {
	pager.setTotal(noticeMapper.countByNotice(notice));
	pager.setDataList(noticeMapper.selectByNotice(notice, pager));
    }

    public void add(Notice notice) {
	noticeMapper.insert(notice);
    }

    public void updateNotice(Notice notice) {
	Assert.notNull(notice.getId());
	noticeMapper.updateByPrimaryKey(notice);
    }

    public Notice getById(Integer id) {
	return noticeMapper.selectByPrimaryKey(id);
    }

    public Notice getNewest() {
	return noticeMapper.getNewest();
    }
}
