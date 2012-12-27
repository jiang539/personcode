package com.term.web.struts2.shangpin;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.term.business.dto.RuKuDto;
import com.term.business.dto.ShangPinDto;
import com.term.business.dto.UserDto;
import com.term.business.service.power.IUserService;
import com.term.business.service.shangpin.IRuKuService;
import com.term.business.service.shangpin.IShangPinService;
import com.term.dbaccess.core.Pagination;
import com.term.dbaccess.querybean.ShangPinQueryBean;
import com.term.web.core.BaseCrudActionSupport;
import com.term.web.core.CrudActionSupport;

@ParentPackage("default")
@Results( { @Result(name = CrudActionSupport.RELOAD, location = "/shangpin/ruku.action", type = "redirect") })
public class RukuAction extends BaseCrudActionSupport<RuKuDto> {
	private IRuKuService ruKuService;
	private IUserService userService;
	private IShangPinService shangPinService;
	private List<UserDto> listUserDto = new ArrayList<UserDto>();
	private List<ShangPinDto> listShpDto = new ArrayList<ShangPinDto>();

	private ShangPinQueryBean queryBean = new ShangPinQueryBean();// 封装查询条件

	public void setRuKuService(IRuKuService ruKuService) {
		this.ruKuService = ruKuService;
		this.baseService = ruKuService;
		entity = new RuKuDto();
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setShangPinService(IShangPinService shangPinService) {
		this.shangPinService = shangPinService;
	}

	public List<UserDto> getListUserDto() {
		return listUserDto;
	}

	public List<ShangPinDto> getListShpDto() {
		return listShpDto;
	}

	public ShangPinQueryBean getQueryBean() {
		return queryBean;
	}

	public void setQueryBean(ShangPinQueryBean queryBean) {
		this.queryBean = queryBean;
	}

	@Override
	public void beforeInput() throws Exception {
		listUserDto = userService.findAll(null);
		listShpDto = shangPinService.findAll(null);
	}

	@Override
	public void beforeList() throws Exception {
		beforeInput();
	}

	public String query() throws Exception {
		beforeInput();
		page = new Pagination(pageIndex);
		listEntity = ruKuService.findByQueryBean(queryBean, page);
		return SUCCESS;
	}
}
