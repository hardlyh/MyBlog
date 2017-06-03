package com.lyh.blog.action;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.lyh.blog.domain.Category;
import com.lyh.blog.domain.Page;
import com.lyh.blog.service.CategoryService;
import com.lyh.blog.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport{
	private int tagid;
	
	private int currentPage; // 当前页

	private String condition; //条件
	
	
	private int tag;
	
	private Category category;
	
	private CategoryService categoryService;

	private Integer startPage; // 起始页面

	
	public String getCondition() {
		return condition;
	}


	public void setCondition(String condition) {
		this.condition = condition;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getTag() {
		return tag;
	}


	public void setTag(int tag) {
		this.tag = tag;
	}


	public Integer getStartPage() {
		return startPage;
	}


	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}


	
	
	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public int getTagid() {
		return tagid;
	}


	public void setTagid(int tagid) {
		this.tagid = tagid;
	}

	
	
	public CategoryService getCategoryService() {
		return categoryService;
	}


	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	//编辑页面category列表
	public String pageTag(){
		List<Category> list=categoryService.findAllEntry();
		ServletActionContext.getServletContext().setAttribute("tagList",list);
		return "page";
	}

	public String showAllTag(){
		List<Category> list=categoryService.findAllEntry();
		ServletActionContext.getServletContext().setAttribute("tagList",list);
		return null;
	}
	
	public String showTagToPage(){
		DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
		if(StringUtils.isNotBlank(this.condition)){
			dc.add(Restrictions.like("name", "%"+this.condition+"%"));
		}
		PageBean pb = categoryService.getPageBean(dc, currentPage, 5, tag, startPage);
		ActionContext.getContext().put("pageBean", pb);
		ActionContext.getContext().put("condition", this.condition);
		ActionContext.getContext().put("targetAction", "categoryAction_showTagToPage.action");
		
		return "list";
	}
	
	public String updateTagOne(){
		Category ct=categoryService.getEntryById(tagid);
		ActionContext.getContext().put("category",ct);
		return "update";
	}
	
	public String updateTagTwo(){
		categoryService.updateEntry(category);
		ActionContext.getContext().put("success","更新标签成功");
		return "listAction";
	}
	
	public String deleteTag(){
		System.out.println(tagid);
		categoryService.deleteEntry(tagid);
		ActionContext.getContext().put("success","删除标签成功");
		return "listAction";
	}
	
	public String addTag(){
		category.setTime(new Date());
		categoryService.saveEntry(category);
		ActionContext.getContext().put("success","添加标签成功");
		return "listAction";
	}
}
