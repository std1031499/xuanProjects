package com.xuan.ida.dao;

import java.util.List;

import com.xuan.ida.entities.Manage;

public class ManageDao extends BaseDao {
	
	
	//�ж��û���Ϣ�Ƿ���ȷ
	public List<Manage> loginCheck(String manageUsername,String managePassword){
		
		String hql = "from Manage m where m.manageUsername = ? and m.managePassword = ?";
		return getSession().createQuery(hql).setString(0, manageUsername).setString(1, managePassword).list();
	}
	
	//�����޸�
	public void saveOrUpdate(Manage manage){
		
		getSession().saveOrUpdate(manage);
	}
}
