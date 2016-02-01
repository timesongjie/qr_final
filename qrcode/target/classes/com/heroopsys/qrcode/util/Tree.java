package com.heroopsys.qrcode.util;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Tree implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String text;

    private String state;

    private String iconCls;

    private boolean checked;

    private List<Tree> children;

    private Map<String, Object> attributes;

    public Tree() {

    }

    public Tree(String text, Long id) {
	this.text = text;
	this.id = id;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getText() {
	return text;
    }

    public void setText(String text) {
	this.text = text;
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state;
    }

    public String getIconCls() {
	return iconCls;
    }

    public void setIconCls(String iconCls) {
	this.iconCls = iconCls;
    }

    public boolean isChecked() {
	return checked;
    }

    public void setChecked(boolean checked) {
	this.checked = checked;
    }

    public List<Tree> getChildren() {
	return children;
    }

    public void setChildren(List<Tree> children) {
	this.children = children;
    }

    public Map<String, Object> getAttributes() {
	return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
	this.attributes = attributes;
    }

}