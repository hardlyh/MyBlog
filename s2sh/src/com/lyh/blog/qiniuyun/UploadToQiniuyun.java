package com.lyh.blog.qiniuyun;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.lyh.blog.util.Upload;

public class UploadToQiniuyun implements ServletRequestAware{
	private File myFileName;

	public File getMyFileName() {
		return myFileName;
	}

	public void setMyFileName(File myFileName) {
		this.myFileName = myFileName;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	private HttpServletRequest request;
	public String upload() throws IOException, ServletException{
		Part part = request.getPart("myFileName");
		System.out.println("part : "+part);
		String fileanme="";
		DiskFileItemFactory factory = new DiskFileItemFactory();//产生FileItem的工厂
		ServletFileUpload sfu = new ServletFileUpload(factory);
		List<FileItem> items = new ArrayList<FileItem>();
		String filename=String.valueOf(System.currentTimeMillis());
		try {
			items = sfu.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("request : "+ request);
		System.out.println("items.size : "+items.size());
		System.out.println("File : "+myFileName);
		for(FileItem item:items){
			Upload u=new Upload();
			fileanme=u.upload(item,filename );
		}
		System.out.println("filename"+fileanme);
		ServletActionContext.getResponse().getWriter().write(fileanme);
		
		return null;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request=arg0;
	}

}
