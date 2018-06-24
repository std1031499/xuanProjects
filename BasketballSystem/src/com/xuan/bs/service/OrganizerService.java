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
	 * ��ѯ�ٰ�Ա��Ϣ
	 * @param userId
	 * @return
	 */
	public List<Organizer> getAllByUserId(Integer userId){
				
		return organizerDao.getAllByUserId(userId);
	}
	
	/**
	 * ��ȡ�ٰ�Ա������Ϣ
	 * @param userId
	 * @return
	 */
	public Organizer get(Integer organizerId){
		
		return organizerDao.get(organizerId);
	}
	
	/**
	 * �������
	 * @param asscessor
	 */
	public void saveOrUpdate(Organizer organizer){
		
		organizerDao.saveOrUpdate(organizer);
	}
}
