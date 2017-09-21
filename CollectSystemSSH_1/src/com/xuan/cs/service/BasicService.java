package com.xuan.cs.service;

import java.util.List;

import com.xuan.cs.dao.BasicDao;
import com.xuan.cs.entities.Basic;

public class BasicService {
	
	private BasicDao basicDao;
	
	public void setBasicDao(BasicDao basicDao) {
		this.basicDao = basicDao;
	}
	
	//添加保存修改
	public void saveOrUpdate(Basic basic){
		basicDao.saveOrUpdate(basic);
	}
	
	//获取基础信息
	public Basic get(Integer basic_Id){
		return basicDao.get(basic_Id);
	}
	
	//
	public List<Basic> input(Integer user_Id){
		List<Basic> basics = basicDao.input(user_Id);
		return basics;
	}
	
	//
	public List<Basic> getAll(Integer user_Id){
		List<Basic> basics = basicDao.getAll(user_Id);
		return basics;
	}
}
