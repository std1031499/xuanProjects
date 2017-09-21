package com.xuan.cs.dao;

import java.util.List;

import com.xuan.cs.entities.ListSecond;

public class ListSecondDao extends BaseDao{
	
	//����������ʾListThird����Ϣ
	public List<ListSecond> getThirdList(String listSecondId){
		
		String hql = "from ListThird t where t.listThirdId like '"+listSecondId+"%'" ;
		return getSession().createQuery(hql).list();
	}
	
	public List<ListSecond> getListSecond(String listSecondId){
		
		String hql = "from ListSecond s  where s.listSecondId = ?";
		return getSession().createQuery(hql).setString(0, listSecondId).list();
	}
	
	//��ʾlistSecond��Ϣ
	public List<ListSecond> getAll(){
		
		String hql ="from ListSecond";
		return getSession().createQuery(hql).list();
	}
}
