package com.fruitsalesplatform.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class RetailerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RetailerExample() {
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

        public Criteria andRetaileridIsNull() {
            addCriterion("retailerid is null");
            return (Criteria) this;
        }

        public Criteria andRetaileridIsNotNull() {
            addCriterion("retailerid is not null");
            return (Criteria) this;
        }

        public Criteria andRetaileridEqualTo(String value) {
            addCriterion("retailerid =", value, "retailerid");
            return (Criteria) this;
        }

        public Criteria andRetaileridNotEqualTo(String value) {
            addCriterion("retailerid <>", value, "retailerid");
            return (Criteria) this;
        }

        public Criteria andRetaileridGreaterThan(String value) {
            addCriterion("retailerid >", value, "retailerid");
            return (Criteria) this;
        }

        public Criteria andRetaileridGreaterThanOrEqualTo(String value) {
            addCriterion("retailerid >=", value, "retailerid");
            return (Criteria) this;
        }

        public Criteria andRetaileridLessThan(String value) {
            addCriterion("retailerid <", value, "retailerid");
            return (Criteria) this;
        }

        public Criteria andRetaileridLessThanOrEqualTo(String value) {
            addCriterion("retailerid <=", value, "retailerid");
            return (Criteria) this;
        }

        public Criteria andRetaileridLike(String value) {
            addCriterion("retailerid like", value, "retailerid");
            return (Criteria) this;
        }

        public Criteria andRetaileridNotLike(String value) {
            addCriterion("retailerid not like", value, "retailerid");
            return (Criteria) this;
        }

        public Criteria andRetaileridIn(List<String> values) {
            addCriterion("retailerid in", values, "retailerid");
            return (Criteria) this;
        }

        public Criteria andRetaileridNotIn(List<String> values) {
            addCriterion("retailerid not in", values, "retailerid");
            return (Criteria) this;
        }

        public Criteria andRetaileridBetween(String value1, String value2) {
            addCriterion("retailerid between", value1, value2, "retailerid");
            return (Criteria) this;
        }

        public Criteria andRetaileridNotBetween(String value1, String value2) {
            addCriterion("retailerid not between", value1, value2, "retailerid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTelphoneIsNull() {
            addCriterion("telphone is null");
            return (Criteria) this;
        }

        public Criteria andTelphoneIsNotNull() {
            addCriterion("telphone is not null");
            return (Criteria) this;
        }

        public Criteria andTelphoneEqualTo(String value) {
            addCriterion("telphone =", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneNotEqualTo(String value) {
            addCriterion("telphone <>", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneGreaterThan(String value) {
            addCriterion("telphone >", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneGreaterThanOrEqualTo(String value) {
            addCriterion("telphone >=", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneLessThan(String value) {
            addCriterion("telphone <", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneLessThanOrEqualTo(String value) {
            addCriterion("telphone <=", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneLike(String value) {
            addCriterion("telphone like", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneNotLike(String value) {
            addCriterion("telphone not like", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneIn(List<String> values) {
            addCriterion("telphone in", values, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneNotIn(List<String> values) {
            addCriterion("telphone not in", values, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneBetween(String value1, String value2) {
            addCriterion("telphone between", value1, value2, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneNotBetween(String value1, String value2) {
            addCriterion("telphone not between", value1, value2, "telphone");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andSegment1IsNull() {
            addCriterion("segment1 is null");
            return (Criteria) this;
        }

        public Criteria andSegment1IsNotNull() {
            addCriterion("segment1 is not null");
            return (Criteria) this;
        }

        public Criteria andSegment1EqualTo(String value) {
            addCriterion("segment1 =", value, "segment1");
            return (Criteria) this;
        }

        public Criteria andSegment1NotEqualTo(String value) {
            addCriterion("segment1 <>", value, "segment1");
            return (Criteria) this;
        }

        public Criteria andSegment1GreaterThan(String value) {
            addCriterion("segment1 >", value, "segment1");
            return (Criteria) this;
        }

        public Criteria andSegment1GreaterThanOrEqualTo(String value) {
            addCriterion("segment1 >=", value, "segment1");
            return (Criteria) this;
        }

        public Criteria andSegment1LessThan(String value) {
            addCriterion("segment1 <", value, "segment1");
            return (Criteria) this;
        }

        public Criteria andSegment1LessThanOrEqualTo(String value) {
            addCriterion("segment1 <=", value, "segment1");
            return (Criteria) this;
        }

        public Criteria andSegment1Like(String value) {
            addCriterion("segment1 like", value, "segment1");
            return (Criteria) this;
        }

        public Criteria andSegment1NotLike(String value) {
            addCriterion("segment1 not like", value, "segment1");
            return (Criteria) this;
        }

        public Criteria andSegment1In(List<String> values) {
            addCriterion("segment1 in", values, "segment1");
            return (Criteria) this;
        }

        public Criteria andSegment1NotIn(List<String> values) {
            addCriterion("segment1 not in", values, "segment1");
            return (Criteria) this;
        }

        public Criteria andSegment1Between(String value1, String value2) {
            addCriterion("segment1 between", value1, value2, "segment1");
            return (Criteria) this;
        }

        public Criteria andSegment1NotBetween(String value1, String value2) {
            addCriterion("segment1 not between", value1, value2, "segment1");
            return (Criteria) this;
        }

        public Criteria andSegment2IsNull() {
            addCriterion("segment2 is null");
            return (Criteria) this;
        }

        public Criteria andSegment2IsNotNull() {
            addCriterion("segment2 is not null");
            return (Criteria) this;
        }

        public Criteria andSegment2EqualTo(String value) {
            addCriterion("segment2 =", value, "segment2");
            return (Criteria) this;
        }

        public Criteria andSegment2NotEqualTo(String value) {
            addCriterion("segment2 <>", value, "segment2");
            return (Criteria) this;
        }

        public Criteria andSegment2GreaterThan(String value) {
            addCriterion("segment2 >", value, "segment2");
            return (Criteria) this;
        }

        public Criteria andSegment2GreaterThanOrEqualTo(String value) {
            addCriterion("segment2 >=", value, "segment2");
            return (Criteria) this;
        }

        public Criteria andSegment2LessThan(String value) {
            addCriterion("segment2 <", value, "segment2");
            return (Criteria) this;
        }

        public Criteria andSegment2LessThanOrEqualTo(String value) {
            addCriterion("segment2 <=", value, "segment2");
            return (Criteria) this;
        }

        public Criteria andSegment2Like(String value) {
            addCriterion("segment2 like", value, "segment2");
            return (Criteria) this;
        }

        public Criteria andSegment2NotLike(String value) {
            addCriterion("segment2 not like", value, "segment2");
            return (Criteria) this;
        }

        public Criteria andSegment2In(List<String> values) {
            addCriterion("segment2 in", values, "segment2");
            return (Criteria) this;
        }

        public Criteria andSegment2NotIn(List<String> values) {
            addCriterion("segment2 not in", values, "segment2");
            return (Criteria) this;
        }

        public Criteria andSegment2Between(String value1, String value2) {
            addCriterion("segment2 between", value1, value2, "segment2");
            return (Criteria) this;
        }

        public Criteria andSegment2NotBetween(String value1, String value2) {
            addCriterion("segment2 not between", value1, value2, "segment2");
            return (Criteria) this;
        }

        public Criteria andSegment3IsNull() {
            addCriterion("segment3 is null");
            return (Criteria) this;
        }

        public Criteria andSegment3IsNotNull() {
            addCriterion("segment3 is not null");
            return (Criteria) this;
        }

        public Criteria andSegment3EqualTo(String value) {
            addCriterion("segment3 =", value, "segment3");
            return (Criteria) this;
        }

        public Criteria andSegment3NotEqualTo(String value) {
            addCriterion("segment3 <>", value, "segment3");
            return (Criteria) this;
        }

        public Criteria andSegment3GreaterThan(String value) {
            addCriterion("segment3 >", value, "segment3");
            return (Criteria) this;
        }

        public Criteria andSegment3GreaterThanOrEqualTo(String value) {
            addCriterion("segment3 >=", value, "segment3");
            return (Criteria) this;
        }

        public Criteria andSegment3LessThan(String value) {
            addCriterion("segment3 <", value, "segment3");
            return (Criteria) this;
        }

        public Criteria andSegment3LessThanOrEqualTo(String value) {
            addCriterion("segment3 <=", value, "segment3");
            return (Criteria) this;
        }

        public Criteria andSegment3Like(String value) {
            addCriterion("segment3 like", value, "segment3");
            return (Criteria) this;
        }

        public Criteria andSegment3NotLike(String value) {
            addCriterion("segment3 not like", value, "segment3");
            return (Criteria) this;
        }

        public Criteria andSegment3In(List<String> values) {
            addCriterion("segment3 in", values, "segment3");
            return (Criteria) this;
        }

        public Criteria andSegment3NotIn(List<String> values) {
            addCriterion("segment3 not in", values, "segment3");
            return (Criteria) this;
        }

        public Criteria andSegment3Between(String value1, String value2) {
            addCriterion("segment3 between", value1, value2, "segment3");
            return (Criteria) this;
        }

        public Criteria andSegment3NotBetween(String value1, String value2) {
            addCriterion("segment3 not between", value1, value2, "segment3");
            return (Criteria) this;
        }

        public Criteria andSegment4IsNull() {
            addCriterion("segment4 is null");
            return (Criteria) this;
        }

        public Criteria andSegment4IsNotNull() {
            addCriterion("segment4 is not null");
            return (Criteria) this;
        }

        public Criteria andSegment4EqualTo(String value) {
            addCriterion("segment4 =", value, "segment4");
            return (Criteria) this;
        }

        public Criteria andSegment4NotEqualTo(String value) {
            addCriterion("segment4 <>", value, "segment4");
            return (Criteria) this;
        }

        public Criteria andSegment4GreaterThan(String value) {
            addCriterion("segment4 >", value, "segment4");
            return (Criteria) this;
        }

        public Criteria andSegment4GreaterThanOrEqualTo(String value) {
            addCriterion("segment4 >=", value, "segment4");
            return (Criteria) this;
        }

        public Criteria andSegment4LessThan(String value) {
            addCriterion("segment4 <", value, "segment4");
            return (Criteria) this;
        }

        public Criteria andSegment4LessThanOrEqualTo(String value) {
            addCriterion("segment4 <=", value, "segment4");
            return (Criteria) this;
        }

        public Criteria andSegment4Like(String value) {
            addCriterion("segment4 like", value, "segment4");
            return (Criteria) this;
        }

        public Criteria andSegment4NotLike(String value) {
            addCriterion("segment4 not like", value, "segment4");
            return (Criteria) this;
        }

        public Criteria andSegment4In(List<String> values) {
            addCriterion("segment4 in", values, "segment4");
            return (Criteria) this;
        }

        public Criteria andSegment4NotIn(List<String> values) {
            addCriterion("segment4 not in", values, "segment4");
            return (Criteria) this;
        }

        public Criteria andSegment4Between(String value1, String value2) {
            addCriterion("segment4 between", value1, value2, "segment4");
            return (Criteria) this;
        }

        public Criteria andSegment4NotBetween(String value1, String value2) {
            addCriterion("segment4 not between", value1, value2, "segment4");
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
