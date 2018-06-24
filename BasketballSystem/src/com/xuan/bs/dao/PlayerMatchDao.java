package com.xuan.bs.dao;

import java.util.List;
import sun.net.www.content.text.plain;

import com.xuan.bs.entities.PlayerMatch;

public class PlayerMatchDao extends BaseDao{
	
	/**
	 * 保存更新
	 * @param playerMatch
	 */
	public void saveOrUpdate(PlayerMatch playerMatch){
		
		getSession().saveOrUpdate(playerMatch);
	}
	
	/**
	 * 获取报名信息 --用户ID 赛事ID
	 * @param userId
	 * @param orgMatchId
	 * @return
	 */
	public List<PlayerMatch> getAllById(Integer userId,Integer orgMatchId){
		
		String hql = "from PlayerMatch p where p.users.userId = ? and p.orgMatch.orgMatchId = ? ";
		return getSession().createQuery(hql).setInteger(0, userId).setInteger(1, orgMatchId).list();
	}
	
	/**
	 * 获取报名信息
	 * @param userId
	 * @return
	 */
	public List<PlayerMatch> getSignUpInfo(Integer userId){
		
		String hql = "from PlayerMatch p "+
				"left outer join fetch p.orgMatch "+
				"where p.users.userId = ? ";
		return getSession().createQuery(hql).setInteger(0, userId).list();
	}
	
	/**
	 * 获取报名信息 -- 根据赛事ID
	 * @param orgMatchId
	 * @return
	 */
	public List<PlayerMatch> getAllByOrgMatchId(Integer orgMatchId){
		
		String hql = "from PlayerMatch p where p.orgMatch.orgMatchId = ? ";
		return getSession().createQuery(hql).setInteger(0, orgMatchId).list();
	}
	
	/**
	 * 获取报名信息 -- 根据状态
	 * @param playMatchState
	 * @return
	 */
	public List<PlayerMatch> getAllByState(String playMatchState){
		
		String hql = "from PlayerMatch p " +
				"left outer join fetch p.orgMatch "+
				"left outer join fetch p.users "+
				"where p.playMatchState = ? ";
		return getSession().createQuery(hql).setString(0,playMatchState).list();
		
	}
	
	/**
	 *  获取报名信息 -- 根据状态 and 赛事ID
	 * @param playMatchState
	 * @param orgMatchId
	 * @return
	 */
	public List<PlayerMatch> getAllByStateAndOrgMatchId(String playMatchState,Integer orgMatchId){
		
		String hql = "from PlayerMatch p " +
				"left outer join fetch p.orgMatch "+
				"left outer join fetch p.users "+
				"where p.playMatchState = ? and p.orgMatch.orgMatchId = ?";
		return getSession().createQuery(hql).setString(0, playMatchState).setInteger(1, orgMatchId).list();
	}
}
