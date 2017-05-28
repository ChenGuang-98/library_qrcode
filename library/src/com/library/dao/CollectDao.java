package com.library.dao;

import java.util.List;

import com.library.dao.bean.Book;
import com.library.dao.bean.Collect;
import com.library.dao.bean.Student;

public interface CollectDao {
	
	/**
	 * 	�����û���ѯ�ղ�
	 * @param student
	 * @return
	 */
	public List<Collect> listByStudent(Student student);

	/**
	 * 	�����û���ѯ�ղ�
	 * @param student
	 * @param index
	 * @param count
	 * @return
	 */
	public List<Collect> listByStudent(Student student, int index, int count);

	/**
	 * 	�����鼮��ѯ�ղ�
	 * @param book
	 * @return
	 */
	public List<Collect> listByBook(Book book);
	
	/**
	 * 	�������ݲ�ѯ�ղ�
	 * @param book
	 * @param index
	 * @param count
	 * @return
	 */
	public List<Collect> listByBook(Book book, int index, int count);

	/**
	 * 	�����û���ѯ�ղ�����
	 * @param sid
	 * @return
	 */
	public int getCountByStudent(int sid);

	/**
	 * 	�����鼮��ѯ�ղ�����
	 * @param bid
	 * @return
	 */
	public int getCountByBook(int bid);
	
	/**
	 * 	�����û� & ͼ���������ղ�
	 * @param sid
	 * @param bid
	 * @return
	 */
	public Collect getByStudentAdnBook(Student student, Book book);
}
