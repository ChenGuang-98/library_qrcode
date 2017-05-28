package com.library.util.base;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.library.dao.bean.Book;
import com.library.dao.bean.BookStudent;
import com.library.dao.bean.Collect;
import com.library.dao.impl.BookDaoImpl;
import com.library.dao.impl.BookTypeDaoImpl;
import com.library.dao.impl.CollectDaoImpl;
import com.library.util.DateUtils;
import com.library.util.hibernate.HibernateUtils;

public class BaseDaoImpl<T> implements BaseDao<T> {
	// �洢���͵�ʵ�ʲ���
	private Class<T> clazz;

	public BaseDaoImpl() {
		// ˭ʵ�ָ��࣬�����˭�����ֽ���
		Class c = this.getClass();
		// ���ر�ʾ�� Class ����ʾ��ʵ�壨�ࡢ�ӿڡ��������ͻ� void����ֱ�ӳ���� Type
		Type type = c.getGenericSuperclass();
		// ������ǿתΪ����������
		ParameterizedType pType = (ParameterizedType) type;
		// ��ȡ����ĸ��������ʵ�����Ͳ�����Ҳ���Ƿ��͵�ʵ�ʲ���
		// ����Ҳ���ǻ�ȡBaseDaoImpl��ʵ�����Ͳ���
		Type[] actualTypeArguments = pType.getActualTypeArguments();
		// ��ʵ�����Ͳ�����ֵ����Ա����
		clazz = (Class<T>) (actualTypeArguments[0]);
	}

	/**
	 * 	����
	 */
	public void save(T bean) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();			// ��ȡ�Ự
			tx = session.beginTransaction();					// ��������

			// ��ʼ������/����ʱ�� & ɾ�����
			Method method1 = bean.getClass().getMethod("setCdate", Date.class);
			method1.invoke(bean, new Date());
			Method method2 = bean.getClass().getMethod("setYn", int.class);
			method2.invoke(bean, 1);

			if("Bespeak".equals(this.clazz.getSimpleName()) || "BookStudent".equals(this.clazz.getSimpleName())) {
				Method method = bean.getClass().getMethod("getId", null);
				int value = (Integer) method.invoke(bean, null);
				if(value == 0) {
					Method method3 = bean.getClass().getMethod("setId", int.class);
					method3.invoke(bean, DateUtils.getId());
				}
			}
			
			// ����
	              session.save(bean);
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
		}
	}

	/**
	 * 	ɾ�����߼�ɾ����
	 */
	public synchronized void delete(int id) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();

			// ���Ϊɾ��״̬ &�������޸�ʱ��
			Object bean = session.get(this.clazz, id);
			if(bean == null)
				return;
			Method method = bean.getClass().getMethod("setYn", int.class);
			method.invoke(bean, 0);
			Method method2 = bean.getClass().getMethod("setUdate", Date.class);
			method2.invoke(bean, new Date());

			// �߼�ɾ��
			session.update(bean);

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
		}
	}
	
	/**
	 * 	ɾ��������ɾ����
	 */
	public synchronized void deleteTrue(int id) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();

			Object bean = session.get(this.clazz, id);
			if(bean == null)
				return;
			session.delete(bean);

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
		}
	}
	
	/**
	 * 	ɾ�����߼�ɾ����
	 */
	public synchronized void delete(T bean) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			
			// ���Ϊɾ��״̬ &�������޸�ʱ��
			Method method = bean.getClass().getMethod("setYn", int.class);
			method.invoke(bean, 0);
			Method method2 = bean.getClass().getMethod("setUdate", Date.class);
			method2.invoke(bean, new Date());

			// �߼�ɾ��
			session.update(bean);

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
		}
	}
	
	/**
	 * 	ɾ��������ɾ����
	 */
	public synchronized void deleteTrue(T bean) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			
			if(bean == null)
				return;
			session.delete(bean);

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
		}
	}

	/**
	 * 	����
	 */
	public synchronized void update(T bean) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();

			// �����޸�ʱ��
			Method method = bean.getClass().getMethod("setUdate", Date.class);
			method.invoke(bean, new Date());

			// ����
			session.update(bean);

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
		}
	}

	/**
	 * 	��ѯ
	 */
	public T get(int id) {
		Session session = null;
		T t = null;
		try {
			session = HibernateUtils.getSession();

			// ��ѯ
			t = (T) session.get(this.clazz, id);
			
			if(t == null)
				return null;
			
			// �鿴���״̬�Ƿ�Ϊɾ��
			Method method = t.getClass().getMethod("getYn", null);
			int value = (Integer) method.invoke(t, null);
			
//			 ����ɾ��״̬�� " �鲻�� "
			if (value == 0)
				t = null;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return t;
	}

	/**
	 * 	��ѯȫ��
	 */
	public List<T> list() {
		Session session = null;
		
		List<T> list = null;
		try {
			session = HibernateUtils.getSession();

			// ��ѯȫ�� & ���˵�ɾ��״̬������
			list = session.createCriteria(this.clazz).add(Restrictions.eq("yn", 1)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	/**
	 * 	��ҳ��ѯ
	 */
	public List<T> list(int index, int count) {
		Session session = null;
		
		List<T> list = null;
		try {
			session = HibernateUtils.getSession();
			
			// ��ѯȫ�� & ���˵�ɾ��״̬������
			Criteria c = session.createCriteria(this.clazz).add(Restrictions.eq("yn", 1));
			
			// ȡĳ��������
			c.setFirstResult(index);
			c.setMaxResults(count);
			list = c.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	/**
	 * 	��ѯ����
	 */
	public int getCount() {
		Session session = null;
		
		int count = 0;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(this.clazz).add(Restrictions.eq("yn", 1));
			
			if(cr.list() != null && cr.list().size() >= 1)
				count = cr.list().size();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}
	
}
