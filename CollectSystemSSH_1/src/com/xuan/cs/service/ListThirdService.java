package com.xuan.cs.service;

import java.util.List;

import com.xuan.cs.dao.ListThirdDao;
import com.xuan.cs.entities.ListThird;

public class ListThirdService {
	
	private ListThirdDao listThirdDao;
	public void setListThirdDao(ListThirdDao listThirdDao) {
		this.listThirdDao = listThirdDao;
	}
	
	public List<ListThird> getListThird(String ListThirdId){
		
		return listThirdDao.getListThird(ListThirdId);
	}
	
	//ªÒ»°listThird
	public List<ListThird> getAll(){
		
		return listThirdDao.getAll();
	}
}
