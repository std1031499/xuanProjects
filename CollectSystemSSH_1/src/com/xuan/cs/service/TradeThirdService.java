package com.xuan.cs.service;

import java.util.List;

import com.xuan.cs.dao.TradeThirdDao;
import com.xuan.cs.entities.TradeThird;

public class TradeThirdService {
	
	private TradeThirdDao tradeThirdDao;
	public void setTradeThirdDao(TradeThirdDao tradeThirdDao) {
		this.tradeThirdDao = tradeThirdDao;
	}
	
	public List<TradeThird> getTradeThird(String TradeThirdId){
		
		return tradeThirdDao.getTradeThird(TradeThirdId);
	}
	
	//œ‘ ætradeThird
	public List<TradeThird> getAll(){
		
		return tradeThirdDao.getAll();
	}
}
