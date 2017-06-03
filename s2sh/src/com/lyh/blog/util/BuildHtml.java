package com.lyh.blog.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.lyh.blog.domain.Page;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class BuildHtml {

	
	
	public static String createHtml(String name,Page page) throws IOException, TemplateException{
	
		ServletContext sc=ServletActionContext.getServletContext();
		String url1=sc.getRealPath("");
		
		File filePath=new File(url1);
		
		Configuration configuration = new Configuration();  
		configuration.setDirectoryForTemplateLoading(filePath);
		configuration.setObjectWrapper(new DefaultObjectWrapper());  
		configuration.setDefaultEncoding("UTF-8");
		Template template = configuration.getTemplate("template.jsp");  
		Map<String, Object> paramMap = new HashMap<String, Object>();  
		paramMap.put("page",page);
		paramMap.put("time",String.valueOf(page.getTime().toLocaleString()));
		String filename=filePath+"/"+name+".jsp";
		Writer writer  = new OutputStreamWriter(new FileOutputStream(new File(filename)),"UTF-8"); 
		template.process(paramMap, writer);  
		
		
		
		return filename;
	}
}
