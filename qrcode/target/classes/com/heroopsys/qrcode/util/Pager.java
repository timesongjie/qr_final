package com.heroopsys.qrcode.util;

import java.io.Serializable;
import java.util.List;

/**
 * Created by time on 15-12-16.
 */
public class Pager<T> implements Serializable {

    public enum OrderType {
	asc, desc
    }

    private static final long serialVersionUID = 1L;

    private int page = 1;// 当前页

    private int rows = 10;// 每页显示记录数

    private int offset = 0;

    private String sort;// 排序字段

    private String order = OrderType.asc.name();// asc/desc

    private List<T> dataList;// 数据列表

    private int total;// 总记录数

    public int getPage() {
	return page;
    }

    public void setPage(int page) {
	this.page = page;
    }

    public int getRows() {
	return rows;
    }

    public void setRows(int rows) {
	this.rows = rows;
    }

    public String getSort() {
	return sort;
    }

    public void setSort(String sort) {
	this.sort = sort;
    }

    public String getOrder() {
	return order;
    }

    public void setOrder(String order) {
	this.order = order;
    }

    public List<T> getDataList() {
	return dataList;
    }

    public void setDataList(List<T> dataList) {
	this.dataList = dataList;
    }

    public int getTotal() {
	return total;
    }

    public void setTotal(int total) {
	this.total = total;
    }

    public int getOffset() {
	if (this.page <= 0) {
	    this.page = 1;
	}
	return (this.page - 1) * rows;
    }

    public void setOffset(int offset) {
	this.offset = offset;
    }
}