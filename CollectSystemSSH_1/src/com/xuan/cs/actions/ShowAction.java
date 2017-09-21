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

	// 连接service****************************************************************
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

	// 获取值**********************************************************************
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
	
	//高级查询传值开始
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
	//高级查询传值结束

	// 跳转
	public String search() {

		return "search";
	}
	
	
	
	
	

	// 查询信息条件   简单查询******************************************************************
	public String select() {
		//System.out.println("q1"+selectInfo);
		//判断标引条件
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

	//查看所有信息*******************************************************************
	public String check(){
		//获取session中的user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("user_Id");
		user_IdB = new Integer(u_Id.toString());
		
		user_IdS = user_IdB;
		
		request.put("getBasicInfos", showService.getAllBasic(user_IdB));
		request.put("getSkillInfos", showService.getSkillById(user_IdS, skill_Id));
			return "check";
		}
	
	//查看信息条件 --高级查询************************************************************
	public String searchComplex(){
		
		return "searchComplex";
	}
	
	public String selectComplex(){
		//System.out.println(user_IdS+selectTypes+selectInputsType+"kk");
		System.out.println(selectTypes+"s1"+selectInputsType+"s2"+includeOrNot+"s3"+ selectInputsInclude+"s4"+ exactOrNot+"s5"+ selectAnother);
		
		request.put("selectSkillHigh", showService.getSkillByHigh(selectTypes, selectInputsType, includeOrNot, selectInputsInclude, exactOrNot, selectAnother, user_IdS));
		return "selectComplex";
	}
	
	
	
	//删除信息*********************************************************************
	private InputStream inputStream;
	
	//public 类型
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
	
	//编辑技术信息*********************************************************************
	public String edit(){
		
		//skill_Id存入session
		session.put("skill_Id", skill_Id);
		
		//request回显list trade
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
	
	//保存编辑信息*******************************************************************	
	public String editSave(){
		
		//若是基础研究 将领域行业赋值为null 若不是将学科分类赋值为null
		//System.out.println(t_Type);
		if(t_Type.equals("基础研究")){
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
	
	//显示所有待审核信息***********************************************************************
	public String auditAll(){
		//user_IdS = user_Id;
		request.put("selectSkillsAudit", showService.getAllSkillNoState("待审核"));
		return "auditAll";
	}
	
	public String audit(){
		
		//获取各个skill表中的user_Id
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
		
		//判断标引条件
		if(selectInfo.equals("1")){
			request.put("selectSkillsAudit", showService.getSkillByNameNoState(inputInfo,"待审核"));
		}
		else if(selectInfo.equals("2")){
			request.put("selectSkillsAudit", showService.getSkillByTypeNoState(inputInfo, "待审核"));
		}
		else if(selectInfo.equals("0")){
			//System.out.println("q2");
			//System.out.println(showService.getAllSkill(user_IdS)+"w1");
			request.put("selectSkillsAudit", showService.getAllSkillNoState( "待审核"));
		}
		return "auditSelect";
	}
	//通过
	public String auditPass(){
		
		model.setAuditState("已通过");
		showService.saveOrUpdate(model);
		return "auditPass";
	}
	
	public void prepareAuditPass(){
		
		model = showService.getSkill(skill_Id);
	}
	
	//不通过
	public String auditPassNo(){
		
		session.put("skill_IdPassNo", skill_Id);
		
		/*//获取session中的user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("user_Id");
		user_IdB = new Integer(u_Id.toString());
		
		user_IdS = user_IdB;*/
		
		//通过skill_Id获取user_IdS
		user_IdS = showService.getSkillByIdAudit(skill_Id).get(0).getUser_IdS();
		
		request.put("getSkillInfosPassNo", showService.getSkillById(user_IdS, skill_Id));
		System.out.println(showService.getSkillById(user_IdS, skill_Id));
		return "auditPassNo";
	}
	
	public void prepareAuditPassNo(){
		
		
	}
	
	//审核意见*********************************************************************
	public String auditInfoSave(){
		
		model.setAuditState("未通过");	
		System.out.println(auditInfomation);
		model.setAuditInfomation(auditInfomation);
		
		showService.saveOrUpdate(model);
		return "auditInfoSave";
	}
	
	public void prepareAuditInfoSave(){
		
		model =  showService.getSkill(skill_Id);
	}
	
	//显示审核意见
	public String auditInfomation(){
		
		//获取session中的user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("user_Id");
		user_IdS = new Integer(u_Id.toString());
		
		request.put("auditInfomationById",showService.getSkillById(user_IdS,skill_Id));
		return "auditInfomation";
	}
	
	//树形结构--分类检索
	public String tree(){
		
		return "tree";
	}
	
	
	
	
	// 接口方法*********************************************************************
	// struts.xml文件修改拦截器 不会调用此方法
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
