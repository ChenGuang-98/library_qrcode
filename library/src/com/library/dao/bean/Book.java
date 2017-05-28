package com.library.dao.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 	�鼮
 * @author Cheng
 *
 */

public class Book {
	
	private int id;
	private String bno;			// ISBN���
	private String bname;		// ����
	private String author;		// ����
	private String publishing;	// ������
	private Double price;			// �۸�
	private int total;				// ȫ������
	private int remain;			// �������
	private String brief;			// ���
	private String catalogue;		// Ŀ¼
	private Date cdate;
	private Date udate;
	private int yn;

	private int ccount;
	private int jcount;
	private int rcount;
	
	private List<Review> reviews = new ArrayList();	// ���������
	private String tname;									// ����������
	private BookType bookType;							// ��������
	private BookImg bookImg;							// �����ͼƬ

	public int getJcount() {
       	return jcount;
       }

	public void setJcount(int jcount) {
       	this.jcount = jcount;
       }

	public int getCcount() {
       	return ccount;
       }

	public void setCcount(int ccount) {
       	this.ccount = ccount;
       }

	public int getRcount() {
       	return rcount;
       }

	public void setRcount(int rcount) {
       	this.rcount = rcount;
       }

	public List<Review> getReviews() {
		return reviews;
	}

	public String getPublishing() {
		return publishing;
	}

	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public String getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}

	public BookImg getBookImg() {
		return bookImg;
	}

	public void setBookImg(BookImg bookImg) {
		this.bookImg = bookImg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBno() {
		return bno;
	}

	public void setBno(String bno) {
		this.bno = bno;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public BookType getBookType() {
		return bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRemain() {
		return remain;
	}

	public void setRemain(int remain) {
		this.remain = remain;
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

	public int getYn() {
		return yn;
	}

	public void setYn(int yn) {
		this.yn = yn;
	}

}