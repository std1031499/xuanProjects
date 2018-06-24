package com.xuan.bs.dao;

import java.util.List;

import com.xuan.bs.entities.EvaluateInfo;

public class EvaluateInfoDao extends BaseDao{
	
	
	/**
	 * 保存更新
	 * @param playerBasic
	 */
	public void saveOrUpdate(EvaluateInfo evaluateInfo){
		
		getSession().saveOrUpdate(evaluateInfo);
	}
	
	/**
	 * 获取评价信息   -- 被评价人ID 队伍ID 评价人ID
	 * @param evaluateEvaluatorId
	 * @param teamId
	 * @return
	 */
	public List<EvaluateInfo> getAllById(Integer evaluateEvaluatorId,Integer teamTeamId,Integer userId){
		
		String hql = "from EvaluateInfo e where e.evaluateEvaluateId = ? and e.teamTeamId = ? and e.users.userId = ? ";
		return getSession().createQuery(hql).setInteger(0, evaluateEvaluatorId).setInteger(1, teamTeamId).setInteger(2, userId).list();
	}
	
	/**
	 * 获取评价信息 --被评价人ID
	 * @param evaluateEvaluatorId
	 * @return
	 */
	public List<EvaluateInfo> getAllByEvaluateEvaluatorId(Integer evaluateEvaluatorId){
		
		String hql = "from EvaluateInfo e where e.evaluateEvaluateId = ?";
		return getSession().createQuery(hql).setInteger(0, evaluateEvaluatorId).list();
	}
	
	/**
	 * 获取评价信息 --主键ID
	 * @param evaluateId
	 * @return
	 */
	public List<EvaluateInfo> getAllByEvaluateId(Integer evaluateId){
		
		String hql = "from EvaluateInfo e where e.evaluateId = ?";
		return getSession().createQuery(hql).setInteger(0, evaluateId).list();
	}
	
}
