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
	
	//服务商**********************************************************************
	//获取此服务商类型的未安排配送员订单信息 --scId 
	public List<Ordersend> getNoDealById(Integer scId){
		
		String hql = "from Ordersend o where o.servicecompany.scId = ?  and o.sender.senderId is null and o.orderStatus ='未安排' ";
		return getSession().createQuery(hql).setInteger(0, scId).list();
	}
	
	//获取订单的所有信息 根据订单编号 -- orderId
	public Ordersend getOrderById(String orderId){
		
		return (Ordersend) getSession().get(Ordersend.class, orderId);
	}
	
	//获取此服务商类型的未派送订单信息 --scId
	public List<Ordersend> getNoSendById(Integer scId){
		
		String hql = "from Ordersend o where o.servicecompany.scId = ?  and o.orderStatus ='未派送' ";
		return getSession().createQuery(hql).setInteger(0, scId).list();				
	}
	
	//获取此服务商类型的派送中订单信息 --scId
	public List<Ordersend> getSendNowById(Integer scId){
		
		String hql = "from Ordersend o where o.servicecompany.scId = ?  and o.orderStatus ='正派送' ";
		return getSession().createQuery(hql).setInteger(0, scId).list();
	}
	
	//获取此服务商类型的已送达订单信息 --scId
	public List<Ordersend> getSendReadyById(Integer scId){
		
		String hql = "from Ordersend o where o.servicecompany.scId = ?  and o.orderStatus ='已送达' ";
		return getSession().createQuery(hql).setInteger(0, scId).list();
	}
	
	//配送员**********************************************************************
	//获取此服务商的配送员的未派送订单信息 --scId senderId
	public List<Ordersend> getNoSendBySenderId(Integer scId,Integer senderId){
		
		String hql = "from Ordersend o where o.servicecompany.scId = ? and o.sender.senderId = ?  and o.orderStatus ='未派送'  ";
		return getSession().createQuery(hql).setInteger(0, scId).setInteger(1, senderId).list();
	}
	
	//获取此服务商的配送员的正在派送订单信息 --scId senderId
	public List<Ordersend> getsendNowBySenderId(Integer scId,Integer senderId){
		
		String hql = "from Ordersend o where o.servicecompany.scId = ? and o.sender.senderId = ?  and o.orderStatus ='正派送'  ";
		return getSession().createQuery(hql).setInteger(0, scId).setInteger(1, senderId).list();
	}
	
	//获取此服务商的配送员的已派送订单信息 --scId senderId
	public List<Ordersend> getsendReadyBySenderId(Integer scId,Integer senderId){
		
		String hql = "from Ordersend o where o.servicecompany.scId = ? and o.sender.senderId = ?  and o.orderStatus ='已送达'  ";
		return getSession().createQuery(hql).setInteger(0, scId).setInteger(1, senderId).list();
	}
	
	//获取此服务商的配送员的已评价订单信息 --scId senderId
	public List<Ordersend> getsendJudgeBySenderId(Integer scId,Integer senderId){
		
		String hql = "from Ordersend o where o.servicecompany.scId = ? and o.sender.senderId = ?  and o.orderStatus ='已评价'  ";
		return getSession().createQuery(hql).setInteger(0, scId).setInteger(1, senderId).list();
	}
}
