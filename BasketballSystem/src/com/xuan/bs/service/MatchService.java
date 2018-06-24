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
	 * �������
	 * @param orgMatch
	 */
	public void saveOrUpdate(OrgMatch orgMatch){
		
		matchDao.saveOrUpdate(orgMatch);
	}
	
	/**
	 * ��ȡ�����������Ϣ  --organizerId
	 * @param organizerId
	 * @return
	 */
	public List<OrgMatch> getAllByOrgId(Integer organizerId){
		
		return matchDao.getAllByOrgId(organizerId);
	}
	
	/**��ȡ������Ϣ --orgMatchId
	 * @param orgMatchId
	 * @return
	 */
	public List<OrgMatch> getAllByOrgMatchId(Integer orgMatchId){
		
		return matchDao.getAllByOrgMatchId(orgMatchId);
	}
	
	/**
	 * ɾ��������Ϣ--orgMatchId
	 * @param orgMatchId
	 */
	public void deleteByOrgMatchId(Integer orgMatchId){
		
		matchDao.deleteByOrgMatchId(orgMatchId);
	}
	
	/**
	 * ��ȡ����������Ϣ
	 * @return
	 */
	public List<OrgMatch> getAll(){
		
		return matchDao.getAll();
	}
	
	/**
	 * ��ȡ������Ϣ--״̬ 
	 * @param organizerId
	 * @param orgMatchState
	 * @return
	 */
	public List<OrgMatch> getAllByOrgIdAndState(Integer organizerId,String orgMatchState){
		
		return matchDao.getAllByOrgIdAndState(organizerId, orgMatchState);
	}
	
	/**
	 * ��ȡ������Ϣ -- ״̬
	 * @param orgMatchState
	 * @return
	 */
	public List<OrgMatch> getAllByState(String orgMatchState){
		
		return matchDao.getAllByState(orgMatchState);
	}
}
