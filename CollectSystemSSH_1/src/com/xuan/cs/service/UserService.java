package com.xuan.cs.service;

import java.util.List;

import com.xuan.cs.dao.UserDao;
import com.xuan.cs.entities.User;

public class UserService {
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	//��ʾ�û���Ϣ
	public List<User> getAll(){
		List<User> users = userDao.getAll();
		return users; 
	}
	
	//�ж��û���Ϣ�Ƿ���ȷ
	public List<User> loginSave(String c_Username,String c_Password,Integer user_Id){
		 List<User> users = userDao.loginSave(c_Username,c_Password,user_Id);
		 System.out.println(users+"haha");
		 return users;
		
	}
	
	//ɾ���û���Ϣ
	public void delete(Integer user_Id){
		userDao.delete(user_Id);
	}
	
	//��ӱ����޸�
	public void saveOrUpdate(User user){
		userDao.saveOrUpdate(user);
	}
	
	public User get(Integer user_Id){
		return userDao.get(user_Id);
	}
	
	//ajax ȷ���û��Ƿ����
	public boolean userNameIsValid(String c_Username){
		//System.out.println(userDao.getUserByUsername(c_Username)+"hhh");
		return userDao.getUserByUsername(c_Username) == null;
	}
	
	
	//��ȡuser��Ϣ--user_Id
	public List<User> getUserByUser_Id(Integer user_Id){
		
		return userDao.getUserByUser_Id(user_Id);
	}
}
