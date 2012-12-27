package com.term.dbaccess.dao.shangpin.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.term.dbaccess.core.BaseHibernateDaoImpl;
import com.term.dbaccess.core.Pagination;
import com.term.dbaccess.dao.shangpin.IRuKuDao;
import com.term.dbaccess.querybean.ShangPinQueryBean;
import com.xinxi11.web.entity.term.RuKu;

@Service("ruKuDao")
public class RuKuDaoImpl extends BaseHibernateDaoImpl<RuKu> implements IRuKuDao {

	public RuKuDaoImpl() {
		super(RuKu.class);
	}

	@Override
	public Long findSumByShangPinId(String shangPinId) {
		String hql = " select sum(amount) from RuKu where shangPin.id=?";
		Object[] values = new Object[] { shangPinId };
		return (Long) findForUnique(hql, values);
	}

	@Override
	public List<RuKu> findByQueryBean(ShangPinQueryBean queryBean,
			Pagination page) {
		DetachedCriteria dc = DetachedCriteria.forClass(RuKu.class);
		if (StringUtils.isNotBlank(queryBean.getSpId())) {
			dc.createCriteria("shangPin").add(
					Restrictions.eq("id", queryBean.getSpId()));
		}
		if (StringUtils.isNotBlank(queryBean.getUserId())) {
			dc.createCriteria("user").add(
					Restrictions.eq("id", queryBean.getUserId()));
		}
		if (queryBean.getStartDate() != null) {
			dc.add(Restrictions.ge("date", queryBean.getStartDate()));
		}
		if (queryBean.getEndDate() != null) {
			dc.add(Restrictions.lt("date", queryBean.getEndDate()));
		}
		return queryForList(dc, page);
	}

}
