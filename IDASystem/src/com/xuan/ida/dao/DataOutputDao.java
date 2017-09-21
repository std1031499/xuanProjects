package com.xuan.ida.dao;

import java.util.List;

import com.xuan.ida.entities.DataOutput;

public class DataOutputDao extends BaseDao {
	
	//��ӱ���
	public void saveOrUpdate(DataOutput dataOutput){
		
		getSession().saveOrUpdate(dataOutput);
	}
	
	//��ȡ������������
	public List<DataOutput> getAll(){
		
		String hql = "from DataOutput d order by d.outputId ";
		return getSession().createQuery(hql).list();
	}
	
	//��ȡ�ͻ������ͳ��ִ��� --�������
	public List<DataOutput> getAreaAndCountByYear(String year){
		
		String hql = "select d.outputCustomerArea as area,count(*) as num from DataOutput d where year(d.outputInvoiceDate)= ?  GROUP BY d.outputCustomerArea ";
		return getSession().createQuery(hql).setString(0, year).list();
	}
	
	//��ѯ���ں͸����ڵ�inputMoney����--�������
	public List<DataOutput> getinfosByYear(String year){
		
		String hql = "select month(d.outputInvoiceDate) , sum(cast(d.outputMoney as float)), sum(cast(d.outputTax as float)), sum(cast(d.outputMoneySum as float)) from DataOutput d where year(cast(d.outputInvoiceDate as date)) = ? GROUP BY month(d.outputInvoiceDate)";
		return getSession().createQuery(hql).setString(0, year).list();
	}
	
	//��ȡ�ͻ��ͳ��ִ��� --�������
	public List<DataOutput> getCustomerAndCountByYear(String year){
		
		String hql = "select d.outputCustomerName as name,count(*) as num from DataOutput d where year(d.outputInvoiceDate)= ?  GROUP BY d.outputCustomerName ";
		return getSession().createQuery(hql).setString(0, year).list();
	}
}
