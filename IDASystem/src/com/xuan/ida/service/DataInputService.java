package com.xuan.ida.service;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.File;
import org.springframework.dao.support.DaoSupport;

import com.xuan.ida.dao.DataInputDao;
import com.xuan.ida.entities.DataInput;

public class DataInputService {
	
	private DataInputDao dataInputDao;
	
	public void setDataInputDao(DataInputDao dataInputDao) {
		this.dataInputDao = dataInputDao;
	}
	
	//添加保存
	public void saveOrUpdate(DataInput dataInput){
		
		dataInputDao.saveOrUpdate(dataInput);
	}
	
	//查询所有进项数据
	public List<DataInput> getAll(){
		
		return dataInputDao.getAll();
	}
	
	//查询供应商姓名和出现次数
	public List<DataInput> getNameAndCount(){
		
		return dataInputDao.getNameAndCount();
	}
	
	//多条件查询--重点供应商  姓名和出现次数
	public List<DataInput> getNameAndCountComplex(String selectAnother[],String selectTypes[],
														String selectInputsMin[],String selectInputsMax[]){
		
		return dataInputDao.getNameAndCountComplex(selectAnother, selectTypes, selectInputsMin, selectInputsMax);
				
	}
	
	//查询日期和该日期的inputMoney总数
	public List<DataInput> getDateAndMoneys(){

		return dataInputDao.getDateAndMoneys();
	}
	
	//查询日期和该日期的inputMoney总数--根据年份
	public List<DataInput> getinfosByYear(String seasonYear){
		
		return dataInputDao.getinfosByYear(seasonYear);
	}
	
	//查询日期的年月  和该年月的 inputMoney inputTax inputMoneySum 的总数
	public List<DataInput> getInfosBySelect(){
		//System.out.println("s1");
		//System.out.println(dataInputDao.getInfosBySelect());
		return dataInputDao.getInfosBySelect();
	}
	
	/*//查询日期和该日期的inputMoney总数--根据年份 分析同比增长速率
	public List<DataInput> getinfosByYearTwo(String historyYearOne,String historyYearTwo){
		
		return dataInputDao.getinfosByYearTwo(historyYearOne, historyYearTwo);
	}*/
	
}
