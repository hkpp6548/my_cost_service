package com.skyhuang.domain;

/** web分页信息
 * Created by hk on 2017/9/29.
 */
public class WebPager {
	/** 当前页 */
	private int currentPage;
	/** 总页数 */
	private int pageNumber;
	/** 每页数 */
	private int pageSize;
	/** 总条数 */
	private int rowNumber;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}
}
