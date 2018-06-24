package com.xuan.bs.service;

import java.util.List;

import com.xuan.bs.dao.OrganizerDao;
import com.xuan.bs.entities.Organizer;

public class OrganizerService {
	
	private OrganizerDao organizerDao;
	
	public void setOrganizerDao(OrganizerDao organizerDao) {
		this.organizerDao = organizerDao;
	}
	
	/**
	 * 查询举办员信息
	 * @param userId
	 * @return
	 */
	public List<Organizer> getAllByUserId(Integer userId){
				
		return organizerDao.getAllByUserId(userId);
	}
	
	/**
	 * 获取举办员基本信息
	 * @param userId
	 * @return
	 */
	public Organizer get(Integer organizerId){
		
		return organizerDao.get(organizerId);
	}
	
	/**
	 * 保存更新
	 * @param asscessor
	 */
	public void saveOrUpdate(Organizer organizer){
		
		organizerDao.saveOrUpdate(organizer);
	}
}
