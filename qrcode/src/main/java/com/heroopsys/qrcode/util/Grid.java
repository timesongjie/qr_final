package com.heroopsys.qrcode.util;

import java.io.Serializable;
import java.util.List;

public class Grid<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<T> rows;// 数据列表

    private Integer total;// 总记录数

    public List<T> getRows() {
	return rows;
    }

    public void setRows(List<T> rows) {
	this.rows = rows;
    }

    public Integer getTotal() {
	return total;
    }

    public void setTotal(Integer total) {
	this.total = total;
    }
}