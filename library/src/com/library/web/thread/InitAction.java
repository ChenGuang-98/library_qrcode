package com.library.web.thread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitAction implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("����");
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("������ʼ����");
		new Thread(new ReturnBookRemindThread()).start();
	}
}