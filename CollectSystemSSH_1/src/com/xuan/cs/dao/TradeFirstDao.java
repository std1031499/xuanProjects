package com.xuan.cs.dao;

import java.util.List;

import com.xuan.cs.entities.TradeFirst;

public class TradeFirstDao extends BaseDao{
	
	//显示TradeFirst
	public List<TradeFirst> getAll(){
		String hql = "from TradeFirst";
		return getSession().createQuery(hql).list();
	}
	
	//三级联动显示TradeSecond信息
	public List<TradeFirst> getSecondTrade(String tradeFirstId){
		
		String hql = "from TradeSecond s where s.tradeSecondId like '"+tradeFirstId+"%' ";
		return getSession().createQuery(hql).list();
	}
	
	public List<TradeFirst> getTradeFirst(String tradeFirstId){
		String hql = "from TradeFirst f where f.tradeFirstId = ?";
		System.out.println(hql+"s3");
		return getSession().createQuery(hql).setString(0, tradeFirstId).list();
	}
}
