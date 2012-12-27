package com.term.web.core;

/**
 * 请在此加入你的功能说明
 *
 * @author 李国江
 * @date 2009-6-11
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.term.business.dto.UserDto;
import com.term.dbaccess.core.Pagination;

public class BaseActionSupport extends ActionSupport {
	/**
	 * 进行CUD操作后,以redirect方式重新打开action默认页的result名.
	 */
	public static final String RELOAD = "reload";
	protected Log log = LogFactory.getLog(getClass());
	/**
	 * 页面参数
	 */
	public String sid;
	public String sparm;
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

	public String getSid() {
		return sid;
	}

	public String getSparm() {
		return sparm;
	}

	/**
	 * 前台页面传入的参数
	 * 
	 * @param sid
	 */
	public void setSid(String sid) {
		this.sid = sid;
	}

	public void setSparm(String sparm) {
		this.sparm = sparm;
	}

	public Pagination getPage() {
		return page;
	}

	public void setPage(Pagination page) {
		this.page = page;
	}

	public UserDto getUserDetail() {
		Object obj = Struts2Utils.getSession().getAttribute("user");
		if (obj instanceof UserDto) {
			return (UserDto) obj;
		}
		return null;
	}

}