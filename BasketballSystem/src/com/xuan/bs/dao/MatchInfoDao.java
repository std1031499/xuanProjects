package com.xuan.bs.dao;

import java.util.List;

import com.xuan.bs.entities.MatchInfo;

public class MatchInfoDao extends BaseDao{
	
	/**
	 * 获取球员约赛状态
	 * @param userId
	 * @return
	 */
	public List<MatchInfo> getStateById(Integer userId,String matchInfoState){
		
		String hql = "select m.matchInfoState from MatchInfo m where m.users.userId = ? and m.matchInfoState = ?";
		return getSession().createQuery(hql).setInteger(0, userId).setString(1, matchInfoState).list();
	}
	
	/**
	 * 获取球员  根据约赛状态 地点ID 队伍类型 约赛类型
	 * @param matchInfoState
	 * @param matchPositionId
	 * @param matchInfoTeamType
	 * @param matchInfoMatchType
	 * @return
	 */
	 
	public List<MatchInfo> getPlayerByState(String matchInfoState,Integer matchPositionId,String matchInfoTeamType,String matchInfoMatchType){
		
		String hql = "from MatchInfo m where m.matchInfoState = ? " +
				" and m.matchPosition.matchPositionId = ?" +
				" and m.matchInfoTeamType = ? and m.matchInfoMatchType = ? ";
		return getSession().createQuery(hql).setString(0, matchInfoState).setInteger(1, matchPositionId)
				.setString(2, matchInfoTeamType).setString(3, matchInfoMatchType).list();
	}
	
	/**
	 * 保存更新
	 * @param matchInfo
	 */
	public void saveOrUpdate(MatchInfo matchInfo){
		
		getSession().saveOrUpdate(matchInfo);
		
	}
	
	/**
	 * 获取约赛信息
	 * @param matchInfoId
	 * @return
	 */
	public MatchInfo get(Integer matchInfoId){
		
		return (MatchInfo) getSession().get(MatchInfo.class, matchInfoId);
	}
	
	/**
	 * 获取约赛信息  根据 约赛状态 和 用户ID
	 * @param matchInfoState
	 * @param userId
	 * @return
	 */
	public List<MatchInfo> getAllByStateAndId(String matchInfoState,Integer userId){
		
		String hql = "from MatchInfo m where m.matchInfoState = ? and m.users.userId = ?";
		return getSession().createQuery(hql).setString(0, matchInfoState).setInteger(1, userId).list();
		
	}
	
}
