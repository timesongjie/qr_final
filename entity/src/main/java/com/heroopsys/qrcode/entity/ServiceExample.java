package com.heroopsys.qrcode.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServiceExample() {
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

        public Criteria andServiceTypeIdIsNull() {
            addCriterion("service_type_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdIsNotNull() {
            addCriterion("service_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdEqualTo(Integer value) {
            addCriterion("service_type_id =", value, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdNotEqualTo(Integer value) {
            addCriterion("service_type_id <>", value, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdGreaterThan(Integer value) {
            addCriterion("service_type_id >", value, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_type_id >=", value, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdLessThan(Integer value) {
            addCriterion("service_type_id <", value, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("service_type_id <=", value, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdIn(List<Integer> values) {
            addCriterion("service_type_id in", values, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdNotIn(List<Integer> values) {
            addCriterion("service_type_id not in", values, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("service_type_id between", value1, value2, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("service_type_id not between", value1, value2, "serviceTypeId");
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

        public Criteria andServiceNameIsNull() {
            addCriterion("service_name is null");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNotNull() {
            addCriterion("service_name is not null");
            return (Criteria) this;
        }

        public Criteria andServiceNameEqualTo(String value) {
            addCriterion("service_name =", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotEqualTo(String value) {
            addCriterion("service_name <>", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThan(String value) {
            addCriterion("service_name >", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThanOrEqualTo(String value) {
            addCriterion("service_name >=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThan(String value) {
            addCriterion("service_name <", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThanOrEqualTo(String value) {
            addCriterion("service_name <=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLike(String value) {
            addCriterion("service_name like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotLike(String value) {
            addCriterion("service_name not like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameIn(List<String> values) {
            addCriterion("service_name in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotIn(List<String> values) {
            addCriterion("service_name not in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameBetween(String value1, String value2) {
            addCriterion("service_name between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotBetween(String value1, String value2) {
            addCriterion("service_name not between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceDateIsNull() {
            addCriterion("service_date is null");
            return (Criteria) this;
        }

        public Criteria andServiceDateIsNotNull() {
            addCriterion("service_date is not null");
            return (Criteria) this;
        }

        public Criteria andServiceDateEqualTo(Date value) {
            addCriterion("service_date =", value, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateNotEqualTo(Date value) {
            addCriterion("service_date <>", value, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateGreaterThan(Date value) {
            addCriterion("service_date >", value, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateGreaterThanOrEqualTo(Date value) {
            addCriterion("service_date >=", value, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateLessThan(Date value) {
            addCriterion("service_date <", value, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateLessThanOrEqualTo(Date value) {
            addCriterion("service_date <=", value, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateIn(List<Date> values) {
            addCriterion("service_date in", values, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateNotIn(List<Date> values) {
            addCriterion("service_date not in", values, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateBetween(Date value1, Date value2) {
            addCriterion("service_date between", value1, value2, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateNotBetween(Date value1, Date value2) {
            addCriterion("service_date not between", value1, value2, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceLocationIsNull() {
            addCriterion("service_location is null");
            return (Criteria) this;
        }

        public Criteria andServiceLocationIsNotNull() {
            addCriterion("service_location is not null");
            return (Criteria) this;
        }

        public Criteria andServiceLocationEqualTo(String value) {
            addCriterion("service_location =", value, "serviceLocation");
            return (Criteria) this;
        }

        public Criteria andServiceLocationNotEqualTo(String value) {
            addCriterion("service_location <>", value, "serviceLocation");
            return (Criteria) this;
        }

        public Criteria andServiceLocationGreaterThan(String value) {
            addCriterion("service_location >", value, "serviceLocation");
            return (Criteria) this;
        }

        public Criteria andServiceLocationGreaterThanOrEqualTo(String value) {
            addCriterion("service_location >=", value, "serviceLocation");
            return (Criteria) this;
        }

        public Criteria andServiceLocationLessThan(String value) {
            addCriterion("service_location <", value, "serviceLocation");
            return (Criteria) this;
        }

        public Criteria andServiceLocationLessThanOrEqualTo(String value) {
            addCriterion("service_location <=", value, "serviceLocation");
            return (Criteria) this;
        }

        public Criteria andServiceLocationLike(String value) {
            addCriterion("service_location like", value, "serviceLocation");
            return (Criteria) this;
        }

        public Criteria andServiceLocationNotLike(String value) {
            addCriterion("service_location not like", value, "serviceLocation");
            return (Criteria) this;
        }

        public Criteria andServiceLocationIn(List<String> values) {
            addCriterion("service_location in", values, "serviceLocation");
            return (Criteria) this;
        }

        public Criteria andServiceLocationNotIn(List<String> values) {
            addCriterion("service_location not in", values, "serviceLocation");
            return (Criteria) this;
        }

        public Criteria andServiceLocationBetween(String value1, String value2) {
            addCriterion("service_location between", value1, value2, "serviceLocation");
            return (Criteria) this;
        }

        public Criteria andServiceLocationNotBetween(String value1, String value2) {
            addCriterion("service_location not between", value1, value2, "serviceLocation");
            return (Criteria) this;
        }

        public Criteria andServiceContentIsNull() {
            addCriterion("service_content is null");
            return (Criteria) this;
        }

        public Criteria andServiceContentIsNotNull() {
            addCriterion("service_content is not null");
            return (Criteria) this;
        }

        public Criteria andServiceContentEqualTo(String value) {
            addCriterion("service_content =", value, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentNotEqualTo(String value) {
            addCriterion("service_content <>", value, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentGreaterThan(String value) {
            addCriterion("service_content >", value, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentGreaterThanOrEqualTo(String value) {
            addCriterion("service_content >=", value, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentLessThan(String value) {
            addCriterion("service_content <", value, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentLessThanOrEqualTo(String value) {
            addCriterion("service_content <=", value, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentLike(String value) {
            addCriterion("service_content like", value, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentNotLike(String value) {
            addCriterion("service_content not like", value, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentIn(List<String> values) {
            addCriterion("service_content in", values, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentNotIn(List<String> values) {
            addCriterion("service_content not in", values, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentBetween(String value1, String value2) {
            addCriterion("service_content between", value1, value2, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentNotBetween(String value1, String value2) {
            addCriterion("service_content not between", value1, value2, "serviceContent");
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
        
        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
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