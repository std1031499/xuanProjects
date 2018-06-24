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
	 * �������
	 * @param playerMatch
	 */
	public void saveOrUpdate(PlayerMatch playerMatch){
		
		playerMatchDao.saveOrUpdate(playerMatch);
	}
	
	/**
	 * ��ȡ������Ϣ --�û�ID ����ID
	 * @param userId
	 * @param orgMatchId
	 * @return
	 */
	public List<PlayerMatch> getAllById(Integer userId,Integer orgMatchId){
		
		return playerMatchDao.getAllById(userId, orgMatchId);
	}
	
	/**
	 * ��ȡ������Ϣ
	 * @param userId
	 * @return
	 */
	public List<PlayerMatch> getSignUpInfo(Integer userId){
		
		return playerMatchDao.getSignUpInfo(userId);
	}
	
	/**
	 * ��ȡ������Ϣ -- ��������ID
	 * @param orgMatchId
	 * @return
	 */
	public List<PlayerMatch> getAllByOrgMatchId(Integer orgMatchId){
		
		return playerMatchDao.getAllByOrgMatchId(orgMatchId);
	}
	
	/**
	 * ��ȡ������Ϣ -- ����״̬
	 * @param playMatchState
	 * @return
	 */
	public List<PlayerMatch> getAllByState(String playMatchState){
		
		return playerMatchDao.getAllByState(playMatchState);
	}
	
	/**
	 *  ��ȡ������Ϣ -- ����״̬ and ����ID
	 * @param playMatchState
	 * @param orgMatchId
	 * @return
	 */
	public List<PlayerMatch> getAllByStateAndOrgMatchId(String playMatchState,Integer orgMatchId){
		
		return playerMatchDao.getAllByStateAndOrgMatchId(playMatchState, orgMatchId);
	}
	
	
	
}
