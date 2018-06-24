package com.xuan.bs.service;

import java.util.List;

import com.xuan.bs.dao.PlayerPositionDao;
import com.xuan.bs.entities.MatchPosition;

public class PlayerPositionService {
		
	private PlayerPositionDao playerPositionDao;
	
	public void setPlayerPositionDao(PlayerPositionDao playerPositionDao) {
		this.playerPositionDao = playerPositionDao;
	}
	
	/**
	 * 获取约赛的地点信息list
	 * @return
	 */
	public List<MatchPosition> getAll(){
//		System.out.println("进入service");
//		System.out.println(playerPositionDao.getAll());
		return playerPositionDao.getAll();
	}
		
	/**
	 * 
	 * 获取经纬度 
	 * @param matchPositionId
	 * @return
	 */
	public List<MatchPosition> getAllById(Integer matchPositionId){
		
		return playerPositionDao.getAllById(matchPositionId);
	}
}
