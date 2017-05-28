package com.library.dao;

import java.util.List;

import com.library.dao.bean.Book;
import com.library.dao.bean.History;
import com.library.dao.bean.Student;

public interface HistoryDao {
	
	/**
	 * 	�����û���ѯ��ʷ��¼��ȫ����
	 * @param student
	 * @return
	 */
	public List<History> listByStudent(Student student);

	/**
	 * 	�����û���ѯ��ʷ��¼����ҳ��
	 * @param student
	 * @return
	 */
	public List<History> listByStudent(Student student, int index, int count);

	/**
	 * 	�����û���ѯ��ʷ��¼��ȫ����
	 * @param student
	 * @return
	 */
	public List<History> listByBook(Book book);

	/**
	 * 	�����鼮��ѯ��ʷ��¼����ҳ��
	 * @param book
	 * @param index
	 * @param count
	 * @return
	 */
	public List<History> listByBook(Book book, int index, int count);

	/**
	 * 	�����û���ѯ��ʷ��¼����
	 * @param sid
	 * @return
	 */
	public int getCountByStudent(int sid);

	/**
	 * 	�����鼮��ѯ��ʷ��¼����
	 * @param sid
	 * @return
	 */
	public int getCountByBook(int bid);
}
