package com.xinxi11.module.core.web.struts2;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.xinxi11.module.core.cache.LoginUserInfo;
import com.xinxi11.module.core.entity.IQueryBean;
import com.xinxi11.module.core.orm.Pagination;
import com.xinxi11.module.core.spring.SpringContextHolder;

public class BaseActionSupport<T> extends ActionSupport {

	private static final long serialVersionUID = 4141441739025655618L;
	/** 进行CUD操作后,以redirect方式重新打开action默认页的result名. */
	public static final String RELOAD = "reload";
	/** 查看页面 */
	public static final String LOOK = "look";
	/** 添加页面 */
	public static final String SAVE = "save";
	/** 更新,修改页面 */
	public static final String UPDATE = "update";
	/** 搜索查询列表页面 */
	public static final String LIST = "list";
	/** 导出excel文件 */
	public static final String EXPORT_EXCEL = "exportExcel";
	/** 无权访问页面 */
	public static final String FORBIDEN = "forbiden";
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

	/** 页面数据对像 */
	protected T dto = null;
	protected List<T> listDto = new ArrayList<T>();
	protected IQueryBean querybean;

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

	public T getDto() {
		return dto;
	}

	public void setDto(T dto) {
		this.dto = dto;
	}

	public List<T> getListDto() {
		return listDto;
	}

	public void setListDto(List<T> listDto) {
		this.listDto = listDto;
	}

	public IQueryBean getQuerybean() {
		return querybean;
	}

	public void setQuerybean(IQueryBean querybean) {
		this.querybean = querybean;
	}

	public LoginUserInfo getLoginUserInfo() {
		return SpringContextHolder.getCacheUser().findCacheUser(
				SpringContextHolder.getLoginUserId());
	}

}