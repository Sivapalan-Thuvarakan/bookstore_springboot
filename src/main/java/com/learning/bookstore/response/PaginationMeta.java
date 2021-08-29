package com.learning.bookstore.response;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PaginationMeta {

	//totalcount -100
	//page size	-10
	//totalpage- 10
	//page number - 1 (1-10) 2(11-20) ,......10(91-100)
	//isFirst
	//isLast
	
	private Long totalCount;
	private Integer pageSize;
	private Integer totalPage;
	private Integer pageNumber;
	private Boolean isFirst;
	private Boolean isLast;
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Boolean getIsFirst() {
		return isFirst;
	}
	public void setIsFirst(Boolean isFirst) {
		this.isFirst = isFirst;
	}
	public Boolean getIsLast() {
		return isLast;
	}
	public void setIsLast(Boolean isLast) {
		this.isLast = isLast;
	}
	
	public static <T> PaginationMeta createPagination(Page<T> page)
	{
		PaginationMeta paginationMeta = new PaginationMeta();
		paginationMeta.setTotalCount(page.getTotalElements());
		paginationMeta.setPageSize(page.getSize());
		paginationMeta.setTotalPage(page.getTotalPages());
		paginationMeta.setPageNumber(page.getNumber());
		paginationMeta.setIsFirst(page.isFirst());
		paginationMeta.setIsLast(page.isLast());
		
		return paginationMeta;
	}
}
