package com.lyh.blog.listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.swing.plaf.synth.SynthSpinnerUI;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyh.blog.action.IndexManageAction;
import com.lyh.blog.domain.PageviewDay;
import com.lyh.blog.domain.PageviewMonth;
import com.lyh.blog.domain.WebData;
import com.lyh.blog.service.PageViewMouthService;
import com.lyh.blog.service.WebDataService;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {
	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM");
	private int a = 0;

	/**
	 * Default constructor.
	 */
	public SessionListener() {

	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		IndexManageAction action = (IndexManageAction) context.getBean("indexManageAction");
		WebDataService dataService = (WebDataService) action.getDataService();
		WebData data = dataService.getEntryById(1);
		String dayStr = formatter.format(new Date());
		PageviewDay day = action.getDayService().getEntryById(dayStr);
		data.setWeb_views(data.getWeb_views()+1);
		dataService.updateEntry(data);
		if (day == null) {
			day = new PageviewDay();
			day.setAmount(1);
			day.setDay(dayStr);
			action.getDayService().saveEntry(day);
		} else {
			day.setAmount(day.getAmount()+1);
			action.getDayService().updateEntry(day);
		}
		
		Date date = new Date();
		String str = formatter2.format(date);
		PageViewMouthService mouthService = action.getMouthService();
		PageviewMonth month = mouthService.getEntryById(str);
		if (month == null) {
			month = new PageviewMonth();
			month.setAmount(1);
			month.setMonth(str);
			System.out.println("session5: ");
			mouthService.saveEntry(month);
			
		} else {
			month.setAmount(month.getAmount() + 1);
			mouthService.updateEntry(month);
		}
		
		ServletActionContext.getServletContext().setAttribute("mouthAmount", month.getAmount());
		ServletActionContext.getServletContext().setAttribute("totalCount", data.getWeb_views());
		ServletActionContext.getServletContext().setAttribute("countByDay", day.getAmount());

	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
	}

}
