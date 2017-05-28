package com.library.util.base;

import java.util.List;

public interface BaseDao<T> {
	/**
	 * 	����
	 * @param bean ����Ķ���
	 */
	public void save(T bean);
	
	/**
	 * 	ɾ��
	 * @param id ɾ�����������ֵ
	 */
	public void delete(int id);
	
	/**
	 * 	ɾ��
	 * @param bean ɾ���Ķ���
	 */
	public void delete(T bean);

	/**
	 * 	����
	 * @param bean ���µĶ���
	 */
	public void update(T bean);

	/**
	 * 	��ѯ
	 * @param id ����ֵ
	 * @return ����
	 */
	public T get(int id);
	
	/**
	 * 	��ѯȫ��
	 * @return ȫ�������List����
	 */
	public List<T> list();

	/**
	 * 	��ҳ��ѯ
	 * @param index ��ʼ
	 * @param count ����
	 * @return ĳ�����������
	 */
	public List<T> list(int index, int count);

	/**
	 * 	��ѯ��������
	 * @return
	 */
	public int getCount();
}
