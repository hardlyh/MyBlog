package com.lyh.blog.service.impl;

import org.hibernate.criterion.DetachedCriteria;

import com.lyh.blog.domain.Page;
import com.lyh.blog.service.PageService;
import com.lyh.blog.service.base.impl.CommonServiceImpl;

public class PageServiceImpl extends CommonServiceImpl<Page> implements PageService{

	@Override
	public Integer getTotalPage(DetachedCriteria dc) {
		
		return getCommonDao().getTotalCount(dc);
	}

}
