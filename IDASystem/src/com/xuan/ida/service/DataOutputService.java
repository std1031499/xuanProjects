package com.xuan.ida.service;

import java.util.List;

import com.xuan.ida.dao.DataOutputDao;
import com.xuan.ida.entities.DataOutput;

public class DataOutputService {
	
	private DataOutputDao dataOutputDao;
	
	public void setDataOutputDao(DataOutputDao dataOutputDao) {
		this.dataOutputDao = dataOutputDao;
	}
	
	//添加保存
	public void saveOrUpdate(DataOutput dataOutput){
		
		dataOutputDao.saveOrUpdate(dataOutput);
	}
	
	//获取所有销项数据
	public List<DataOutput> getAll(){
		
		return dataOutputDao.getAll();
	}
	
	//获取客户地区和出现次数
	public List<DataOutput> getAreaAndCountByYear(String year){
		
		return dataOutputDao.getAreaAndCountByYear(year);
	}
	
	//查询日期和该日期的inputMoney总数--根据年份
	public List<DataOutput> getinfosByYear(String year){
		
		return dataOutputDao.getinfosByYear(year);
	}
	
	//获取客户和出现次数 --根据年份
	public List<DataOutput> getCustomerAndCountByYear(String year){
		
		return dataOutputDao.getCustomerAndCountByYear(year);
	}
}
