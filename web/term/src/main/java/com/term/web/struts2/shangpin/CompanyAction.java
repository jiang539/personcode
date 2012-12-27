package com.term.web.struts2.shangpin;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.term.business.dto.CompanyDto;
import com.term.business.service.shangpin.ICompanyService;
import com.term.web.core.BaseCrudActionSupport;
import com.term.web.core.CrudActionSupport;

@ParentPackage("default")
@Results( { @Result(name = CrudActionSupport.RELOAD, location = "/shangpin/company.action", type = "redirect") })
public class CompanyAction extends BaseCrudActionSupport<CompanyDto> {
	private ICompanyService companyService;

	public void setCompanyService(ICompanyService companyService) {
		this.companyService = companyService;
		this.baseService = companyService;
		entity = new CompanyDto();
	}

}
