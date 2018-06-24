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
	 * 获取球员约赛状态
	 * @param userId
	 * @return
	 */
	public List<MatchInfo> getStateById(Integer userId,String matchInfoState){
		
		return matchInfoDao.getStateById(userId,matchInfoState);
	}
	
	/**
	 * 获取球员  根据球员的约赛状态
	 * @param matchInfoState
	 * @return
	 */
	public List<MatchInfo> getPlayerByState(String matchInfoState,Integer matchPositionId,String matchInfoTeamType,String matchInfoMatchType){
		
		
		return matchInfoDao.getPlayerByState(matchInfoState, matchPositionId, matchInfoTeamType, matchInfoMatchType);
	}
		
	/**
	 * 保存更新
	 * @param matchInfo
	 */
	public void saveOrUpdate(MatchInfo matchInfo){
		
		matchInfoDao.saveOrUpdate(matchInfo);
	}
	
	/**
	 * 获取约赛信息
	 * @param matchInfoId
	 * @return
	 */
	public MatchInfo get(Integer matchInfoId){
		
		return matchInfoDao.get(matchInfoId);
	}
	
	/**
	 * 获取约赛信息  根据 约赛状态 和 用户ID
	 * @param matchInfoState
	 * @param userId
	 * @return
	 */
	public List<MatchInfo> getAllByStateAndId(String matchInfoState,Integer userId){
		
		return matchInfoDao.getAllByStateAndId(matchInfoState, userId);
	}
	
}
