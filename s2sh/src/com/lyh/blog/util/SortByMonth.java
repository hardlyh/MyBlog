package com.lyh.blog.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.lf5.util.DateFormatManager;
import org.junit.Test;

import com.lyh.blog.domain.Page;

public class SortByMonth {
	
	@Test
	//public void sortByMonth()
	//public void Map<String,List<Page>> sortByMonth(List<Page> list)
	public Map<String,List<Page>> sortByMonth(List<Page> list){
		Map<String,List<Page>> map=new TreeMap<String, List<Page>>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        // Ωµ–Ú≈≈–Ú
                        return obj2.compareTo(obj1);
                    }
                });
		DateFormatManager dateFormatManager=new DateFormatManager("yyyy-MM");
		Date date=new Date();
		
		for(Page p:list){
			List<Page> list2=new ArrayList<Page>();
			String mouth=dateFormatManager.format(p.getTime());
			if(map.get(mouth)==null){
				list2.add(p);
				map.put(mouth, list2);
			}else{
				map.get(mouth).add(p);
			}
			
		}
		
		
		return map;
		
	}

}
