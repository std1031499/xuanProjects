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
	
	//��ӱ���
	public void saveOrUpdate(DataInput dataInput){
		
		dataInputDao.saveOrUpdate(dataInput);
	}
	
	//��ѯ���н�������
	public List<DataInput> getAll(){
		
		return dataInputDao.getAll();
	}
	
	//��ѯ��Ӧ�������ͳ��ִ���
	public List<DataInput> getNameAndCount(){
		
		return dataInputDao.getNameAndCount();
	}
	
	//��������ѯ--�ص㹩Ӧ��  �����ͳ��ִ���
	public List<DataInput> getNameAndCountComplex(String selectAnother[],String selectTypes[],
														String selectInputsMin[],String selectInputsMax[]){
		
		return dataInputDao.getNameAndCountComplex(selectAnother, selectTypes, selectInputsMin, selectInputsMax);
				
	}
	
	//��ѯ���ں͸����ڵ�inputMoney����
	public List<DataInput> getDateAndMoneys(){

		return dataInputDao.getDateAndMoneys();
	}
	
	//��ѯ���ں͸����ڵ�inputMoney����--�������
	public List<DataInput> getinfosByYear(String seasonYear){
		
		return dataInputDao.getinfosByYear(seasonYear);
	}
	
	//��ѯ���ڵ�����  �͸����µ� inputMoney inputTax inputMoneySum ������
	public List<DataInput> getInfosBySelect(){
		//System.out.println("s1");
		//System.out.println(dataInputDao.getInfosBySelect());
		return dataInputDao.getInfosBySelect();
	}
	
	/*//��ѯ���ں͸����ڵ�inputMoney����--������� ����ͬ����������
	public List<DataInput> getinfosByYearTwo(String historyYearOne,String historyYearTwo){
		
		return dataInputDao.getinfosByYearTwo(historyYearOne, historyYearTwo);
	}*/
	
}
