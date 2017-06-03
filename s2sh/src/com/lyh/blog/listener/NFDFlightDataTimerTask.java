package com.lyh.blog.listener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyh.blog.action.IndexManageAction;
import com.lyh.blog.domain.PageviewDay;
import com.lyh.blog.domain.PageviewMonth;
import com.lyh.blog.domain.WebData;

public class NFDFlightDataTimerTask extends TimerTask {
	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	

	@Override
	public void run() {
		try {
			TimerManager.save();
			System.out.println("执行当前时间" + formatter.format(Calendar.getInstance().getTime()));
		} catch (Exception e) {
			System.out.println("-------------解析信息发生异常--------------");
			e.printStackTrace();
		}
	}

}