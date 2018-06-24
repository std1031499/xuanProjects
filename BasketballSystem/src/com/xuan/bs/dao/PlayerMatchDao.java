package com.xuan.bs.dao;

import java.util.List;
import sun.net.www.content.text.plain;

import com.xuan.bs.entities.PlayerMatch;

public class PlayerMatchDao extends BaseDao{
	
	/**
	 * �������
	 * @param playerMatch
	 */
	public void saveOrUpdate(PlayerMatch playerMatch){
		
		getSession().saveOrUpdate(playerMatch);
	}
	
	/**
	 * ��ȡ������Ϣ --�û�ID ����ID
	 * @param userId
	 * @param orgMatchId
	 * @return
	 */
	public List<PlayerMatch> getAllById(Integer userId,Integer orgMatchId){
		
		String hql = "from PlayerMatch p where p.users.userId = ? and p.orgMatch.orgMatchId = ? ";
		return getSession().createQuery(hql).setInteger(0, userId).setInteger(1, orgMatchId).list();
	}
	
	/**
	 * ��ȡ������Ϣ
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
	 * ��ȡ������Ϣ -- ��������ID
	 * @param orgMatchId
	 * @return
	 */
	public List<PlayerMatch> getAllByOrgMatchId(Integer orgMatchId){
		
		String hql = "from PlayerMatch p where p.orgMatch.orgMatchId = ? ";
		return getSession().createQuery(hql).setInteger(0, orgMatchId).list();
	}
	
	/**
	 * ��ȡ������Ϣ -- ����״̬
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
	 *  ��ȡ������Ϣ -- ����״̬ and ����ID
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
