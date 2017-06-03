package com.lyh.blog.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lyh.blog.dao.base.CommonDao;
import com.lyh.blog.domain.Page;
import com.lyh.blog.util.PageBean;

public class CommonDaoImpl<T> implements CommonDao<T> {

	private HibernateTemplate hibernateTemplate; // spring内置的hibernate对象

	public HibernateTemplate getHibernateTemplate() {

		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	private Class classt;

	public CommonDaoImpl() {
		ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.classt = (Class) parameterizedType.getActualTypeArguments()[0];
	}

	public List<T> findAllEntry() {
		return (List<T>) this.hibernateTemplate.find("from " + this.classt.getName());
	}

	public void saveEntry(T t) {
		this.hibernateTemplate.save(t);

	}

	public void updateEntry(T t) {
		this.hibernateTemplate.update(t);
	}

	public void deleteEntry(Serializable id) {
		System.out.println("delete : " + id);
		T t = (T) this.hibernateTemplate.get(this.classt, id);
		this.hibernateTemplate.delete(t);
	}

	public T getEntryById(Serializable id) {
		return (T) this.hibernateTemplate.get(this.classt, id);
	}

	public List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {

		List<T> list = (List<T>) this.hibernateTemplate.findByCriteria(dc, start, pageSize);
		return list;
	}
	
	public List<T> findByCondition(DetachedCriteria dc) {
		List<T> list = (List<T>)this.hibernateTemplate.findByCriteria(dc);
		return list;
	}
	

	public Integer getTotalCount(DetachedCriteria dc) {
		// 设置聚合函数
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		// 清空聚合函数
		dc.setProjection(null);
		if (list != null && list.size() > 0) {
			Long count = list.get(0);
			return count.intValue();
		} else {
			return null;
		}

	}

}
