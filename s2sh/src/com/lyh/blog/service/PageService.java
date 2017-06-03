package com.lyh.blog.service;



import org.hibernate.criterion.DetachedCriteria;

import com.lyh.blog.domain.Page;
import com.lyh.blog.service.base.CommonService;

public interface PageService extends CommonService<Page>{
	
	 public Integer getTotalPage(DetachedCriteria dc);
	 
}

