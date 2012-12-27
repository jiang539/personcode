package com.term.web.struts2.shangpin;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.term.business.dto.KuCunDto;
import com.term.business.dto.ShangPinDto;
import com.term.business.service.shangpin.IKuCunService;
import com.term.business.service.shangpin.IShangPinService;
import com.term.dbaccess.core.Pagination;
import com.term.dbaccess.querybean.ShangPinQueryBean;
import com.term.web.core.BaseListActionSupport;
import com.term.web.core.CrudActionSupport;

@ParentPackage("default")
@Results( { @Result(name = CrudActionSupport.RELOAD, location = "/shangpin/kucun.action", type = "redirect") })
public class KucunAction extends BaseListActionSupport {

	private IKuCunService kuCunService;
	private IShangPinService shangPinService;
	private List<KuCunDto> listEntity;

	private ShangPinQueryBean queryBean = new ShangPinQueryBean();// 封装查询条件
	private List<ShangPinDto> listShpDto = new ArrayList<ShangPinDto>();

	public void setKuCunService(IKuCunService kuCunService) {
		this.kuCunService = kuCunService;
	}

	public void setShangPinService(IShangPinService shangPinService) {
		this.shangPinService = shangPinService;
	}

	public List<KuCunDto> getListEntity() {
		return listEntity;
	}

	public ShangPinQueryBean getQueryBean() {
		return queryBean;
	}

	public void setQueryBean(ShangPinQueryBean queryBean) {
		this.queryBean = queryBean;
	}

	public List<ShangPinDto> getListShpDto() {
		return listShpDto;
	}

	public void initData() {
		listShpDto = shangPinService.findAll(null);
	}

	@Override
	public String list() throws Exception {
		initData();
		page = new Pagination(pageIndex);
		listEntity = kuCunService.findAll(page);
		return SUCCESS;
	}

	public String query() throws Exception {
		initData();
		page = new Pagination(pageIndex);
		listEntity = kuCunService.findByQueryBean(queryBean, page);
		return SUCCESS;
	}

}
