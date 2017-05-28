package com.library.util;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.library.dao.bean.Bespeak;
import com.library.dao.bean.BookStudent;
import com.library.dao.bean.Remind;
import com.library.dao.impl.BespeakDaoImpl;
import com.library.dao.impl.BookDaoImpl;
import com.library.dao.impl.BookStudentDaoImpl;
import com.library.dao.impl.RemindDaoImpl;

/**
 * JavaMail Session ���ӵ�¼ MimeMessage �ʼ� MimeBodyPart ���� MimeMultiPart Traspoart
 * �����ʼ� send(MimeMessage m);
 * 
 * @author APPle
 */
public class EmailUtils {

	public static void sendEmail(String addressee, String content) {
		// 1�������ʼ�������
		Properties props = new Properties();
		// 1.1 ���ӵķ��ʼ��ķ�������ַ �����ʼ���������ַ
		props.setProperty("mail.host", "smtp.163.com");
		// 1.2 ָ��������֤��¼
		props.setProperty("mail.smtp.auth", "true");

		// 2) ����һ��Session����,���Ӻ͵�¼������
		/**
		 * ����һ�� �������ӵ����á� �������� ���ض��û���������base64���ܵĶ���
		 */
		Session session = Session.getDefaultInstance(props,
		              new Authenticator() {
			              @Override
			              protected PasswordAuthentication getPasswordAuthentication() {
				              return new PasswordAuthentication(
				                            "javaweb_cheng@163.com", "CG0918");
			              }
		              });
		// �򿪵���
		// session.setDebug(true);

		// 2���ڱ��������ϣ� ����һ���ʼ�
		MimeMessage mail = new MimeMessage(session);

		try {
	              // 3�������ʼ�����
	              // 3.1 ���÷�����
	              mail.setFrom(new InternetAddress("javaweb_cheng@163.com"));

	              // 3.2 �����ռ���
	              mail.setRecipient(RecipientType.TO,
	                            new InternetAddress(addressee));

	              // 3.3 ��������
	              mail.setSubject("ͼ���");

	              // 3.4 ��������
	              /**
	               * �������� �ʼ������ݸ�ʽ���� ��ͨ�ı���html��ʽ
	               */
	              mail.setContent(content, "text/html;charset=utf-8");

	              // 4)�����ʼ�
	              Transport.send(mail);
              } catch (Exception e) {
	              e.printStackTrace();
              }
	}
	
	// �ʼ�����
	public static int returnBookEmailRemind() {
		List<BookStudent> list = new BookStudentDaoImpl()
		              .listByReturnRemind();
		
		if(list == null)
			return 0;
		for (int i = 0; i < list.size(); i++) {
			new BookStudentDaoImpl().init(list.get(i));
			String sname = list.get(i).getSname();
			String email = list.get(i).getEamil();
			String bname = list.get(i).getBname();
			String cdate = DateUtils
			              .formatDate(list.get(i).getCdate());
			String rdate = DateUtils
			              .formatDate(list.get(i).getRdate());
			String bid = list.get(i).getBook().getId() + "";

			String content = sname
			              + "��ã�<br/>����"
			              + cdate
			              + "���ĵ�ͼ��<a href='http://www.cxycheng.com/library/book_s_bookInfo?bid="
			              + bid + "'>��" + bname + "��</a>��������<br/>����"
			              + rdate + "֮ǰ�黹��";
			EmailUtils.sendEmail(email, content);

			BookStudent bookStudent = list.get(i);
			bookStudent.setSms(1);
			new BookStudentDaoImpl().update(bookStudent);
		}
		return list.size();
	}

	public static int getBookEmailRemind(int bid) {
		List<Remind> list = new RemindDaoImpl().listByBook(new BookDaoImpl().get(bid));
		for (int i = 0; i < list.size(); i++) {
			Remind bean = list.get(i);
			String sname = bean.getStudent().getSname();
			String bname = bean.getBook().getBname();
			String bid1 = bean.getBook().getId()+"";
			String email = bean.getStudent().getEmail();
			
			String content = sname
			              + "��ã�<br/>"
			              +"�ղ����˹黹��<a href='http://www.cxycheng.com/library/book_s_bookInfo?bid="
			              + bid1 + "'>��" + bname + "��</a><br/>�������İɣ�";
			
			EmailUtils.sendEmail(email, content);
			
			new RemindDaoImpl().deleteTrue(bean);
              }
		return list.size();
	}
	
	public static long bespeakRemind(int bid) {
		Bespeak bespeak = new BespeakDaoImpl().get(bid);
		
		String bid1 = bespeak.getBook().getId()+"";
		String bname = bespeak.getBook().getBname();
		String email = bespeak.getStudent().getEmail();
		String gdate = DateUtils.formatDateTime(bespeak.getGdate());
		
		String content = bespeak.getStudent().getSname() + "���<br/>��ԤԼ��<a href='http://www.cxycheng.com/library/book_s_bookInfo?bid="
			              + bid1 + "'>��" + bname + "��</a><br/>���齫��Ϊ��������" + gdate + "�������ڣ����뾡��ȡ�顣";
		
		EmailUtils.sendEmail(email, content);
		
		return bespeak.getGdate().getTime() - System.currentTimeMillis();
	}
}

class Authentication extends Authenticator {
	String username = null;
	String password = null;

	public Authentication() {
	}

	public Authentication(String username, String password) {
		this.username = username;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		PasswordAuthentication pa = new PasswordAuthentication(username,
		              password);
		return pa;
	}
}