package com.xuan.cs.dao;

import java.util.List;

import com.xuan.cs.entities.ListFirst;

public class ListFirstDao extends BaseDao {
	
	//显示ListFirst
	public List<ListFirst> getAll(){
//		String hql = "from ListFirst f where f.ListFirstId = ?";
		String hql = "from ListFirst ";
		//System.out.println("hql");
		return getSession().createQuery(hql).list();
//		return getSession().createQuery(hql).setInteger(0, ListFirstId).list();
	}
	
	//三级联动显示ListSecond信息
	public List<ListFirst> getSecondList(String listFirstId){
		
		String hql  ="from ListSecond s where s.listSecondId like '"+listFirstId+"%' ";
		
		return getSession().createQuery(hql).list();
	}
	
	public List<ListFirst> getListFirst(String listFirstId){
		
		String hql = "from ListFirst f  where f.listFirstId = ? ";
		return getSession().createQuery(hql).setString(0, listFirstId).list();											
	}
}
