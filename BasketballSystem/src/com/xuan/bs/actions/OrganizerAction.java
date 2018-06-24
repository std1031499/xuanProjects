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
	
	//����service****************************************************************
	private OrganizerService organizerService;
	
	public void setOrganizerService(OrganizerService organizerService) {
		this.organizerService = organizerService;
	}
	
	
	//��ȡ��ֵ
	private Integer organizerJudge; //�����ж��Ƿ���ڻ�����Ϣ���Ҵ洢id��Ϣ
	public void setOrganizerJudge(Integer organizerJudge) {
		this.organizerJudge = organizerJudge;
	}

	//��ת
	
	
	
	//��ȡsession ID
	public Integer getSessionId(){
		
		//��ȡSession�е�userId
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer user_Id = new Integer(u_Id.toString());
		
		return user_Id;
	}
	
	//����޸ľٰ�Ա��Ϣ****************************************************************
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
	
	//������ӵ���Ϣ
	public String addSave(){
		
		organizerService.saveOrUpdate(model);
		return SUCCESS;
	}
	
	public void prepareAddSave(){
		
		if (organizerJudge == null) {
			model = new Organizer();
		}
		else{
			model = organizerService.get(organizerJudge);//������д ��ȡ��Id
		}
		
		
	} 
	
	//�༭��Ϣ*****************************************************************
	public String organizerInfoEdit(){
		
		System.out.println("��ϢΪ��"+model);
		return "asscessorInfoEdit";
	}
	
	public void prepareOrganizerInfoEdit(){
		
		if(organizerJudge != null){
			
			model = organizerService.get(organizerJudge);
		}
	}
			
	//����༭��Ϣ
	public String editSave(){
//				System.out.println("��ϢΪ��"+model);
		organizerService.saveOrUpdate(model);
		return "editSave";
	}
	
	public void prepareEditSave() {
		// TODO Auto-generated method stub
		model = organizerService.get(organizerJudge); 
	}
	


	
	//�ӿڷ���
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
