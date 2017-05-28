package com.library.dao;

import com.library.dao.bean.Student;

public interface StudentDao {
	
	/**
	 * 	��¼��֤
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public Student login(Student student) throws Exception;
	
	/**
	 * 	ע����֤
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public boolean register(Student student) throws Exception;
	
	/**
	 * 	���ԤԼ��¼
	 * @param student
	 * @param index
	 * @param count
	 */
	public void fillBespeaks(Student student, int index, int count);

	/**
	 * 	�������¼
	 * @param student
	 * @param index
	 * @param count
	 */
	public void fillBookStudents(Student student, int index, int count);

	/**
	 * 	����ղ�
	 * @param student
	 * @param index
	 * @param count
	 */
	public void fillCollects(Student student, int index, int count);

	/**
	 * 	�����ʷ��¼
	 * @param student
	 * @param index
	 * @param count
	 */
	public void fillHistorys(Student student, int index, int count);

	/**
	 * 	��ʼ����ȫ����䣩
	 * @param student
	 * @param index
	 * @param count
	 */
	public void init(Student student, int index, int count);
}
