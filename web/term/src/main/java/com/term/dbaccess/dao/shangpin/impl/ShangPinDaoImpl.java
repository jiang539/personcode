package com.term.dbaccess.dao.shangpin.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.term.dbaccess.core.BaseHibernateDaoImpl;
import com.term.dbaccess.dao.shangpin.IShangPinDao;
import com.xinxi11.web.entity.term.ShangPin;

@Service("shangPinDao")
public class ShangPinDaoImpl extends BaseHibernateDaoImpl<ShangPin> implements
		IShangPinDao {

	public ShangPinDaoImpl() {
		super(ShangPin.class);
	}

	@Override
	public List<String> findSpType() {
		String hql="select type from ShangPin group by type";
		return queryForList(hql, null);
	}

}
