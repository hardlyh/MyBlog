package com.lyh.blog.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.lyh.blog.domain.Article;
import com.lyh.blog.domain.Category;
import com.lyh.blog.domain.Myprofile;
import com.lyh.blog.domain.Page;
import com.lyh.blog.service.ArticleService;
import com.lyh.blog.service.CategoryService;
import com.lyh.blog.service.MyprofileService;
import com.lyh.blog.service.PageService;
import com.lyh.blog.util.PageBean;
import com.lyh.blog.util.SortByMonth;
import com.opensymphony.xwork2.ActionContext;

public class WebPageAction {

	private int currentPage; // 当前页

	private int tag;

	private String tagCondition;

	private String condition;

	private Integer startPage; // 起始页面

	private CategoryService categoryService; // 类别

	private MyprofileService myprofileService; // 自己详情

	private PageService pageService; // service

	private ArticleService articleService;

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public String getTagCondition() {
		return tagCondition;
	}

	public void setTagCondition(String tagCondition) {
		this.tagCondition = tagCondition;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public MyprofileService getMyprofileService() {
		return myprofileService;
	}

	public void setMyprofileService(MyprofileService myprofileService) {
		this.myprofileService = myprofileService;
	}

	public PageService getPageService() {
		return pageService;
	}

	public void setPageService(PageService pageService) {
		this.pageService = pageService;
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

	public String jumpIndex() { // 跳转主页面
		DetachedCriteria dc = DetachedCriteria.forClass(Page.class);
		dc.addOrder(Order.desc("time"));
		dc.add(Restrictions.eq("isprivate", "no"));
		PageBean pb = pageService.getPageBean(dc, currentPage, 7, tag, startPage);
		ActionContext.getContext().put("pageBean", pb);
		ActionContext.getContext().put("targetAction", "webPageAction_jumpIndex");
		List<Category> list = categoryService.findAllEntry();
		ActionContext.getContext().getApplication().put("categoryList", list);
		Myprofile myprofile = myprofileService.getEntryById(1);
		
		List<Page> listPage=this.findByView();
		ActionContext.getContext().getSession().put("listPage", listPage);
		ActionContext.getContext().getApplication().put("myprofile", myprofile);
		return "index";
	}
	
	public String findByPrivate(){
		DetachedCriteria dc = DetachedCriteria.forClass(Page.class);
		dc.add(Restrictions.eq("isprivate", "yes"));
		dc.addOrder(Order.desc("time"));
		PageBean pb = pageService.getPageBean(dc, currentPage, 7, tag, startPage);
		ActionContext.getContext().put("pageBean", pb);
		ActionContext.getContext().put("targetAction", "webPageAction_findByPrivate");
		return "privateList";
	}

	public String condition() {
		DetachedCriteria dc = DetachedCriteria.forClass(Page.class);
		dc.add(Restrictions.eq("isprivate", "no"));
		if (StringUtils.isNotBlank(condition)) {
			dc.add(Restrictions.like("title", "%" + this.condition + "%"));
			ActionContext.getContext().put("condition", this.condition);
		} else if (StringUtils.isNotBlank(tagCondition)) {
			dc.add(Restrictions.eq("tag", this.tagCondition));
			ActionContext.getContext().put("tagCondition", this.tagCondition);
		}
		dc.addOrder(Order.desc("time"));
		PageBean pb = pageService.getPageBean(dc, currentPage, 7, tag, startPage);
		ActionContext.getContext().put("pageBean", pb);
		ActionContext.getContext().put("targetAction", "webPageAction_condition");
		return "pageList";
	}
	
	public String findAllNoCondition(){  //查询全部,没有条件
		DetachedCriteria dc = DetachedCriteria.forClass(Page.class);
		dc.add(Restrictions.eq("isprivate", "no"));
		dc.addOrder(Order.desc("time"));
		PageBean pb = pageService.getPageBean(dc, currentPage, 7, tag, startPage);
		ActionContext.getContext().put("pageBean", pb);
		ActionContext.getContext().put("targetAction", "webPageAction_condition");
		return "pageList";
		
	}
	
	
	public String getArticle(){
		DetachedCriteria dc = DetachedCriteria.forClass(Article.class);
		dc.addOrder(Order.desc("time"));
		List<Article> list=articleService.findByCondition(dc);
		ActionContext.getContext().put("articleList", list);
		System.out.println("listsize : "+ list.size());
		return "article";
	}

	
	public String timeLine() {
		DetachedCriteria dc = DetachedCriteria.forClass(Page.class);
		dc.add(Restrictions.eq("isprivate", "no"));
		List<Page> list = pageService.findByCondition(dc);
		SortByMonth byMonth = new SortByMonth();
		Map<String, List<Page>> map = byMonth.sortByMonth(list);
		ActionContext.getContext().put("map", map);
		return "timeLine";
	}
	
	public List<Page> findByView(){
		DetachedCriteria dc = DetachedCriteria.forClass(Page.class);
		dc.addOrder(Order.desc("pageview"));
		dc.add(Restrictions.eq("isprivate", "no"));
		PageBean pb = pageService.getPageBean(dc, 0, 5, 0, 2);
		
		return pb.getList();
	}
	
	
	
	
	public String updateView(){
		System.out.println("pageView : "+this.tag);
		Page page=pageService.getEntryById(this.tag);
		Integer pageView = page.getPageview();
		System.out.println("pageView1 : "+page.getPageview());
		if(pageView==null){
			pageView=1;
		}else{
			pageView=page.getPageview()+1;
		}
		page.setPageview(pageView);
		System.out.println("pageView2 : "+page.getPageview());
		pageService.updateEntry(page);
		System.out.println("pageView3 : "+page.getPageview());
		return null;
	}

}
