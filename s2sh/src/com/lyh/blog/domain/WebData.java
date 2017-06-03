package com.lyh.blog.domain;
// Generated 2017-5-23 17:13:52 by Hibernate Tools 3.2.2.GA

public class WebData{
	private Integer data_id;
	private Integer web_views;
	private Integer web_articleamount;
	public Integer getData_id() {
		return data_id;
	}
	public void setData_id(Integer data_id) {
		this.data_id = data_id;
	}
	public Integer getWeb_views() {
		return web_views;
	}
	public void setWeb_views(Integer web_views) {
		this.web_views = web_views;
	}
	public Integer getWeb_articleamount() {
		return web_articleamount;
	}
	public void setWeb_articleamount(Integer web_articleamount) {
		this.web_articleamount = web_articleamount;
	}
	public WebData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WebData(Integer data_id, Integer web_views, Integer web_articleamount) {
		super();
		this.data_id = data_id;
		this.web_views = web_views;
		this.web_articleamount = web_articleamount;
	}
	
	
	
	



}
