package com.xuan.ida.service;

import java.util.List;

import com.xuan.ida.dao.ManageDao;
import com.xuan.ida.entities.Manage;

public class ManageService {
	
	private ManageDao manageDao;
	
	public void setManageDao(ManageDao manageDao) {
		this.manageDao = manageDao;
	}
	
	//�ж��û���Ϣ�Ƿ���ȷ
	public List<Manage> loginCheck(String manageUsername,String managePassword){
		
		return manageDao.loginCheck(manageUsername, managePassword);
	}
	
	//�����޸�
	public void saveOrUpdate(Manage manage){
		
		manageDao.saveOrUpdate(manage);
	}
		
	//
	
}
