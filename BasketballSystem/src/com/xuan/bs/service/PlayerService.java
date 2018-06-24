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
	 * 保存更新
	 * @param playerBasic
	 */
	public void saveOrUpdate(PlayerBasic playerBasic){
		
		playerDao.saveOrUpdate(playerBasic);
	}
	
	
	/**
	 * 查询球员基础信息
	 * @param userId
	 * @return
	 */
	public List<PlayerBasic> getAllByUserId(Integer userId){
//		System.out.println(playerDao.getAllByUserId(userId)+"进入service");
		return playerDao.getAllByUserId(userId);
	}
	
	/**
	 * 获取球员基础信息
	 * @param userId
	 * @return
	 */
	public PlayerBasic get(Integer userId){
		return playerDao.get(userId);
	}
}
