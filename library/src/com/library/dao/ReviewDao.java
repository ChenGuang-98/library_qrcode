package com.library.dao;

import java.util.List;

import com.library.dao.bean.Book;
import com.library.dao.bean.Review;
import com.library.dao.bean.Student;

public interface ReviewDao {
	
	/**
	 * 	�����û���ѯ���ۣ�ȫ����
	 * @param student
	 * @return
	 */
	public List<Review> listByStudent(Student student);
	
	/**
	 * 	�����û���ѯ���ۣ���ҳ��
	 * @param student
	 * @param index
	 * @param count
	 * @return
	 */
	public List<Review> listByStudent(Student student, int index, int count);
	
	/**
	 * 	�����鼮��ѯ���ۣ�ȫ����
	 * @param book
	 * @return
	 */
	public List<Review> listByBook(Book book);
	
	/**
	 * 	�����鼮��ѯ���ۣ���ҳ��
	 * @param book
	 * @param index
	 * @param count
	 * @return
	 */
	public List<Review> listByBook(Book book, int index, int count);
	
	/**
	 * 	�����û���ѯ��������
	 * @param sid
	 * @return
	 */
	public int getCountByStudent(int sid);
	
	/**
	 * 	�����鼮��ѯ��������
	 * @param bid
	 * @return
	 */
	public int getCountByBook(int bid);
}
