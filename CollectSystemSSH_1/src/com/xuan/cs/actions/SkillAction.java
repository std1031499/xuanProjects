package com.xuan.cs.actions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.xuan.cs.entities.Basic;
import com.xuan.cs.entities.ListFirst;
import com.xuan.cs.entities.ListSecond;
import com.xuan.cs.entities.ListThird;
import com.xuan.cs.entities.Skill;
import com.xuan.cs.entities.TradeFirst;
import com.xuan.cs.entities.TradeSecond;
import com.xuan.cs.entities.TradeThird;
import com.xuan.cs.service.ListFirstService;
import com.xuan.cs.service.ListSecondService;

import com.xuan.cs.service.ListThirdService;
import com.xuan.cs.service.SkillService;
import com.xuan.cs.service.TradeFirstService;
import com.xuan.cs.service.TradeSecondService;
import com.xuan.cs.service.TradeThirdService;
import com.xuan.cs.service.UserService;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class SkillAction extends ActionSupport implements RequestAware,SessionAware,
ModelDriven<Skill>, Preparable{
	
	private static final long serialVersionUID = 1L;
	
	//����service****************************************************************
	private SkillService skillService;
	
	public void setSkillService(SkillService skillService) {
		this.skillService = skillService;
	}
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private ListFirstService listFirstService;
	
	public void setListFirstService(ListFirstService listFirstService) {
		this.listFirstService = listFirstService;
	}
	
	private ListSecondService listSecondService;
	
	public void setListSecondService(ListSecondService listSecondService) {
		this.listSecondService = listSecondService;
	}
	
	private ListThirdService listThirdService;
	
	public void setListThirdService(ListThirdService listThirdService) {
		this.listThirdService = listThirdService;
	}
	
	private TradeFirstService tradeFirstService;
	
	public void setTradeFirstService(TradeFirstService tradeFirstService) {
		this.tradeFirstService = tradeFirstService;
	}
	
	private TradeSecondService tradeSecondService;
	
	public void setTradeSecondService(TradeSecondService tradeSecondService) {
		this.tradeSecondService = tradeSecondService;
	}
	
	private TradeThirdService tradeThirdService;
	
	public void setTradeThirdService(TradeThirdService tradeThirdService) {
		this.tradeThirdService = tradeThirdService;
	}
	
	
	//��ȡֵ**********************************************************************
	private String listFirstId;
	public void setListFirstId(String listFirstId) {
		this.listFirstId = listFirstId;
	}
	
	private String listSecondId;
	public void setListSecondId(String listSecondId) {
		this.listSecondId = listSecondId;
	}
	
	private String listThirdId;
	public void setListThirdId(String listThirdId) {
		this.listThirdId = listThirdId;
	}
	
	private String tradeFirstId;
	public void setTradeFirstId(String tradeFirstId) {
		this.tradeFirstId = tradeFirstId;
	}
	
	private String tradeSecondId;
	public void setTradeSecondId(String tradeSecondId) {
		this.tradeSecondId = tradeSecondId;
	}
	
	private String tradeThirdId;
	public void setTradeThirdId(String tradeThirdId) {
		this.tradeThirdId = tradeThirdId;
	}
	
	
	
	//InputStream
	private InputStream inputStream;
	
	//public ����
	public InputStream getInputStream(){
		return inputStream;
	}
	
	
	
	//��Ӽ�����Ϣ*******************************************************************
	
	public String input(){
		//��һ�������˵� request����listFirsts
		request.put("listFirsts", listFirstService.getAll());
		//��һ�������˵� request����tradeFirsts
		request.put("tradeFirsts", tradeFirstService.getAll());
		return "input";
	}
	
	public void prepareInput(){
			
	}
	
	//���νṹ--��һ��
	public String linkageFirstList() throws JsonGenerationException, JsonMappingException, IOException{
		
		try {
			List<ListFirst> listFirstResult = listFirstService.getAll();
			//System.out.println(listFirstResult+"k1");
			//����һ��json����
			ObjectMapper mapper=new ObjectMapper();
			String result=mapper.writeValueAsString(listFirstResult);
			//System.out.println(result+"kk");
			
			inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ajax-success";
	}
	
	
	//��������
	public String linkageSecondList() throws JsonGenerationException, JsonMappingException, IOException{
		
		
		
		String listFirstIdS = listFirstId.substring(0,2);
		System.out.println(listFirstIdS);
		//System.out.println(listFirstId+"z6");
		try {
			List<ListFirst> listFirstResult = listFirstService.getSecondList(listFirstIdS);
			//System.out.println(listFirstResult+"k1");
			//����һ��json����
			ObjectMapper mapper=new ObjectMapper();
			String result=mapper.writeValueAsString(listFirstResult);
			//System.out.println(result+"kk");
			
			inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ajax-success";
	}
	
	public String linkageThirdList() throws JsonGenerationException, JsonMappingException, IOException{
		
		
		 
		 String listSecondIdS = listSecondId.substring(0,5);
		
		try {			
			List<ListSecond> listSecondResult = listSecondService.getThirdList(listSecondIdS);
			//����һ��json����		
			ObjectMapper mapper=new ObjectMapper();
			String result=mapper.writeValueAsString(listSecondResult);
			//System.out.println(result);
			
			inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ajax-success";
	}
	
	public String linkageSecondTrade() throws JsonGenerationException, JsonMappingException, IOException{
			
			String tradeFirstIdS = tradeFirstId.substring(0,1);			
			
		try {
			List<TradeFirst> tradeFirstResult = tradeFirstService.getSecondTrade(tradeFirstIdS);
			//����һ��json����		
			ObjectMapper mapper=new ObjectMapper();
			String result=mapper.writeValueAsString(tradeFirstResult);
			//System.out.println(result);
			inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ajax-success";
	}
	
	public String linkageThirdTrade() throws JsonGenerationException, JsonMappingException, IOException{
		
		String tradeSecondIdS = tradeSecondId.substring(0,3);
		
		try {
			List<TradeSecond> tradeSecondResult = tradeSecondService.getThirdTrade(tradeSecondIdS);
			//����һ��json����		
			ObjectMapper mapper=new ObjectMapper();
			String result=mapper.writeValueAsString(tradeSecondResult);
			
			inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return "ajax-success";
	}
	
	//������ӵĻ�����Ϣ
	public String save(){		
		
		//ʵ�廯������ϵֵ
//		System.out.println("q1"+model.getListFirst().getListFirstId());
//		System.out.println("q2"+model.getListSecond().getListSecondId());
//		System.out.println("q3"+model.getListThird().getListThirdId());
//		System.out.println("q4"+model.getTradeFirst().getTradeFirstId());
//		System.out.println("q5"+model.getTradeSecond().getTradeSecondId());
//		System.out.println("q6"+model.getTradeThird().getTradeThirdId());				
//		ListFirst listFirst = (ListFirst) listFirstService.getListFirst(model.getListFirst().getListFirstId()).get(0);
//		model.setListFirst(listFirst);
//		
//		ListSecond listSecond = (ListSecond) listSecondService.getListSecond(model.getListSecond().getListSecondId()).get(0);
//		model.setListSecond(listSecond);
//		
//		ListThird listThird = (ListThird) listThirdService.getListThird(model.getListThird().getListThirdId()).get(0);
//		model.setListThird(listThird);
//		
//		TradeFirst tradeFirst =   tradeFirstService.getTradeFirst(model.getTradeFirst().getTradeFirstId()).get(0);
//		model.setTradeFirst(tradeFirst);
//		
//		TradeSecond tradeSecond = (TradeSecond) tradeSecondService.getTradeSecond(model.getTradeSecond().getTradeSecondId()).get(0);
//		model.setTradeSecond(tradeSecond);
//		
//		TradeThird tradeThird = (TradeThird) tradeThirdService.getTradeThird(model.getTradeThird().getTradeThirdId()).get(0);
//		model.setTradeThird(tradeThird);
				
		skillService.saveOrUpdate(model);

		return SUCCESS;
	}
	
	public void prepareSave(){
		model = new Skill();
	}
	
	
	
	
	//�ӿڷ���*********************************************************************
	//struts.xml�ļ��޸������� ������ô˷���
	@Override
	public void prepare() throws Exception {}

	private Skill model;
	
	@Override
	public Skill getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	private Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}
	
	//�̳� RequestAware
	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
	
}
