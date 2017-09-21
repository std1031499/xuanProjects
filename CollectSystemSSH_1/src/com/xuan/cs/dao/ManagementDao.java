package com.xuan.cs.dao;

import java.util.List;

import com.xuan.cs.entities.Management;

public class ManagementDao extends BaseDao{
	
	//显示归口管理部门
	public List<Management> getAll(){
		String hql = "from Management";
		return getSession().createQuery(hql).list();
	}
	
	//根据id查询归口管理部门
	public List<Management> getAllById(Integer management_Id){
		String hql = "from Management m where m.management_Id = ? ";
		return getSession().createQuery(hql).setInteger(0, management_Id).list();
	}
}
