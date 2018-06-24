package com.xuan.bs.dao;

import java.util.List;

import com.xuan.bs.entities.MatchPosition;

public class PlayerPositionDao extends BaseDao{
	
	/**
	 * ��ȡԼ���ĵص���Ϣlist
	 * @return
	 */
	public List<MatchPosition> getAll(){
		
		String hql = "from MatchPosition";
		return getSession().createQuery(hql).list();
	}
	
	/**
	 * 
	 * ��ȡ��γ�� 
	 * @param matchPositionId
	 * @return
	 */
	public List<MatchPosition> getAllById(Integer matchPositionId){
		
		String hql = "select matchPositionLongitude,matchPositionLatitude " +
				"from MatchPosition m where m.matchPositionId = ?";
		
		return getSession().createQuery(hql).setInteger(0, matchPositionId).list();
	}
}
