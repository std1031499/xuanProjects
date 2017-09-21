package com.TCWL.system.services;

import java.util.List;

import com.TCWL.system.dao.UsualUserInfoListDao;
import com.TCWL.system.entities.Usualuserinfolist;

public class UsualUserInfoListService {
	
	private UsualUserInfoListDao usualUserInfoListDao;
	
	public void setUsualUserInfoListDao(
			UsualUserInfoListDao usualUserInfoListDao) {
		this.usualUserInfoListDao = usualUserInfoListDao;
	}
	
	//��ȡ��ͨ�û�������Ϣ--userId
	public Usualuserinfolist get(Integer userId){
		
		return usualUserInfoListDao.get(userId);
	}
	
	//��ȡ��ȡ��ͨ�û�������Ϣ--userId
	public List<Usualuserinfolist> getAllById(Integer userId ){
		
		return usualUserInfoListDao.getAllById(userId);
	}
	
	//�����޸�
	public void saveOrUpdate(Usualuserinfolist usualuserinfolist){
		
		usualUserInfoListDao.saveOrUpdate(usualuserinfolist);
	}
	//
	
}
