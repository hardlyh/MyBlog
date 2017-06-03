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
    //时间间隔
     private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;
     public TimerManager() {
          Calendar calendar = Calendar.getInstance(); 
                 
          /*** 定制每日2:00执行方法 ***/
 
          calendar.set(Calendar.HOUR_OF_DAY, 15);
          calendar.set(Calendar.MINUTE, 0);
          calendar.set(Calendar.SECOND, 0);
          
          Date date=calendar.getTime(); //第一次执行定时任务的时间
          System.out.println(date);
          System.out.println("before 方法比较："+date.before(new Date()));
          //如果第一次执行定时任务的时间 小于 当前的时间
          //此时要在 第一次执行定时任务的时间 加一天，以便此任务在下个时间点执行。如果不加一天，任务会立即执行。循环执行的周期则以当前时间为准
          if (date.before(new Date())) {
              date = this.addDay(date, 1);
              System.out.println(date);
          }
           
          Timer timer = new Timer();
           
          NFDFlightDataTimerTask task = new NFDFlightDataTimerTask();
          //安排指定的任务在指定的时间开始进行重复的固定延迟执行。
          timer.schedule(task,date,PERIOD_DAY);
         }
 
         // 增加或减少天数
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