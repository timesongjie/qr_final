package com.heroopsys.qrcode.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceExample() {
	oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
	this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
	return orderByClause;
    }

    public void setDistinct(boolean distinct) {
	this.distinct = distinct;
    }

    public boolean isDistinct() {
	return distinct;
    }

    public List<Criteria> getOredCriteria() {
	return oredCriteria;
    }

    public void or(Criteria criteria) {
	oredCriteria.add(criteria);
    }

    public Criteria or() {
	Criteria criteria = createCriteriaInternal();
	oredCriteria.add(criteria);
	return criteria;
    }

    public Criteria createCriteria() {
	Criteria criteria = createCriteriaInternal();
	if (oredCriteria.size() == 0) {
	    oredCriteria.add(criteria);
	}
	return criteria;
    }

    protected Criteria createCriteriaInternal() {
	Criteria criteria = new Criteria();
	return criteria;
    }

    public void clear() {
	oredCriteria.clear();
	orderByClause = null;
	distinct = false;
    }

    protected abstract static class GeneratedCriteria {
	protected List<Criterion> criteria;

	protected GeneratedCriteria() {
	    super();
	    criteria = new ArrayList<Criterion>();
	}

	public boolean isValid() {
	    return criteria.size() > 0;
	}

	public List<Criterion> getAllCriteria() {
	    return criteria;
	}

	public List<Criterion> getCriteria() {
	    return criteria;
	}

	protected void addCriterion(String condition) {
	    if (condition == null) {
		throw new RuntimeException("Value for condition cannot be null");
	    }
	    criteria.add(new Criterion(condition));
	}

	protected void addCriterion(String condition, Object value, String property) {
	    if (value == null) {
		throw new RuntimeException("Value for " + property + " cannot be null");
	    }
	    criteria.add(new Criterion(condition, value));
	}

	protected void addCriterion(String condition, Object value1, Object value2, String property) {
	    if (value1 == null || value2 == null) {
		throw new RuntimeException("Between values for " + property + " cannot be null");
	    }
	    criteria.add(new Criterion(condition, value1, value2));
	}

	public Criteria andIdIsNull() {
	    addCriterion("id is null");
	    return (Criteria) this;
	}

	public Criteria andIdIsNotNull() {
	    addCriterion("id is not null");
	    return (Criteria) this;
	}

	public Criteria andIdEqualTo(Integer value) {
	    addCriterion("id =", value, "id");
	    return (Criteria) this;
	}

	public Criteria andIdNotEqualTo(Integer value) {
	    addCriterion("id <>", value, "id");
	    return (Criteria) this;
	}

	public Criteria andIdGreaterThan(Integer value) {
	    addCriterion("id >", value, "id");
	    return (Criteria) this;
	}

	public Criteria andIdGreaterThanOrEqualTo(Integer value) {
	    addCriterion("id >=", value, "id");
	    return (Criteria) this;
	}

	public Criteria andIdLessThan(Integer value) {
	    addCriterion("id <", value, "id");
	    return (Criteria) this;
	}

	public Criteria andIdLessThanOrEqualTo(Integer value) {
	    addCriterion("id <=", value, "id");
	    return (Criteria) this;
	}

	public Criteria andIdIn(List<Integer> values) {
	    addCriterion("id in", values, "id");
	    return (Criteria) this;
	}

	public Criteria andIdNotIn(List<Integer> values) {
	    addCriterion("id not in", values, "id");
	    return (Criteria) this;
	}

	public Criteria andIdBetween(Integer value1, Integer value2) {
	    addCriterion("id between", value1, value2, "id");
	    return (Criteria) this;
	}

	public Criteria andIdNotBetween(Integer value1, Integer value2) {
	    addCriterion("id not between", value1, value2, "id");
	    return (Criteria) this;
	}

	public Criteria andDeviceCodeIsNull() {
	    addCriterion("device_code is null");
	    return (Criteria) this;
	}

	public Criteria andDeviceCodeIsNotNull() {
	    addCriterion("device_code is not null");
	    return (Criteria) this;
	}

	public Criteria andDeviceCodeEqualTo(String value) {
	    addCriterion("device_code =", value, "deviceCode");
	    return (Criteria) this;
	}

	public Criteria andDeviceCodeNotEqualTo(String value) {
	    addCriterion("device_code <>", value, "deviceCode");
	    return (Criteria) this;
	}

	public Criteria andDeviceCodeGreaterThan(String value) {
	    addCriterion("device_code >", value, "deviceCode");
	    return (Criteria) this;
	}

	public Criteria andDeviceCodeGreaterThanOrEqualTo(String value) {
	    addCriterion("device_code >=", value, "deviceCode");
	    return (Criteria) this;
	}

	public Criteria andDeviceCodeLessThan(String value) {
	    addCriterion("device_code <", value, "deviceCode");
	    return (Criteria) this;
	}

	public Criteria andDeviceCodeLessThanOrEqualTo(String value) {
	    addCriterion("device_code <=", value, "deviceCode");
	    return (Criteria) this;
	}

	public Criteria andDeviceCodeLike(String value) {
	    addCriterion("device_code like", value, "deviceCode");
	    return (Criteria) this;
	}

	public Criteria andDeviceCodeNotLike(String value) {
	    addCriterion("device_code not like", value, "deviceCode");
	    return (Criteria) this;
	}

	public Criteria andDeviceCodeIn(List<String> values) {
	    addCriterion("device_code in", values, "deviceCode");
	    return (Criteria) this;
	}

	public Criteria andDeviceCodeNotIn(List<String> values) {
	    addCriterion("device_code not in", values, "deviceCode");
	    return (Criteria) this;
	}

	public Criteria andDeviceCodeBetween(String value1, String value2) {
	    addCriterion("device_code between", value1, value2, "deviceCode");
	    return (Criteria) this;
	}

	public Criteria andDeviceCodeNotBetween(String value1, String value2) {
	    addCriterion("device_code not between", value1, value2, "deviceCode");
	    return (Criteria) this;
	}

	public Criteria andDeviceModelIsNull() {
	    addCriterion("device_model is null");
	    return (Criteria) this;
	}

	public Criteria andDeviceModelIsNotNull() {
	    addCriterion("device_model is not null");
	    return (Criteria) this;
	}

	public Criteria andDeviceModelEqualTo(String value) {
	    addCriterion("device_model =", value, "deviceModel");
	    return (Criteria) this;
	}

	public Criteria andDeviceModelNotEqualTo(String value) {
	    addCriterion("device_model <>", value, "deviceModel");
	    return (Criteria) this;
	}

	public Criteria andDeviceModelGreaterThan(String value) {
	    addCriterion("device_model >", value, "deviceModel");
	    return (Criteria) this;
	}

	public Criteria andDeviceModelGreaterThanOrEqualTo(String value) {
	    addCriterion("device_model >=", value, "deviceModel");
	    return (Criteria) this;
	}

	public Criteria andDeviceModelLessThan(String value) {
	    addCriterion("device_model <", value, "deviceModel");
	    return (Criteria) this;
	}

	public Criteria andDeviceModelLessThanOrEqualTo(String value) {
	    addCriterion("device_model <=", value, "deviceModel");
	    return (Criteria) this;
	}

	public Criteria andDeviceModelLike(String value) {
	    addCriterion("device_model like", value, "deviceModel");
	    return (Criteria) this;
	}

	public Criteria andDeviceModelNotLike(String value) {
	    addCriterion("device_model not like", value, "deviceModel");
	    return (Criteria) this;
	}

	public Criteria andDeviceModelIn(List<String> values) {
	    addCriterion("device_model in", values, "deviceModel");
	    return (Criteria) this;
	}

	public Criteria andDeviceModelNotIn(List<String> values) {
	    addCriterion("device_model not in", values, "deviceModel");
	    return (Criteria) this;
	}

	public Criteria andDeviceModelBetween(String value1, String value2) {
	    addCriterion("device_model between", value1, value2, "deviceModel");
	    return (Criteria) this;
	}

	public Criteria andDeviceModelNotBetween(String value1, String value2) {
	    addCriterion("device_model not between", value1, value2, "deviceModel");
	    return (Criteria) this;
	}

	public Criteria andDeviceQrcodeIsNull() {
	    addCriterion("device_qrcode is null");
	    return (Criteria) this;
	}

	public Criteria andDeviceQrcodeIsNotNull() {
	    addCriterion("device_qrcode is not null");
	    return (Criteria) this;
	}

	public Criteria andDeviceQrcodeEqualTo(String value) {
	    addCriterion("device_qrcode =", value, "deviceQrcode");
	    return (Criteria) this;
	}

	public Criteria andDeviceQrcodeNotEqualTo(String value) {
	    addCriterion("device_qrcode <>", value, "deviceQrcode");
	    return (Criteria) this;
	}

	public Criteria andDeviceQrcodeGreaterThan(String value) {
	    addCriterion("device_qrcode >", value, "deviceQrcode");
	    return (Criteria) this;
	}

	public Criteria andDeviceQrcodeGreaterThanOrEqualTo(String value) {
	    addCriterion("device_qrcode >=", value, "deviceQrcode");
	    return (Criteria) this;
	}

	public Criteria andDeviceQrcodeLessThan(String value) {
	    addCriterion("device_qrcode <", value, "deviceQrcode");
	    return (Criteria) this;
	}

	public Criteria andDeviceQrcodeLessThanOrEqualTo(String value) {
	    addCriterion("device_qrcode <=", value, "deviceQrcode");
	    return (Criteria) this;
	}

	public Criteria andDeviceQrcodeLike(String value) {
	    addCriterion("device_qrcode like", value, "deviceQrcode");
	    return (Criteria) this;
	}

	public Criteria andDeviceQrcodeNotLike(String value) {
	    addCriterion("device_qrcode not like", value, "deviceQrcode");
	    return (Criteria) this;
	}

	public Criteria andDeviceQrcodeIn(List<String> values) {
	    addCriterion("device_qrcode in", values, "deviceQrcode");
	    return (Criteria) this;
	}

	public Criteria andDeviceQrcodeNotIn(List<String> values) {
	    addCriterion("device_qrcode not in", values, "deviceQrcode");
	    return (Criteria) this;
	}

	public Criteria andDeviceQrcodeBetween(String value1, String value2) {
	    addCriterion("device_qrcode between", value1, value2, "deviceQrcode");
	    return (Criteria) this;
	}

	public Criteria andDeviceQrcodeNotBetween(String value1, String value2) {
	    addCriterion("device_qrcode not between", value1, value2, "deviceQrcode");
	    return (Criteria) this;
	}

	public Criteria andProjectNameIsNull() {
	    addCriterion("project_name is null");
	    return (Criteria) this;
	}

	public Criteria andProjectNameIsNotNull() {
	    addCriterion("project_name is not null");
	    return (Criteria) this;
	}

	public Criteria andProjectNameEqualTo(String value) {
	    addCriterion("project_name =", value, "projectName");
	    return (Criteria) this;
	}

	public Criteria andProjectNameNotEqualTo(String value) {
	    addCriterion("project_name <>", value, "projectName");
	    return (Criteria) this;
	}

	public Criteria andProjectNameGreaterThan(String value) {
	    addCriterion("project_name >", value, "projectName");
	    return (Criteria) this;
	}

	public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
	    addCriterion("project_name >=", value, "projectName");
	    return (Criteria) this;
	}

	public Criteria andProjectNameLessThan(String value) {
	    addCriterion("project_name <", value, "projectName");
	    return (Criteria) this;
	}

	public Criteria andProjectNameLessThanOrEqualTo(String value) {
	    addCriterion("project_name <=", value, "projectName");
	    return (Criteria) this;
	}

	public Criteria andProjectNameLike(String value) {
	    addCriterion("project_name like", value, "projectName");
	    return (Criteria) this;
	}

	public Criteria andProjectNameNotLike(String value) {
	    addCriterion("project_name not like", value, "projectName");
	    return (Criteria) this;
	}

	public Criteria andProjectNameIn(List<String> values) {
	    addCriterion("project_name in", values, "projectName");
	    return (Criteria) this;
	}

	public Criteria andProjectNameNotIn(List<String> values) {
	    addCriterion("project_name not in", values, "projectName");
	    return (Criteria) this;
	}

	public Criteria andProjectNameBetween(String value1, String value2) {
	    addCriterion("project_name between", value1, value2, "projectName");
	    return (Criteria) this;
	}

	public Criteria andProjectNameNotBetween(String value1, String value2) {
	    addCriterion("project_name not between", value1, value2, "projectName");
	    return (Criteria) this;
	}

	public Criteria andProjectLeaderIsNull() {
	    addCriterion("project_leader is null");
	    return (Criteria) this;
	}

	public Criteria andProjectLeaderIsNotNull() {
	    addCriterion("project_leader is not null");
	    return (Criteria) this;
	}

	public Criteria andProjectLeaderEqualTo(String value) {
	    addCriterion("project_leader =", value, "projectLeader");
	    return (Criteria) this;
	}

	public Criteria andProjectLeaderNotEqualTo(String value) {
	    addCriterion("project_leader <>", value, "projectLeader");
	    return (Criteria) this;
	}

	public Criteria andProjectLeaderGreaterThan(String value) {
	    addCriterion("project_leader >", value, "projectLeader");
	    return (Criteria) this;
	}

	public Criteria andProjectLeaderGreaterThanOrEqualTo(String value) {
	    addCriterion("project_leader >=", value, "projectLeader");
	    return (Criteria) this;
	}

	public Criteria andProjectLeaderLessThan(String value) {
	    addCriterion("project_leader <", value, "projectLeader");
	    return (Criteria) this;
	}

	public Criteria andProjectLeaderLessThanOrEqualTo(String value) {
	    addCriterion("project_leader <=", value, "projectLeader");
	    return (Criteria) this;
	}

	public Criteria andProjectLeaderLike(String value) {
	    addCriterion("project_leader like", value, "projectLeader");
	    return (Criteria) this;
	}

	public Criteria andProjectLeaderNotLike(String value) {
	    addCriterion("project_leader not like", value, "projectLeader");
	    return (Criteria) this;
	}

	public Criteria andProjectLeaderIn(List<String> values) {
	    addCriterion("project_leader in", values, "projectLeader");
	    return (Criteria) this;
	}

	public Criteria andProjectLeaderNotIn(List<String> values) {
	    addCriterion("project_leader not in", values, "projectLeader");
	    return (Criteria) this;
	}

	public Criteria andProjectLeaderBetween(String value1, String value2) {
	    addCriterion("project_leader between", value1, value2, "projectLeader");
	    return (Criteria) this;
	}

	public Criteria andProjectLeaderNotBetween(String value1, String value2) {
	    addCriterion("project_leader not between", value1, value2, "projectLeader");
	    return (Criteria) this;
	}

	public Criteria andProjectOthersIsNull() {
	    addCriterion("project_others is null");
	    return (Criteria) this;
	}

	public Criteria andProjectOthersIsNotNull() {
	    addCriterion("project_others is not null");
	    return (Criteria) this;
	}

	public Criteria andProjectOthersEqualTo(String value) {
	    addCriterion("project_others =", value, "projectOthers");
	    return (Criteria) this;
	}

	public Criteria andProjectOthersNotEqualTo(String value) {
	    addCriterion("project_others <>", value, "projectOthers");
	    return (Criteria) this;
	}

	public Criteria andProjectOthersGreaterThan(String value) {
	    addCriterion("project_others >", value, "projectOthers");
	    return (Criteria) this;
	}

	public Criteria andProjectOthersGreaterThanOrEqualTo(String value) {
	    addCriterion("project_others >=", value, "projectOthers");
	    return (Criteria) this;
	}

	public Criteria andProjectOthersLessThan(String value) {
	    addCriterion("project_others <", value, "projectOthers");
	    return (Criteria) this;
	}

	public Criteria andProjectOthersLessThanOrEqualTo(String value) {
	    addCriterion("project_others <=", value, "projectOthers");
	    return (Criteria) this;
	}

	public Criteria andProjectOthersLike(String value) {
	    addCriterion("project_others like", value, "projectOthers");
	    return (Criteria) this;
	}

	public Criteria andProjectOthersNotLike(String value) {
	    addCriterion("project_others not like", value, "projectOthers");
	    return (Criteria) this;
	}

	public Criteria andProjectOthersIn(List<String> values) {
	    addCriterion("project_others in", values, "projectOthers");
	    return (Criteria) this;
	}

	public Criteria andProjectOthersNotIn(List<String> values) {
	    addCriterion("project_others not in", values, "projectOthers");
	    return (Criteria) this;
	}

	public Criteria andProjectOthersBetween(String value1, String value2) {
	    addCriterion("project_others between", value1, value2, "projectOthers");
	    return (Criteria) this;
	}

	public Criteria andProjectOthersNotBetween(String value1, String value2) {
	    addCriterion("project_others not between", value1, value2, "projectOthers");
	    return (Criteria) this;
	}

	public Criteria andDebugDateIsNull() {
	    addCriterion("debug_date is null");
	    return (Criteria) this;
	}

	public Criteria andDebugDateIsNotNull() {
	    addCriterion("debug_date is not null");
	    return (Criteria) this;
	}

	public Criteria andDebugDateEqualTo(Date value) {
	    addCriterion("debug_date =", value, "debugDate");
	    return (Criteria) this;
	}

	public Criteria andDebugDateNotEqualTo(Date value) {
	    addCriterion("debug_date <>", value, "debugDate");
	    return (Criteria) this;
	}

	public Criteria andDebugDateGreaterThan(Date value) {
	    addCriterion("debug_date >", value, "debugDate");
	    return (Criteria) this;
	}

	public Criteria andDebugDateGreaterThanOrEqualTo(Date value) {
	    addCriterion("debug_date >=", value, "debugDate");
	    return (Criteria) this;
	}

	public Criteria andDebugDateLessThan(Date value) {
	    addCriterion("debug_date <", value, "debugDate");
	    return (Criteria) this;
	}

	public Criteria andDebugDateLessThanOrEqualTo(Date value) {
	    addCriterion("debug_date <=", value, "debugDate");
	    return (Criteria) this;
	}

	public Criteria andDebugDateIn(List<Date> values) {
	    addCriterion("debug_date in", values, "debugDate");
	    return (Criteria) this;
	}

	public Criteria andDebugDateNotIn(List<Date> values) {
	    addCriterion("debug_date not in", values, "debugDate");
	    return (Criteria) this;
	}

	public Criteria andDebugDateBetween(Date value1, Date value2) {
	    addCriterion("debug_date between", value1, value2, "debugDate");
	    return (Criteria) this;
	}

	public Criteria andDebugDateNotBetween(Date value1, Date value2) {
	    addCriterion("debug_date not between", value1, value2, "debugDate");
	    return (Criteria) this;
	}

	public Criteria andFinishDateIsNull() {
	    addCriterion("finish_date is null");
	    return (Criteria) this;
	}

	public Criteria andFinishDateIsNotNull() {
	    addCriterion("finish_date is not null");
	    return (Criteria) this;
	}

	public Criteria andFinishDateEqualTo(Date value) {
	    addCriterion("finish_date =", value, "finishDate");
	    return (Criteria) this;
	}

	public Criteria andFinishDateNotEqualTo(Date value) {
	    addCriterion("finish_date <>", value, "finishDate");
	    return (Criteria) this;
	}

	public Criteria andFinishDateGreaterThan(Date value) {
	    addCriterion("finish_date >", value, "finishDate");
	    return (Criteria) this;
	}

	public Criteria andFinishDateGreaterThanOrEqualTo(Date value) {
	    addCriterion("finish_date >=", value, "finishDate");
	    return (Criteria) this;
	}

	public Criteria andFinishDateLessThan(Date value) {
	    addCriterion("finish_date <", value, "finishDate");
	    return (Criteria) this;
	}

	public Criteria andFinishDateLessThanOrEqualTo(Date value) {
	    addCriterion("finish_date <=", value, "finishDate");
	    return (Criteria) this;
	}

	public Criteria andFinishDateIn(List<Date> values) {
	    addCriterion("finish_date in", values, "finishDate");
	    return (Criteria) this;
	}

	public Criteria andFinishDateNotIn(List<Date> values) {
	    addCriterion("finish_date not in", values, "finishDate");
	    return (Criteria) this;
	}

	public Criteria andFinishDateBetween(Date value1, Date value2) {
	    addCriterion("finish_date between", value1, value2, "finishDate");
	    return (Criteria) this;
	}

	public Criteria andFinishDateNotBetween(Date value1, Date value2) {
	    addCriterion("finish_date not between", value1, value2, "finishDate");
	    return (Criteria) this;
	}

	public Criteria andContractPointIsNull() {
	    addCriterion("contract_point is null");
	    return (Criteria) this;
	}

	public Criteria andContractPointIsNotNull() {
	    addCriterion("contract_point is not null");
	    return (Criteria) this;
	}

	public Criteria andContractPointEqualTo(String value) {
	    addCriterion("contract_point =", value, "contractPoint");
	    return (Criteria) this;
	}

	public Criteria andContractPointNotEqualTo(String value) {
	    addCriterion("contract_point <>", value, "contractPoint");
	    return (Criteria) this;
	}

	public Criteria andContractPointGreaterThan(String value) {
	    addCriterion("contract_point >", value, "contractPoint");
	    return (Criteria) this;
	}

	public Criteria andContractPointGreaterThanOrEqualTo(String value) {
	    addCriterion("contract_point >=", value, "contractPoint");
	    return (Criteria) this;
	}

	public Criteria andContractPointLessThan(String value) {
	    addCriterion("contract_point <", value, "contractPoint");
	    return (Criteria) this;
	}

	public Criteria andContractPointLessThanOrEqualTo(String value) {
	    addCriterion("contract_point <=", value, "contractPoint");
	    return (Criteria) this;
	}

	public Criteria andContractPointLike(String value) {
	    addCriterion("contract_point like", value, "contractPoint");
	    return (Criteria) this;
	}

	public Criteria andContractPointNotLike(String value) {
	    addCriterion("contract_point not like", value, "contractPoint");
	    return (Criteria) this;
	}

	public Criteria andContractPointIn(List<String> values) {
	    addCriterion("contract_point in", values, "contractPoint");
	    return (Criteria) this;
	}

	public Criteria andContractPointNotIn(List<String> values) {
	    addCriterion("contract_point not in", values, "contractPoint");
	    return (Criteria) this;
	}

	public Criteria andContractPointBetween(String value1, String value2) {
	    addCriterion("contract_point between", value1, value2, "contractPoint");
	    return (Criteria) this;
	}

	public Criteria andContractPointNotBetween(String value1, String value2) {
	    addCriterion("contract_point not between", value1, value2, "contractPoint");
	    return (Criteria) this;
	}

	public Criteria andClientNameIsNull() {
	    addCriterion("client_name is null");
	    return (Criteria) this;
	}

	public Criteria andClientNameIsNotNull() {
	    addCriterion("client_name is not null");
	    return (Criteria) this;
	}

	public Criteria andClientNameEqualTo(String value) {
	    addCriterion("client_name =", value, "clientName");
	    return (Criteria) this;
	}

	public Criteria andClientNameNotEqualTo(String value) {
	    addCriterion("client_name <>", value, "clientName");
	    return (Criteria) this;
	}

	public Criteria andClientNameGreaterThan(String value) {
	    addCriterion("client_name >", value, "clientName");
	    return (Criteria) this;
	}

	public Criteria andClientNameGreaterThanOrEqualTo(String value) {
	    addCriterion("client_name >=", value, "clientName");
	    return (Criteria) this;
	}

	public Criteria andClientNameLessThan(String value) {
	    addCriterion("client_name <", value, "clientName");
	    return (Criteria) this;
	}

	public Criteria andClientNameLessThanOrEqualTo(String value) {
	    addCriterion("client_name <=", value, "clientName");
	    return (Criteria) this;
	}

	public Criteria andClientNameLike(String value) {
	    addCriterion("client_name like", value, "clientName");
	    return (Criteria) this;
	}

	public Criteria andClientNameNotLike(String value) {
	    addCriterion("client_name not like", value, "clientName");
	    return (Criteria) this;
	}

	public Criteria andClientNameIn(List<String> values) {
	    addCriterion("client_name in", values, "clientName");
	    return (Criteria) this;
	}

	public Criteria andClientNameNotIn(List<String> values) {
	    addCriterion("client_name not in", values, "clientName");
	    return (Criteria) this;
	}

	public Criteria andClientNameBetween(String value1, String value2) {
	    addCriterion("client_name between", value1, value2, "clientName");
	    return (Criteria) this;
	}

	public Criteria andClientNameNotBetween(String value1, String value2) {
	    addCriterion("client_name not between", value1, value2, "clientName");
	    return (Criteria) this;
	}

	public Criteria andClientSiteIsNull() {
	    addCriterion("client_site is null");
	    return (Criteria) this;
	}

	public Criteria andClientSiteIsNotNull() {
	    addCriterion("client_site is not null");
	    return (Criteria) this;
	}

	public Criteria andClientSiteEqualTo(String value) {
	    addCriterion("client_site =", value, "clientSite");
	    return (Criteria) this;
	}

	public Criteria andClientSiteNotEqualTo(String value) {
	    addCriterion("client_site <>", value, "clientSite");
	    return (Criteria) this;
	}

	public Criteria andClientSiteGreaterThan(String value) {
	    addCriterion("client_site >", value, "clientSite");
	    return (Criteria) this;
	}

	public Criteria andClientSiteGreaterThanOrEqualTo(String value) {
	    addCriterion("client_site >=", value, "clientSite");
	    return (Criteria) this;
	}

	public Criteria andClientSiteLessThan(String value) {
	    addCriterion("client_site <", value, "clientSite");
	    return (Criteria) this;
	}

	public Criteria andClientSiteLessThanOrEqualTo(String value) {
	    addCriterion("client_site <=", value, "clientSite");
	    return (Criteria) this;
	}

	public Criteria andClientSiteLike(String value) {
	    addCriterion("client_site like", value, "clientSite");
	    return (Criteria) this;
	}

	public Criteria andClientSiteNotLike(String value) {
	    addCriterion("client_site not like", value, "clientSite");
	    return (Criteria) this;
	}

	public Criteria andClientSiteIn(List<String> values) {
	    addCriterion("client_site in", values, "clientSite");
	    return (Criteria) this;
	}

	public Criteria andClientSiteNotIn(List<String> values) {
	    addCriterion("client_site not in", values, "clientSite");
	    return (Criteria) this;
	}

	public Criteria andClientSiteBetween(String value1, String value2) {
	    addCriterion("client_site between", value1, value2, "clientSite");
	    return (Criteria) this;
	}

	public Criteria andClientSiteNotBetween(String value1, String value2) {
	    addCriterion("client_site not between", value1, value2, "clientSite");
	    return (Criteria) this;
	}

	public Criteria andClientIsNull() {
	    addCriterion("client is null");
	    return (Criteria) this;
	}

	public Criteria andClientIsNotNull() {
	    addCriterion("client is not null");
	    return (Criteria) this;
	}

	public Criteria andClientEqualTo(String value) {
	    addCriterion("client =", value, "client");
	    return (Criteria) this;
	}

	public Criteria andClientNotEqualTo(String value) {
	    addCriterion("client <>", value, "client");
	    return (Criteria) this;
	}

	public Criteria andClientGreaterThan(String value) {
	    addCriterion("client >", value, "client");
	    return (Criteria) this;
	}

	public Criteria andClientGreaterThanOrEqualTo(String value) {
	    addCriterion("client >=", value, "client");
	    return (Criteria) this;
	}

	public Criteria andClientLessThan(String value) {
	    addCriterion("client <", value, "client");
	    return (Criteria) this;
	}

	public Criteria andClientLessThanOrEqualTo(String value) {
	    addCriterion("client <=", value, "client");
	    return (Criteria) this;
	}

	public Criteria andClientLike(String value) {
	    addCriterion("client like", value, "client");
	    return (Criteria) this;
	}

	public Criteria andClientNotLike(String value) {
	    addCriterion("client not like", value, "client");
	    return (Criteria) this;
	}

	public Criteria andClientIn(List<String> values) {
	    addCriterion("client in", values, "client");
	    return (Criteria) this;
	}

	public Criteria andClientNotIn(List<String> values) {
	    addCriterion("client not in", values, "client");
	    return (Criteria) this;
	}

	public Criteria andClientBetween(String value1, String value2) {
	    addCriterion("client between", value1, value2, "client");
	    return (Criteria) this;
	}

	public Criteria andClientNotBetween(String value1, String value2) {
	    addCriterion("client not between", value1, value2, "client");
	    return (Criteria) this;
	}

	public Criteria andClientTelIsNull() {
	    addCriterion("client_tel is null");
	    return (Criteria) this;
	}

	public Criteria andClientTelIsNotNull() {
	    addCriterion("client_tel is not null");
	    return (Criteria) this;
	}

	public Criteria andClientTelEqualTo(String value) {
	    addCriterion("client_tel =", value, "clientTel");
	    return (Criteria) this;
	}

	public Criteria andClientTelNotEqualTo(String value) {
	    addCriterion("client_tel <>", value, "clientTel");
	    return (Criteria) this;
	}

	public Criteria andClientTelGreaterThan(String value) {
	    addCriterion("client_tel >", value, "clientTel");
	    return (Criteria) this;
	}

	public Criteria andClientTelGreaterThanOrEqualTo(String value) {
	    addCriterion("client_tel >=", value, "clientTel");
	    return (Criteria) this;
	}

	public Criteria andClientTelLessThan(String value) {
	    addCriterion("client_tel <", value, "clientTel");
	    return (Criteria) this;
	}

	public Criteria andClientTelLessThanOrEqualTo(String value) {
	    addCriterion("client_tel <=", value, "clientTel");
	    return (Criteria) this;
	}

	public Criteria andClientTelLike(String value) {
	    addCriterion("client_tel like", value, "clientTel");
	    return (Criteria) this;
	}

	public Criteria andClientTelNotLike(String value) {
	    addCriterion("client_tel not like", value, "clientTel");
	    return (Criteria) this;
	}

	public Criteria andClientTelIn(List<String> values) {
	    addCriterion("client_tel in", values, "clientTel");
	    return (Criteria) this;
	}

	public Criteria andClientTelNotIn(List<String> values) {
	    addCriterion("client_tel not in", values, "clientTel");
	    return (Criteria) this;
	}

	public Criteria andClientTelBetween(String value1, String value2) {
	    addCriterion("client_tel between", value1, value2, "clientTel");
	    return (Criteria) this;
	}

	public Criteria andClientTelNotBetween(String value1, String value2) {
	    addCriterion("client_tel not between", value1, value2, "clientTel");
	    return (Criteria) this;
	}

	public Criteria andActivationCodeIsNull() {
	    addCriterion("activation_code is null");
	    return (Criteria) this;
	}

	public Criteria andActivationCodeIsNotNull() {
	    addCriterion("activation_code is not null");
	    return (Criteria) this;
	}

	public Criteria andActivationCodeEqualTo(String value) {
	    addCriterion("activation_code =", value, "activationCode");
	    return (Criteria) this;
	}

	public Criteria andActivationCodeNotEqualTo(String value) {
	    addCriterion("activation_code <>", value, "activationCode");
	    return (Criteria) this;
	}

	public Criteria andActivationCodeGreaterThan(String value) {
	    addCriterion("activation_code >", value, "activationCode");
	    return (Criteria) this;
	}

	public Criteria andActivationCodeGreaterThanOrEqualTo(String value) {
	    addCriterion("activation_code >=", value, "activationCode");
	    return (Criteria) this;
	}

	public Criteria andActivationCodeLessThan(String value) {
	    addCriterion("activation_code <", value, "activationCode");
	    return (Criteria) this;
	}

	public Criteria andActivationCodeLessThanOrEqualTo(String value) {
	    addCriterion("activation_code <=", value, "activationCode");
	    return (Criteria) this;
	}

	public Criteria andActivationCodeLike(String value) {
	    addCriterion("activation_code like", value, "activationCode");
	    return (Criteria) this;
	}

	public Criteria andActivationCodeNotLike(String value) {
	    addCriterion("activation_code not like", value, "activationCode");
	    return (Criteria) this;
	}

	public Criteria andActivationCodeIn(List<String> values) {
	    addCriterion("activation_code in", values, "activationCode");
	    return (Criteria) this;
	}

	public Criteria andActivationCodeNotIn(List<String> values) {
	    addCriterion("activation_code not in", values, "activationCode");
	    return (Criteria) this;
	}

	public Criteria andActivationCodeBetween(String value1, String value2) {
	    addCriterion("activation_code between", value1, value2, "activationCode");
	    return (Criteria) this;
	}

	public Criteria andActivationCodeNotBetween(String value1, String value2) {
	    addCriterion("activation_code not between", value1, value2, "activationCode");
	    return (Criteria) this;
	}

	public Criteria andActivationCode2IsNull() {
	    addCriterion("activation_code2 is null");
	    return (Criteria) this;
	}

	public Criteria andActivationCode2IsNotNull() {
	    addCriterion("activation_code2 is not null");
	    return (Criteria) this;
	}

	public Criteria andActivationCode2EqualTo(String value) {
	    addCriterion("activation_code2 =", value, "activationCode2");
	    return (Criteria) this;
	}

	public Criteria andActivationCode2NotEqualTo(String value) {
	    addCriterion("activation_code2 <>", value, "activationCode2");
	    return (Criteria) this;
	}

	public Criteria andActivationCode2GreaterThan(String value) {
	    addCriterion("activation_code2 >", value, "activationCode2");
	    return (Criteria) this;
	}

	public Criteria andActivationCode2GreaterThanOrEqualTo(String value) {
	    addCriterion("activation_code2 >=", value, "activationCode2");
	    return (Criteria) this;
	}

	public Criteria andActivationCode2LessThan(String value) {
	    addCriterion("activation_code2 <", value, "activationCode2");
	    return (Criteria) this;
	}

	public Criteria andActivationCode2LessThanOrEqualTo(String value) {
	    addCriterion("activation_code2 <=", value, "activationCode2");
	    return (Criteria) this;
	}

	public Criteria andActivationCode2Like(String value) {
	    addCriterion("activation_code2 like", value, "activationCode2");
	    return (Criteria) this;
	}

	public Criteria andActivationCode2NotLike(String value) {
	    addCriterion("activation_code2 not like", value, "activationCode2");
	    return (Criteria) this;
	}

	public Criteria andActivationCode2In(List<String> values) {
	    addCriterion("activation_code2 in", values, "activationCode2");
	    return (Criteria) this;
	}

	public Criteria andActivationCode2NotIn(List<String> values) {
	    addCriterion("activation_code2 not in", values, "activationCode2");
	    return (Criteria) this;
	}

	public Criteria andActivationCode2Between(String value1, String value2) {
	    addCriterion("activation_code2 between", value1, value2, "activationCode2");
	    return (Criteria) this;
	}

	public Criteria andActivationCode2NotBetween(String value1, String value2) {
	    addCriterion("activation_code2 not between", value1, value2, "activationCode2");
	    return (Criteria) this;
	}

	public Criteria andActivationCode3IsNull() {
	    addCriterion("activation_code3 is null");
	    return (Criteria) this;
	}

	public Criteria andActivationCode3IsNotNull() {
	    addCriterion("activation_code3 is not null");
	    return (Criteria) this;
	}

	public Criteria andActivationCode3EqualTo(String value) {
	    addCriterion("activation_code3 =", value, "activationCode3");
	    return (Criteria) this;
	}

	public Criteria andActivationCode3NotEqualTo(String value) {
	    addCriterion("activation_code3 <>", value, "activationCode3");
	    return (Criteria) this;
	}

	public Criteria andActivationCode3GreaterThan(String value) {
	    addCriterion("activation_code3 >", value, "activationCode3");
	    return (Criteria) this;
	}

	public Criteria andActivationCode3GreaterThanOrEqualTo(String value) {
	    addCriterion("activation_code3 >=", value, "activationCode3");
	    return (Criteria) this;
	}

	public Criteria andActivationCode3LessThan(String value) {
	    addCriterion("activation_code3 <", value, "activationCode3");
	    return (Criteria) this;
	}

	public Criteria andActivationCode3LessThanOrEqualTo(String value) {
	    addCriterion("activation_code3 <=", value, "activationCode3");
	    return (Criteria) this;
	}

	public Criteria andActivationCode3Like(String value) {
	    addCriterion("activation_code3 like", value, "activationCode3");
	    return (Criteria) this;
	}

	public Criteria andActivationCode3NotLike(String value) {
	    addCriterion("activation_code3 not like", value, "activationCode3");
	    return (Criteria) this;
	}

	public Criteria andActivationCode3In(List<String> values) {
	    addCriterion("activation_code3 in", values, "activationCode3");
	    return (Criteria) this;
	}

	public Criteria andActivationCode3NotIn(List<String> values) {
	    addCriterion("activation_code3 not in", values, "activationCode3");
	    return (Criteria) this;
	}

	public Criteria andActivationCode3Between(String value1, String value2) {
	    addCriterion("activation_code3 between", value1, value2, "activationCode3");
	    return (Criteria) this;
	}

	public Criteria andActivationCode3NotBetween(String value1, String value2) {
	    addCriterion("activation_code3 not between", value1, value2, "activationCode3");
	    return (Criteria) this;
	}

	public Criteria andActivationCode4IsNull() {
	    addCriterion("activation_code4 is null");
	    return (Criteria) this;
	}

	public Criteria andActivationCode4IsNotNull() {
	    addCriterion("activation_code4 is not null");
	    return (Criteria) this;
	}

	public Criteria andActivationCode4EqualTo(String value) {
	    addCriterion("activation_code4 =", value, "activationCode4");
	    return (Criteria) this;
	}

	public Criteria andActivationCode4NotEqualTo(String value) {
	    addCriterion("activation_code4 <>", value, "activationCode4");
	    return (Criteria) this;
	}

	public Criteria andActivationCode4GreaterThan(String value) {
	    addCriterion("activation_code4 >", value, "activationCode4");
	    return (Criteria) this;
	}

	public Criteria andActivationCode4GreaterThanOrEqualTo(String value) {
	    addCriterion("activation_code4 >=", value, "activationCode4");
	    return (Criteria) this;
	}

	public Criteria andActivationCode4LessThan(String value) {
	    addCriterion("activation_code4 <", value, "activationCode4");
	    return (Criteria) this;
	}

	public Criteria andActivationCode4LessThanOrEqualTo(String value) {
	    addCriterion("activation_code4 <=", value, "activationCode4");
	    return (Criteria) this;
	}

	public Criteria andActivationCode4Like(String value) {
	    addCriterion("activation_code4 like", value, "activationCode4");
	    return (Criteria) this;
	}

	public Criteria andActivationCode4NotLike(String value) {
	    addCriterion("activation_code4 not like", value, "activationCode4");
	    return (Criteria) this;
	}

	public Criteria andActivationCode4In(List<String> values) {
	    addCriterion("activation_code4 in", values, "activationCode4");
	    return (Criteria) this;
	}

	public Criteria andActivationCode4NotIn(List<String> values) {
	    addCriterion("activation_code4 not in", values, "activationCode4");
	    return (Criteria) this;
	}

	public Criteria andActivationCode4Between(String value1, String value2) {
	    addCriterion("activation_code4 between", value1, value2, "activationCode4");
	    return (Criteria) this;
	}

	public Criteria andActivationCode4NotBetween(String value1, String value2) {
	    addCriterion("activation_code4 not between", value1, value2, "activationCode4");
	    return (Criteria) this;
	}

	public Criteria andWlanIsNull() {
	    addCriterion("wlan is null");
	    return (Criteria) this;
	}

	public Criteria andWlanIsNotNull() {
	    addCriterion("wlan is not null");
	    return (Criteria) this;
	}

	public Criteria andWlanEqualTo(String value) {
	    addCriterion("wlan =", value, "wlan");
	    return (Criteria) this;
	}

	public Criteria andWlanNotEqualTo(String value) {
	    addCriterion("wlan <>", value, "wlan");
	    return (Criteria) this;
	}

	public Criteria andWlanGreaterThan(String value) {
	    addCriterion("wlan >", value, "wlan");
	    return (Criteria) this;
	}

	public Criteria andWlanGreaterThanOrEqualTo(String value) {
	    addCriterion("wlan >=", value, "wlan");
	    return (Criteria) this;
	}

	public Criteria andWlanLessThan(String value) {
	    addCriterion("wlan <", value, "wlan");
	    return (Criteria) this;
	}

	public Criteria andWlanLessThanOrEqualTo(String value) {
	    addCriterion("wlan <=", value, "wlan");
	    return (Criteria) this;
	}

	public Criteria andWlanLike(String value) {
	    addCriterion("wlan like", value, "wlan");
	    return (Criteria) this;
	}

	public Criteria andWlanNotLike(String value) {
	    addCriterion("wlan not like", value, "wlan");
	    return (Criteria) this;
	}

	public Criteria andWlanIn(List<String> values) {
	    addCriterion("wlan in", values, "wlan");
	    return (Criteria) this;
	}

	public Criteria andWlanNotIn(List<String> values) {
	    addCriterion("wlan not in", values, "wlan");
	    return (Criteria) this;
	}

	public Criteria andWlanBetween(String value1, String value2) {
	    addCriterion("wlan between", value1, value2, "wlan");
	    return (Criteria) this;
	}

	public Criteria andWlanNotBetween(String value1, String value2) {
	    addCriterion("wlan not between", value1, value2, "wlan");
	    return (Criteria) this;
	}

	public Criteria andSimPhoneIsNull() {
	    addCriterion("sim_phone is null");
	    return (Criteria) this;
	}

	public Criteria andSimPhoneIsNotNull() {
	    addCriterion("sim_phone is not null");
	    return (Criteria) this;
	}

	public Criteria andSimPhoneEqualTo(String value) {
	    addCriterion("sim_phone =", value, "simPhone");
	    return (Criteria) this;
	}

	public Criteria andSimPhoneNotEqualTo(String value) {
	    addCriterion("sim_phone <>", value, "simPhone");
	    return (Criteria) this;
	}

	public Criteria andSimPhoneGreaterThan(String value) {
	    addCriterion("sim_phone >", value, "simPhone");
	    return (Criteria) this;
	}

	public Criteria andSimPhoneGreaterThanOrEqualTo(String value) {
	    addCriterion("sim_phone >=", value, "simPhone");
	    return (Criteria) this;
	}

	public Criteria andSimPhoneLessThan(String value) {
	    addCriterion("sim_phone <", value, "simPhone");
	    return (Criteria) this;
	}

	public Criteria andSimPhoneLessThanOrEqualTo(String value) {
	    addCriterion("sim_phone <=", value, "simPhone");
	    return (Criteria) this;
	}

	public Criteria andSimPhoneLike(String value) {
	    addCriterion("sim_phone like", value, "simPhone");
	    return (Criteria) this;
	}

	public Criteria andSimPhoneNotLike(String value) {
	    addCriterion("sim_phone not like", value, "simPhone");
	    return (Criteria) this;
	}

	public Criteria andSimPhoneIn(List<String> values) {
	    addCriterion("sim_phone in", values, "simPhone");
	    return (Criteria) this;
	}

	public Criteria andSimPhoneNotIn(List<String> values) {
	    addCriterion("sim_phone not in", values, "simPhone");
	    return (Criteria) this;
	}

	public Criteria andSimPhoneBetween(String value1, String value2) {
	    addCriterion("sim_phone between", value1, value2, "simPhone");
	    return (Criteria) this;
	}

	public Criteria andSimPhoneNotBetween(String value1, String value2) {
	    addCriterion("sim_phone not between", value1, value2, "simPhone");
	    return (Criteria) this;
	}

	public Criteria andSimFeeIsNull() {
	    addCriterion("sim_fee is null");
	    return (Criteria) this;
	}

	public Criteria andSimFeeIsNotNull() {
	    addCriterion("sim_fee is not null");
	    return (Criteria) this;
	}

	public Criteria andSimFeeEqualTo(String value) {
	    addCriterion("sim_fee =", value, "simFee");
	    return (Criteria) this;
	}

	public Criteria andSimFeeNotEqualTo(String value) {
	    addCriterion("sim_fee <>", value, "simFee");
	    return (Criteria) this;
	}

	public Criteria andSimFeeGreaterThan(String value) {
	    addCriterion("sim_fee >", value, "simFee");
	    return (Criteria) this;
	}

	public Criteria andSimFeeGreaterThanOrEqualTo(String value) {
	    addCriterion("sim_fee >=", value, "simFee");
	    return (Criteria) this;
	}

	public Criteria andSimFeeLessThan(String value) {
	    addCriterion("sim_fee <", value, "simFee");
	    return (Criteria) this;
	}

	public Criteria andSimFeeLessThanOrEqualTo(String value) {
	    addCriterion("sim_fee <=", value, "simFee");
	    return (Criteria) this;
	}

	public Criteria andSimFeeLike(String value) {
	    addCriterion("sim_fee like", value, "simFee");
	    return (Criteria) this;
	}

	public Criteria andSimFeeNotLike(String value) {
	    addCriterion("sim_fee not like", value, "simFee");
	    return (Criteria) this;
	}

	public Criteria andSimFeeIn(List<String> values) {
	    addCriterion("sim_fee in", values, "simFee");
	    return (Criteria) this;
	}

	public Criteria andSimFeeNotIn(List<String> values) {
	    addCriterion("sim_fee not in", values, "simFee");
	    return (Criteria) this;
	}

	public Criteria andSimFeeBetween(String value1, String value2) {
	    addCriterion("sim_fee between", value1, value2, "simFee");
	    return (Criteria) this;
	}

	public Criteria andSimFeeNotBetween(String value1, String value2) {
	    addCriterion("sim_fee not between", value1, value2, "simFee");
	    return (Criteria) this;
	}

	public Criteria andBakIsNull() {
	    addCriterion("bak is null");
	    return (Criteria) this;
	}

	public Criteria andBakIsNotNull() {
	    addCriterion("bak is not null");
	    return (Criteria) this;
	}

	public Criteria andBakEqualTo(String value) {
	    addCriterion("bak =", value, "bak");
	    return (Criteria) this;
	}

	public Criteria andBakNotEqualTo(String value) {
	    addCriterion("bak <>", value, "bak");
	    return (Criteria) this;
	}

	public Criteria andBakGreaterThan(String value) {
	    addCriterion("bak >", value, "bak");
	    return (Criteria) this;
	}

	public Criteria andBakGreaterThanOrEqualTo(String value) {
	    addCriterion("bak >=", value, "bak");
	    return (Criteria) this;
	}

	public Criteria andBakLessThan(String value) {
	    addCriterion("bak <", value, "bak");
	    return (Criteria) this;
	}

	public Criteria andBakLessThanOrEqualTo(String value) {
	    addCriterion("bak <=", value, "bak");
	    return (Criteria) this;
	}

	public Criteria andBakLike(String value) {
	    addCriterion("bak like", value, "bak");
	    return (Criteria) this;
	}

	public Criteria andBakNotLike(String value) {
	    addCriterion("bak not like", value, "bak");
	    return (Criteria) this;
	}

	public Criteria andBakIn(List<String> values) {
	    addCriterion("bak in", values, "bak");
	    return (Criteria) this;
	}

	public Criteria andBakNotIn(List<String> values) {
	    addCriterion("bak not in", values, "bak");
	    return (Criteria) this;
	}

	public Criteria andBakBetween(String value1, String value2) {
	    addCriterion("bak between", value1, value2, "bak");
	    return (Criteria) this;
	}

	public Criteria andBakNotBetween(String value1, String value2) {
	    addCriterion("bak not between", value1, value2, "bak");
	    return (Criteria) this;
	}
    }

    public static class Criteria extends GeneratedCriteria {

	protected Criteria() {
	    super();
	}
    }

    public static class Criterion {
	private String condition;

	private Object value;

	private Object secondValue;

	private boolean noValue;

	private boolean singleValue;

	private boolean betweenValue;

	private boolean listValue;

	private String typeHandler;

	public String getCondition() {
	    return condition;
	}

	public Object getValue() {
	    return value;
	}

	public Object getSecondValue() {
	    return secondValue;
	}

	public boolean isNoValue() {
	    return noValue;
	}

	public boolean isSingleValue() {
	    return singleValue;
	}

	public boolean isBetweenValue() {
	    return betweenValue;
	}

	public boolean isListValue() {
	    return listValue;
	}

	public String getTypeHandler() {
	    return typeHandler;
	}

	protected Criterion(String condition) {
	    super();
	    this.condition = condition;
	    this.typeHandler = null;
	    this.noValue = true;
	}

	protected Criterion(String condition, Object value, String typeHandler) {
	    super();
	    this.condition = condition;
	    this.value = value;
	    this.typeHandler = typeHandler;
	    if (value instanceof List<?>) {
		this.listValue = true;
	    } else {
		this.singleValue = true;
	    }
	}

	protected Criterion(String condition, Object value) {
	    this(condition, value, null);
	}

	protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
	    super();
	    this.condition = condition;
	    this.value = value;
	    this.secondValue = secondValue;
	    this.typeHandler = typeHandler;
	    this.betweenValue = true;
	}

	protected Criterion(String condition, Object value, Object secondValue) {
	    this(condition, value, secondValue, null);
	}
    }
}