package com.lyh.blog.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

public class BuildSessionFactory {
	public static ApplicationContext context;
	
	static{
		context=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}

}
