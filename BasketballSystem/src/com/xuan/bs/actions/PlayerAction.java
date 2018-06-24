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
import com.xuan.bs.entities.EvaluateInfo;
import com.xuan.bs.entities.MatchInfo;
import com.xuan.bs.entities.MatchPosition;
import com.xuan.bs.entities.PlayerBasic;
import com.xuan.bs.entities.Team;
import com.xuan.bs.service.EvaluateServcie;
import com.xuan.bs.service.MainService;
import com.xuan.bs.service.MatchInfoService;
import com.xuan.bs.service.MatchService;
import com.xuan.bs.service.PlayerService;
import com.xuan.bs.service.PlayerPositionService;
import com.xuan.bs.service.TeamService;


public class PlayerAction extends ActionSupport implements RequestAware,SessionAware,
ModelDriven<PlayerBasic>, Preparable{
	
	private static final long serialVersionUID = 1L;
	
	//����service****************************************************************
		private PlayerService playerService;
		
		public void setPlayerService(PlayerService playerService) {
			this.playerService = playerService;
		}
		
		private MainService mainService;
		
		public void setMainService(MainService mainService) {
			this.mainService = mainService;
		}
		
		private PlayerPositionService playerPositionService;
		
		public void setPlayerPositionService(
				PlayerPositionService playerPositionService) {
			this.playerPositionService = playerPositionService;
		}
		
		private MatchInfoService matchInfoService;
		public void setMatchInfoService(MatchInfoService matchInfoService) {
			this.matchInfoService = matchInfoService;
		}
		
		private EvaluateServcie evaluateServcie;
		public void setEvaluateServcie(EvaluateServcie evaluateServcie) {
			this.evaluateServcie = evaluateServcie;
		}
		
		private TeamService teamService;
		public void setTeamService(TeamService teamService) {
			this.teamService = teamService;
		}
		
		
		//��ȡ��ֵ
		private String userId;
		public void setUserId(String userId) {
			this.userId = userId;
		}
		
		private Integer playerIdJudge; //�����ж��Ƿ���ڻ�����Ϣ���Ҵ洢id��Ϣ
		public void setPlayerIdJudge(Integer playerIdJudge) {
			this.playerIdJudge = playerIdJudge;
		}
		
		private Integer playerEvaluateId;
		public void setPlayerEvaluateId(Integer playerEvaluateId) {
			this.playerEvaluateId = playerEvaluateId;
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
		
		
		//����޸Ļ�����Ϣ*************************************************************					
		public String basicInfoAdd(){
			
			
//			System.out.println(user_Id+"s11");
			List<PlayerBasic> getAll = playerService.getAllByUserId(getSessionId());
			if(getAll.size()>0){
				//System.out.println("k5");
				session.put("playerId",playerService.getAllByUserId(getSessionId()).get(0).getPlayerId());
				playerIdJudge = playerService.getAllByUserId(getSessionId()).get(0).getPlayerId();
				//System.out.println(playerService.getAllByUserId(getSessionId(userId)).get(0).getPlayerId()+"k7");
				//��ʾ������Ϣ
				request.put("playerBasic", playerService.getAllByUserId(getSessionId()));
				
			}
			else {
				session.put("playerId", null);
				playerIdJudge = null;
			}
			
			return "basicInfo";
		}
		
		
		//������ӵĻ�����Ϣ
		public String addSave() {
		
			playerService.saveOrUpdate(model);
			return SUCCESS;
			
		}
		
		public void prepareAddSave(){
			
			if (playerIdJudge == null) {
				model = new PlayerBasic();
			}
			else{
				model = playerService.get(playerIdJudge);//������д ��ȡ��Id
			}
			
			
		}
		
		//�༭��Ϣ*****************************************************************
		public String basicInfoEdit(){
			
			System.out.println("��ϢΪ��"+model);
			return "basicInfoEdit";
		}
		
		public void prepareBasicInfoEdit(){
			
			if(playerIdJudge != null){
				
				model = playerService.get(playerIdJudge);
			}
		}
		
		//����༭��Ϣ
		public String editSave(){
//			System.out.println("��ϢΪ��"+model);
			playerService.saveOrUpdate(model);
			return "editSave";
		}
		
		public void prepareEditSave() {
			// TODO Auto-generated method stub
			model = playerService.get(playerIdJudge);
		}
		
		//��ǰ��λ
		public String currentPosition(){
			
			return "currentPosition";
		}
		
		
		//������Ϣ*****************************************************************
		public String showEvaluateInfo(){
			
			List<EvaluateInfo> getValue = evaluateServcie.getAllByEvaluateEvaluatorId(getSessionId());
			request.put("playerEvaluateInfo", getValue);
			
			return "showEvaluateInfo";
		}
		
		//������ϸ��Ϣ
		public String getPlayerEvaluateInfo() throws JsonGenerationException, JsonMappingException, IOException{
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			List<EvaluateInfo> getValue = evaluateServcie.getAllByEvaluateId(playerEvaluateId);
			map.put("evaluateLevel",getValue.get(0).getEvaluateLevel());
			map.put("evaluateInfo", getValue.get(0).getEvaluateInfo());
			
			List<Team> getTeam = teamService.getNameById(getValue.get(0).getTeamTeamId());
			map.put("teamName", getTeam.get(0).getTeamName());
			
			List<PlayerBasic> getPlayer = playerService.getAllByUserId(getValue.get(0).getUsers().getUserId());
			map.put("evaluator", getPlayer.get(0).getPlayerName());
			
			ObjectMapper mapper=new ObjectMapper();
			String json = mapper.writeValueAsString(map);
			
			//��Json���鷵�ص�ǰ̨
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");//��ʽ
			PrintWriter out = response.getWriter();
			out.print(json);
			
			return null;
		}
		
		
		//
		public String skillInfoShow(){
			
			
			return "skillInfoShow";
		}
		
		public String playerScore(){
			
			return "playerScore";
		}
		
		
		
		
		
		//�ӿڷ���
		@Override
		public void prepare() throws Exception {
			// TODO Auto-generated method stub
			
		} 
		
		private PlayerBasic model;
		
		@Override
		public PlayerBasic getModel() {
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
