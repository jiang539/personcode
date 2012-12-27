package com.term.dbaccess.core;

/**
 * 分页信息
 */
public class Pagination {
	public static final int DEFAULT_PAGE_SIZE = 20;
	/** 页码,从1开始 */
	private int pageIndex;
	/** 每页多少行 */
	private int pageSize;
	/** 数据总行数 */
	private int totalCount = 0;
	/** 总共可以分多少页 */
	private int pageCount;

	/**
	 * 分页信息,默认每页20行数据
	 * 
	 * @param pageIndex
	 *            页码,从1开始
	 */
	public Pagination(int pageIndex) {
		this(pageIndex, DEFAULT_PAGE_SIZE);
	}

	/**
	 * 分页信息
	 * 
	 * @param pageIndex
	 *            页码,从1开始
	 * @param pageSize
	 *            每页多少行,默认为 20
	 */
	public Pagination(int pageIndex, int pageSize) {
		if (pageIndex < 1)
			pageIndex = 1;
		if (pageSize < 1)
			pageSize = DEFAULT_PAGE_SIZE;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}

	/**
	 * 获取当前页页码
	 * 
	 * @return
	 */
	public int getPageIndex() {
		return pageIndex;
	}

	/**
	 * 获取每页多少行
	 * 
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 获取总共有多少页
	 * 
	 * @return
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * 获取起始行数
	 * 
	 * @return
	 */
	public int getFirstResult() {
		return (pageIndex - 1) * pageSize;
	}

	/**
	 * 获取总记录数
	 * 
	 * @return
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * 设置总记录数
	 * 
	 * @param totalCount
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		pageCount = totalCount / pageSize
				+ (totalCount % pageSize == 0 ? 0 : 1);
		// 调整页码信息,防止出界
		if (totalCount == 0) {
			if (pageIndex != 1)
				pageIndex = 1;
		} else {
			if (pageIndex > pageCount)
				pageIndex = pageCount;
		}
	}

	/**
	 * 是否是第一页
	 * 
	 * @return
	 */
	public boolean getIsFirst() {
		return pageIndex == 1;
	}

	/**
	 * 是否还有前一页
	 * 
	 * @return
	 */
	public boolean getHasPrevious() {
		return pageIndex > 1;
	}

	/**
	 * 是否还有下一页
	 * 
	 * @return
	 */
	public boolean getHasNext() {
		return pageIndex < pageCount;
	}

	/**
	 * 是否是最后一页
	 * 
	 * @return
	 */
	public boolean getIsLast() {
		return pageIndex == pageCount || pageIndex < 1;
	}

	/**
	 * 是否有数据
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return totalCount == 0;
	}

	public boolean getIsEmpty() {
		return totalCount == 0;
	}
}
