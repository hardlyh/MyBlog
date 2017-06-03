package com.lyh.blog.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.lyh.blog.domain.Admin;
import com.lyh.blog.service.AdminService;
import com.opensymphony.xwork2.ActionContext;

public class AdminAction {

	private AdminService adminService;

	private String username;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() {
		
		List<Admin> list=adminService.findAllEntry();
		for(Admin admin:list){
			if(admin.getUsername().equals(this.username)&&admin.getPassword().equals(this.password)){
				ActionContext.getContext().getSession().put("user", admin);
				return "indexAction";
			}
		}
		ActionContext.getContext().put("error", "账号密码错误");
		ActionContext.getContext().put("useranme", this.username);
		return "login";
	}

	public String quit() {
		ActionContext.getContext().getSession().remove("user");
		ActionContext.getContext().put("success", "注销成功");
		return "login";
	}
	
	public String updateOne(){
		Admin admin=(Admin) ActionContext.getContext().getSession().get("user");
		ActionContext.getContext().put("username", admin.getUsername());
		return "update";
	}
	
	public String updateTwo(){
		Admin a=new Admin();
		a.setPassword(this.password);
		a.setUsername(this.username);
		adminService.updateEntry(a);
		ActionContext.getContext().put("success", "密码更新成功");
		return "indexAction";
	}

}
