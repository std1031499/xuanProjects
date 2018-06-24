package com.xuan.bs.service;

import java.util.List;

import com.xuan.bs.dao.MainDao;
import com.xuan.bs.entities.RoleMenu;
import com.xuan.bs.entities.UserRole;
import com.xuan.bs.entities.Users;

public class MainService {
	
	private MainDao mainDao;
	
	public void setMainDao(MainDao mainDao) {
		this.mainDao = mainDao;
	}
	
	
	//判断用户信息是否正确
	public List<Users> loginCheck(String userName,String userPwd){
		
		return mainDao.loginCheck(userName, userPwd);
	}
	
	//获取用户--根据id
	public List<Users> getUsersById(Integer userId){
		
		return mainDao.getUsersById(userId);
	}
	
	//获取用户角色 --根据用户id
	public List<UserRole> getRoleById(Integer userId){
		
		return mainDao.getRoleById(userId);
	}
	
	/**
	 * 获取角色权限菜单
	 * @param roleId	角色ID
	 * @param permiss	菜单栏状态
	 * @return
	 */
	public List<RoleMenu> getMenuById(Integer roleId,Integer permiss){
		
		return mainDao.getMenuById(roleId, permiss);
	}
}
