package com.lyh.blog.util;

import java.util.List;

//分页对象封装
public class PageBean {
	// 当前页数
	private Integer currentPage;
	// 总记录数
	private Integer totalCount;
	// 每页显示条数
	private Integer pageSize;
	// 总页数
	private Integer totalPage;
	// 分页列表数据
	private List list;
	//起始页
	private Integer startPage;
	//终止页
	private Integer endPage;
	// 构造函数初始化
	
	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize,Integer startPage) {
		this.totalCount = totalCount;
		
		this.pageSize = pageSize;

		this.currentPage = currentPage;
		// 没有指定当前页,默认值为1
		if (this.currentPage == null) {
			this.currentPage = 1;
		}
		// 默认显示页数
		if (this.pageSize == null) {
			this.pageSize = 5;
		}
		// 总页数
		this.totalPage = (totalCount % pageSize == 0) ? (totalCount / pageSize) : (totalCount / pageSize) + 1;
		//判断页数是否超出范围
		if(this.currentPage<1){
			this.currentPage=1;
		}
		
		if(this.currentPage>this.totalPage){
			this.currentPage=this.totalPage;
		}
		
		if(startPage==null)
			this.startPage=1;
		else
			this.startPage=startPage;
			
		
		if(this.startPage+5>totalPage)
			this.endPage=totalPage;
		else
			this.endPage=this.startPage+5;
		
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage() {
		if(this.startPage-5<1){
			this.startPage=1;
		}else{
			this.startPage-=5;
			this.endPage=this.startPage+5;
			this.currentPage=this.startPage;
		}
		
			
		
		
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage() {
		if(this.startPage+5<this.totalPage){
			if(this.endPage+5>this.totalPage){
				this.startPage+=5;
				this.endPage=this.totalPage;
			}else{
				this.endPage+=5;
				this.startPage=this.endPage-5;
				
			}
			this.currentPage=this.startPage;
		}
		
	}
	//计算起始索引
	public int getStart(){
		return (this.currentPage-1)*this.pageSize;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
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
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	

}
