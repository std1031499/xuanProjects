package com.xuan.cs.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.xuan.cs.entities.User;

public class UserDao extends BaseDao{
	
	//显示用户信息*******************************************************************
	public List<User> getAll(){
		String hql = "from User";
		return getSession().createQuery(hql).list();
	}
	
	//判断用户信息是否正确***************************************************************
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
		//判断获取的list是否存在
		/*if(ss.size()>0)
		{	
			return "success";			
		}
		else 
		{
			return "error";			
		}*/
		
	}
	
	

	
	
	
	//删除用户信息*******************************************************************
	public void delete(Integer id){
		String hql = "delete from User u where u.user_Id = ?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	
	//保存更新*********************************************************************
	public void saveOrUpdate(User user){
		getSession().saveOrUpdate(user);		
	}
	
	public User get(Integer user_Id){
		return (User) getSession().get(User.class, user_Id);
	}
	
	//ajax判断用户是否可用
	public User getUserByUsername(String c_Username){
		String hql = "from User u where u.c_Username = ?";
		Query query = getSession().createQuery(hql).setString(0, c_Username);
		return (User) query.uniqueResult();
	}
	
	//获取user信息--user_Id
	public List<User> getUserByUser_Id(Integer user_Id){
		
		String hql = "from User u where u.user_Id = ?";
		return getSession().createQuery(hql).setInteger(0, user_Id).list();
	}
	
	
}
