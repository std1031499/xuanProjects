package com.xuan.cs.service;

import java.util.List;

import com.xuan.cs.dao.AreaDao;
import com.xuan.cs.entities.Area;

public class AreaService {
	
	private AreaDao areaDao;
	
	public void setAreaDao(AreaDao areaDao) {
		this.areaDao = areaDao;
	}
	
	//��ʾ���ڵ�����Ϣ
	public List<Area> getAll(){
		return areaDao.getAll();
	}
	
	//����id��ѯ������Ϣ
	public List<Area> getAllById(Integer area_Id ){
		
		return areaDao.getAllById(area_Id);
	}
}
