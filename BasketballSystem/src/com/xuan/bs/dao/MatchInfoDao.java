package com.xuan.bs.dao;

import java.util.List;

import com.xuan.bs.entities.MatchInfo;

public class MatchInfoDao extends BaseDao{
	
	/**
	 * ��ȡ��ԱԼ��״̬
	 * @param userId
	 * @return
	 */
	public List<MatchInfo> getStateById(Integer userId,String matchInfoState){
		
		String hql = "select m.matchInfoState from MatchInfo m where m.users.userId = ? and m.matchInfoState = ?";
		return getSession().createQuery(hql).setInteger(0, userId).setString(1, matchInfoState).list();
	}
	
	/**
	 * ��ȡ��Ա  ����Լ��״̬ �ص�ID �������� Լ������
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
	 * �������
	 * @param matchInfo
	 */
	public void saveOrUpdate(MatchInfo matchInfo){
		
		getSession().saveOrUpdate(matchInfo);
		
	}
	
	/**
	 * ��ȡԼ����Ϣ
	 * @param matchInfoId
	 * @return
	 */
	public MatchInfo get(Integer matchInfoId){
		
		return (MatchInfo) getSession().get(MatchInfo.class, matchInfoId);
	}
	
	/**
	 * ��ȡԼ����Ϣ  ���� Լ��״̬ �� �û�ID
	 * @param matchInfoState
	 * @param userId
	 * @return
	 */
	public List<MatchInfo> getAllByStateAndId(String matchInfoState,Integer userId){
		
		String hql = "from MatchInfo m where m.matchInfoState = ? and m.users.userId = ?";
		return getSession().createQuery(hql).setString(0, matchInfoState).setInteger(1, userId).list();
		
	}
	
}
