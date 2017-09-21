package com.TCWL.system.services;

import java.util.List;

import com.TCWL.system.dao.SenderDao;
import com.TCWL.system.entities.Sender;

public class SenderService {
	
	private SenderDao senderDao;
	
	public void setSenderDao(SenderDao senderDao) {
		this.senderDao = senderDao;
	}
	
	//��ȡ�˷����̵���������Ա --scId
	public List<Sender> getSenderInfosById(Integer scId){
		
		return senderDao.getSenderInfosById(scId);
	}
	
	//�����޸�
	public void saveOrUpdate(Sender sender){
		
		senderDao.saveOrUpdate(sender);
	}
	
	//��ȡһ������Ա��������Ϣ --senderId
	public Sender getOneSenderById(Integer senderId){
		
		return senderDao.getOneSenderById(senderId);
	}
	
	
}
