package com.lyh.blog.service.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.lyh.blog.util.PageBean;

public interface CommonService<T> {

	/**
	 * �������е�
	 * @return
	 */
	public List<T> findAllEntry();

	/**
	 * �������
	 * 
	 * @param t
	 */
	public void saveEntry(T t);

	/**
	 * ���¶���
	 * 
	 * @param t
	 */
	public void updateEntry(T t);

	/**
	 * ɾ������
	 * 
	 * @param id
	 */
	public void deleteEntry(Serializable id);

	/**
	 * ����id��ѯ����
	 * 
	 * @param id
	 * @return
	 */
	public T getEntryById(Serializable id);

	/**
	 * ���ط�ҳ����
	 * 
	 * @param dc
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize,int tag,Integer startPage);
	
	public List<T> findByCondition(DetachedCriteria dc);

}
