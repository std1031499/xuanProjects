package com.xuan.cs.dao;

import java.util.List;

import com.xuan.cs.entities.Area;

public class AreaDao extends BaseDao{
	
	 //�����ڵ�����ʾ hql
	 public List<Area> getAll(){
		 String hql = "from Area";
		 return getSession().createQuery(hql).list();
	 }
	 
	 //����id��ѯ������Ϣ
	 public List<Area> getAllById(Integer area_Id ){
		 String hql = "from Area a where a.area_Id = ?";
		 return getSession().createQuery(hql).setInteger(0, area_Id).list();
	 }
}
