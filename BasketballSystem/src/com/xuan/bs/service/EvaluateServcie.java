package com.xuan.bs.service;

import java.util.List;

import com.xuan.bs.dao.EvaluateInfoDao;
import com.xuan.bs.entities.EvaluateInfo;

public class EvaluateServcie {
	
	private EvaluateInfoDao evaluateInfoDao;
	public void setEvaluateInfoDao(EvaluateInfoDao evaluateInfoDao) {
		this.evaluateInfoDao = evaluateInfoDao;
	}
	
	/**
	 * �������
	 * @param playerBasic
	 */
	public void saveOrUpdate(EvaluateInfo evaluateInfo){
		
		evaluateInfoDao.saveOrUpdate(evaluateInfo);
	}
	
	/**
	 * ��ȡ������Ϣ   -- ��������ID ����ID
	 * @param evaluateEvaluatorId
	 * @param teamId
	 * @return
	 */
	public List<EvaluateInfo> getAllById(Integer evaluateEvaluatorId,Integer teamTeamId,Integer userId){
		
		return evaluateInfoDao.getAllById(evaluateEvaluatorId, teamTeamId, userId);
	}
	
	/**
	 * ��ȡ������Ϣ --��������ID
	 * @param evaluateEvaluatorId
	 * @return
	 */
	public List<EvaluateInfo> getAllByEvaluateEvaluatorId(Integer evaluateEvaluatorId){
		
		return evaluateInfoDao.getAllByEvaluateEvaluatorId(evaluateEvaluatorId);
	}
	
	/**
	 * ��ȡ������Ϣ --����ID
	 * @param evaluateId
	 * @return
	 */
	public List<EvaluateInfo> getAllByEvaluateId(Integer evaluateId){
		
		return evaluateInfoDao.getAllByEvaluateId(evaluateId);
	}
}
