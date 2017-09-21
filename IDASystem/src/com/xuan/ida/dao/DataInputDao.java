package com.xuan.ida.dao;

import java.util.List;

import com.xuan.ida.entities.DataInput;

public class DataInputDao extends BaseDao {
	
	//添加保存
	public void saveOrUpdate(DataInput dataInput){
		
		getSession().saveOrUpdate(dataInput);
	}
	
	//查询所有进项数据
	public List<DataInput> getAll(){ 
		
		String hql = "from DataInput";
		return getSession().createQuery(hql).list();
	}
	
	//查询供应商姓名和出现次数
	public List<DataInput> getNameAndCount(){
		
		String hql = "select inputSupplierName as name,count(*) as num from DataInput GROUP BY inputSupplierName";
		return getSession().createQuery(hql).list();
	}
	
	//多条件查询--重点供应商  姓名和出现次数
	public List<DataInput> getNameAndCountComplex(String selectAnother[],String selectTypes[],
													String selectInputsMin[],String selectInputsMax[]){
		
		String hql = "select inputSupplierName as name,count(*) as num from DataInput d where d.inputId !='' ";
		for(int i=0;i<selectAnother.length;i++)
		{
			//第一个条件 判断新添加的条件 并且 或者 不含
			if(selectAnother[i].equals("1"))//并且*******************************
			{	
				if(selectTypes[i].equals("year"))//进项日期
				{	
					if(!selectInputsMin[i].equals("")&&selectInputsMin[i]!=null)
					{	
						hql+=" and year(d.inputInvoiceDate)>='"+selectInputsMin[i]+"' ";
					}
					if(!selectInputsMax[i].equals("")&&selectInputsMax[i]!=null)
					{
						hql+=" and year(d.inputInvoiceDate)<='"+selectInputsMax[i]+"' ";
					}
				}
				
				if(selectTypes[i].equals("tax"))//进项税金
				{
					if(!selectInputsMin[i].equals("")&&selectInputsMin[i]!=null)
					{	
						hql+=" and cast(d.inputTax as float) >='"+selectInputsMin[i]+"' ";
					}
					if(!selectInputsMax[i].equals("")&&selectInputsMax[i]!=null)
					{
						hql+=" and cast(d.inputTax as float) <='"+selectInputsMax[i]+"' ";
					}
				}
				
				if(selectTypes[i].equals("money"))//进项金额
				{
					if(!selectInputsMin[i].equals("")&&selectInputsMin[i]!=null)
					{
						hql+=" and cast(d.inputMoney as float) >='"+selectInputsMin[i]+"' ";
					}
					if(!selectInputsMax[i].equals("")&&selectInputsMax[i]!=null)
					{
						hql+=" and cast(d.inputMoney as float) <='"+selectInputsMax[i]+"' ";
					}
				}
				
				if(selectTypes[i].equals("sum"))//进项总额
				{
					if(!selectInputsMin[i].equals("")&&selectInputsMin[i]!=null)
					{
						hql+=" and cast(d.inputMoneySum as float) >='"+selectInputsMin[i]+"' ";
					}
					if(!selectInputsMax[i].equals("")&&selectInputsMax[i]!=null)
					{
						hql+=" and cast(d.inputMoneySum as float) <='"+selectInputsMax[i]+"' ";
					}
				}
			}
			
			else if(selectAnother[i].equals("0"))//或者**************************
			{
				if(selectTypes[i].equals("year"))//进项日期
				{	
					if(!selectInputsMin[i].equals("")&&selectInputsMin[i]!=null)
					{	
						hql+=" or year(d.inputInvoiceDate)>='"+selectInputsMin[i]+"' ";
					}
					if(!selectInputsMax[i].equals("")&&selectInputsMax[i]!=null)
					{
						hql+=" or year(d.inputInvoiceDate)<='"+selectInputsMax[i]+"' ";
					}
				}
				
				if(selectTypes[i].equals("tax"))//进项税金
				{
					if(!selectInputsMin[i].equals("")&&selectInputsMin[i]!=null)
					{	
						hql+=" or cast(d.inputTax as float) >='"+selectInputsMin[i]+"' ";
					}
					if(!selectInputsMax[i].equals("")&&selectInputsMax[i]!=null)
					{
						hql+=" or cast(d.inputTax as float) <='"+selectInputsMax[i]+"' ";
					}
				}
				
				if(selectTypes[i].equals("money"))//进项金额
				{
					if(!selectInputsMin[i].equals("")&&selectInputsMin[i]!=null)
					{
						hql+=" or cast(d.inputMoney as float) >='"+selectInputsMin[i]+"' ";
					}
					if(!selectInputsMax[i].equals("")&&selectInputsMax[i]!=null)
					{
						hql+=" or cast(d.inputMoney as float) <='"+selectInputsMax[i]+"' ";
					}
				}
				
				if(selectTypes[i].equals("sum"))//进项总额
				{
					if(!selectInputsMin[i].equals("")&&selectInputsMin[i]!=null)
					{
						hql+=" or cast(d.inputMoneySum as float) >='"+selectInputsMin[i]+"' ";
					}
					if(!selectInputsMax[i].equals("")&&selectInputsMax[i]!=null)
					{
						hql+=" or cast(d.inputMoneySum as float) <='"+selectInputsMax[i]+"' ";
					}
				}
			}
			
			else if(selectAnother[i].equals("-1"))//不含*******************************
			{
				if(selectTypes[i].equals("year"))//进项日期
				{	
					if(!selectInputsMin[i].equals("")&&selectInputsMin[i]!=null)
					{	
						hql+=" or year(d.inputInvoiceDate) < '"+selectInputsMin[i]+"' ";
					}
					if(!selectInputsMax[i].equals("")&&selectInputsMax[i]!=null)
					{
						hql+=" or year(d.inputInvoiceDate) > '"+selectInputsMax[i]+"' ";
					}
				}
				
				if(selectTypes[i].equals("tax"))//进项税金
				{
					if(!selectInputsMin[i].equals("")&&selectInputsMin[i]!=null)
					{	
						hql+=" or cast(d.inputTax as float) < '"+selectInputsMin[i]+"' ";
					}
					if(!selectInputsMax[i].equals("")&&selectInputsMax[i]!=null)
					{
						hql+=" or cast(d.inputTax as float) > '"+selectInputsMax[i]+"' ";
					}
				}
				
				if(selectTypes[i].equals("money"))//进项金额
				{
					if(!selectInputsMin[i].equals("")&&selectInputsMin[i]!=null)
					{
						hql+=" or cast(d.inputMoney as float) < '"+selectInputsMin[i]+"' ";
					}
					if(!selectInputsMax[i].equals("")&&selectInputsMax[i]!=null)
					{
						hql+=" or cast(d.inputMoney as float) > '"+selectInputsMax[i]+"' ";
					}
				}
				
				if(selectTypes[i].equals("sum"))//进项总额
				{
					if(!selectInputsMin[i].equals("")&&selectInputsMin[i]!=null)
					{
						hql+=" or cast(d.inputMoneySum as float) < '"+selectInputsMin[i]+"' ";
					}
					if(!selectInputsMax[i].equals("")&&selectInputsMax[i]!=null)
					{
						hql+=" or cast(d.inputMoneySum as float) > '"+selectInputsMax[i]+"' ";
					}
				}
				
			}
		}
		
		
		hql+= " GROUP BY inputSupplierName ";
		System.out.println(hql);
		return getSession().createQuery(hql).list();
	}
	
	//查询日期和该日期的inputMoney总数
	public List<DataInput> getDateAndMoneys(){
		//String hql = "select d.inputInvoiceDate ,SUM(cast(d.inputMoney as Integer ))  from DataInput d group by d.inputInvoiceDate,d.inputMoney";
		String hql = "select d.inputInvoiceDate, sum(cast(d.inputMoney as float)), sum(cast(d.inputTax as float)), sum(cast(d.inputMoneySum as float)) from DataInput d group by d.inputMoney ,d.inputInvoiceDate,d.inputTax,d.inputMoneySum ORDER BY d.inputInvoiceDate ASC";
		return getSession().createQuery(hql).list();
	}
	
	//查询日期和该日期的inputMoney总数--根据年份
	public List<DataInput> getinfosByYear(String seasonYear){
		
		String hql = "select month(d.inputInvoiceDate) , sum(cast(d.inputMoney as float)), sum(cast(d.inputTax as float)), sum(cast(d.inputMoneySum as float)) from DataInput d where year(cast(d.inputInvoiceDate as date)) = ? GROUP BY month(d.inputInvoiceDate)";
		return getSession().createQuery(hql).setString(0, seasonYear).list();
	}
	
	//查询日期的年月  和该年月的 inputMoney inputTax inputMoneySum 的总数
	public List<DataInput> getInfosBySelect(){
		
		String hql = "select cast(year(d.inputInvoiceDate) as string) + substring(cast(month(d.inputInvoiceDate) + 100 as string),2,2) , sum(cast(d.inputMoney as float)), sum(cast(d.inputTax as float)), sum(cast(d.inputMoneySum as float)) from DataInput d  GROUP BY cast(year(d.inputInvoiceDate) as string) + substring(cast(month(d.inputInvoiceDate)+100 as string),2,2) ";
		//System.out.println(hql );
		return getSession().createQuery(hql).list();		
	}
	
	/*//查询日期和该日期的inputMoney总数--根据年份 分析同比增长速率
	public List<DataInput> getinfosByYearTwo(String historyYearOne,String historyYearTwo){
		
		String hql = "select month(d.inputInvoiceDate) , sum(cast(d.inputMoney as float)), sum(cast(d.inputTax as float)), sum(cast(d.inputMoneySum as float)) from DataInput d where year(cast(d.inputInvoiceDate as date)) = ? or year(cast(d.inputInvoiceDate as date)) = ?  GROUP BY month(d.inputInvoiceDate)";
		return getSession().createQuery(hql).setString(0, historyYearOne).setString(1, historyYearTwo).list(); 
	}*/

	
}
