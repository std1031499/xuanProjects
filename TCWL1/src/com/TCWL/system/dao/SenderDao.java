package com.TCWL.system.dao;

import java.util.List;

import com.TCWL.system.entities.Sender;

public class SenderDao extends BaseDao {
	
	//��ȡ�˷����̵���������Ա --scId
	public List<Sender> getSenderInfosById(Integer scId){
		
		String hql = "from Sender s where s.servicecompany.scId = ? and s.senderStatus = 'true'  ";
		return getSession().createQuery(hql).setInteger(0, scId).list();
	}
	
	//�����޸�
	public void saveOrUpdate(Sender sender){
		
		getSession().saveOrUpdate(sender);
	}
	
	//��ȡһ������Ա��������Ϣ --senderId
	public Sender getOneSenderById(Integer senderId){
				
		return (Sender) getSession().get(Sender.class, senderId );
	}
	
	
	
}
