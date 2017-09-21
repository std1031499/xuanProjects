package com.xuan.cs.actions;

import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.sun.swing.internal.plaf.basic.resources.basic;
import com.xuan.cs.entities.Basic;
import com.xuan.cs.entities.Management;
import com.xuan.cs.entities.User;
import com.xuan.cs.service.AreaService;
import com.xuan.cs.service.BasicService;
import com.xuan.cs.service.ManagementService;
import com.xuan.cs.service.UserService;

public class BasicAction extends ActionSupport implements RequestAware,SessionAware,
ModelDriven<Basic>, Preparable{
	
	private static final long serialVersionUID = 1L;
	
	
	//����service****************************************************************
	private BasicService basicService;
	
	public void setBasicService(BasicService basicService) {
		this.basicService = basicService;
	}
	
	private ManagementService managementService;
	
	public void setManagementService(ManagementService managementService) {
		this.managementService = managementService;
	}
	
	private AreaService areaService;
	
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}
	
	public UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//*************************************************************************
	private Integer basic_Id;
	
	public void setBasic_Id(Integer basic_Id) {
		this.basic_Id = basic_Id;
	}
	
	
	//��ӻ�����Ϣ*******************************************************************
	public String input(){
		request.put("managements", managementService.getAll());
		request.put("areas", areaService.getAll());
		
		//��ȡsession�е�user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("user_Id");
		Integer user_Id = new Integer(u_Id.toString());
		//System.out.println(user_Id+"z2");
		
		//��ȡһ��������Ϣ��id �����ж��Ƿ���д������Ϣ
		List<Basic> getU_Id = basicService.input(user_Id);
		
		//System.out.println(getU_Id+"z3");
		
		if(getU_Id.size()>0){
			//System.out.println(getU_Id.get(0).getBasic_Id()+"z1");
			session.put("basic_Id", getU_Id.get(0).getBasic_Id());
						
			//��ʾ������			
			request.put("basics", basicService.getAll(user_Id));			
		}
		else{
			session.put("basic_Id", null);
		}			
		
		return INPUT;
	}
	
	public void prepareInput(){
				
	}
	
	//������ӵĻ�����Ϣ ***************************************************************
	public String save(){
		
		
		//System.out.println(model+"save");
		basicService.saveOrUpdate(model);//����
		
		return SUCCESS;
	}
	
	public void prepareSave(){
		
		if(basic_Id == null){
		model = new Basic();//��id Ϊnull ���û�δ��д������Ϣ ���ʼ��
			//System.out.println(model+"11zzz");
		}
		else{
			model = basicService.get(basic_Id);//������д ���ȡ��id
		}
		
	}
	
	//�༭��Ϣ*********************************************************************
	public String edit(){
		request.put("managements", managementService.getAll());
		request.put("areas", areaService.getAll());
		
		return "edit";
	}
	
	public void prepareEdit(){
		if(basic_Id!=null){
			model = basicService.get(basic_Id);
		}
	}
	
	
	//����༭��Ϣ*******************************************************************
	
	public String editSave(){
		
		
		//System.out.println(model+"k2");
		basicService.saveOrUpdate(model);
		return "editSave";
	}
	
	public void prepareEditSave(){
		model = basicService.get(basic_Id);
		System.out.println(model+"k1");
	}
	
	
	
	
	
	
	
	//�̳� RequestAware
	private Map<String, Object> request;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
	
	private Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}
	
	//struts.xml�ļ��޸������� ������ô˷���
	@Override
	public void prepare() throws Exception {}
	
	private Basic model;
	
	@Override
	public Basic getModel() {
		// TODO Auto-generated method stub
		return model;
	}



	
	
	
	
}
