package com.lyh.blog.qiniuyun;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.lyh.blog.util.Upload;

public class UploadToQiniuyun implements ServletRequestAware{
	private File wangEditorH5File;

	public File getWangEditorH5File() {
		return wangEditorH5File;
	}

	public void setWangEditorH5File(File wangEditorH5File) {
		this.wangEditorH5File = wangEditorH5File;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	private HttpServletRequest request;
	public String upload() throws IOException, ServletException{
		System.out.println("File : "+wangEditorH5File);
		String fileanme="";
		String filename=String.valueOf(System.currentTimeMillis());
		InputStream input = new FileInputStream(wangEditorH5File);
		Upload u=new Upload();
		fileanme=u.upload(input,filename );
		System.out.println("http://oelwgiulw.bkt.clouddn.com/"+fileanme);
		ServletActionContext.getResponse().getWriter().write("http://oelwgiulw.bkt.clouddn.com/"+fileanme);
		
		return null;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request=arg0;
	}

}
