package com.xuan.cs.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.xuan.cs.dao.ShowDao;
import com.xuan.cs.entities.Basic;
import com.xuan.cs.entities.Skill;
import com.xuan.cs.entities.User;
import com.xuan.cs.service.ListFirstService;
import com.xuan.cs.service.ListSecondService;
import com.xuan.cs.service.ListThirdService;
import com.xuan.cs.service.ShowService;
import com.xuan.cs.service.TradeFirstService;
import com.xuan.cs.service.TradeSecondService;
import com.xuan.cs.service.TradeThirdService;

public class ShowAction extends ActionSupport implements RequestAware,
		SessionAware, ModelDriven<Skill>,Preparable {

	private static final long serialVersionUID = 1L;

	// ����service****************************************************************
	private ShowService showService;

	public void setShowService(ShowService showService) {
		this.showService = showService;
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

	// ��ȡֵ**********************************************************************
	private String inputInfo;

	public void setInputInfo(String inputInfo) {
		this.inputInfo = inputInfo;
	}

	private String selectInfo;

	public void setSelectInfo(String selectInfo) {
		this.selectInfo = selectInfo;
	}
	
	private Integer user_IdS;
	
	public void setUser_IdS(Integer user_IdS) {
		this.user_IdS = user_IdS;
	}
	
	private Integer user_IdB;
	
	public void setUser_IdB(Integer user_IdB) {
		this.user_IdB = user_IdB;
	}
	
	private Integer skill_Id;
	
	public void setSkill_Id(Integer skill_Id) {
		this.skill_Id = skill_Id;
	}
	
	private String t_Type;
	
	public void setT_Type(String t_Type) {
		this.t_Type = t_Type;
	}
	
	private Integer user_Id;
	
	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}
	
	private String auditInfomation;
	
	public void setAuditInfomation(String auditInfomation) {
		this.auditInfomation = auditInfomation;
	}
	
	//�߼���ѯ��ֵ��ʼ
	private String selectTypes[];
	
	public void setSelectTypes(String[] selectTypes) {
		this.selectTypes = selectTypes;
	}
	
	private String selectInputsType[];
	
	public void setSelectInputsType(String[] selectInputsType) {
		this.selectInputsType = selectInputsType;
	}
	
	private String includeOrNot[];
	
	public void setIncludeOrNot(String[] includeOrNot) {
		this.includeOrNot = includeOrNot;
	}
	
	private String selectInputsInclude[];
	
	public void setSelectInputsInclude(String[] selectInputsInclude) {
		this.selectInputsInclude = selectInputsInclude;
	}
	
	private String exactOrNot[];
	
	public void setExactOrNot(String[] exactOrNot) {
		this.exactOrNot = exactOrNot;
	}
	
	private String selectAnother[];
	
	public void setSelectAnother(String[] selectAnother) {
		this.selectAnother = selectAnother;
	}
	//�߼���ѯ��ֵ����

	// ��ת
	public String search() {

		return "search";
	}
	
	
	
	
	

	// ��ѯ��Ϣ����   �򵥲�ѯ******************************************************************
	public String select() {
		//System.out.println("q1"+selectInfo);
		//�жϱ�������
		if(selectInfo.equals("1")){
			request.put("selectSkills", showService.getSkillByName(inputInfo,user_IdS));
		}
		else if(selectInfo.equals("2")){
			request.put("selectSkills", showService.getSkillByType(inputInfo,user_IdS));
		}
		else if(selectInfo.equals("0")){
			//System.out.println("q2");
			//System.out.println(showService.getAllSkill(user_IdS)+"w1");
			request.put("selectSkills", showService.getAllSkill(user_IdS));
		}
		return "select";
	}

	//�鿴������Ϣ*******************************************************************
	public String check(){
		//��ȡsession�е�user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("user_Id");
		user_IdB = new Integer(u_Id.toString());
		
		user_IdS = user_IdB;
		
		request.put("getBasicInfos", showService.getAllBasic(user_IdB));
		request.put("getSkillInfos", showService.getSkillById(user_IdS, skill_Id));
			return "check";
		}
	
	//�鿴��Ϣ���� --�߼���ѯ************************************************************
	public String searchComplex(){
		
		return "searchComplex";
	}
	
	public String selectComplex(){
		//System.out.println(user_IdS+selectTypes+selectInputsType+"kk");
		System.out.println(selectTypes+"s1"+selectInputsType+"s2"+includeOrNot+"s3"+ selectInputsInclude+"s4"+ exactOrNot+"s5"+ selectAnother);
		
		request.put("selectSkillHigh", showService.getSkillByHigh(selectTypes, selectInputsType, includeOrNot, selectInputsInclude, exactOrNot, selectAnother, user_IdS));
		return "selectComplex";
	}
	
	
	
	//ɾ����Ϣ*********************************************************************
	private InputStream inputStream;
	
	//public ����
	public InputStream getInputStream(){
		return inputStream;
	}
	
	public String delete(){
		
		try {
			showService.delete(skill_Id);
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
	
	//�༭������Ϣ*********************************************************************
	public String edit(){
		
		//skill_Id����session
		session.put("skill_Id", skill_Id);
		
		//request����list trade
		request.put("listFirstsEdit", listFirstService.getAll());
		request.put("listSecondsEdit", listSecondService.getAll());
		request.put("listThirdsEdit", listThirdService.getAll());
		request.put("tradeFirstsEdit", tradeFirstService.getAll());
		request.put("tradeSecondsEdit", tradeSecondService.getAll());
		request.put("tradeThirdsEdit", tradeThirdService.getAll());
		
		return "edit";
	}
		
	public void prepareEdit(){
		
		if(skill_Id!=null){
			
			model = showService.getSkill(skill_Id);
		}
	}
	
	//����༭��Ϣ*******************************************************************	
	public String editSave(){
		
		//���ǻ����о� ��������ҵ��ֵΪnull �����ǽ�ѧ�Ʒ��ำֵΪnull
		//System.out.println(t_Type);
		if(t_Type.equals("�����о�")){
			System.out.println("hh");
			model.setT_Territory(null);
			model.setTradeFirst(null);
			model.setTradeSecond(null);
			model.setTradeThird(null);
		}
		else{
			model.setListFirst(null);
			model.setListSecond(null);
			model.setListThird(null);
		}
		
		
		showService.saveOrUpdate(model);
		return "editSave";
	}
		
	public void prepareEditSave(){
		model = showService.getSkill(skill_Id);
	}
	
	//��ʾ���д������Ϣ***********************************************************************
	public String auditAll(){
		//user_IdS = user_Id;
		request.put("selectSkillsAudit", showService.getAllSkillNoState("�����"));
		return "auditAll";
	}
	
	public String audit(){
		
		//��ȡ����skill���е�user_Id
		//System.out.println(skill_Id);
		List<Skill> getUser_Id = showService.getSkillByIdAudit(skill_Id);
		//System.out.println(getUser_Id);
		user_IdS = getUser_Id.get(0).getUser_IdS();
		user_IdB = user_IdS;
		//System.out.println(user_IdS+"sasa");
//		HttpServletRequest req = ServletActionContext.getRequest();
//		Object u_Id = req.getSession().getAttribute("user_Id");
//		user_IdB = new Integer(u_Id.toString());
//		
//		user_IdS = user_IdB;
		//System.out.println(skill_Id);
		request.put("getBasicInfos", showService.getAllBasic(user_IdB));
		request.put("getSkillInfos", showService.getSkillById(user_IdS, skill_Id));
		return "audit";
	}
	
	
	public String auditSelect(){
		
		//�жϱ�������
		if(selectInfo.equals("1")){
			request.put("selectSkillsAudit", showService.getSkillByNameNoState(inputInfo,"�����"));
		}
		else if(selectInfo.equals("2")){
			request.put("selectSkillsAudit", showService.getSkillByTypeNoState(inputInfo, "�����"));
		}
		else if(selectInfo.equals("0")){
			//System.out.println("q2");
			//System.out.println(showService.getAllSkill(user_IdS)+"w1");
			request.put("selectSkillsAudit", showService.getAllSkillNoState( "�����"));
		}
		return "auditSelect";
	}
	//ͨ��
	public String auditPass(){
		
		model.setAuditState("��ͨ��");
		showService.saveOrUpdate(model);
		return "auditPass";
	}
	
	public void prepareAuditPass(){
		
		model = showService.getSkill(skill_Id);
	}
	
	//��ͨ��
	public String auditPassNo(){
		
		session.put("skill_IdPassNo", skill_Id);
		
		/*//��ȡsession�е�user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("user_Id");
		user_IdB = new Integer(u_Id.toString());
		
		user_IdS = user_IdB;*/
		
		//ͨ��skill_Id��ȡuser_IdS
		user_IdS = showService.getSkillByIdAudit(skill_Id).get(0).getUser_IdS();
		
		request.put("getSkillInfosPassNo", showService.getSkillById(user_IdS, skill_Id));
		System.out.println(showService.getSkillById(user_IdS, skill_Id));
		return "auditPassNo";
	}
	
	public void prepareAuditPassNo(){
		
		
	}
	
	//������*********************************************************************
	public String auditInfoSave(){
		
		model.setAuditState("δͨ��");	
		System.out.println(auditInfomation);
		model.setAuditInfomation(auditInfomation);
		
		showService.saveOrUpdate(model);
		return "auditInfoSave";
	}
	
	public void prepareAuditInfoSave(){
		
		model =  showService.getSkill(skill_Id);
	}
	
	//��ʾ������
	public String auditInfomation(){
		
		//��ȡsession�е�user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("user_Id");
		user_IdS = new Integer(u_Id.toString());
		
		request.put("auditInfomationById",showService.getSkillById(user_IdS,skill_Id));
		return "auditInfomation";
	}
	
	//���νṹ--�������
	public String tree(){
		
		return "tree";
	}
	
	
	
	
	// �ӿڷ���*********************************************************************
	// struts.xml�ļ��޸������� ������ô˷���
	@Override
	public void prepare() throws Exception {
	}

	private Skill model;// skill.java

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

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

}
