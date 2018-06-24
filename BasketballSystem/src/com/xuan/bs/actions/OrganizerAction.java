package com.xuan.bs.actions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.xuan.bs.entities.Organizer;
import com.xuan.bs.service.OrganizerService;

public class OrganizerAction extends ActionSupport implements RequestAware,SessionAware,
ModelDriven<Organizer>, Preparable{
	
	private static final long serialVersionUID = 1L;
	
	//连接service****************************************************************
	private OrganizerService organizerService;
	
	public void setOrganizerService(OrganizerService organizerService) {
		this.organizerService = organizerService;
	}
	
	
	//获取传值
	private Integer organizerJudge; //用于判断是否存在基础信息并且存储id信息
	public void setOrganizerJudge(Integer organizerJudge) {
		this.organizerJudge = organizerJudge;
	}

	//跳转
	
	
	
	//获取session ID
	public Integer getSessionId(){
		
		//获取Session中的userId
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer user_Id = new Integer(u_Id.toString());
		
		return user_Id;
	}
	
	//添加修改举办员信息****************************************************************
	public String organizerInfoAdd(){
		
		List<Organizer> getAll = organizerService.getAllByUserId(getSessionId());
		if (getAll.size()>0) {
			session.put("organizerId", organizerService.getAllByUserId(getSessionId()).get(0).getOrganizerId());
			organizerJudge = organizerService.getAllByUserId(getSessionId()).get(0).getOrganizerId();
			request.put("organizer", organizerService.getAllByUserId(getSessionId()));
		}
		else{
			
			session.put("organizerId", null);
			organizerJudge = null;
		}
		return "asscessorInfoAdd";
	}
	
	//保存添加的信息
	public String addSave(){
		
		organizerService.saveOrUpdate(model);
		return SUCCESS;
	}
	
	public void prepareAddSave(){
		
		if (organizerJudge == null) {
			model = new Organizer();
		}
		else{
			model = organizerService.get(organizerJudge);//若已填写 获取此Id
		}
		
		
	} 
	
	//编辑信息*****************************************************************
	public String organizerInfoEdit(){
		
		System.out.println("信息为："+model);
		return "asscessorInfoEdit";
	}
	
	public void prepareOrganizerInfoEdit(){
		
		if(organizerJudge != null){
			
			model = organizerService.get(organizerJudge);
		}
	}
			
	//保存编辑信息
	public String editSave(){
//				System.out.println("信息为："+model);
		organizerService.saveOrUpdate(model);
		return "editSave";
	}
	
	public void prepareEditSave() {
		// TODO Auto-generated method stub
		model = organizerService.get(organizerJudge); 
	}
	


	
	//接口方法
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	private Organizer model;
	@Override
	public Organizer getModel() {
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
