package com.lyh.blog.listener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyh.blog.action.IndexManageAction;
import com.lyh.blog.domain.PageviewDay;
import com.lyh.blog.domain.PageviewMonth;
import com.lyh.blog.domain.WebData;

public class TimerManager {
	private static SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM");
    //ʱ����
     private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;
     public TimerManager() {
          Calendar calendar = Calendar.getInstance(); 
                 
          /*** ����ÿ��2:00ִ�з��� ***/
 
          calendar.set(Calendar.HOUR_OF_DAY, 15);
          calendar.set(Calendar.MINUTE, 0);
          calendar.set(Calendar.SECOND, 0);
          
          Date date=calendar.getTime(); //��һ��ִ�ж�ʱ�����ʱ��
          System.out.println(date);
          System.out.println("before �����Ƚϣ�"+date.before(new Date()));
          //�����һ��ִ�ж�ʱ�����ʱ�� С�� ��ǰ��ʱ��
          //��ʱҪ�� ��һ��ִ�ж�ʱ�����ʱ�� ��һ�죬�Ա���������¸�ʱ���ִ�С��������һ�죬���������ִ�С�ѭ��ִ�е��������Ե�ǰʱ��Ϊ׼
          if (date.before(new Date())) {
              date = this.addDay(date, 1);
              System.out.println(date);
          }
           
          Timer timer = new Timer();
           
          NFDFlightDataTimerTask task = new NFDFlightDataTimerTask();
          //����ָ����������ָ����ʱ�俪ʼ�����ظ��Ĺ̶��ӳ�ִ�С�
          timer.schedule(task,date,PERIOD_DAY);
         }
 
         // ���ӻ��������
         public Date addDay(Date date, int num) {
          Calendar startDT = Calendar.getInstance();
          startDT.setTime(date);
          startDT.add(Calendar.DAY_OF_MONTH, num);
          return startDT.getTime();
         }
         
         
         
         
         public static void save(){
        	 
        	ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

 			IndexManageAction action = (IndexManageAction) context.getBean("indexManageAction");
 			Integer totalCount = (Integer) ServletActionContext.getServletContext().getAttribute("totalCount");
 			Integer countByDay = (Integer) ServletActionContext.getServletContext().getAttribute("countByDay");

 			WebData data = action.getDataService().getEntryById(1);
 			data.setWeb_views(totalCount);

 			PageviewDay day = new PageviewDay();
 			day.setAmount(countByDay);
 			day.setDay(new Date());
 			action.getDayService().saveEntry(day);

 			Date date = new Date();
 			String mouth = formatter2.format(date);
 			PageviewMonth month = action.getMouthService().getEntryById(mouth);
 			
 			if (month == null) {
 				month = new PageviewMonth();
 				month.setAmount(countByDay);
 				month.setMonth(mouth);
 				action.getMouthService().saveEntry(month);
 			} else {
 				Integer amount = month.getAmount();
 				amount += countByDay;
 				month.setAmount(amount);
 				action.getMouthService().updateEntry(month);
 			}
         }
}