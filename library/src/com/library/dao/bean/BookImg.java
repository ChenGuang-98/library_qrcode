package com.library.dao.bean;

import java.util.Date;

/**
 * 	�鼮ͼƬ
 * @author Cheng
 *
 */

public class BookImg {
	
	private int id;
	private String iname;		// ͼƬ��
	private String type;		// ͼƬ����
	private Date cdate;
	private Date udate;
	private int yn;

	private Book book;		// �����鼮

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCdate() {
		return cdate;
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

}
