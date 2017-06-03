package com.lyh.blog.dao.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface CommonDao<T> {
	
	/**
	 * ������������
	 * @return
	 */
	public List<T> findAllEntry();
	
	/**
	 * ��������
	 * @param t ����ĳ־û�����
	 */
	public void saveEntry(T t);
	
	/**
	 * ��������
	 * @param t ���µĳ־û�����
	 */
	public void updateEntry(T t);
	
	/**
	 * ɾ������
	 * @param id ����
	 */
	public void deleteEntry(Serializable id);
	
	/**
	 * ����������ѯ����
	 * @param id ����
	 * @return
	 */
	public T getEntryById(Serializable id);
	
	
	/**
	 * ��ѯ�����������ܼ�¼����
	 * @param dc DetachedCriteria��ѯ����
	 * @return
	 */
	public Integer getTotalCount(DetachedCriteria dc);
	
	/**
	 * ��ѯ��ҳ
	 * @param dc DetachedCriteria��ѯ����
	 * @param start ��ʼ����
	 * @param pageSize  ���ݳ���
	 * @return
	 */
	public List<T> getPageList(DetachedCriteria dc,Integer start,Integer pageSize);
	
	
	/**
	 * ����������ѯ���з��ϵĶ���
	 * @param dc
	 * @return
	 */
	public List<T> findByCondition(DetachedCriteria dc) ;

}
