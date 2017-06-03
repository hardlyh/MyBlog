package com.lyh.blog.service.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.lyh.blog.util.PageBean;

public interface CommonService<T> {

	/**
	 * 返回所有的
	 * @return
	 */
	public List<T> findAllEntry();

	/**
	 * 保存对象
	 * 
	 * @param t
	 */
	public void saveEntry(T t);

	/**
	 * 更新对象
	 * 
	 * @param t
	 */
	public void updateEntry(T t);

	/**
	 * 删除对象
	 * 
	 * @param id
	 */
	public void deleteEntry(Serializable id);

	/**
	 * 根据id查询对象
	 * 
	 * @param id
	 * @return
	 */
	public T getEntryById(Serializable id);

	/**
	 * 返回分页数据
	 * 
	 * @param dc
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize,int tag,Integer startPage);
	
	public List<T> findByCondition(DetachedCriteria dc);

}
