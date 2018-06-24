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
	
	
	//�ж��û���Ϣ�Ƿ���ȷ
	public List<Users> loginCheck(String userName,String userPwd){
		
		return mainDao.loginCheck(userName, userPwd);
	}
	
	//��ȡ�û�--����id
	public List<Users> getUsersById(Integer userId){
		
		return mainDao.getUsersById(userId);
	}
	
	//��ȡ�û���ɫ --�����û�id
	public List<UserRole> getRoleById(Integer userId){
		
		return mainDao.getRoleById(userId);
	}
	
	/**
	 * ��ȡ��ɫȨ�޲˵�
	 * @param roleId	��ɫID
	 * @param permiss	�˵���״̬
	 * @return
	 */
	public List<RoleMenu> getMenuById(Integer roleId,Integer permiss){
		
		return mainDao.getMenuById(roleId, permiss);
	}
}
