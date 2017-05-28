package com.library.dao;

import java.util.List;

import com.library.dao.bean.Bespeak;
import com.library.dao.bean.Book;
import com.library.dao.bean.Student;

public interface BespeakDao {
	/**
	 * �����û���ѯԤԼ��¼
	 * @param student
	 * @return
	 */
	public List<Bespeak> listByStudent(Student student);
	
	/**
	 * �����û���ѯԤԼ��¼
	 * @param student
	 * @return
	 */
	public List<Bespeak> listByStudent(Student student, int index, int count);
	
	/**
	 * �����鼮��ѯԤԼ��¼
	 * @param student
	 * @return
	 */
	public List<Bespeak> listByBook(Book book);
	
	/**
	 * �����鼮��ѯԤԼ��¼
	 * @param student
	 * @return
	 */
	public List<Bespeak> listByBook(Book book, int index, int count);
	
	/**
	 * 	�����û���ѯԤԼ����
	 * @param
	 * @return
	 */
	public int getCountByStudent (int sid);
	
	/**
	 * 	�����鼮��ѯԤԼ����
	 * @param
	 * @return
	 */
	public int getCountByBook (int bid);
	
	/**
	 * 	�����û���ѯԤԼ��¼ ������ɣ�
	 * @param student
	 * @param index
	 * @param count
	 * @return
	 */
	public List<Bespeak> listByStudentTrue(Student student, int index, int count);
	
	/**
	 * 	�����û���ѯԤԼ����	������ɣ�
	 * @param sid
	 * @return
	 */
	public int getCountByStudentTrue(int sid);

	/**
	 * 	�����û���ѯԤԼ����	��ȫ����
	 * @param sid
	 * @return
	 */
	public int getCountByStudentAll(int sid);
	
	/**
	 *	�����û������ѯԤԼ��¼	��δ��ɣ�
	 * @param student
	 * @param book
	 * @return
	 */
	public Bespeak getByStudentAndBook(Student student, Book book);

	/**
	 * 	�����û���ѯԤԼ����	��δ��ɣ�
	 * @param student
	 * @return
	 */
	public int queryExistCount(Student student);

	/**
	 * 	�õ�ԤԼ������ȫ����
	 * @return
	 */
	public int getCount();
	
	/**
	 * 	�õ�ԤԼ����������ɣ�
	 * @return
	 */
	public int getCount0();
	
	/**
	 * 	�õ�ԤԼ������δ��ɣ�
	 * @return
	 */
	public int getCount1();
}
