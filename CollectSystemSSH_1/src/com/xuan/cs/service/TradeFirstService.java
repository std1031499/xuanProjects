package com.xuan.cs.service;

import java.util.List;

import com.xuan.cs.dao.TradeFirstDao;
import com.xuan.cs.entities.TradeFirst;

public class TradeFirstService {
	
	private TradeFirstDao tradeFirstDao;
	
	public void setTradeFirstDao(TradeFirstDao tradeFirstDao) {
		this.tradeFirstDao = tradeFirstDao;
	}
	
	//显示tradeFirst的信息
	public List<TradeFirst> getAll(){
		
		return tradeFirstDao.getAll();
	}
	
	//三级联动显示TradeSecond信息
	public List<TradeFirst> getSecondTrade(String tradeFirstId){
		
		return tradeFirstDao.getSecondTrade(tradeFirstId);
	}
	
	public List<TradeFirst> getTradeFirst(String tradeFirstId){
		//System.out.println(tradeFirstDao.getTradeFirst(tradeFirstId)+"s4");
		return tradeFirstDao.getTradeFirst(tradeFirstId);
	}
}
