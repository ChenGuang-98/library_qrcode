package com.library.dao.bean;

import java.util.Date;

/**
 * 	����Ա
 * @author Cheng
 *
 */

public class Admin {

	private int id;
	private String ano;			// ���
	private String aname;		// ����
	private String password;		// ����
	private Date cdate;			// ����ʱ��
	private Date udate;			// �޸�ʱ��
	private int yn;				// ɾ�����

	private int ycount;
	private int jcount;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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