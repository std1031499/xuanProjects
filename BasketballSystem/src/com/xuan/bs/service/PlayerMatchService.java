package com.xuan.bs.service;

import java.util.List;

import com.xuan.bs.dao.PlayerMatchDao;
import com.xuan.bs.entities.PlayerMatch;

public class PlayerMatchService {
	
	private PlayerMatchDao playerMatchDao;
	public void setPlayerMatchDao(PlayerMatchDao playerMatchDao) {
		this.playerMatchDao = playerMatchDao;
	}
	
	/**
	 * 保存更新
	 * @param playerMatch
	 */
	public void saveOrUpdate(PlayerMatch playerMatch){
		
		playerMatchDao.saveOrUpdate(playerMatch);
	}
	
	/**
	 * 获取报名信息 --用户ID 赛事ID
	 * @param userId
	 * @param orgMatchId
	 * @return
	 */
	public List<PlayerMatch> getAllById(Integer userId,Integer orgMatchId){
		
		return playerMatchDao.getAllById(userId, orgMatchId);
	}
	
	/**
	 * 获取报名信息
	 * @param userId
	 * @return
	 */
	public List<PlayerMatch> getSignUpInfo(Integer userId){
		
		return playerMatchDao.getSignUpInfo(userId);
	}
	
	/**
	 * 获取报名信息 -- 根据赛事ID
	 * @param orgMatchId
	 * @return
	 */
	public List<PlayerMatch> getAllByOrgMatchId(Integer orgMatchId){
		
		return playerMatchDao.getAllByOrgMatchId(orgMatchId);
	}
	
	/**
	 * 获取报名信息 -- 根据状态
	 * @param playMatchState
	 * @return
	 */
	public List<PlayerMatch> getAllByState(String playMatchState){
		
		return playerMatchDao.getAllByState(playMatchState);
	}
	
	/**
	 *  获取报名信息 -- 根据状态 and 赛事ID
	 * @param playMatchState
	 * @param orgMatchId
	 * @return
	 */
	public List<PlayerMatch> getAllByStateAndOrgMatchId(String playMatchState,Integer orgMatchId){
		
		return playerMatchDao.getAllByStateAndOrgMatchId(playMatchState, orgMatchId);
	}
	
	
	
}
