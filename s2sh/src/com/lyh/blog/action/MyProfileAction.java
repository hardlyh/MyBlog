package com.lyh.blog.action;

import java.io.File;
import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.lyh.blog.domain.Myprofile;
import com.lyh.blog.service.MyprofileService;
import com.lyh.blog.util.UploadUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MyProfileAction extends ActionSupport {
	private MyprofileService myprofileService;

	private Myprofile mp;

	private File file2;

	public Myprofile getMp() {
		return mp;
	}

	public void setMp(Myprofile mp) {
		this.mp = mp;
	}

	
	
	public File getFile2() {
		return file2;
	}

	public void setFile2(File file2) {
		this.file2 = file2;
	}

	public MyprofileService getMyprofileService() {
		return myprofileService;
	}

	public void setMyprofileService(MyprofileService myprofileService) {
		this.myprofileService = myprofileService;
	}

	public String updateMyProfile() {
		
		String url2 = null;
		if(this.file2!=null){
			url2=UploadUtils.upload("/admin/assets/img","user-medium.png", this.file2);
		}
		System.out.println(url2);
		myprofileService.updateEntry(this.mp);
		ActionContext.getContext().put("success","更新个人信息成功");
		return "myProfileAction";
	}

	public String findMyProfile() {
		Myprofile myprofile=myprofileService.getEntryById(1);
		ActionContext.getContext().put("mp",myprofile);
		return "myProfile";
	}

	public String saveMyProfile() {
		
		return null;
	}

	public String upToTemp() throws IOException {
		String url = UploadUtils.uploadToTemp("head.png", this.file2);
		ServletActionContext.getResponse().getWriter().println(url);
		System.out.println(url);
		return null;
	}

}
