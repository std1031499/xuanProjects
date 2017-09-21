package com.xuan.ida.dao;

import java.util.List;

import com.xuan.ida.entities.DataOutput;

public class DataOutputDao extends BaseDao {
	
	//添加保存
	public void saveOrUpdate(DataOutput dataOutput){
		
		getSession().saveOrUpdate(dataOutput);
	}
	
	//获取所有销项数据
	public List<DataOutput> getAll(){
		
		String hql = "from DataOutput d order by d.outputId ";
		return getSession().createQuery(hql).list();
	}
	
	//获取客户地区和出现次数 --根据年份
	public List<DataOutput> getAreaAndCountByYear(String year){
		
		String hql = "select d.outputCustomerArea as area,count(*) as num from DataOutput d where year(d.outputInvoiceDate)= ?  GROUP BY d.outputCustomerArea ";
		return getSession().createQuery(hql).setString(0, year).list();
	}
	
	//查询日期和该日期的inputMoney总数--根据年份
	public List<DataOutput> getinfosByYear(String year){
		
		String hql = "select month(d.outputInvoiceDate) , sum(cast(d.outputMoney as float)), sum(cast(d.outputTax as float)), sum(cast(d.outputMoneySum as float)) from DataOutput d where year(cast(d.outputInvoiceDate as date)) = ? GROUP BY month(d.outputInvoiceDate)";
		return getSession().createQuery(hql).setString(0, year).list();
	}
	
	//获取客户和出现次数 --根据年份
	public List<DataOutput> getCustomerAndCountByYear(String year){
		
		String hql = "select d.outputCustomerName as name,count(*) as num from DataOutput d where year(d.outputInvoiceDate)= ?  GROUP BY d.outputCustomerName ";
		return getSession().createQuery(hql).setString(0, year).list();
	}
}
