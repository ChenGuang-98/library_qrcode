package com.library.util.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class HibernateUtils {
	private static SessionFactory sf;
	
	static {
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	
	@Test
	public void createTable() {
		// �������ù��������󣬼����������ļ����������ļ��ټ���ӳ���ļ���
		Configuration cfg = new Configuration().configure();
		// �Զ���������
//		SchemaExport export = new SchemaExport(cfg);
//		/**
//		 * ������ ��һ���Ƿ��ӡ������䵽����̨ �ζ����Ƿ�ִ�нű���������
//		 */
//		export.create(true, true);
	}


	/**
	 * �ṩsession
	 */
	public static Session getSession() {
		return sf.openSession();
	}

	public static void main(String[] args) {
		System.out.println(HibernateUtils.getSession());
	}
}
