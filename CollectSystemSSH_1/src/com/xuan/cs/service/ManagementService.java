package com.xuan.cs.service;

import java.util.List;

import com.xuan.cs.dao.ManagementDao;
import com.xuan.cs.entities.Management;

public class ManagementService {
	
	private ManagementDao managementDao ;
	
	public void setManagementDao(ManagementDao managementDao) {
		this.managementDao = managementDao;
	}
	
	//显示归口管理部门信息
	public List<Management> getAll(){
		return managementDao.getAll();
	}
	
	//根据id查询归口管理部门
	public List<Management> getAllById(Integer management_Id){
		
		return managementDao.getAllById(management_Id);
	}
}
