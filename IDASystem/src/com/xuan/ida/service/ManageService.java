package com.xuan.ida.service;

import java.util.List;

import com.xuan.ida.dao.ManageDao;
import com.xuan.ida.entities.Manage;

public class ManageService {
	
	private ManageDao manageDao;
	
	public void setManageDao(ManageDao manageDao) {
		this.manageDao = manageDao;
	}
	
	//判断用户信息是否正确
	public List<Manage> loginCheck(String manageUsername,String managePassword){
		
		return manageDao.loginCheck(manageUsername, managePassword);
	}
	
	//保存修改
	public void saveOrUpdate(Manage manage){
		
		manageDao.saveOrUpdate(manage);
	}
		
	//
	
}
