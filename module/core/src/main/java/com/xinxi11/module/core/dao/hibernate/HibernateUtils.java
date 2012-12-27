package com.xinxi11.module.core.dao.hibernate;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinxi11.module.core.dao.Finder;

/**
 * hibernate工具类
 */
public class HibernateUtils {

	private static Logger log = LoggerFactory.getLogger(HibernateUtils.class);

	/**
	 * 根据finder自动组装Query<br>
	 * 统一给query的参数设置参数值<br>
	 * 如果命名符为空,则按点位符来处理
	 * 
	 * @param finder
	 * @return
	 */
	public static Query findQuery(Finder finder, String hql, Session session) {
		log.debug(hql);

		Query query = null;
		if (finder.isHql()) {
			query = session.createQuery(hql);
		} else {
			query = session.createSQLQuery(hql);
		}

		// 没有参数
		if (finder.getValues().isEmpty()) {
			return query;
		}
		// 查询语句有参数
		List<Object> listValues = finder.getValues();
		if (finder.getParams().isEmpty()) {
			// 占位符设置参数
			for (int i = 0; i < listValues.size(); i++) {
				query.setParameter(i, listValues.get(i));
			}
		} else {
			// 命名参数设置
			List<String> listParms = finder.getParams();
			for (int i = 0; i < listValues.size(); i++) {
				if (listValues.get(i) instanceof Collection<?>) {
					query.setParameterList(listParms.get(i), (Collection<?>) listValues.get(i));
				} else {
					query.setParameter(listParms.get(i), listValues.get(i));
				}
			}
		}
		return query;
	}

}
