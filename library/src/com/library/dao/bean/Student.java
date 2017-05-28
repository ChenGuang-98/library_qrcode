package com.library.dao.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 	������
 * @author Cheng
 *
 */

public class Student {
	
	private int id;
	private String sno;		// ���
	private String idcard;	// ���֤
	private String sname;		// ����
	private String password; // ����
	private String phone;		// �ֻ�
	private String email;		// ����
	private Date cdate;
	private Date udate;
	private int yn;

	private String passwordNew;
	private int ccount;		// �ղ�����
	private int ycount;		// ԤԼ����
	private int jcount;		// ��������
	private int hcount;		// ��ʷ��¼����
	private int tag;			// ΥԼ���
	
	private List<BookStudent> bookStudents = new ArrayList(); 	// ����
	private List<Bespeak> bespeaks = new ArrayList(); 			// ԤԼ
	private List<Collect> collects = new ArrayList(); 				// �ղ�
	private List<History> historys = new ArrayList(); 				// ��ʷ��¼
	
	public int getHcount() {
       	return hcount;
       }

	public void setHcount(int hcount) {
       	this.hcount = hcount;
       }

	public int getTag() {
       	return tag;
       }

	public void setTag(int tag) {
       	this.tag = tag;
       }

	public int getCcount() {
       	return ccount;
       }

	public void setCcount(int ccount) {
       	this.ccount = ccount;
       }

	public int getYcount() {
       	return ycount;
       }

	public void setYcount(int ycount) {
       	this.ycount = ycount;
       }

	public int getJcount() {
       	return jcount;
       }

	public void setJcount(int jcount) {
       	this.jcount = jcount;
       }

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Bespeak> getBespeaks() {
		return bespeaks;
	}

	public void setBespeaks(List<Bespeak> bespeaks) {
		this.bespeaks = bespeaks;
	}

	public List<Collect> getCollects() {
		return collects;
	}

	public void setCollects(List<Collect> collects) {
		this.collects = collects;
	}

	public List<History> getHistorys() {
		return historys;
	}

	public void setHistorys(List<History> historys) {
		this.historys = historys;
	}

	public List<BookStudent> getBookStudents() {
		return bookStudents;
	}

	public void setBookStudents(List<BookStudent> bookStudents) {
		this.bookStudents = bookStudents;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordNew() {
		return passwordNew;
	}

	public void setPasswordNew(String passwordNew) {
		this.passwordNew = passwordNew;
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