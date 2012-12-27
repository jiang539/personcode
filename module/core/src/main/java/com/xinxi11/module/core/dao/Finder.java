package com.xinxi11.module.core.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * HQL 或者 SQL 语句封装<br>
 * <b>注意:占位符参数和命名参数不能混合使用</b><br>
 * 如果是本地sql,必须将属性isHql设置为false,默认值为true
 * 
 * @author 李国江
 * @date 2009-8-31
 */
public class Finder {

	/** hql语句 */
	private StringBuilder hqlBuilder;

	/** 命名参数,使用占位符参数时禁止使用此对象 */
	private List<String> params;
	/** 参数值 */
	private List<Object> values;
	/** true:HQl ;false:本地SQL .默认为true */
	private boolean isHql = true;
	/** hql中是否有where关键字 */
	private boolean hasWhere = false;
	/** 统计总行数的sql语句,如果为Null则由finder自己组装查询语句 */
	public String countSql = null;

	public static final String ROW_COUNT = "select count(*) ";
	public static final String FROM = "from";
	public static final String HQL_FETCH = "fetch";
	public static final String ORDER_BY = " order ";
	public static final String GROUP_BY = "group";
	public static final String AND = " and ";
	public static final String WHERE = " where ";

	/** 创建新的hql语句对象,默认为HQL语句 */
	public Finder(String hql) {
		this(hql, true);
	}

	/**
	 * 创建新的hql语句对象
	 * 
	 * @param hql
	 *            hql语句
	 * @param isHql
	 *            是否是HQL语句,false为本地sql语句
	 */
	public Finder(String hql, boolean isHql) {
		this.isHql = isHql;
		this.hqlBuilder = new StringBuilder(hql);
	}

	public boolean isHql() {
		return isHql;
	}

	/** 添加子句,没有做非空检验 */
	public Finder append(String hql) {
		hqlBuilder.append(hql);
		return this;
	}

	/**
	 * 有非空检验
	 */
	public Finder append(String hql, Object value) {
		return append(false, hql, value);
	}

	/**
	 * 设置命名参数的hql语句,有非空检验
	 * @param hql hql
	 * @param paramName hql语句中指定的占位符名称
	 * @param value 参数值
	 */
	public Finder appendPlaceHolder(String hql, String paramName, Object value) {
		if (!isNull(value)) {
			hqlBuilder.append(hql);
			setParam(paramName, value);
		}
		return this;
	}

	/** 是否有where关键字,如果没有则添加where,没有则添加and */
	public Finder appendWhere() {
		if (hasWhere) {
			hqlBuilder.append(AND);
		} else {
			hqlBuilder.append(WHERE);
			hasWhere = true;
		}
		return this;
	}

	/**
	 * 添加where子句<br>
	 * 对象不为空时,如果子句中没有where则先添加where,如果有where则添加and,之后再添加子句,并填充占位符参数<br>
	 * 对象为空时,直接返回
	 */
	public Finder appendWhereHql(Object value, String hql) {
		return append(true, hql, value);
	}

	/**
	 * 
	 * @param isWhere 是否判断语句中含有where
	 * @param hql hql
	 * @param value 参数值
	 */
	private Finder append(Boolean isWhere, String hql, Object value) {
		if (!isNull(value)) {
			if (isWhere) {
				appendWhere();
			}
			hqlBuilder.append(hql);
			addValues(value);
		}
		return this;
	}

	private Boolean isNull(Object value) {
		if (null != value && StringUtils.isNotBlank(value.toString())) {
			Boolean collectionB = (value instanceof Collection<?>)
					&& ((Collection<?>) value).isEmpty();
			if (!collectionB) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 设置参数,没有做非空检验
	 */
	public Finder setParam(String param, Object value) {
		getParams().add(param);
		getValues().add(value);
		return this;
	}

	/** 占位符参数对应的value,没有做非空检验 */
	public Finder addValues(Object values) {
		this.getValues().add(values);
		return this;
	}

	/**
	 * 获得原始hql语句
	 * 
	 * @return
	 */
	public String getOrigHql() {
		return hqlBuilder.toString();
	}

	/**
	 * 获得查询数据库记录数的hql语句。
	 */
	public String getRowCountHql() {
		// 自定义统计总数据行数语句
		if (countSql != null)
			return countSql;

		String hql = hqlBuilder.toString();

		int fromIndex = hql.toLowerCase().indexOf(FROM);
		String projectionHql = hql.substring(0, fromIndex);

		hql = hql.substring(fromIndex);
		String rowCountHql = hql.replace(HQL_FETCH, "");

		int index = rowCountHql.toLowerCase().indexOf(ORDER_BY);
		if (index > 0) {
			rowCountHql = rowCountHql.substring(0, index);
		}
		int gIndex = rowCountHql.toLowerCase().indexOf(GROUP_BY);
		if (gIndex > 0) {
			rowCountHql = rowCountHql.substring(0, gIndex);
		}

		return wrapProjection(projectionHql) + rowCountHql;
	}

	/**
	 * 封装统计数据行数的统计语句
	 * 
	 * @param projection
	 * @param countName
	 * @return
	 */
	private String wrapProjection(String projection) {
		return ROW_COUNT;
	}

	/** 获取占位符参数 */
	public List<String> getParams() {
		if (params == null) {
			this.params = new ArrayList<String>();
		}
		return params;
	}

	public List<Object> getValues() {
		if (values == null) {
			this.values = new ArrayList<Object>();
		}
		return values;
	}

	public boolean isHasWhere() {
		return hasWhere;
	}

	public Finder setHasWhere() {
		this.hasWhere = true;
		return this;
	}

	public StringBuilder getHqlBuilder() {
		return hqlBuilder;
	}

	public Finder setHqlBuilder(StringBuilder hqlBuilder) {
		this.hqlBuilder.append(hqlBuilder);
		return this;
	}

	public void setCountSql(String countSql) {
		this.countSql = countSql;
	}

}
