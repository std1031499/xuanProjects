package com.xuan.ida.dao;

import java.util.List;

import com.xuan.ida.entities.Manage;

public class ManageDao extends BaseDao {
	
	
	//判断用户信息是否正确
	public List<Manage> loginCheck(String manageUsername,String managePassword){
		
		String hql = "from Manage m where m.manageUsername = ? and m.managePassword = ?";
		return getSession().createQuery(hql).setString(0, manageUsername).setString(1, managePassword).list();
	}
	
	//保存修改
	public void saveOrUpdate(Manage manage){
		
		getSession().saveOrUpdate(manage);
	}
}
