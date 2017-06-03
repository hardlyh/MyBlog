package com.lyh.blog.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.lyh.blog.domain.Category;
import com.lyh.blog.domain.Page;
import com.lyh.blog.domain.PageviewDay;
import com.lyh.blog.domain.PageviewMonth;
import com.lyh.blog.domain.WebData;
import com.lyh.blog.service.CategoryService;
import com.lyh.blog.service.PageService;
import com.lyh.blog.service.PageViewDayService;
import com.lyh.blog.service.PageViewMouthService;
import com.lyh.blog.service.WebDataService;
import com.lyh.blog.util.PageBean;
import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONArray;

public class IndexManageAction {

	private CategoryService categoryService;

	private WebDataService dataService;

	private PageService pageService;
	
	private PageViewDayService dayService;
	
	private PageViewMouthService mouthService;

	public PageViewDayService getDayService() {
		return dayService;
	}

	public void setDayService(PageViewDayService dayService) {
		this.dayService = dayService;
	}

	public PageViewMouthService getMouthService() {
		return mouthService;
	}

	public void setMouthService(PageViewMouthService mouthService) {
		this.mouthService = mouthService;
	}

	public PageService getPageService() {
		return pageService;
	}

	public void setPageService(PageService pageService) {
		this.pageService = pageService;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public WebDataService getDataService() {
		return dataService;
	}

	public void setDataService(WebDataService dataService) {
		this.dataService = dataService;
	}

	public String getIndex() {  //跳转主页面
		WebData data=dataService.getEntryById(1);
		ActionContext.getContext().put("data", data);
		return "index";
	}
	
	
	public String json() throws IOException{  //返回json , 构建表格
		Map<String,Object> map=new HashMap<>();   //返回的map
		List<PageviewDay> pageList=this.getByDay(); //pageViewDay的List
		List<String> labels1=new ArrayList<>(); //第一个图标的labels
		List<String> labels=new ArrayList<>();//第2个图标的labels
		List<Category> list=this.addPageAmountByTag();
		List<Integer> series1=new ArrayList<>();
		List<Integer> series=new ArrayList<>();
		
		
		for(int i=pageList.size()-1;i>=0;i--){
			labels1.add(pageList.get(i).getDay());
			series1.add(pageList.get(i).getAmount());
		}
		
		map.put("labels1", labels1);
		map.put("series1", series1);
		
		for(Category c:list){
			labels.add(c.getName());
			series.add(c.getAmount());
		}
		
		
		
		map.put("labels", labels);
		map.put("series", series);
		String str=JSONArray.fromObject(map).toString();
		String str2=str.substring(1, str.length()-1);
		System.out.println(str2);
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		ServletActionContext.getResponse().getWriter().println(str2);
		return null;
		
	}

	public List<Category> addPageAmountByTag() {  //获取每个标签所包含的文章数
		List<Category> list = categoryService.findAllEntry();
		for (Category ca : list) {
			DetachedCriteria dc = DetachedCriteria.forClass(Page.class);
			dc.add(Restrictions.eq("tag", ca.getName()));
			Integer amount = pageService.getTotalPage(dc);
			if (amount == null) {
				ca.setAmount(0);
			} else {
				ca.setAmount(amount);
			}
			categoryService.updateEntry(ca);
		}
		return list;
	}
	
	
	public List<PageviewDay> getByDay(){  //获取过去五天的访问数据
		DetachedCriteria dc = DetachedCriteria.forClass(PageviewDay.class);
		dc.addOrder(Order.desc("day"));
		PageBean pb = pageService.getPageBean(dc, null, 5, 0, 1);
		System.out.println(pb.getList().size());
		return pb.getList();
	}
}
