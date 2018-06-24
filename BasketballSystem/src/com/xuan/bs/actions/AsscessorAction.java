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
import com.xuan.bs.entities.Asscessor;
import com.xuan.bs.entities.PlayerBasic;
import com.xuan.bs.service.AsscessorService;

public class AsscessorAction extends ActionSupport implements RequestAware,SessionAware,
ModelDriven<Asscessor>, Preparable{
	
	private static final long serialVersionUID = 1L;
	
	//连接service****************************************************************
	private AsscessorService asscessorService;
	
	public void setAsscessorService(AsscessorService asscessorService) {
		this.asscessorService = asscessorService;
	}
	
	
	//获取传值
	private Integer asscessorJudge; //用于判断是否存在基础信息并且存储id信息
	public void setAsscessorJudge(Integer asscessorJudge) {
		this.asscessorJudge = asscessorJudge;
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
	public String asscessorInfoAdd(){
		
		List<Asscessor> getAll = asscessorService.getAllByUserId(getSessionId());
		if (getAll.size()>0) {
			session.put("asscessorId", asscessorService.getAllByUserId(getSessionId()).get(0).getAsscessorId());
			asscessorJudge = asscessorService.getAllByUserId(getSessionId()).get(0).getAsscessorId();
			request.put("asscessor", asscessorService.getAllByUserId(getSessionId()));
		}
		else{
			
			session.put("asscessorId", null);
			asscessorJudge = null;
		}
		return "asscessorInfoAdd";
	}
	
	//保存添加的信息
	public String addSave(){
		
		asscessorService.saveOrUpdate(model);
		return SUCCESS;
	}
	
	public void prepareAddSave(){
		
		if (asscessorJudge == null) {
			model = new Asscessor();
		}
		else{
			model = asscessorService.get(asscessorJudge);//若已填写 获取此Id
		}
		
		
	} 
	
	//编辑信息*****************************************************************
	public String asscessorInfoEdit(){
		
		System.out.println("信息为："+model);
		return "asscessorInfoEdit";
	}
	
	public void prepareAsscessorInfoEdit(){
		
		if(asscessorJudge != null){
			
			model = asscessorService.get(asscessorJudge);
		}
	}
			
	//保存编辑信息
	public String editSave(){
//				System.out.println("信息为："+model);
		asscessorService.saveOrUpdate(model);
		return "editSave";
	}
	
	public void prepareEditSave() {
		// TODO Auto-generated method stub
		model = asscessorService.get(asscessorJudge);
	}
	
	
	
	
	
	//接口方法
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	private Asscessor model;
	@Override
	public Asscessor getModel() {
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
