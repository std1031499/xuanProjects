package com.xuan.cs.service;

import java.util.List;

import com.xuan.cs.dao.UserDao;
import com.xuan.cs.entities.User;

public class UserService {
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	//显示用户信息
	public List<User> getAll(){
		List<User> users = userDao.getAll();
		return users; 
	}
	
	//判断用户信息是否正确
	public List<User> loginSave(String c_Username,String c_Password,Integer user_Id){
		 List<User> users = userDao.loginSave(c_Username,c_Password,user_Id);
		 System.out.println(users+"haha");
		 return users;
		
	}
	
	//删除用户信息
	public void delete(Integer user_Id){
		userDao.delete(user_Id);
	}
	
	//添加保存修改
	public void saveOrUpdate(User user){
		userDao.saveOrUpdate(user);
	}
	
	public User get(Integer user_Id){
		return userDao.get(user_Id);
	}
	
	//ajax 确定用户是否可用
	public boolean userNameIsValid(String c_Username){
		//System.out.println(userDao.getUserByUsername(c_Username)+"hhh");
		return userDao.getUserByUsername(c_Username) == null;
	}
	
	
	//获取user信息--user_Id
	public List<User> getUserByUser_Id(Integer user_Id){
		
		return userDao.getUserByUser_Id(user_Id);
	}
}
