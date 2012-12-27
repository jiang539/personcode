package com.xinxi11.module.core.orm.hibernate;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinxi11.module.core.orm.Finder;
import com.xinxi11.module.core.orm.Pagination;

/**
* hibernate工具类
* @date 2010-10-25
*/
public class HibernateUtils {

	private static Logger log = LoggerFactory.getLogger(HibernateUtils.class);

	/**
	 * 将记录的状态置为删除状态
	 */
	public static Finder deleteActive(Set<Serializable> ids, Class<?> clazz) {
		Finder finder = new Finder("update " + clazz.getSimpleName());
		finder.append(" set active=1 where id in (:ids)");
		finder.setParam("ids", ids);
		log.debug(finder.getOrigHql());
		return finder;
	}

	/**
	 * 按属性值删除对象
	 * 
	 * @param propertyName
	 *            列名
	 * @param value
	 *            列值
	 * @return finder
	 */
	public static Finder deleteByProperty(String propertyName, Object value, Class<?> clazz) {
		Finder finder = new Finder(" delete from " + clazz.getSimpleName());
		finder.append(" where " + propertyName + " =? ", value);
		log.debug(finder.getOrigHql());
		return finder;
	}

	/**
	 * 查询所有对象
	 * 
	 * @return
	 */
	public static Finder findAll(Class<?> clazz) {
		Finder finder = new Finder(" from ");
		finder.append(clazz.getSimpleName());
		log.debug(finder.getOrigHql());
		return finder;
	}

	/**
	 * 通过属性,查询对象
	 * 
	 * @param propertyName
	 *            属性
	 * @param value
	 *            值
	 * @return 唯一实体
	 */
	public static Finder findByProperty(String propertyName, Object value, Class<?> clazz) {
		Finder finder = new Finder(" FROM ");
		finder.append(clazz.getSimpleName()).append(" where " + propertyName + " =? ", value);
		log.debug(finder.getOrigHql());
		return finder;
	}

	/**
	 * 通过列值like模糊查询数据
	 * 
	 * @param propertyName
	 *            列名
	 * @param value
	 *            列值,%value%
	 * @return
	 */
	public static Finder findLikeProperty(String propertyName, Object value, Class<?> clazz) {
		Finder finder = new Finder(" from ");
		finder.append(clazz.getSimpleName()).append(" where " + propertyName + " like ?", value);
		log.debug(finder.getOrigHql());
		return finder;
	}

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

	/**
	 * 查找列表对象
	 * 
	 * @param query
	 *            query
	 * @param page
	 * @return List
	 */
	public static List<?> findList(Query query, Pagination page) {
		if (page == null) {
			return query.list();
		}
		return query.setFirstResult(page.getFirstResult()).setMaxResults(page.getPageSize()).list();
	}

	/**
	 * 查找 Iterator 对象
	 * 
	 * @param query
	 *            query
	 * @param page
	 * @return Iterator
	 */
	public static Iterator<?> findIterate(Query query, Pagination page) {
		if (page == null) {
			return query.iterate();
		}
		return query.setFirstResult(page.getFirstResult()).setMaxResults(page.getPageSize())
				.iterate();
	}

}
