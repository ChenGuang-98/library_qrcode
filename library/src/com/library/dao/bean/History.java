package com.library.dao.bean;

import java.util.Date;

/**
 *  ��ʷ��¼
 * @author Cheng
 *
 */

public class History {
	
	private int id;
	private Book book;			// ���ʹ�����
	private Student student;
	private Date cdate;
	private Date udate;
	private int count;			// ���ʴ���
	private int hcount;
	private int yn;

	public int getCount() {
       	return count;
       }

	public void setCount(int count) {
       	this.count = count;
       }

	public Date getCdate() {
		return cdate;
	}

	public int getHcount() {
       	return hcount;
       }

	public void setHcount(int hcount) {
       	this.hcount = hcount;
       }

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public Date getUdate() {
		return udate;
	}

	public void setUdate(Date udate) {
		this.udate = udate;
	}

	public int getYn() {
		return yn;
	}

	public void setYn(int yn) {
		this.yn = yn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
