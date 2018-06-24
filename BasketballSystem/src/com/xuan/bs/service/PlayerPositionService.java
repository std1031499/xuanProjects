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
	 * ��ȡԼ���ĵص���Ϣlist
	 * @return
	 */
	public List<MatchPosition> getAll(){
//		System.out.println("����service");
//		System.out.println(playerPositionDao.getAll());
		return playerPositionDao.getAll();
	}
		
	/**
	 * 
	 * ��ȡ��γ�� 
	 * @param matchPositionId
	 * @return
	 */
	public List<MatchPosition> getAllById(Integer matchPositionId){
		
		return playerPositionDao.getAllById(matchPositionId);
	}
}
