package com.library.dao.bean;

import java.util.Date;

/**
 * �����¼
 * 
 * @author Cheng
 * 
 */

public class BookStudent {

	private int id;
	private Book book; 			// �������
	private Student student; 	// �������
	private String qname; 		// ��ά��ͼƬ��
	private Date bdate; 			// ���ʱ��
	private Date rdate; 			// �����ʱ��
	private Date adate; 			// ����Աȷ��ʱ��
	private Date cdate;
	private Date udate;
	private int yn;
	private int status; 			// 0��δȷ�� 1����� 2���黹
	private int sms;				// �������ͱ��

	private String bno; // ����
	private Double price; // ��۸�
	private String bname; // ����
	private String author; // �������

	private String sno; // �����˱��
	private String sname; // ����������
	private String phone; // �������ֻ�
	private String eamil;

	private String uri;
	
	public String getEamil() {
       	return eamil;
       }

	public void setEamil(String eamil) {
       	this.eamil = eamil;
       }

	public String getUri() {
       	return uri;
       }

	public void setUri(String uri) {
       	this.uri = uri;
       }

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getSms() {
       	return sms;
       }

	public void setSms(int sms) {
       	this.sms = sms;
       }

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getAdate() {
		return adate;
	}

	public void setAdate(Date adate) {
		this.adate = adate;
	}

	public String getQname() {
		return qname;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		this.qname = id+"";
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
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

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
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

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
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