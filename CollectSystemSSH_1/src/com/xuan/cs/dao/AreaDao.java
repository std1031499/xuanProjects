package com.xuan.cs.dao;

import java.util.List;

import com.xuan.cs.entities.Area;

public class AreaDao extends BaseDao{
	
	 //将所在地域显示 hql
	 public List<Area> getAll(){
		 String hql = "from Area";
		 return getSession().createQuery(hql).list();
	 }
	 
	 //根据id查询地域信息
	 public List<Area> getAllById(Integer area_Id ){
		 String hql = "from Area a where a.area_Id = ?";
		 return getSession().createQuery(hql).setInteger(0, area_Id).list();
	 }
}
