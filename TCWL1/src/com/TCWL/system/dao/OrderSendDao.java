package com.TCWL.system.dao;

import java.util.List;

import com.TCWL.system.entities.Ordersend;
import com.TCWL.system.entities.Sender;

public class OrderSendDao extends BaseDao{
	
	
	public void saveOrUpdate(Ordersend ordersend){
		getSession().saveOrUpdate(ordersend);
	}
	
	@SuppressWarnings("unchecked")
	public int getTodayNum(String date){
		String orderId = date + "_____";
		String hql = "From Ordersend os where os.orderId like ?";
		List<Ordersend> list = getSession().createQuery(hql).setString(0, orderId).list();
		return list.size();
	}
	
	//������**********************************************************************
	//��ȡ�˷��������͵�δ��������Ա������Ϣ --scId 
	public List<Ordersend> getNoDealById(Integer scId){
		
		String hql = "from Ordersend o where o.servicecompany.scId = ?  and o.sender.senderId is null and o.orderStatus ='δ����' ";
		return getSession().createQuery(hql).setInteger(0, scId).list();
	}
	
	//��ȡ������������Ϣ ���ݶ������ -- orderId
	public Ordersend getOrderById(String orderId){
		
		return (Ordersend) getSession().get(Ordersend.class, orderId);
	}
	
	//��ȡ�˷��������͵�δ���Ͷ�����Ϣ --scId
	public List<Ordersend> getNoSendById(Integer scId){
		
		String hql = "from Ordersend o where o.servicecompany.scId = ?  and o.orderStatus ='δ����' ";
		return getSession().createQuery(hql).setInteger(0, scId).list();				
	}
	
	//��ȡ�˷��������͵������ж�����Ϣ --scId
	public List<Ordersend> getSendNowById(Integer scId){
		
		String hql = "from Ordersend o where o.servicecompany.scId = ?  and o.orderStatus ='������' ";
		return getSession().createQuery(hql).setInteger(0, scId).list();
	}
	
	//��ȡ�˷��������͵����ʹﶩ����Ϣ --scId
	public List<Ordersend> getSendReadyById(Integer scId){
		
		String hql = "from Ordersend o where o.servicecompany.scId = ?  and o.orderStatus ='���ʹ�' ";
		return getSession().createQuery(hql).setInteger(0, scId).list();
	}
	
	//����Ա**********************************************************************
	//��ȡ�˷����̵�����Ա��δ���Ͷ�����Ϣ --scId senderId
	public List<Ordersend> getNoSendBySenderId(Integer scId,Integer senderId){
		
		String hql = "from Ordersend o where o.servicecompany.scId = ? and o.sender.senderId = ?  and o.orderStatus ='δ����'  ";
		return getSession().createQuery(hql).setInteger(0, scId).setInteger(1, senderId).list();
	}
	
	//��ȡ�˷����̵�����Ա���������Ͷ�����Ϣ --scId senderId
	public List<Ordersend> getsendNowBySenderId(Integer scId,Integer senderId){
		
		String hql = "from Ordersend o where o.servicecompany.scId = ? and o.sender.senderId = ?  and o.orderStatus ='������'  ";
		return getSession().createQuery(hql).setInteger(0, scId).setInteger(1, senderId).list();
	}
	
	//��ȡ�˷����̵�����Ա�������Ͷ�����Ϣ --scId senderId
	public List<Ordersend> getsendReadyBySenderId(Integer scId,Integer senderId){
		
		String hql = "from Ordersend o where o.servicecompany.scId = ? and o.sender.senderId = ?  and o.orderStatus ='���ʹ�'  ";
		return getSession().createQuery(hql).setInteger(0, scId).setInteger(1, senderId).list();
	}
	
	//��ȡ�˷����̵�����Ա�������۶�����Ϣ --scId senderId
	public List<Ordersend> getsendJudgeBySenderId(Integer scId,Integer senderId){
		
		String hql = "from Ordersend o where o.servicecompany.scId = ? and o.sender.senderId = ?  and o.orderStatus ='������'  ";
		return getSession().createQuery(hql).setInteger(0, scId).setInteger(1, senderId).list();
	}
}
