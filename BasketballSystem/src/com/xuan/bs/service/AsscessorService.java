package com.xuan.bs.service;

import java.util.List;

import com.xuan.bs.dao.AsscessorDao;
import com.xuan.bs.entities.Asscessor;

public class AsscessorService {
	
	private AsscessorDao asscessorDao;
	
	public void setAsscessorDao(AsscessorDao asscessorDao) {
		this.asscessorDao = asscessorDao;
	}
	
	/**
	 * ��ѯ�ٰ�Ա��Ϣ
	 * @param userId
	 * @return
	 */
	public List<Asscessor> getAllByUserId(Integer userId){
		
		String hql = "from Asscessor a where a.users.userId = ?";
		return asscessorDao.getAllByUserId(userId);
	}
	
	/**
	 * ��ȡ�ٰ�Ա������Ϣ
	 * @param userId
	 * @return
	 */
	public Asscessor get(Integer userId){
		
		return asscessorDao.get(userId);
	}
	
	/**
	 * �������
	 * @param asscessor
	 */
	public void saveOrUpdate(Asscessor asscessor){
		
		asscessorDao.saveOrUpdate(asscessor);
	}
}
