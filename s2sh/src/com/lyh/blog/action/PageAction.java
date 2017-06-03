package com.lyh.blog.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.SubsetIteratorFilter.Decider;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.lyh.blog.domain.Page;
import com.lyh.blog.service.PageService;
import com.lyh.blog.util.BuildHtml;
import com.lyh.blog.util.PageBean;
import com.lyh.blog.util.SortByMonth;
import com.lyh.blog.util.UploadUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.TemplateException;

public class PageAction extends ActionSupport {
	private int id; // ��Ҫ���������id

	private int currentPage; // ��ǰҳ

	private int tag;
	
	private File file;
	
	private String condition;  //������ѯ

	private Integer startPage; // ��ʼҳ��

	private Page page; // model

	private PageService pageService; // service

	

	public void setFile(File file) {
		this.file = file;
	}


	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Integer getStartPage() {
		return startPage;
	}

	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public PageService getPageService() {
		return pageService;
	}

	public void setPageService(PageService pageService) {
		this.pageService = pageService;
	}
	

	
	//�������
	public String savePage() throws IOException, TemplateException {
		String url3="";
		page.setTime(new Date()); 
		String name=String.valueOf(System.currentTimeMillis());
		page.setDescription(this.substringByContent(page.getContent()));
		
		if(this.file!=null){
			url3=UploadUtils.upload("/admin/assets/page_img",name+".jpg", this.file);
			page.setHead_url(name+".jpg");
		}else{
			page.setHead_url("default.jpg");
		}
		
		BuildHtml.createHtml(name,page);
		page.setHtmlUrl(name);
		pageService.saveEntry(page);
		ActionContext.getContext().put("success","�������³ɹ�");
		return "pageListAction";
		
	}
	//��ѯȫ����page���ҷ�ҳ
	public String showAllPage() {
		DetachedCriteria dc = DetachedCriteria.forClass(Page.class);
		if(StringUtils.isNotBlank(this.condition)){
			dc.add(Restrictions.like("title", "%"+this.condition+"%"));
		}
		dc.addOrder(Order.desc("time"));
		PageBean pb = pageService.getPageBean(dc, currentPage, 5, tag, startPage);
		ActionContext.getContext().put("pageBean", pb);
		ActionContext.getContext().put("condition", this.condition);
		ActionContext.getContext().put("targetAction", "pageAction_showAllPage.action");
		return "pageList";
	}
	
	
	//����1, ת�����½���
	public String updatePageOne() {
		Page page = pageService.getEntryById(id);
		ActionContext.getContext().put("page", page);
		System.out.println("pageConetxt : "+page.getContent());
		return "update";
	}
	//�ύ����
	public String updatePageTwo() throws IOException, TemplateException {
		page.setTime(new Date());
		page.setDescription(this.substringByContent(page.getContent()));
		BuildHtml.createHtml(page.getHtmlUrl(),page);
		
		if(this.file!=null){
			String filename=page.getHead_url();
			if(StringUtils.isBlank(filename)||filename.equals("default.jpg")){
				filename=String.valueOf(System.currentTimeMillis()+".jpg");
				page.setHead_url(filename);
			}
			UploadUtils.upload("/admin/assets/page_img",filename, this.file);
		}
		pageService.updateEntry(page);
		ActionContext.getContext().put("success","�������³ɹ�");
		return "pageListAction";
	}
	//ɾ��
	public String deletePage() {
		pageService.deleteEntry(id);
		ActionContext.getContext().put("success","ɾ�����³ɹ�");
		return "pageListAction";
	}
	//�鵵
	public String timeLine(){
		List<Page> list=pageService.findAllEntry();
		SortByMonth byMonth=new SortByMonth();
		Map<String,List<Page>> map=byMonth.sortByMonth(list);
		ActionContext.getContext().put("map", map);
		return "map";
	}
	
	
	public String substringByContent(String content2){
		String content=content2.trim();
		String description="";
		description=content.substring(3, content.indexOf("</p>"));
		System.out.println("content : "+content);
		System.out.println("description : "+description);
		return description;
	}

}
