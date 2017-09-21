package com.TCWL.system.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.TCWL.system.entities.Sender;
import com.TCWL.system.entities.Servicecompany;
import com.TCWL.system.services.SenderService;
import com.TCWL.system.services.ServiceCompanyService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class SenderAction extends ActionSupport implements RequestAware,SessionAware,
ModelDriven<Sender>, Preparable{
	
	private static final long serialVersionUID = 1L;
	
	//����service
	private SenderService senderService;
	
	public void setSenderService(SenderService senderService) {
		this.senderService = senderService;
	}
	
	private ServiceCompanyService serviceCompanyService;
	
	public void setServiceCompanyService(
			ServiceCompanyService serviceCompanyService) {
		this.serviceCompanyService = serviceCompanyService;
	}

	
		
	
	//��ȡ��ֵ
	private String senderName;
	
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	
	private String senderPhone;
	
	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}
	
	private Integer senderId;
	
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	
	
	//inputStream**************************************************************
	private InputStream inputStream;
	
	//public ����
	public InputStream getInputStream(){
		return inputStream;
	}
	
	
	//�������������Ա*****************************************************************
	public String addSender(){
		
		//��ȡsession�е�user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer scId = new Integer((Integer) u_Id);
				
		request.put("senderOfCompanyName", serviceCompanyService.getSCompanyInfosById(scId).getScName());
		return "addSender";
	}
	
	public String addSenderSave(){
		
		//��ȡsession�е�user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer scId = new Integer((Integer) u_Id);
				
		Servicecompany servicecompany = new Servicecompany();
		servicecompany.setScId(scId);
		model.setServicecompany(servicecompany);
		model.setSenderStatus("true");
		senderService.saveOrUpdate(model);
		
		
		
		return "addSenderSave";
	}
	
	public void  prepareAddSenderSave(){
		
		model = new Sender();
	}
	
	//��������Ա********************************************************************
	public String manageSender(){
		
		//��ȡsession�е�user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer scId = new Integer((Integer) u_Id);
		
		request.put("manageSenderInfos", senderService.getSenderInfosById(scId));
		return "manageSender";
	}
	
	//ɾ���÷����̵�����Ա --��״̬��true ��Ϊ false
	public String deleteSender(){
		
		try {

			model.setSenderStatus("false");
			senderService.saveOrUpdate(model);
			
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return "ajax-success";
	}
	
	public void prepareDeleteSender(){
		
		model = senderService.getOneSenderById(senderId);
	}
	
	//�༭����Ա��Ϣ
	public String editSender(){
		
		//request.put("senderId", senderService.getOneSenderById(senderId).getSenderId());
		return "editSender";
	}
	
	public void prepareEditSender(){
		
		model = senderService.getOneSenderById(senderId);
	}
	
	//����༭������Ա��Ϣ 
	public String editSenderSave(){
				
		senderService.saveOrUpdate(model);
		return "editSenderSave";
	}
	
	public void prepareEditSenderSave(){
		
		model = senderService.getOneSenderById(senderId);
	}
	
	
	//�ӿڷ���*********************************************************************
	public void prepare() throws Exception {}
	
	
	private Sender model;	
	
	public Sender getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
	private Map<String, Object> session;
	
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}
	
	private Map<String, Object> request;
	
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
}
