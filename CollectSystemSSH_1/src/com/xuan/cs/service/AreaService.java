package com.xuan.cs.service;

import java.util.List;

import com.xuan.cs.dao.AreaDao;
import com.xuan.cs.entities.Area;

public class AreaService {
	
	private AreaDao areaDao;
	
	public void setAreaDao(AreaDao areaDao) {
		this.areaDao = areaDao;
	}
	
	//显示所在地域信息
	public List<Area> getAll(){
		return areaDao.getAll();
	}
	
	//根据id查询地域信息
	public List<Area> getAllById(Integer area_Id ){
		
		return areaDao.getAllById(area_Id);
	}
}
