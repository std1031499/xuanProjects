package com.TCWL.system.services;

import com.TCWL.system.dao.ServiceCompanyDao;
import com.TCWL.system.entities.Servicecompany;

public class ServiceCompanyService {
	
	private ServiceCompanyDao serviceCompanyDao;
	
	public void setServiceCompanyDao(ServiceCompanyDao serviceCompanyDao) {
		this.serviceCompanyDao = serviceCompanyDao;
	}
	
	//��ȡ������������Ϣ  --scId
	public Servicecompany getSCompanyInfosById(Integer scId){
		
		return serviceCompanyDao.getSCompanyInfosById(scId);
	}
}
