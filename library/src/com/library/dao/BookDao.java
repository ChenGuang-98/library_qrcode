package com.library.dao;

import java.util.List;

import com.library.dao.bean.Book;
import com.library.dao.bean.BookStudent;
import com.library.dao.bean.BookType;

public interface BookDao {
	
	/**
	 * 	�������Ͳ�ѯ�鼮
	 * @param booktype
	 * @return ĳ���ȫ���鼮
	 */
	public List<Book> listByType(BookType booktype);
	
	/**
	 * 	�������Ͳ�ѯ�鼮
	 * @param booktype
	 * @return ĳ���ĳ�����鼮
	 */
	public List<Book> listByType(BookType booktype, int index, int count);
	
	/**
	 * 	�������Ͳ�ѯ�鼮����
	 * @param tid
	 * @return ĳ�����鼮����
	 */
	public int getCountByType(int tid);
	
	/**
	 * 	��������
	 * @param book
	 */
	public void fillTypeName(Book book);
	
	/**
	 * 	���ݹؼ��������鼮
	 * @param search
	 * @return
	 */
	public List<Book> listBySearch(String search, int index, int count);
	
	/**
	 * 	�������
	 * @param bean
	 */
	public void fillReview(Book bean);
	
	/**
	 * 	����������ѯͼ������
	 * @param search
	 * @return
	 */
	public int getCountBySearch(String search);
}
