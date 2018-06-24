package com.xuan.bs.dao;

import java.util.List;

import com.xuan.bs.entities.PlayerBasic;

public class PlayerDao extends BaseDao{
	
	
	/**
	 * �������
	 * @param playerBasic
	 */
	public void saveOrUpdate(PlayerBasic playerBasic){
		
		getSession().saveOrUpdate(playerBasic);
	}
	
	/**
	 * ��ѯ��Ա������Ϣ
	 * @param userId 
	 * @return
	 */
	public List<PlayerBasic> getAllByUserId(Integer userId){
//		System.out.println("����dao");
		String hql = "from PlayerBasic b where b.users.userId = ?";
		return getSession().createQuery(hql).setInteger(0, userId).list();
				
	}
	
	/**
	 * ��ȡ��Ա������Ϣ
	 * @param userId
	 * @return
	 */
	public PlayerBasic get(Integer userId){
		return (PlayerBasic) getSession().get(PlayerBasic.class, userId);
	}
}
