package com.xuan.cs.service;

import com.xuan.cs.dao.SkillDao;
import com.xuan.cs.entities.Skill;

public class SkillService {
	
	private SkillDao skillDao;
	
	public void setSkillDao(SkillDao skillDao) {
		this.skillDao = skillDao;
	}
	
	
	//��ӱ����޸�
	public void saveOrUpdate(Skill skill){
		
		skillDao.saveOrUpdate(skill);
		System.out.println("h3");
	}
}
