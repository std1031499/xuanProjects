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
	 * 查询举办员信息
	 * @param userId
	 * @return
	 */
	public List<Asscessor> getAllByUserId(Integer userId){
		
		String hql = "from Asscessor a where a.users.userId = ?";
		return asscessorDao.getAllByUserId(userId);
	}
	
	/**
	 * 获取举办员基本信息
	 * @param userId
	 * @return
	 */
	public Asscessor get(Integer userId){
		
		return asscessorDao.get(userId);
	}
	
	/**
	 * 保存更新
	 * @param asscessor
	 */
	public void saveOrUpdate(Asscessor asscessor){
		
		asscessorDao.saveOrUpdate(asscessor);
	}
}
