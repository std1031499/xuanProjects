package com.xuan.cs.service;

import java.util.List;

import com.xuan.cs.dao.ShowDao;
import com.xuan.cs.entities.Basic;
import com.xuan.cs.entities.Skill;

public class ShowService {
	
	private ShowDao showDao;
	
	public void setShowDao(ShowDao showDao) {
		this.showDao = showDao;
	}
	
	//简单查询*********************************************************************
	//查询技术表信息--技术需求名称
	public List<Skill> getSkillByName(String inputInfo,Integer user_IdS){
		
		return showDao.getSkillByName(inputInfo,user_IdS);
	}
	
	//查询技术表信息--科技活动类型
	public List<Skill> getSkillByType(String inputInfo,Integer user_IdS){
		
		return showDao.getSkillByType(inputInfo,user_IdS);
	}
	
	//查询skill所有信息
	public List<Skill> getAllSkill(Integer user_IdS){
		//System.out.println(showDao.getAll(user_IdS)+"q3");
		return showDao.getAllSkill(user_IdS);
	}
	
	
	//高级查询*********************************************************************
	public List<Skill> getSkillByHigh(String selectTypes[],String selectInputsType[],String includeOrNot[],
										String selectInputsInclude[],String exactOrNot[],String selectAnother[],Integer user_IdS ){
		
		return showDao.getSkillByHigh(selectTypes, selectInputsType, includeOrNot, selectInputsInclude, exactOrNot, selectAnother, user_IdS);
				
		
	}
	
	//查询basic的所有信息
	public List<Basic> getAllBasic(Integer user_IdB){
		
		return showDao.getAllBasic(user_IdB);
	}
	
	//查看skill的一个信息 根据skill_Id
	public List<Skill> getSkillById(Integer user_IdS,Integer skill_Id){
		
		return showDao.getSkillById(user_IdS, skill_Id);
	}
	
	//删除skill信息
	public void delete(Integer skill_Id){
		
		showDao.delete(skill_Id);
	}
	
	//获取技术信息
	public Skill getSkill(Integer skill_Id){
		
		return showDao.getSkill(skill_Id);
	}
	
	//添加保存修改
	public void saveOrUpdate(Skill skill){
		
		showDao.saveOrUpdate(skill);
	}
	
	//查询待审核的信息
	public List<Skill> getAllSkillNoState(String auditState){
		
		return showDao.getAllSkillNoState(auditState);		
	}
	
	//查询待审核的信息--技术需求名称
	public List<Skill> getSkillByNameNoState(String inputInfo,String auditState){
		
		return showDao.getSkillByNameNoState(inputInfo, auditState);
	}
	
	//查询待审核的信息--科技活动类型
	public List<Skill> getSkillByTypeNoState(String inputInfo,String auditState){
		
		return showDao.getSkillByTypeNoState(inputInfo,auditState);
	}
	
	//查询skill信息 --skill_Id
	public List<Skill> getSkillByIdAudit(Integer skill_Id){
		
		return showDao.getSkillByIdAudit(skill_Id);
	}
		
		
	
	
}
