package com.TCWL.system.dao;

import com.TCWL.system.entities.Servicecompany;


public class ServiceCompanyDao extends BaseDao {
	
	//��ȡ������������Ϣ  --scId
	public Servicecompany getSCompanyInfosById(Integer scId){
		
		return (Servicecompany) getSession().get(Servicecompany.class, scId);
	}
}
