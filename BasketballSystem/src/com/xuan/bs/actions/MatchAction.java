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
	
	//连接service****************************************************************
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
	
	//获取传值*********************************************************************

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
	
	//public 类型
	public InputStream getInputStream(){
		return inputStream;
	}
	
	//获取session ID
	public Integer getSessionId(){
		
		//获取Session中的userId
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer user_Id = new Integer(u_Id.toString());
		
		return user_Id;
	}
	//举办赛事*********************************************************************
	public String matchAdd(){
		
		model = new OrgMatch();
		//获取asscessorIdS
		List<Organizer> org = organizerService.getAllByUserId(getSessionId());
		Integer organizerId = org.get(0).getOrganizerId();
		session.put("organizerId", organizerId);
		
		return "matchAdd";
	}
	
	
	public String matchAddSave(){
		        
		System.out.println("model:"+model);
		model.setOrgMatchState("进行中");
		matchService.saveOrUpdate(model); 
		return "matchAddSave";
	}
	
	public void prepareMatchAddSave(){
		
		model = new OrgMatch();
	}
	
	
	//赛事管理*********************************************************************
	public String matchManageIng(){
		
		//获取OrganizerId
		List<Organizer> getId = organizerService.getAllByUserId(getSessionId());
		Integer orgId = getId.get(0).getOrganizerId();
		//获取赛事信息 进行中状态
		List<OrgMatch> getValue = matchService.getAllByOrgIdAndState(orgId, "进行中");
		
		request.put("matchManageInfo", getValue);
		
		return "matchManageIng";
	}
	
	public String matchManageDone(){
		
		//获取OrganizerId
		List<Organizer> getId = organizerService.getAllByUserId(getSessionId());
		Integer orgId = getId.get(0).getOrganizerId();
		//获取赛事信息 进行中状态
		List<OrgMatch> getValue = matchService.getAllByOrgIdAndState(orgId, "已完成");
		
		request.put("matchManageInfo", getValue);
				
		return "matchManageDone";
	}
	
	//结束赛事
	public String endMatchInfo() throws JsonGenerationException, JsonMappingException, IOException{
		
		OrgMatch matchInfo = matchService.getAllByOrgMatchId(matchInfoId).get(0);
		Map<String,Object> map = new HashMap<String,Object>();
		
		try {
			matchInfo.setOrgMatchState("已完成");
			matchService.saveOrUpdate(matchInfo);
			map.put("state",1);
		} catch (Exception e) {
			// TODO: handle exception
			map.put("state",0);
		}
		
		//将Map数组转化为Json数组
		ObjectMapper mapper=new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		
		//将Json数组返回到前台
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");//格式
		PrintWriter out = response.getWriter();
		out.print(json);
		
		return null;
	}
	
	//显示赛事信息
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
		
		//将Map数组转化为Json数组
		ObjectMapper mapper=new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		
		//将Json数组返回到前台
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");//格式
		PrintWriter out = response.getWriter();
		out.print(json);
		
		return null;
	}
	
	//删除赛事信息
	public String deleteMatchInfo() throws JsonGenerationException, JsonMappingException, IOException{
		
		Map<String,Object> map=new HashMap<String,Object>();
		try{
			matchService.deleteByOrgMatchId(matchInfoId);
			map.put("state", 1);
		}catch (Exception e) {
			// TODO: handle exception
			map.put("state", 0);
		}
		//将Map数组转化为Json数组
		ObjectMapper mapper=new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		
		//将Json数组返回到前台
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");//格式
		PrintWriter out = response.getWriter();
		out.print(json);
		
		return null;
	}
	
	//编辑赛事
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
		//将Map数组转化为Json数组
		ObjectMapper mapper=new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		
		//将Json数组返回到前台
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");//格式
		PrintWriter out = response.getWriter();
		out.print(json);
		
		return null;
	}
	
	//保存编辑赛事
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
	
	//赛事公告信息*******************************************************************
	public String matchShow(){
		
		List<OrgMatch> getAll = matchService.getAllByState("已完成");
		
		request.put("allMatch", getAll);
		
		return "matchShow";
	}
	
	//报名信息*********************************************************************
	//查看可报名的赛事
	public String matchSignUp(){
		
		List<OrgMatch> getValue = matchService.getAllByState("进行中");
		request.put("matchInfoSign", getValue);
		
		return "matchSignUp";
	}
	
	//保存报名信息
	public String saveSignUpInfo() throws UnsupportedEncodingException{
			
			List<PlayerMatch> getValue = playerMatchService.getAllById(getSessionId(), orgMatchIdSign);
			if(getValue.size()>0){//若已参加这个赛事
				
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			}
			else{
				
				PlayerMatch playerMatch = new PlayerMatch();
				playerMatch.setPlayMatchState("未审核");
				
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
	
	//查看报名信息
	public String showSignUp(){
		
		List<PlayerMatch> getValue = playerMatchService.getSignUpInfo(getSessionId());
//		System.out.println(getValue.get(arg0));
		request.put("signUpInfo", getValue);
		return "showSignUp";
	}
	
	//球员信息审核*******************************************************************
	public String playerAudit(){
		
		
//		List<OrgMatch> getValue = matchService.getAllByState("进行中");
//		request.put("matchInfoAudit", getValue);//显示赛事名称
		
		List<PlayerMatch> getInfo = playerMatchService.getAllByState("未审核");
		request.put("playerAuditInfo", getInfo);
		
//		session.put("selectJudge", true);
		
		return "playerAudit";
	}
	
	
	//选择审核
	/*public String selectAudit(){
		
		List<PlayerMatch> getValue = playerMatchService.getAllByStateAndOrgMatchId("未审核", orgMatchIdAudit);
		
		session.put("selectJudge", false);
		request.put("playerAuditSelect", getValue);
		
		return "selectAudit";
	
	}*/
	
	//显示球员详细信息
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
		
		//将Json数组返回到前台
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");//格式
		PrintWriter out = response.getWriter();
		out.print(json);
		
		return null;
	}
	
	//审核通过
	public String setAuditPass() throws JsonGenerationException, JsonMappingException, IOException{
		
		PlayerMatch playerMatch = playerMatchService.getAllById(playerId, auditOrgId).get(0);
		Map<String, Object> map = new HashMap<String, Object>();
		playerMatch.setPlayMatchState("已通过");
		try {
			playerMatchService.saveOrUpdate(playerMatch);
			map.put("pass", 1);
		} catch (Exception e) {
			// TODO: handle exception
			map.put("pass", 0);
		}
		
		ObjectMapper mapper=new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		
		//将Json数组返回到前台
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");//格式
		PrintWriter out = response.getWriter();
		out.print(json);
		
		return null;
		
		
	}
	
	//审核退回
	public String setAuditReturn() throws JsonGenerationException, JsonMappingException, IOException{
		
		PlayerMatch playerMatch = playerMatchService.getAllById(playerId, auditOrgId).get(0);
		Map<String, Object> map = new HashMap<String, Object>();
		playerMatch.setPlayMatchState("已退回");
		try {
			playerMatchService.saveOrUpdate(playerMatch);
			map.put("pass", 1);
		} catch (Exception e) {
			// TODO: handle exception
			map.put("pass", 0);
		}
		
		ObjectMapper mapper=new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		
		//将Json数组返回到前台
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");//格式
		PrintWriter out = response.getWriter();
		out.print(json);
		
		return null;
		
		
	}
	
	//接口方法
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
