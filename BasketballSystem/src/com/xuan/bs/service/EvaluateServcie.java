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
	 * 保存更新
	 * @param playerBasic
	 */
	public void saveOrUpdate(EvaluateInfo evaluateInfo){
		
		evaluateInfoDao.saveOrUpdate(evaluateInfo);
	}
	
	/**
	 * 获取评价信息   -- 被评价人ID 队伍ID
	 * @param evaluateEvaluatorId
	 * @param teamId
	 * @return
	 */
	public List<EvaluateInfo> getAllById(Integer evaluateEvaluatorId,Integer teamTeamId,Integer userId){
		
		return evaluateInfoDao.getAllById(evaluateEvaluatorId, teamTeamId, userId);
	}
	
	/**
	 * 获取评价信息 --被评价人ID
	 * @param evaluateEvaluatorId
	 * @return
	 */
	public List<EvaluateInfo> getAllByEvaluateEvaluatorId(Integer evaluateEvaluatorId){
		
		return evaluateInfoDao.getAllByEvaluateEvaluatorId(evaluateEvaluatorId);
	}
	
	/**
	 * 获取评价信息 --主键ID
	 * @param evaluateId
	 * @return
	 */
	public List<EvaluateInfo> getAllByEvaluateId(Integer evaluateId){
		
		return evaluateInfoDao.getAllByEvaluateId(evaluateId);
	}
}
