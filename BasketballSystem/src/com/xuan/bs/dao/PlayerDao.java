package com.xuan.bs.dao;

import java.util.List;

import com.xuan.bs.entities.PlayerBasic;

public class PlayerDao extends BaseDao{
	
	
	/**
	 * 保存更新
	 * @param playerBasic
	 */
	public void saveOrUpdate(PlayerBasic playerBasic){
		
		getSession().saveOrUpdate(playerBasic);
	}
	
	/**
	 * 查询球员基础信息
	 * @param userId 
	 * @return
	 */
	public List<PlayerBasic> getAllByUserId(Integer userId){
//		System.out.println("进入dao");
		String hql = "from PlayerBasic b where b.users.userId = ?";
		return getSession().createQuery(hql).setInteger(0, userId).list();
				
	}
	
	/**
	 * 获取球员基础信息
	 * @param userId
	 * @return
	 */
	public PlayerBasic get(Integer userId){
		return (PlayerBasic) getSession().get(PlayerBasic.class, userId);
	}
}
