package com.term.web.core;

import com.opensymphony.xwork2.ActionSupport;
import com.term.dbaccess.core.Pagination;

/**
 * 查询页面的action处理
 */
public class BaseListActionSupport extends ActionSupport {

	/**
	 * 页面分页参数
	 */
	protected Integer pageIndex = 1;
	protected Integer pageSize = 20;
	protected Pagination page = new Pagination(1);

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Pagination getPage() {
		return page;
	}

	/**
	 * 默认的跳转方法,
	 */
	@Override
	public String execute() throws Exception {
		return list();
	}

	/**
	 * Action函数,显示Entity列表. return SUCCESS.
	 */
	public String list() throws Exception {
		return SUCCESS;
	};

}
