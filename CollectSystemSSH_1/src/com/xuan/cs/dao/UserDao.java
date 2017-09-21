package com.xuan.cs.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.xuan.cs.entities.User;

public class UserDao extends BaseDao{
	
	//��ʾ�û���Ϣ*******************************************************************
	public List<User> getAll(){
		String hql = "from User";
		return getSession().createQuery(hql).list();
	}
	
	//�ж��û���Ϣ�Ƿ���ȷ***************************************************************
	public List<User> loginSave(String c_Username,String c_Password,Integer user_Id){
		
		
		String hql = "from User u where u.c_Username = ? and u.c_Password = ? ";	
		//System.out.println(hql);
		return getSession().createQuery(hql).setString(0, c_Username)
											.setString(1, c_Password)
											.list();
		
		/*Query query = getSession().createQuery(hql);
		query.setString(0,"1");
		List<User> ss = query.list();
		System.out.println(ss);
		return ss;*/
//		List<User> ss = getSession().createQuery(hql).setString();
		//�жϻ�ȡ��list�Ƿ����
		/*if(ss.size()>0)
		{	
			return "success";			
		}
		else 
		{
			return "error";			
		}*/
		
	}
	
	

	
	
	
	//ɾ���û���Ϣ*******************************************************************
	public void delete(Integer id){
		String hql = "delete from User u where u.user_Id = ?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	
	//�������*********************************************************************
	public void saveOrUpdate(User user){
		getSession().saveOrUpdate(user);		
	}
	
	public User get(Integer user_Id){
		return (User) getSession().get(User.class, user_Id);
	}
	
	//ajax�ж��û��Ƿ����
	public User getUserByUsername(String c_Username){
		String hql = "from User u where u.c_Username = ?";
		Query query = getSession().createQuery(hql).setString(0, c_Username);
		return (User) query.uniqueResult();
	}
	
	//��ȡuser��Ϣ--user_Id
	public List<User> getUserByUser_Id(Integer user_Id){
		
		String hql = "from User u where u.user_Id = ?";
		return getSession().createQuery(hql).setInteger(0, user_Id).list();
	}
	
	
}
