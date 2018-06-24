package com.xuan.bs.service;

import java.util.List;

import com.xuan.bs.dao.MatchDao;
import com.xuan.bs.entities.OrgMatch;
public class MatchService {
	
	private MatchDao matchDao;
	
	public void setMatchDao(MatchDao matchDao) {
		this.matchDao = matchDao;
	}
	
	/**
	 * 保存更新
	 * @param orgMatch
	 */
	public void saveOrUpdate(OrgMatch orgMatch){
		
		matchDao.saveOrUpdate(orgMatch);
	}
	
	/**
	 * 获取管理的赛事信息  --organizerId
	 * @param organizerId
	 * @return
	 */
	public List<OrgMatch> getAllByOrgId(Integer organizerId){
		
		return matchDao.getAllByOrgId(organizerId);
	}
	
	/**获取赛事信息 --orgMatchId
	 * @param orgMatchId
	 * @return
	 */
	public List<OrgMatch> getAllByOrgMatchId(Integer orgMatchId){
		
		return matchDao.getAllByOrgMatchId(orgMatchId);
	}
	
	/**
	 * 删除赛事信息--orgMatchId
	 * @param orgMatchId
	 */
	public void deleteByOrgMatchId(Integer orgMatchId){
		
		matchDao.deleteByOrgMatchId(orgMatchId);
	}
	
	/**
	 * 获取所有赛事信息
	 * @return
	 */
	public List<OrgMatch> getAll(){
		
		return matchDao.getAll();
	}
	
	/**
	 * 获取赛事信息--状态 
	 * @param organizerId
	 * @param orgMatchState
	 * @return
	 */
	public List<OrgMatch> getAllByOrgIdAndState(Integer organizerId,String orgMatchState){
		
		return matchDao.getAllByOrgIdAndState(organizerId, orgMatchState);
	}
	
	/**
	 * 获取赛事信息 -- 状态
	 * @param orgMatchState
	 * @return
	 */
	public List<OrgMatch> getAllByState(String orgMatchState){
		
		return matchDao.getAllByState(orgMatchState);
	}
}
