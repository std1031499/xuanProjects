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
	
	//�򵥲�ѯ*********************************************************************
	//��ѯ��������Ϣ--������������
	public List<Skill> getSkillByName(String inputInfo,Integer user_IdS){
		
		return showDao.getSkillByName(inputInfo,user_IdS);
	}
	
	//��ѯ��������Ϣ--�Ƽ������
	public List<Skill> getSkillByType(String inputInfo,Integer user_IdS){
		
		return showDao.getSkillByType(inputInfo,user_IdS);
	}
	
	//��ѯskill������Ϣ
	public List<Skill> getAllSkill(Integer user_IdS){
		//System.out.println(showDao.getAll(user_IdS)+"q3");
		return showDao.getAllSkill(user_IdS);
	}
	
	
	//�߼���ѯ*********************************************************************
	public List<Skill> getSkillByHigh(String selectTypes[],String selectInputsType[],String includeOrNot[],
										String selectInputsInclude[],String exactOrNot[],String selectAnother[],Integer user_IdS ){
		
		return showDao.getSkillByHigh(selectTypes, selectInputsType, includeOrNot, selectInputsInclude, exactOrNot, selectAnother, user_IdS);
				
		
	}
	
	//��ѯbasic��������Ϣ
	public List<Basic> getAllBasic(Integer user_IdB){
		
		return showDao.getAllBasic(user_IdB);
	}
	
	//�鿴skill��һ����Ϣ ����skill_Id
	public List<Skill> getSkillById(Integer user_IdS,Integer skill_Id){
		
		return showDao.getSkillById(user_IdS, skill_Id);
	}
	
	//ɾ��skill��Ϣ
	public void delete(Integer skill_Id){
		
		showDao.delete(skill_Id);
	}
	
	//��ȡ������Ϣ
	public Skill getSkill(Integer skill_Id){
		
		return showDao.getSkill(skill_Id);
	}
	
	//��ӱ����޸�
	public void saveOrUpdate(Skill skill){
		
		showDao.saveOrUpdate(skill);
	}
	
	//��ѯ����˵���Ϣ
	public List<Skill> getAllSkillNoState(String auditState){
		
		return showDao.getAllSkillNoState(auditState);		
	}
	
	//��ѯ����˵���Ϣ--������������
	public List<Skill> getSkillByNameNoState(String inputInfo,String auditState){
		
		return showDao.getSkillByNameNoState(inputInfo, auditState);
	}
	
	//��ѯ����˵���Ϣ--�Ƽ������
	public List<Skill> getSkillByTypeNoState(String inputInfo,String auditState){
		
		return showDao.getSkillByTypeNoState(inputInfo,auditState);
	}
	
	//��ѯskill��Ϣ --skill_Id
	public List<Skill> getSkillByIdAudit(Integer skill_Id){
		
		return showDao.getSkillByIdAudit(skill_Id);
	}
		
		
	
	
}
