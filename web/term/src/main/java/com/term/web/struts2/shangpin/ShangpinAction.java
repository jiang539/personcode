package com.term.web.struts2.shangpin;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.term.business.dto.CompanyDto;
import com.term.business.dto.ShangPinDto;
import com.term.business.service.shangpin.ICompanyService;
import com.term.business.service.shangpin.IShangPinService;
import com.term.web.core.BaseCrudActionSupport;
import com.term.web.core.CrudActionSupport;

@ParentPackage("default")
@Results( { @Result(name = CrudActionSupport.RELOAD, location = "/shangpin/shangpin.action", type = "redirect") })
public class ShangpinAction extends BaseCrudActionSupport<ShangPinDto> {
	private IShangPinService shangPinService;
	private ICompanyService companyService;
	private List<String> listSpType = new ArrayList<String>();
	private List<CompanyDto> listCompanyDto = new ArrayList<CompanyDto>();

	public void setShangPinService(IShangPinService shangPinService) {
		this.shangPinService = shangPinService;
		this.baseService = shangPinService;
		entity = new ShangPinDto();
	}

	public void setCompanyService(ICompanyService companyService) {
		this.companyService = companyService;
	}

	public List<String> getListSpType() {
		return listSpType;
	}

	public List<CompanyDto> getListCompanyDto() {
		return listCompanyDto;
	}

	@Override
	public void beforeInput() throws Exception {
		listSpType = shangPinService.findSpType();
		listCompanyDto = companyService.findAll(null);
		// listSpType = CollectionUtils.getListDto(listType);
	}

}
