package com.xuan.cs.dao;

import java.util.List;

import com.xuan.cs.entities.TradeThird;

public class TradeThirdDao extends BaseDao{
	
	public List<TradeThird> getTradeThird(String TradeThirdId){
		
		String hql = "from TradeThird t where t.tradeThirdId = ?";
		return getSession().createQuery(hql).setString(0, TradeThirdId).list();
	}
	
	//œ‘ ætradeThird
	public List<TradeThird> getAll(){
		
		String hql = "from TradeThird";
		return getSession().createQuery(hql).list();
	}
}
