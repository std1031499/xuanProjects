package com.xuan.bs.service;

import java.util.List;

import com.xuan.bs.dao.PlayerDao;
import com.xuan.bs.entities.PlayerBasic;


public class PlayerService {
	
	private PlayerDao playerDao;
	
	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
	
	
	/**
	 * �������
	 * @param playerBasic
	 */
	public void saveOrUpdate(PlayerBasic playerBasic){
		
		playerDao.saveOrUpdate(playerBasic);
	}
	
	
	/**
	 * ��ѯ��Ա������Ϣ
	 * @param userId
	 * @return
	 */
	public List<PlayerBasic> getAllByUserId(Integer userId){
//		System.out.println(playerDao.getAllByUserId(userId)+"����service");
		return playerDao.getAllByUserId(userId);
	}
	
	/**
	 * ��ȡ��Ա������Ϣ
	 * @param userId
	 * @return
	 */
	public PlayerBasic get(Integer userId){
		return playerDao.get(userId);
	}
}
