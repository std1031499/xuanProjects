package com.xuan.bs.dao;

import java.util.List;

import com.xuan.bs.entities.Asscessor;

public class AsscessorDao extends BaseDao{
	
	/**
	 * ��ѯ�ٰ�Ա��Ϣ
	 * @param userId
	 * @return
	 */
	public List<Asscessor> getAllByUserId(Integer userId){
		
		String hql = "from Asscessor a where a.users.userId = ?";
		return getSession().createQuery(hql).setInteger(0, userId).list();
	}
	
	/**
	 * ��ȡ�ٰ�Ա������Ϣ
	 * @param userId
	 * @return
	 */
	public Asscessor get(Integer userId){
		
		return (Asscessor) getSession().get(Asscessor.class, userId);
	}
	
	/**
	 * �������
	 * @param asscessor
	 */
	public void saveOrUpdate(Asscessor asscessor){
		
		getSession().saveOrUpdate(asscessor);
	}
	
}
