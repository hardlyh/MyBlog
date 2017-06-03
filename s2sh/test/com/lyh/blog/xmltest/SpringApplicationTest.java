package com.lyh.blog.xmltest;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;



public class SpringApplicationTest {

	@Test
	public void test() {
		Date date=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM");
		System.out.println(dateFormat.format(date));

	}

	

}
