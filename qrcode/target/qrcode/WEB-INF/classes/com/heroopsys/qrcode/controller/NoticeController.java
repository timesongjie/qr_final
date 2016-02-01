package com.heroopsys.qrcode.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.heroopsys.qrcode.common.controller.BaseController;
import com.heroopsys.qrcode.entity.Account;
import com.heroopsys.qrcode.entity.Notice;
import com.heroopsys.qrcode.service.NoticeService;
import com.heroopsys.qrcode.util.Grid;
import com.heroopsys.qrcode.util.Pager;
import com.heroopsys.qrcode.util.Result;

@Controller
@RequestMapping("/notice")
public class NoticeController extends BaseController {

    @Resource
    private NoticeService noticeService;
    private Logger log = LoggerFactory.getLogger(NoticeController.class);

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Grid<Notice> list(Integer page, Integer rows) {
	if (page == null) {
	    page = 1;
	}
	if (rows == null) {
	    rows = 20;
	}
	Notice notice = new Notice();
	Pager<Notice> pager = new Pager<Notice>();
	pager.setPage(page);
	pager.setRows(rows);
	Grid<Notice> grid = new Grid<Notice>();
	try {
	    noticeService.list(notice, pager);
	} catch (Exception e) {
	    e.printStackTrace();
	    log.error("查询设备列表报错，联系管理员!" + e.getMessage());
	}
	grid.setRows(pager.getDataList());
	grid.setTotal(pager.getTotal());
	return grid;
    };

    @RequestMapping
    public Result addNotice(Notice notice, Model model) {
	notice.setAddDate(new Date());
	noticeService.add(notice);
	doClear(model, "notice");
	return new Result("添加成功", true);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public Result updateNotice(Notice notice, Model model) {
	noticeService.updateNotice(notice);
	doClear(model, "notice");
	return new Result("更新成功!", true);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getNoticeById(@PathVariable Integer  id, Model model) {
	Notice notice = noticeService.getById(id);
	model.addAttribute("notice", notice);
	return "notice/noticeEdit";
    }
}
