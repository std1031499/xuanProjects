package com.xuan.cs.service;

import java.util.List;

import com.xuan.cs.dao.ListFirstDao;
import com.xuan.cs.entities.ListFirst;

public class ListFirstService {
	
	private ListFirstDao listFirstDao;
	
	public void setListFirstDao(ListFirstDao listFirstDao) {
		this.listFirstDao = listFirstDao;
	}
	
	//显示listFirst信息
	public List<ListFirst> getAll(){
		//System.out.println("z4");
		//System.out.println(listFirstDao.getAll(ListFirstId)+"z3");
		return listFirstDao.getAll();
	}
	
	//三级联动显示ListSecond信息
	public List<ListFirst> getSecondList(String listFirstId){
		//System.out.println(listFirstDao.getSecondList(ListFirstId)+"z5");
		return listFirstDao.getSecondList(listFirstId);
	}
	
	public List<ListFirst> getListFirst(String listFirstId){
		
		return listFirstDao.getListFirst(listFirstId);
	}
}
