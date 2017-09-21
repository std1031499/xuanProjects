package com.TCWL.system.services;

import java.util.List;

import com.TCWL.system.dao.OrderSendDao;
import com.TCWL.system.entities.Ordersend;
import com.TCWL.system.entities.Sender;

public class OrderSendService {

	private OrderSendDao orderSendDao;
	public void setOrderSendDao(OrderSendDao orderSendDao) {
		this.orderSendDao = orderSendDao;
	}
	
	public void saveOrUpdate(Ordersend ordersend){
		
//		System.out.println(ordersend);
		
		orderSendDao.saveOrUpdate(ordersend);
	}
	
	public int getTodayNum(String date){
		return orderSendDao.getTodayNum(date);
	}
	
	
	//������**********************************************************************
	//��ȡ�˷��������͵�δ��������Ա������Ϣ --scId
	public List<Ordersend> getNoDealById(Integer scId){
		
		return orderSendDao.getNoDealById(scId);
	}
	
	//��ȡ������������Ϣ ���ݶ������ -- orderId
	public Ordersend getOrderById(String orderId){
		
		return orderSendDao.getOrderById(orderId);
	}
	
	//��ȡ�˷��������͵�δ���Ͷ�����Ϣ --scId
	public List<Ordersend> getNoSendById(Integer scId){
		
		return orderSendDao.getNoSendById(scId);
	}
	
	//��ȡ�˷��������͵�δ���Ͷ�����Ϣ --scId
	public List<Ordersend> getSendNowById(Integer scId){
		
		return orderSendDao.getSendNowById(scId);
	}
	
	//��ȡ�˷��������͵����ʹﶩ����Ϣ --scId
	public List<Ordersend> getSendReadyById(Integer scId){
		
		return orderSendDao.getSendReadyById(scId);
	}
	
	//����Ա**********************************************************************
	//��ȡ�˷����̵�����Ա��δ���Ͷ�����Ϣ --scId senderId
	public List<Ordersend> getNoSendBySenderId(Integer scId,Integer senderId){
		
		return orderSendDao.getNoSendBySenderId(scId, senderId);
	}
	
	//��ȡ�˷����̵�����Ա���������Ͷ�����Ϣ --scId senderId
	public List<Ordersend> getsendNowBySenderId(Integer scId,Integer senderId){
		
		return orderSendDao.getsendNowBySenderId(scId, senderId);
				
	}
	
	//��ȡ�˷����̵�����Ա�������Ͷ�����Ϣ --scId senderId
	public List<Ordersend> getsendReadyBySenderId(Integer scId,Integer senderId){
		
		return orderSendDao.getsendReadyBySenderId(scId, senderId);
	}
	
	//��ȡ�˷����̵�����Ա�������۶�����Ϣ --scId senderId
	public List<Ordersend> getsendJudgeBySenderId(Integer scId,Integer senderId){
		
		return orderSendDao.getsendJudgeBySenderId(scId, senderId);
	}

}
