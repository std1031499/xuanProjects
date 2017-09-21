package com.xuan.ida.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.xuan.ida.entities.Manage;
import com.xuan.ida.service.ManageService;

public class ManageAction extends ActionSupport implements RequestAware,SessionAware,
ModelDriven<Manage>, Preparable{
	
	private static final long serialVersionUID = 1L;
	
	//����service****************************************************************
	private ManageService manageService;
	
	public void setManageService(ManageService manageService) {
		this.manageService = manageService;
	}
	
	//��ȡ��ֵ*********************************************************************
	public String manageUsername;
	
	public void setManageUsername(String manageUsername) {
		this.manageUsername = manageUsername;
	}
	
	public String managePassword;
	
	public void setManagePassword(String managePassword) {
		this.managePassword = managePassword;
	}
	
	public String managePasswordSure;
	
	public void setManagePasswordSure(String managePasswordSure) {
		this.managePasswordSure = managePasswordSure;
	}
	
	//��ת
	public String  top(){
		
		return "top";
	}
	
	public String leftSide(){
		
		return "leftSide";
	}
	
	public String homePage(){
		
		return "homePage";
	}
	
	//�ж��Ƿ���ϵ�¼����
	public String loginCheck(){
		
		List<Manage> getValue = manageService.loginCheck(manageUsername, managePassword);
		
		if(getValue.size()>0){
			
			return SUCCESS;
		}
		else{
			return ERROR;
		}
		
	}

	//ע���û�
	public String registerSave(){
		
		if(managePasswordSure.equals(managePassword)){
			System.out.println(model);
			manageService.saveOrUpdate(model);
		}
		
		return "registerSave";
	}
	
	public void prepareRegisterSave(){
		
		model = new Manage();
		System.out.println("hhhh");
	}
	
	
	//�ӿڷ���*********************************************************************
	
	@Override
	public void prepare() throws Exception {}
	
	private Manage model;
	
	@Override
	public Manage getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	private Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}
	
	private Map<String, Object> request;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
	
	
	
}
