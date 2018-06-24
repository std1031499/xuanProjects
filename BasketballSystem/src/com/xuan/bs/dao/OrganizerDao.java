package com.xuan.bs.dao;

import java.util.List;

import com.xuan.bs.entities.Organizer;

public class OrganizerDao extends BaseDao{
	
	/**
	 * 查询举办员信息
	 * @param userId
	 * @return
	 */
	public List<Organizer> getAllByUserId(Integer userId){
		
		String hql = "from Organizer a where a.users.userId = ?";
		return getSession().createQuery(hql).setInteger(0, userId).list();
	}
	
	/**
	 * 获取举办员基本信息
	 * @param userId
	 * @return
	 */
	public Organizer get(Integer organizerId){
		
		return (Organizer) getSession().get(Organizer.class, organizerId);
	}
	
	/**
	 * 保存更新
	 * @param asscessor
	 */
	public void saveOrUpdate(Organizer organizer){
		
		getSession().saveOrUpdate(organizer);
	}
	
}
