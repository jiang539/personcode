package com.term.business.service.shangpin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.term.business.core.BaseServiceImpl;
import com.term.business.dto.CompanyDto;
import com.term.business.service.shangpin.ICompanyService;
import com.term.dbaccess.dao.shangpin.ICompanyDao;
import com.xinxi11.web.entity.term.Company;

@Service("companyService")
public class CompanyServiceImpl extends BaseServiceImpl<CompanyDto, Company>
		implements ICompanyService {

	private ICompanyDao companyDao;

	@Autowired
	public void setCompanyDao(ICompanyDao companyDao) {
		this.companyDao = companyDao;
		this.baseHibernateDao = companyDao;
	}

}
