package com.xuan.cs.dao;

import java.util.List;

import com.xuan.cs.entities.ListFirst;
import com.xuan.cs.entities.ListSecond;
import com.xuan.cs.entities.ListThird;
import com.xuan.cs.entities.Skill;
import com.xuan.cs.entities.TradeFirst;
import com.xuan.cs.entities.TradeSecond;

public class SkillDao extends BaseDao {
	
	//�������*********************************************************************
	public void saveOrUpdate(Skill skill){
		getSession().saveOrUpdate(skill);
		System.out.println("h2");
	}
	
	//ʵ�廯������ϵֵ
	
	
	
	
	
	
	
	
	
}
