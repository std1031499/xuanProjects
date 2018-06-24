package com.xuan.bs.dao;

import java.util.List;

import com.xuan.bs.entities.Organizer;

public class OrganizerDao extends BaseDao{
	
	/**
	 * ��ѯ�ٰ�Ա��Ϣ
	 * @param userId
	 * @return
	 */
	public List<Organizer> getAllByUserId(Integer userId){
		
		String hql = "from Organizer a where a.users.userId = ?";
		return getSession().createQuery(hql).setInteger(0, userId).list();
	}
	
	/**
	 * ��ȡ�ٰ�Ա������Ϣ
	 * @param userId
	 * @return
	 */
	public Organizer get(Integer organizerId){
		
		return (Organizer) getSession().get(Organizer.class, organizerId);
	}
	
	/**
	 * �������
	 * @param asscessor
	 */
	public void saveOrUpdate(Organizer organizer){
		
		getSession().saveOrUpdate(organizer);
	}
	
}
