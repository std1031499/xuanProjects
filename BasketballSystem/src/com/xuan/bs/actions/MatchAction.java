package com.xuan.bs.actions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.xuan.bs.entities.OrgMatch;
import com.xuan.bs.entities.Organizer;
import com.xuan.bs.entities.PlayerBasic;
import com.xuan.bs.entities.PlayerMatch;
import com.xuan.bs.entities.Users;
import com.xuan.bs.service.OrganizerService;
import com.xuan.bs.service.MatchService;
import com.xuan.bs.service.PlayerMatchService;
import com.xuan.bs.service.PlayerService;


public class MatchAction extends ActionSupport implements RequestAware,SessionAware,
ModelDriven<OrgMatch>, Preparable{
	
private static final long serialVersionUID = 1L;
	
	//����service****************************************************************
	private MatchService matchService;
	
	public void setMatchService(MatchService matchService) {
		this.matchService = matchService;
	}
	
	private OrganizerService organizerService;
	
	public void setOrganizerService(OrganizerService organizerService) {
		this.organizerService = organizerService;
	}
	
	private PlayerMatchService playerMatchService;
	public void setPlayerMatchService(PlayerMatchService playerMatchService) {
		this.playerMatchService = playerMatchService;
	}
	
	private PlayerService playerService;
	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}
	
	//��ȡ��ֵ*********************************************************************

	private Integer matchInfoId;
	public void setMatchInfoId(Integer matchInfoId) {
		this.matchInfoId = matchInfoId;
	}
	
	private Integer editOrgMatchId;
	public void setEditOrgMatchId(Integer editOrgMatchId) {
		this.editOrgMatchId = editOrgMatchId;
	}
	
	private String editMatchName;
	public void setEditMatchName(String editMatchName) {
		this.editMatchName = editMatchName;
	}
	
	private String editMatchTime;
	public void setEditMatchTime(String editMatchTime) {
		this.editMatchTime = editMatchTime;
	}
	
	private String editMatchIntroduction;
	public void setEditMatchIntroduction(String editMatchIntroduction) {
		this.editMatchIntroduction = editMatchIntroduction;
	}
	
	private String editMatchRule;
	public void setEditMatchRule(String editMatchRule) {
		this.editMatchRule = editMatchRule;
	}
	
	private String editMatchMap;
	public void setEditMatchMap(String editMatchMap) {
		this.editMatchMap = editMatchMap;
	}
	
	private String editMatchPosition;
	public void setEditMatchPosition(String editMatchPosition) {
		this.editMatchPosition = editMatchPosition;
	}
	
	private String editMatchJudge;
	public void setEditMatchJudge(String editMatchJudge) {
		this.editMatchJudge = editMatchJudge;
	}
	
	private Integer orgMatchIdSign;
	public void setOrgMatchIdSign(Integer orgMatchIdSign) {
		this.orgMatchIdSign = orgMatchIdSign;
	}
	
	private Integer orgMatchIdAudit;
	public void setOrgMatchIdAudit(Integer orgMatchIdAudit) {
		this.orgMatchIdAudit = orgMatchIdAudit;
	}
	
	private Integer playerId;
	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}
	
	private Integer auditOrgId;
	public void setAuditOrgId(Integer auditOrgId) {
		this.auditOrgId = auditOrgId;
	}
	
	//InputStream
	private InputStream inputStream;
	
	//public ����
	public InputStream getInputStream(){
		return inputStream;
	}
	
	//��ȡsession ID
	public Integer getSessionId(){
		
		//��ȡSession�е�userId
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer user_Id = new Integer(u_Id.toString());
		
		return user_Id;
	}
	//�ٰ�����*********************************************************************
	public String matchAdd(){
		
		model = new OrgMatch();
		//��ȡasscessorIdS
		List<Organizer> org = organizerService.getAllByUserId(getSessionId());
		Integer organizerId = org.get(0).getOrganizerId();
		session.put("organizerId", organizerId);
		
		return "matchAdd";
	}
	
	
	public String matchAddSave(){
		        
		System.out.println("model:"+model);
		model.setOrgMatchState("������");
		matchService.saveOrUpdate(model); 
		return "matchAddSave";
	}
	
	public void prepareMatchAddSave(){
		
		model = new OrgMatch();
	}
	
	
	//���¹���*********************************************************************
	public String matchManageIng(){
		
		//��ȡOrganizerId
		List<Organizer> getId = organizerService.getAllByUserId(getSessionId());
		Integer orgId = getId.get(0).getOrganizerId();
		//��ȡ������Ϣ ������״̬
		List<OrgMatch> getValue = matchService.getAllByOrgIdAndState(orgId, "������");
		
		request.put("matchManageInfo", getValue);
		
		return "matchManageIng";
	}
	
	public String matchManageDone(){
		
		//��ȡOrganizerId
		List<Organizer> getId = organizerService.getAllByUserId(getSessionId());
		Integer orgId = getId.get(0).getOrganizerId();
		//��ȡ������Ϣ ������״̬
		List<OrgMatch> getValue = matchService.getAllByOrgIdAndState(orgId, "�����");
		
		request.put("matchManageInfo", getValue);
				
		return "matchManageDone";
	}
	
	//��������
	public String endMatchInfo() throws JsonGenerationException, JsonMappingException, IOException{
		
		OrgMatch matchInfo = matchService.getAllByOrgMatchId(matchInfoId).get(0);
		Map<String,Object> map = new HashMap<String,Object>();
		
		try {
			matchInfo.setOrgMatchState("�����");
			matchService.saveOrUpdate(matchInfo);
			map.put("state",1);
		} catch (Exception e) {
			// TODO: handle exception
			map.put("state",0);
		}
		
		//��Map����ת��ΪJson����
		ObjectMapper mapper=new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		
		//��Json���鷵�ص�ǰ̨
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");//��ʽ
		PrintWriter out = response.getWriter();
		out.print(json);
		
		return null;
	}
	
	//��ʾ������Ϣ
	public String getMatchInfo() throws JsonGenerationException, JsonMappingException, IOException{
		
		List<OrgMatch> matchInfo = matchService.getAllByOrgMatchId(matchInfoId);
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("orgMatchName", matchInfo.get(0).getOrgMatchName());
		map.put("orgMatchTime", matchInfo.get(0).getOrgMatchTime());
		map.put("orgMatchIntroduction", matchInfo.get(0).getOrgMatchIntroduction());
		map.put("orgMatchRule", matchInfo.get(0).getOrgMatchRule());
		map.put("orgMatchMap", matchInfo.get(0).getOrgMatchMap());
		map.put("orgMatchPosition", matchInfo.get(0).getOrgMatchPosition());
		map.put("orgMatchJudge", matchInfo.get(0).getOrgMatchJudge());
		
		//��Map����ת��ΪJson����
		ObjectMapper mapper=new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		
		//��Json���鷵�ص�ǰ̨
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");//��ʽ
		PrintWriter out = response.getWriter();
		out.print(json);
		
		return null;
	}
	
	//ɾ��������Ϣ
	public String deleteMatchInfo() throws JsonGenerationException, JsonMappingException, IOException{
		
		Map<String,Object> map=new HashMap<String,Object>();
		try{
			matchService.deleteByOrgMatchId(matchInfoId);
			map.put("state", 1);
		}catch (Exception e) {
			// TODO: handle exception
			map.put("state", 0);
		}
		//��Map����ת��ΪJson����
		ObjectMapper mapper=new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		
		//��Json���鷵�ص�ǰ̨
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");//��ʽ
		PrintWriter out = response.getWriter();
		out.print(json);
		
		return null;
	}
	
	//�༭����
	public String editMatchInfo() throws JsonGenerationException, JsonMappingException, IOException{
		
		List<OrgMatch> matchInfo = matchService.getAllByOrgMatchId(matchInfoId);
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("orgMatchName", matchInfo.get(0).getOrgMatchName());
		map.put("orgMatchTime", matchInfo.get(0).getOrgMatchTime());
		map.put("orgMatchIntroduction", matchInfo.get(0).getOrgMatchIntroduction());
		map.put("orgMatchRule", matchInfo.get(0).getOrgMatchRule());
		map.put("orgMatchMap", matchInfo.get(0).getOrgMatchMap());
		map.put("orgMatchPosition", matchInfo.get(0).getOrgMatchPosition());
		map.put("orgMatchJudge", matchInfo.get(0).getOrgMatchJudge());
		map.put("orgMatchId", matchInfo.get(0).getOrgMatchId());
		//��Map����ת��ΪJson����
		ObjectMapper mapper=new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		
		//��Json���鷵�ص�ǰ̨
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");//��ʽ
		PrintWriter out = response.getWriter();
		out.print(json);
		
		return null;
	}
	
	//����༭����
	public String saveMatchInfo(){
		
		OrgMatch matchInfo = matchService.getAllByOrgMatchId(editOrgMatchId).get(0);
		
		matchInfo.setOrgMatchIntroduction(editMatchIntroduction);
		matchInfo.setOrgMatchJudge(editMatchJudge);
		matchInfo.setOrgMatchMap(editMatchMap);
		matchInfo.setOrgMatchName(editMatchName);
		matchInfo.setOrgMatchPosition(editMatchPosition);
		matchInfo.setOrgMatchPosition(editMatchPosition);
		matchInfo.setOrgMatchRule(editMatchRule);
		matchInfo.setOrgMatchTime(editMatchTime);
		
		try {
			matchService.saveOrUpdate(matchInfo);
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
	
	//���¹�����Ϣ*******************************************************************
	public String matchShow(){
		
		List<OrgMatch> getAll = matchService.getAllByState("�����");
		
		request.put("allMatch", getAll);
		
		return "matchShow";
	}
	
	//������Ϣ*********************************************************************
	//�鿴�ɱ���������
	public String matchSignUp(){
		
		List<OrgMatch> getValue = matchService.getAllByState("������");
		request.put("matchInfoSign", getValue);
		
		return "matchSignUp";
	}
	
	//���汨����Ϣ
	public String saveSignUpInfo() throws UnsupportedEncodingException{
			
			List<PlayerMatch> getValue = playerMatchService.getAllById(getSessionId(), orgMatchIdSign);
			if(getValue.size()>0){//���Ѳμ��������
				
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			}
			else{
				
				PlayerMatch playerMatch = new PlayerMatch();
				playerMatch.setPlayMatchState("δ���");
				
				Users users = new Users();
				users.setUserId(getSessionId());
				playerMatch.setUsers(users);
				
				OrgMatch orgMatch = new OrgMatch();
				orgMatch.setOrgMatchId(orgMatchIdSign);
				playerMatch.setOrgMatch(orgMatch);
				
				playerMatchService.saveOrUpdate(playerMatch);
				
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			}

		return "ajax-success";
		
	}
	
	//�鿴������Ϣ
	public String showSignUp(){
		
		List<PlayerMatch> getValue = playerMatchService.getSignUpInfo(getSessionId());
//		System.out.println(getValue.get(arg0));
		request.put("signUpInfo", getValue);
		return "showSignUp";
	}
	
	//��Ա��Ϣ���*******************************************************************
	public String playerAudit(){
		
		
//		List<OrgMatch> getValue = matchService.getAllByState("������");
//		request.put("matchInfoAudit", getValue);//��ʾ��������
		
		List<PlayerMatch> getInfo = playerMatchService.getAllByState("δ���");
		request.put("playerAuditInfo", getInfo);
		
//		session.put("selectJudge", true);
		
		return "playerAudit";
	}
	
	
	//ѡ�����
	/*public String selectAudit(){
		
		List<PlayerMatch> getValue = playerMatchService.getAllByStateAndOrgMatchId("δ���", orgMatchIdAudit);
		
		session.put("selectJudge", false);
		request.put("playerAuditSelect", getValue);
		
		return "selectAudit";
	
	}*/
	
	//��ʾ��Ա��ϸ��Ϣ
	public String getPlayerInfo() throws JsonGenerationException, JsonMappingException, IOException{
		
		List<PlayerBasic> getValue = playerService.getAllByUserId(playerId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("playerName", getValue.get(0).getPlayerName());
		map.put("playerHeight", getValue.get(0).getPlayerHeight());
		map.put("playerSex", getValue.get(0).getPlayerSex());
		map.put("playerAge", getValue.get(0).getPlayerAge());
		map.put("playerPhone", getValue.get(0).getPlayerPhone());
		map.put("playerIdentity", getValue.get(0).getPlayerIdentity());
		map.put("playerAddress", getValue.get(0).getPlayerAddress());
		map.put("playerPosition", getValue.get(0).getPlayerPosition());
		
		ObjectMapper mapper=new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		
		//��Json���鷵�ص�ǰ̨
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");//��ʽ
		PrintWriter out = response.getWriter();
		out.print(json);
		
		return null;
	}
	
	//���ͨ��
	public String setAuditPass() throws JsonGenerationException, JsonMappingException, IOException{
		
		PlayerMatch playerMatch = playerMatchService.getAllById(playerId, auditOrgId).get(0);
		Map<String, Object> map = new HashMap<String, Object>();
		playerMatch.setPlayMatchState("��ͨ��");
		try {
			playerMatchService.saveOrUpdate(playerMatch);
			map.put("pass", 1);
		} catch (Exception e) {
			// TODO: handle exception
			map.put("pass", 0);
		}
		
		ObjectMapper mapper=new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		
		//��Json���鷵�ص�ǰ̨
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");//��ʽ
		PrintWriter out = response.getWriter();
		out.print(json);
		
		return null;
		
		
	}
	
	//����˻�
	public String setAuditReturn() throws JsonGenerationException, JsonMappingException, IOException{
		
		PlayerMatch playerMatch = playerMatchService.getAllById(playerId, auditOrgId).get(0);
		Map<String, Object> map = new HashMap<String, Object>();
		playerMatch.setPlayMatchState("���˻�");
		try {
			playerMatchService.saveOrUpdate(playerMatch);
			map.put("pass", 1);
		} catch (Exception e) {
			// TODO: handle exception
			map.put("pass", 0);
		}
		
		ObjectMapper mapper=new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		
		//��Json���鷵�ص�ǰ̨
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");//��ʽ
		PrintWriter out = response.getWriter();
		out.print(json);
		
		return null;
		
		
	}
	
	//�ӿڷ���
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	} 
	
	private OrgMatch model;

	@Override
	public OrgMatch getModel() {
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
