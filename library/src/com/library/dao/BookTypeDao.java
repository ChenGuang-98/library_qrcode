package com.library.dao;

import com.library.dao.bean.BookType;

public interface BookTypeDao {
	
	/**
	 * 	���ĳ������鼮
	 * @param booktype
	 * @param index
	 * @param count
	 */
	public void fillBooks(BookType booktype, int index, int count);
	
	/**
	 * 	���ݷ�������ѯ����
	 * @param tname
	 * @return
	 */
	public BookType getByName(String tname);
}
