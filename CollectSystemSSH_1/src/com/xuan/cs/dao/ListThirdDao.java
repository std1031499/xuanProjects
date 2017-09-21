package com.xuan.cs.dao;

import java.util.List;

import com.xuan.cs.entities.ListThird;



public class ListThirdDao extends BaseDao {
	
	public List<ListThird> getListThird(String ListThirdId){
		
		String hql = "from ListThird t where t.listThirdId = ?";
		return getSession().createQuery(hql).setString(0, ListThirdId).list();
	}
	
	//ªÒ»°listThird
	public List<ListThird> getAll(){
		
		String hql = "from ListThird";
		return getSession().createQuery(hql).list();
	}
}
