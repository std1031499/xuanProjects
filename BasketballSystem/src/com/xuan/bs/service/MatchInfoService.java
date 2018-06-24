package com.xuan.bs.service;

import java.util.List;

import com.xuan.bs.dao.MatchInfoDao;
import com.xuan.bs.entities.MatchInfo;

public class MatchInfoService {
	
	private MatchInfoDao matchInfoDao;
	
	public void setMatchInfoDao(MatchInfoDao matchInfoDao) {
		this.matchInfoDao = matchInfoDao;
	}
	
	/**
	 * ��ȡ��ԱԼ��״̬
	 * @param userId
	 * @return
	 */
	public List<MatchInfo> getStateById(Integer userId,String matchInfoState){
		
		return matchInfoDao.getStateById(userId,matchInfoState);
	}
	
	/**
	 * ��ȡ��Ա  ������Ա��Լ��״̬
	 * @param matchInfoState
	 * @return
	 */
	public List<MatchInfo> getPlayerByState(String matchInfoState,Integer matchPositionId,String matchInfoTeamType,String matchInfoMatchType){
		
		
		return matchInfoDao.getPlayerByState(matchInfoState, matchPositionId, matchInfoTeamType, matchInfoMatchType);
	}
		
	/**
	 * �������
	 * @param matchInfo
	 */
	public void saveOrUpdate(MatchInfo matchInfo){
		
		matchInfoDao.saveOrUpdate(matchInfo);
	}
	
	/**
	 * ��ȡԼ����Ϣ
	 * @param matchInfoId
	 * @return
	 */
	public MatchInfo get(Integer matchInfoId){
		
		return matchInfoDao.get(matchInfoId);
	}
	
	/**
	 * ��ȡԼ����Ϣ  ���� Լ��״̬ �� �û�ID
	 * @param matchInfoState
	 * @param userId
	 * @return
	 */
	public List<MatchInfo> getAllByStateAndId(String matchInfoState,Integer userId){
		
		return matchInfoDao.getAllByStateAndId(matchInfoState, userId);
	}
	
}
