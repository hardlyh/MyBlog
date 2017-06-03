package com.lyh.blog.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.lyh.blog.util.UploadUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class WebManageAction extends ActionSupport {

	public File picture1;

	public File picture2;

	public File picture3;

	public File picture4;

	public File getPicture1() {
		return picture1;
	}

	public void setPicture1(File picture1) {
		this.picture1 = picture1;
	}

	public File getPicture2() {
		return picture2;
	}

	public void setPicture2(File picture2) {
		this.picture2 = picture2;
	}

	public File getPicture3() {
		return picture3;
	}

	public void setPicture3(File picture3) {
		this.picture3 = picture3;
	}

	public File getPicture4() {
		return picture4;
	}

	public void setPicture4(File picture4) {
		this.picture4 = picture4;
	}

	public String upload() {
		List<File> filelist = new ArrayList<File>();
		filelist.add(picture1);
		filelist.add(picture2);
		filelist.add(picture3);
		filelist.add(picture4);
		String[] filename = { "head.png", "b1.png", "b2.png", "b3.png" };
		for (int i = 0; i < filelist.size(); i++) {
			if (filelist.get(i) != null) {
				UploadUtils.upload("/assets/i", filename[i], filelist.get(i));
			}
		}
		ActionContext.getContext().put("success", "±£´æ³É¹¦");

		return "message";
	}
}
