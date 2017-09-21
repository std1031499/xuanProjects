package com.xuan.cs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xuan.cs.entities.Basic;


public class BasicDao extends BaseDao{
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	//�������*********************************************************************
	public void saveOrUpdate(Basic basic){
		getSession().saveOrUpdate(basic);
	}
	
	//��ȡ������Ϣ
	public Basic get(Integer basic_Id){
		return (Basic) getSession().get(Basic.class, basic_Id);
	}
	
	public List<Basic> input(Integer user_Id){
		String hql = "from Basic b  where b.user_IdB = ? ";		
		return getSession().createQuery(hql).setInteger(0, user_Id).list();
	}
	
	//��������Ϣ��ʾ hql
	public List<Basic> getAll(Integer user_Id){
		String hql = "from Basic b left outer join fetch b.management left outer join fetch b.area  where b.user_IdB = ?";
		//System.out.println(hql+"z7");
		return getSession().createQuery(hql).setInteger(0, user_Id).list();
	}
}
