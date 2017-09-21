package com.xuan.ida.service;

import java.util.List;

import com.xuan.ida.dao.DataOutputDao;
import com.xuan.ida.entities.DataOutput;

public class DataOutputService {
	
	private DataOutputDao dataOutputDao;
	
	public void setDataOutputDao(DataOutputDao dataOutputDao) {
		this.dataOutputDao = dataOutputDao;
	}
	
	//��ӱ���
	public void saveOrUpdate(DataOutput dataOutput){
		
		dataOutputDao.saveOrUpdate(dataOutput);
	}
	
	//��ȡ������������
	public List<DataOutput> getAll(){
		
		return dataOutputDao.getAll();
	}
	
	//��ȡ�ͻ������ͳ��ִ���
	public List<DataOutput> getAreaAndCountByYear(String year){
		
		return dataOutputDao.getAreaAndCountByYear(year);
	}
	
	//��ѯ���ں͸����ڵ�inputMoney����--�������
	public List<DataOutput> getinfosByYear(String year){
		
		return dataOutputDao.getinfosByYear(year);
	}
	
	//��ȡ�ͻ��ͳ��ִ��� --�������
	public List<DataOutput> getCustomerAndCountByYear(String year){
		
		return dataOutputDao.getCustomerAndCountByYear(year);
	}
}
