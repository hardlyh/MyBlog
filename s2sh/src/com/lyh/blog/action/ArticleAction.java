package com.lyh.blog.action;

import java.io.File;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.lyh.blog.domain.Article;
import com.lyh.blog.domain.Page;
import com.lyh.blog.service.ArticleService;
import com.lyh.blog.util.PageBean;
import com.lyh.blog.util.UploadUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ArticleAction extends ActionSupport {
	private ArticleService articleService;

	private Article article;

	private int id;

	private File file;

	private int currentPage; // 当前页

	private int tag;

	private Integer startPage; // 起始页面

	private String condition; // 条件查询

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

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public String saveArticle() {

		String url3 = "";
		if(file!=null){
			String name = String.valueOf(System.currentTimeMillis());
			url3 = UploadUtils.upload("/HTML", name+".html", this.file);
			article.setFilename(name + ".html");
		}
		article.setTime(new Date());
		articleService.saveEntry(article);
		ActionContext.getContext().put("success", "保存页面成功");
		return "articleListAction";
	}

	public String findAllArticle() {
		DetachedCriteria dc = DetachedCriteria.forClass(Article.class);
		if (StringUtils.isNotBlank(this.condition)) {
			dc.add(Restrictions.like("name", "%" + this.condition + "%"));
		}
		dc.addOrder(Order.desc("time"));
		PageBean pb = articleService.getPageBean(dc, currentPage, 5, tag, startPage);
		ActionContext.getContext().put("pageBean", pb);
		ActionContext.getContext().put("condition", this.condition);
		ActionContext.getContext().put("targetAction", "articleAction_findAllArticle.action");
		return "articleList";
	}

	public String deleteArticle() {
		articleService.deleteEntry(id);
		ActionContext.getContext().put("success", "删除页面成功");
		return "articleListAction";

	}

	public String updateOne() {
		article=articleService.getEntryById(id);
		ActionContext.getContext().put("article", article);
		return "update";
	}
	
	public String updateTwo() {
		String name=article.getName();
		article=articleService.getEntryById(article.getId());
		article.setName(name);
		article.setTime(new Date());
		articleService.updateEntry(article);
		ActionContext.getContext().put("success", "更新页面成功");
		return "articleListAction";
	}

}
