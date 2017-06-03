package com.lyh.blog.dao.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface CommonDao<T> {
	
	/**
	 * 返回所有数据
	 * @return
	 */
	public List<T> findAllEntry();
	
	/**
	 * 保存数据
	 * @param t 保存的持久化对象
	 */
	public void saveEntry(T t);
	
	/**
	 * 更新数据
	 * @param t 更新的持久化对象
	 */
	public void updateEntry(T t);
	
	/**
	 * 删除数据
	 * @param id 主键
	 */
	public void deleteEntry(Serializable id);
	
	/**
	 * 根据主键查询数据
	 * @param id 主键
	 * @return
	 */
	public T getEntryById(Serializable id);
	
	
	/**
	 * 查询符合条件的总记录条数
	 * @param dc DetachedCriteria查询对象
	 * @return
	 */
	public Integer getTotalCount(DetachedCriteria dc);
	
	/**
	 * 查询分页
	 * @param dc DetachedCriteria查询对象
	 * @param start 开始索引
	 * @param pageSize  数据长度
	 * @return
	 */
	public List<T> getPageList(DetachedCriteria dc,Integer start,Integer pageSize);
	
	
	/**
	 * 按照条件查询所有符合的对象
	 * @param dc
	 * @return
	 */
	public List<T> findByCondition(DetachedCriteria dc) ;

}
