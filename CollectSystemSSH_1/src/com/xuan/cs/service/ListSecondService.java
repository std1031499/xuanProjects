package com.xuan.cs.service;

import java.util.List;

import com.xuan.cs.dao.ListSecondDao;
import com.xuan.cs.entities.ListSecond;

public class ListSecondService {
	
	private ListSecondDao listSecondDao;
	
	public void setListSecondDao(ListSecondDao listSecondDao) {
		this.listSecondDao = listSecondDao;
	}
	
	//����������ʾListThird����Ϣ
	public List<ListSecond> getThirdList(String listSecondId){
		//System.out.println(listSecondDao.getThirdList(ListSecondId)+"c4");
		return listSecondDao.getThirdList(listSecondId);
	}
	
	public List<ListSecond> getListSecond(String listSecondId){
		
		return listSecondDao.getListSecond(listSecondId);
	}
	
	//��ʾlistSecond��Ϣ
	public List<ListSecond> getAll(){
		
		return listSecondDao.getAll();
	}
}
