package com.library.dao;

import java.util.List;

import com.library.dao.bean.Book;
import com.library.dao.bean.BookStudent;
import com.library.dao.bean.Student;

public interface BookStudentDao {
	
	/**
	 * 	�����û���ѯ�����¼
	 * @param student
	 * @return ĳ�û��Ľ����¼
	 */
	public List<BookStudent> listByStudent(Student student);
	
	/**
	 * 	�����û���ѯ�����¼
	 * @param student
	 * @return ĳ�û��Ľ����¼
	 */
	public List<BookStudent> listByStudent2(Student student, int index, int count);
	
	/**
	 * 	�����鼮��ѯ�����¼
	 * @param student
	 * @return ĳ�鼮�Ľ����¼
	 */
	public List<BookStudent> listByBook(Book book);
	
	/**
	 * 	�����鼮��ѯ�����¼
	 * @param student
	 * @return ĳ�鼮�Ľ����¼
	 */
	public List<BookStudent> listByBook(Book book, int index, int count);
	
	/**
	 * 	�����鼮��ѯ�������
	 * @param sid
	 * @return ĳ����Ľ������
	 */
	public int getCountByBook(int bid);
	
	/**
	 * 	��ʼ�������¼����
	 * @param bean
	 */
	public void init(BookStudent bean);
	
	/**
	 * 	��ѯ������״̬2�����״̬��
	 * @param index
	 * @param count
	 * @return
	 */
	public List<BookStudent> list2(int index, int count);
	
	/**
	 * 	�����û���ѯ�����¼��״̬0���Թ黹��
	 * @param student
	 * @param index
	 * @param count
	 * @return
	 */
	public List<BookStudent> listByStudent0(Student student, int index, int count);

	/**
	 * 	�����û���ѯ���������״̬2���Խ����
	 * @param sid
	 * @return
	 */
	public int getCountByStudent2(int sid);
	
	/**
	 * 	�����û���ѯ���������״̬0���ѹ黹��
	 * @param sid
	 * @return
	 */
	public int getCountByStudent0(int sid);
	
	/**
	 * 	�����û���ѯ�������
	 * @param sid
	 * @return
	 */
	public int getCountByStudentAll(int sid);
	
	/**
	 * 	�����û������ݲ�ѯ�����¼
	 * @param student
	 * @param book
	 * @return
	 */
	public BookStudent getByStudentAndBook(Student student, Book book);

	/**
	 * 	�����û���ѯ���������δȷ����
	 * @param student
	 * @return
	 */
	public int queryExistCount(Student student);
	
	/**
	 * 	��ѯ�����¼
	 * @return
	 */
	public int getCount();
	
	/**
	 * 	���뵽��ʱ��ǰ����
	 * @return
	 */
	public List<BookStudent> listByReturnRemind();
}
