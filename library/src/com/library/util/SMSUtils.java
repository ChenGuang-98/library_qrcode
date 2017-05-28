package com.library.util;

//�ӿ����ͣ��������ߴ������Žӿڣ�֧�ַ�����֤����š�����֪ͨ���ŵȡ�
// �˻�ע�᣺��ͨ���õ�ַ��ͨ�˻�http://sms.ihuyi.com/register.html
// ע�����
//��1�������ڼ䣬����Ĭ�ϵ�ģ����в��ԣ�Ĭ��ģ������ӿ��ĵ���
//��2����ʹ�� �û���(���磺cf_demo123)�� APIkey�����ýӿڣ�APIkey�ڻ�Ա���Ŀ��Ի�ȡ��
//��3���ô���������뻥�����߶��Žӿڲο�ʹ�ã��ͻ��ɸ���ʵ����Ҫ���б�д��

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import org.dom4j.Document;   
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;   
import org.dom4j.Element;   

import com.library.dao.bean.BookStudent;
import com.library.dao.impl.BookStudentDaoImpl;


public class SMSUtils {
	
	private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
	
	public static void demo01(String phone, String content) {
	       HttpClient client = new HttpClient(); 
		PostMethod method = new PostMethod(Url);

		client.getParams().setContentCharset("UTF-8");
		method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=UTF-8");

//		int mobile_code = (int)((Math.random()*9+1)*100000);

//	    String content = new String("������֤���ǣ�" + mobile_code + "���벻Ҫ����֤��й¶�������ˡ�");

		NameValuePair[] data = {//�ύ����
			    new NameValuePair("account", "C36734019"), 
			    new NameValuePair("password", "61970f6fb88861b2be9e6ef8258766fb"), //�鿴�������¼�û�����->��֤�롢֪ͨ����->�ʻ���ǩ������->APIKEY
			    //new NameValuePair("password", util.StringUtil.MD5Encode("����")),
			    new NameValuePair("mobile", phone), 
			    new NameValuePair("content", content),
		};
		method.setRequestBody(data);

		try {
			client.executeMethod(method);
			
			String SubmitResult =method.getResponseBodyAsString();

			//System.out.println(SubmitResult);

			Document doc = DocumentHelper.parseText(SubmitResult);
			Element root = doc.getRootElement();

			String code = root.elementText("code");
			String msg = root.elementText("msg");
			String smsid = root.elementText("smsid");

			System.out.println(code);
			System.out.println(msg);
			System.out.println(smsid);

			 if("2".equals(code)){
				System.out.println("�����ύ�ɹ�");
			}

		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       }
 
	public static void demo02(String phone, String content) {
		 
		        String testUsername = "cheng01"; //�ڶ��ű�ע����û���
		        String testPassword = "Cheng0918"; //�ڶ��ű�ע�������
		        String testPhone = phone;
		        
		        int mobile_code = (int)((Math.random()*9+1)*100000);
		        
//		        String testContent = "��ͼ��ݡ�������֤����" + mobile_code + "�����Ǳ��˲�������Դ���Ϣ��"; // ע�����ʱ��Ҳ����Ϲ�˾��ƻ���վǩ���������������ݶ��š�ǧ��Ҫ��������������ݣ����� ��һ�¡����á�������ܻ��ղ���
		        
		        String httpUrl = "http://api.smsbao.com/sms";
		 
		        StringBuffer httpArg = new StringBuffer();
		        httpArg.append("u=").append(testUsername).append("&");
		        httpArg.append("p=").append(md5(testPassword)).append("&");
		        httpArg.append("m=").append(testPhone).append("&");
		        httpArg.append("c=").append(encodeUrlString(content, "UTF-8"));
		 
		        String result = request(httpUrl, httpArg.toString());
		        System.out.println(result);
		    }
		 
	public static String request(String httpUrl, String httpArg) {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		httpUrl = httpUrl + "?" + httpArg;

		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url
			              .openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is,
			              "UTF-8"));
			String strRead = reader.readLine();
			if (strRead != null) {
				sbf.append(strRead);
				while ((strRead = reader.readLine()) != null) {
					sbf.append("\n");
					sbf.append(strRead);
				}
			}
			reader.close();
			result = sbf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String md5(String plainText) {
		StringBuffer buf = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return buf.toString();
	}

	public static String encodeUrlString(String str, String charset) {
		String strret = null;
		if (str == null)
			return str;
		try {
			strret = java.net.URLEncoder.encode(str, charset);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return strret;
	}
	
	// ��������
	private static int SMSRemind() {
		List<BookStudent> list = new BookStudentDaoImpl()
		              .listByReturnRemind();
		for (int i = 0; i < list.size(); i++) {
			new BookStudentDaoImpl().init(list.get(i));
			String sname = list.get(i).getSname();
			String phone = list.get(i).getPhone();
			String bname = list.get(i).getBname();
			String cdate = DateUtils
			              .formatDate(list.get(i).getCdate());
			String rdate = DateUtils
			              .formatDate(list.get(i).getRdate());

			String content = "��ͼ��ݡ�" + sname + "��ã�����" + cdate
			              + "���ĵ�ͼ�顶" + bname + "���������ڣ�����" + rdate
			              + "֮ǰ�黹��";
			SMSUtils.demo02(phone, content);

			BookStudent bookStudent = list.get(i);
			bookStudent.setSms(1);
			new BookStudentDaoImpl().update(bookStudent);
			return 1;
		}

		return list.size();
	}
}
