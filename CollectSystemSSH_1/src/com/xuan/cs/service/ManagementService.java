package com.xuan.cs.service;

import java.util.List;

import com.xuan.cs.dao.ManagementDao;
import com.xuan.cs.entities.Management;

public class ManagementService {
	
	private ManagementDao managementDao ;
	
	public void setManagementDao(ManagementDao managementDao) {
		this.managementDao = managementDao;
	}
	
	//��ʾ��ڹ�������Ϣ
	public List<Management> getAll(){
		return managementDao.getAll();
	}
	
	//����id��ѯ��ڹ�����
	public List<Management> getAllById(Integer management_Id){
		
		return managementDao.getAllById(management_Id);
	}
}
