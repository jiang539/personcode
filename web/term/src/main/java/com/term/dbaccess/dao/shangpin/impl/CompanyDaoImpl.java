package com.term.dbaccess.dao.shangpin.impl;

import org.springframework.stereotype.Service;

import com.term.dbaccess.core.BaseHibernateDaoImpl;
import com.term.dbaccess.dao.shangpin.ICompanyDao;
import com.xinxi11.web.entity.term.Company;

@Service("companyDao")
public class CompanyDaoImpl extends BaseHibernateDaoImpl<Company> implements
		ICompanyDao {

	public CompanyDaoImpl() {
		super(Company.class);
	}

}
