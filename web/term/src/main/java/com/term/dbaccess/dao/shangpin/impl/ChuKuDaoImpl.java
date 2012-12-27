package com.term.dbaccess.dao.shangpin.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.term.dbaccess.core.BaseHibernateDaoImpl;
import com.term.dbaccess.core.Pagination;
import com.term.dbaccess.dao.shangpin.IChuKuDao;
import com.term.dbaccess.querybean.ShangPinQueryBean;
import com.xinxi11.web.entity.term.ChuKu;

@Service("chuKuDao")
public class ChuKuDaoImpl extends BaseHibernateDaoImpl<ChuKu> implements
		IChuKuDao {

	public ChuKuDaoImpl() {
		super(ChuKu.class);
	}

	@Override
	public Long findSumByShangPinId(String shangPinId) {
		String hql = " select sum(amount) from ChuKu where shangPin.id=?";
		Object[] values = new Object[] { shangPinId };
		return (Long) findForUnique(hql, values);
	}

	@Override
	public List<ChuKu> findByQueryBean(ShangPinQueryBean queryBean,
			Pagination page) {
		DetachedCriteria dc = DetachedCriteria.forClass(ChuKu.class);
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
