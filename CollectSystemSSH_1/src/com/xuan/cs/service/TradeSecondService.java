package com.xuan.cs.service;

import java.util.List;

import com.xuan.cs.dao.TradeSecondDao;
import com.xuan.cs.entities.TradeSecond;

public class TradeSecondService {
	
	private TradeSecondDao tradeSecondDao;
	
	public void setTradeSecondDao(TradeSecondDao tradeSecondDao) {
		this.tradeSecondDao = tradeSecondDao;
	}
	
	////����������ʾTradeThird��Ϣ
	public List<TradeSecond> getThirdTrade(String tradeSecondId){
		
		return tradeSecondDao.getThirdTrade(tradeSecondId);
	}
	
	public List<TradeSecond> getTradeSecond(String tradeSecondId){
		
		return tradeSecondDao.getTradeSecond(tradeSecondId);
	}
	
	//��ʾtradeSecond
	public List<TradeSecond> getAll(){
		
		return tradeSecondDao.getAll();
	}
}
