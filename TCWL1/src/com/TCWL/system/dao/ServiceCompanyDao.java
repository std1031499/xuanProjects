package com.TCWL.system.dao;

import com.TCWL.system.entities.Servicecompany;


public class ServiceCompanyDao extends BaseDao {
	
	//获取服务商所有信息  --scId
	public Servicecompany getSCompanyInfosById(Integer scId){
		
		return (Servicecompany) getSession().get(Servicecompany.class, scId);
	}
}
