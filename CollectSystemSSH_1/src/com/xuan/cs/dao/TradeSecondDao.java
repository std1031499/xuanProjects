package com.xuan.cs.dao;

import java.util.List;

import com.xuan.cs.entities.TradeSecond;

public class TradeSecondDao extends BaseDao {
	
	//三级联动显示TradeThird信息
	public List<TradeSecond> getThirdTrade(String tradeSecondId){
		
		String hql = "from TradeThird t where t.tradeThirdId like '"+tradeSecondId+"%' ";
		return getSession().createQuery(hql).list();
	}
	
	public List<TradeSecond> getTradeSecond(String tradeSecondId){
		String hql = "from TradeSecond s where s.tradeSecondId = ?";
		return getSession().createQuery(hql).setString(0, tradeSecondId).list();
	}
	
	//显示tradeSecond
	public List<TradeSecond> getAll(){
		
		String hql = "from TradeSecond";
		return getSession().createQuery(hql).list();
	}
}
