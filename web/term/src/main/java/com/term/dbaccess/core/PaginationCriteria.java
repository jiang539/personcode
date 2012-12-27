package com.term.dbaccess.core;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.transform.ResultTransformer;

/**
 * 动态查询,并且分页
 */
public class PaginationCriteria {
	private static Log log = LogFactory.getLog(PaginationCriteria.class);

	public static List query(Criteria criteria, Pagination page) {
		// 先获取排序类型及结果返回类型
		Field orderEntriesField = getField(criteria.getClass(), "orderEntries");
		List _old_orderEntries = (List) getFieldValue(orderEntriesField, criteria);
		CriteriaImpl impl = (CriteriaImpl) criteria;
		Projection projection = impl.getProjection();
		ResultTransformer transformer = impl.getResultTransformer();
		// 是否有排序字段
		boolean restore = false;
		if (_old_orderEntries.size() > 0) {
			restore = true;
			setFieldValue(orderEntriesField, criteria, new ArrayList());
		}
		// 查询数据总行数
		criteria.setProjection(Projections.rowCount());
		Integer rowCount = (Integer) criteria.uniqueResult();
		if (rowCount == null || rowCount == 0) {
			page.setTotalCount(0);
			// 判断是否继续查询结果
			return Collections.EMPTY_LIST;
		}
		// 设置总行数
		page.setTotalCount(rowCount);

		// 恢复旧数据信息
		criteria.setProjection(projection);// 恢复投影操作
		criteria.setResultTransformer(transformer);// 设置原有的返回对象的类型
		if (restore) {
			// 是否有排序字段
			setFieldValue(orderEntriesField, criteria, _old_orderEntries);
		}
		// 查询
		return criteria.setFirstResult(page.getFirstResult()).setMaxResults(page.getPageSize())
				.setFetchSize(page.getPageSize()).list();
	}

	private static Field getField(Class clazz, String fieldName) {
		try {
			return clazz.getDeclaredField(fieldName);
		} catch (Exception e) {
			log.warn("Class.getDeclaredField(String) failed.", e);
			throw new RuntimeException(e);
		}
	}

	private static Object getFieldValue(Field field, Object obj) {
		field.setAccessible(true);
		try {
			return field.get(obj);
		} catch (Exception e) {
			log.warn("Field.get(Object) failed.", e);
			throw new RuntimeException(e);
		}
	}

	private static void setFieldValue(Field field, Object target, Object value) {
		field.setAccessible(true);
		try {
			field.set(target, value);
		} catch (Exception e) {
			log.warn("Field.set(Object, Object) failed.", e);
			throw new RuntimeException(e);
		}
	}
}
