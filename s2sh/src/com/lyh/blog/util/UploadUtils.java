package com.lyh.blog.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class UploadUtils {
	
	public static String upload(String path,String filename,File file){
		ServletContext sc=ServletActionContext.getServletContext();
		String url1=sc.getRealPath(path);
		File filePath=new File(url1);
		if(!filePath.exists()){
			filePath.mkdirs();
		}
		String url2=url1+"/"+String.valueOf(filename);
		File file22=new File(filePath, filename);
		try {
			FileUtils.copyFile(file, file22);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(url2);
		return url2;
		
	}
	
	
	
	public static String uploadToTemp(String filename,File file){
		ServletContext sc=ServletActionContext.getServletContext();
		String url1=sc.getRealPath("/images/temp");
		File filePath=new File(url1);
		if(!filePath.exists()){
			filePath.mkdirs();
		}
		String url2=url1+"/"+String.valueOf(filename);
		File file22=new File(filePath, filename);
		try {
			FileUtils.copyFile(file, file22);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url2;
		
	}

}
