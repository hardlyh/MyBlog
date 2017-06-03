package com.lyh.blog.util;

import java.util.List;

//��ҳ�����װ
public class PageBean {
	// ��ǰҳ��
	private Integer currentPage;
	// �ܼ�¼��
	private Integer totalCount;
	// ÿҳ��ʾ����
	private Integer pageSize;
	// ��ҳ��
	private Integer totalPage;
	// ��ҳ�б�����
	private List list;
	//��ʼҳ
	private Integer startPage;
	//��ֹҳ
	private Integer endPage;
	// ���캯����ʼ��
	
	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize,Integer startPage) {
		this.totalCount = totalCount;
		
		this.pageSize = pageSize;

		this.currentPage = currentPage;
		// û��ָ����ǰҳ,Ĭ��ֵΪ1
		if (this.currentPage == null) {
			this.currentPage = 1;
		}
		// Ĭ����ʾҳ��
		if (this.pageSize == null) {
			this.pageSize = 5;
		}
		// ��ҳ��
		this.totalPage = (totalCount % pageSize == 0) ? (totalCount / pageSize) : (totalCount / pageSize) + 1;
		//�ж�ҳ���Ƿ񳬳���Χ
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
	//������ʼ����
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
