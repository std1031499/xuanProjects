package com.xuan.bs.dao;

import java.util.List;

import com.xuan.bs.entities.OrgMatch;


public class MatchDao extends BaseDao{
	
	/**
	 * 保存更新
	 * @param orgMatch
	 */
	public void saveOrUpdate(OrgMatch orgMatch){
		
		getSession().saveOrUpdate(orgMatch);
	}
	
	/**
	 * 获取管理的赛事信息  --organizerId
	 * @param organizerId
	 * @return
	 */
	public List<OrgMatch> getAllByOrgId(Integer organizerId){
		
		String hql = "from OrgMatch o where o.organizer.organizerId = ?";
		return getSession().createQuery(hql).setInteger(0, organizerId).list();
	}
	
	/**获取赛事信息 --orgMatchId
	 * @param orgMatchId
	 * @return
	 */
	public List<OrgMatch> getAllByOrgMatchId(Integer orgMatchId){
		
		String hql = "from OrgMatch o where o.orgMatchId = ?";
		return getSession().createQuery(hql).setInteger(0, orgMatchId).list();
	}
	
	/**
	 * 删除赛事信息--orgMatchId
	 * @param orgMatchId
	 */
	public void deleteByOrgMatchId(Integer orgMatchId){
		
		String hql = "delete from OrgMatch where orgMatchId = ? ";
		getSession().createQuery(hql).setInteger(0, orgMatchId).executeUpdate();
	}
	
	/**
	 * 获取所有赛事信息
	 * @return
	 */
	public List<OrgMatch> getAll(){
		
		String hql = "from OrgMatch";
		return getSession().createQuery(hql).list();
	}
	
	/**
	 * 获取赛事信息--状态 
	 * @param organizerId
	 * @param orgMatchState
	 * @return
	 */
	public List<OrgMatch> getAllByOrgIdAndState(Integer organizerId,String orgMatchState){
		
		String hql = "from OrgMatch o where o.organizer.organizerId = ? and o.orgMatchState = ?";
		return getSession().createQuery(hql).setInteger(0, organizerId).setString(1, orgMatchState).list();
	}
	
	/**
	 * 获取赛事信息 -- 状态
	 * @param orgMatchState
	 * @return
	 */
	public List<OrgMatch> getAllByState(String orgMatchState){
		
		String hql = "from OrgMatch o where o.orgMatchState = ?";
		return getSession().createQuery(hql).setString(0, orgMatchState).list();
	}
	

}
