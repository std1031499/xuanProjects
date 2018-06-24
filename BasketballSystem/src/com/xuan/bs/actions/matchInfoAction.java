package com.xuan.bs.actions;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.xuan.bs.dao.MainDao;
import com.xuan.bs.entities.EvaluateInfo;
import com.xuan.bs.entities.Image;
import com.xuan.bs.entities.MatchInfo;
import com.xuan.bs.entities.MatchPosition;
import com.xuan.bs.entities.PlayerBasic;
import com.xuan.bs.entities.Team;
import com.xuan.bs.entities.Users;
import com.xuan.bs.service.EvaluateServcie;
import com.xuan.bs.service.ImageService;
import com.xuan.bs.service.MainService;
import com.xuan.bs.service.MatchInfoService;
import com.xuan.bs.service.PlayerPositionService;
import com.xuan.bs.service.PlayerService;
import com.xuan.bs.service.TeamService;

public class matchInfoAction extends ActionSupport implements RequestAware,SessionAware,
ModelDriven<MatchInfo>, Preparable{
			
	private static final long serialVersionUID = 1L;
	
	//����service****************************************************************
	
	private MatchInfoService matchInfoService;
	public void setMatchInfoService(MatchInfoService matchInfoService) {
		this.matchInfoService = matchInfoService;
	}
	
	private PlayerPositionService playerPositionService;
	
	public void setPlayerPositionService(
			PlayerPositionService playerPositionService) {
		this.playerPositionService = playerPositionService;
	}
	
	private TeamService teamService;
	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}
	
	private PlayerService playerService;
	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}
	
	private EvaluateServcie evaluateServcie;
	public void setEvaluateServcie(EvaluateServcie evaluateServcie) {
		this.evaluateServcie = evaluateServcie;
	}
	
	
	//��ֵ
	private Integer matchPositionId;
	public void setMatchPositionId(Integer matchPositionId) {
		this.matchPositionId = matchPositionId;
	}
	
	private String matchInfoTeamType;
	public void setMatchInfoTeamType(String matchInfoTeamType) {
		this.matchInfoTeamType = matchInfoTeamType;
	}
	
	private String matchInfoMatchType;
	public void setMatchInfoMatchType(String matchInfoMatchType) {
		this.matchInfoMatchType = matchInfoMatchType;
	}
	
	private String matchState;
	public void setMatchState(String matchState) {
		this.matchState = matchState;
	}
	
	private String matchInfoTime;
	public void setMatchInfoTime(String matchInfoTime) {
		this.matchInfoTime = matchInfoTime;
	}
	
	private Integer teamUserId;
	public void setTeamUserId(Integer teamUserId) {
		this.teamUserId = teamUserId;
	}
	
	private Integer teamPlayerId;
	public void setTeamPlayerId(Integer teamPlayerId) {
		this.teamPlayerId = teamPlayerId;
	}
	
	private Integer evaluatePlayerId;
	public void setEvaluatePlayerId(Integer evaluatePlayerId) {
		this.evaluatePlayerId = evaluatePlayerId;
	}
	
	private Integer evaluateEvaluator;
	public void setEvaluateEvaluator(Integer evaluateEvaluator) {
		this.evaluateEvaluator = evaluateEvaluator;
	}
	
	private String evaluateLevel;
	public void setEvaluateLevel(String evaluateLevel) {
		this.evaluateLevel = evaluateLevel;
	}
	
	private String evaluateInfo;
	public void setEvaluateInfo(String evaluateInfo) {	
		this.evaluateInfo = evaluateInfo;
	}
	
	private Integer teamId;
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
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
	
	
	
	//��Աƥ��*****************************************************************
	//�ж���Ա��ƥ��״̬
	public String playerMatching(){
		
//				System.out.println("ƥ�俪ʼ��");
				System.out.println("�ص�Ϊ��"+playerPositionService.getAll());
		request.put("playerPositions", playerPositionService.getAll());
		
		//�ж�Լ��״̬
//				List<MatchInfo> getStateOne = matchInfoService.getStateById(getSessionId(),"δԼ��");
		List<MatchInfo> getStateTwo = matchInfoService.getStateById(getSessionId(),"ƥ����");
		List<MatchInfo> getStateThree = matchInfoService.getStateById(getSessionId(),"Լ����");
//				List<MatchInfo> getStateFour = matchInfoService.getStateById(getSessionId(),"�����");
		
		if(getStateTwo.size()>0){//ƥ����
			
			session.put("matchState", true);
		}
		else if(getStateThree.size()>0){//Լ����
			
			List<Team> teamId = teamService.getTeamById(getSessionId(),"Լ����");
//			System.out.println("teamId.get(0).getTeamTeamId():"+teamId.get(0).getTeamTeamId());
			List<Team> getValue = teamService.getNameById(teamId.get(0).getTeamTeamId());
			
//			System.out.println("getValue:"+getValue);
//			System.out.println("teamName:"+getValue.get(0).getTeamName());
 			request.put("teamName",getValue.get(0).getTeamName());
 			request.put("teamInfo", getValue);
 			
			session.put("matchState", false);
		}
		else{//δԼ��
			session.put("matchState",null);
		}
		
		return "playerMatching";
	}
	
	//��ͼ��ʾ  �����ʾ�ص�
	public String showMap() throws JsonGenerationException, JsonMappingException, IOException{
		
		try{				
			List<MatchPosition> positionResult = playerPositionService.getAllById(matchPositionId);
			//����json����
			ObjectMapper mapper=new ObjectMapper();
			String result=mapper.writeValueAsString(positionResult);
			inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
			System.out.println("result:"+result);
		}
		catch (UnsupportedEncodingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "ajax-success";
	}
	
	//��ȡƥ����Ա
	public String getPlayer() throws UnsupportedEncodingException{
		
		System.out.println("����ƥ��"+matchPositionId+matchInfoTeamType+matchInfoMatchType);
		List<MatchInfo> getPlayer = matchInfoService.getPlayerByState("ƥ����", matchPositionId, matchInfoTeamType, matchInfoMatchType);
		System.out.println("�����Ա��Ϣ");
//		System.out.println("ID:"+getPlayer.get(0).getMatchInfoId());
		model = new MatchInfo();
		Users users = new Users();
		users.setUserId(getSessionId());
		model.setUsers(users);
		
//		model.getMatchInfoMatchType();
		model.setMatchInfoMatchType(matchInfoMatchType);
//		model.getMatchInfoMatchType();
		model.setMatchInfoTeamType(matchInfoTeamType);
		model.setMatchInfoTime(matchInfoTime);
		
		MatchPosition matchPosition = new MatchPosition();
		matchPosition.setMatchPositionId(matchPositionId);
		model.setMatchPosition(matchPosition);
		System.out.println("model:");
		System.out.println(model);
		
		if(matchInfoTeamType.equals("����С��")){//��Ϊ����С��
//			System.out.println("������С��1");
			if(getPlayer.size()>=5){
//				System.out.println("������С��2");			
					
				//����Ա��Լ����Ϣ����
				model.setMatchInfoState("Լ����");
				
				
				//��ȡ��ǰ�û���name
				System.out.println("��ȡName��ʼ");
				System.out.println("sessionID"+getSessionId());
				
				List<PlayerBasic> getNameOne = playerService.getAllByUserId(getSessionId());
				System.out.println("getName"+getNameOne);
				System.out.println("Name"+getNameOne.get(0).getPlayerName());
				List<PlayerBasic> getNameTwo = playerService.getAllByUserId(getPlayer.get(0).getUsers().getUserId());
				List<PlayerBasic> getNameThree = playerService.getAllByUserId(getPlayer.get(1).getUsers().getUserId());
				List<PlayerBasic> getNameFour = playerService.getAllByUserId(getPlayer.get(2).getUsers().getUserId());
				List<PlayerBasic> getNameFive = playerService.getAllByUserId(getPlayer.get(3).getUsers().getUserId());
				List<PlayerBasic> getNameSix = playerService.getAllByUserId(getPlayer.get(4).getUsers().getUserId());
			
				String teamName = getNameOne.get(0).getPlayerName()+"��"
						+getNameTwo.get(0).getPlayerName()+"��"
						+getNameThree.get(0).getPlayerName()+"��"
						+getNameFour.get(0).getPlayerName()+"��"
						+getNameFive.get(0).getPlayerName()+"��"
						+getNameSix.get(0).getPlayerName();

				System.out.println("��������Ϊ��"+teamName);
				//����Ա���䵽ͬһ������
				List<Team> getTeamId = teamService.getAll();//���������Ķ���ID
				Integer teamTeamId;
				if(getTeamId.size()==0){
					teamTeamId = 1;
				}
				else{
					teamTeamId = getTeamId.get(0).getTeamTeamId() + 1;
				}
				//���Լ�����Ϣ����team
				Team teamSelf = new Team();
				Users users2 = new Users();
				users2.setUserId(getSessionId());
				teamSelf.setUsers(users2);
				teamSelf.setTeamName(teamName);
				teamSelf.setTeamState("Լ����");
				teamSelf.setTeamTeamId(teamTeamId);
				System.out.println("teamSelf"+teamSelf);
				teamService.saveOrUpdate(teamSelf);
				//��ƥ�䵽�Ķ�����Ϣ����team
				for(int i=0;i<5;i++){
					
					Team team = new Team();
					
					Users user = new Users();
					user.setUserId(getPlayer.get(i).getUsers().getUserId());
					team.setUsers(user);
					
					team.setTeamName(teamName);
					team.setTeamState("Լ����");
					team.setTeamTeamId(teamTeamId);
					System.out.println("team:"+team);
					teamService.saveOrUpdate(team);
				}
				
				//�������ID
				model.setTeamTeamId(teamTeamId);
				matchInfoService.saveOrUpdate(model);
				System.out.println("model:"+model);
				
				for(int i=0;i<5;i++){//�����ݵ�ǰ2�� ����ƥ�� ״̬��ΪԼ����
//					System.out.println("������С��3");
					MatchInfo matchInfo = new MatchInfo();
//					System.out.println("newMatchInfo:"+matchInfo);
//					System.out.println("ID:"+getPlayer.get(i).getMatchInfoId());
					
					matchInfo = matchInfoService.get(getPlayer.get(i).getMatchInfoId());
//					System.out.println("matchInfoID"+matchInfo);
					matchInfo.setMatchInfoState("Լ����");
					matchInfo.setTeamTeamId(teamTeamId);
//					System.out.println("matchInfo"+matchInfo);
					matchInfoService.saveOrUpdate(matchInfo);
				}
				
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			}
			else{
				
				model.setMatchInfoState("ƥ����");
				
				matchInfoService.saveOrUpdate(model);
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			}
		}
		else if(matchInfoTeamType.equals("�����ж�")){//��Ϊ�����ж�
			
			if(getPlayer.size()>=7){
				
				//����Ա��Լ����Ϣ����
				model.setMatchInfoState("Լ����");
				
				
				//��ȡ��ǰ�û���name
				System.out.println("��ȡName��ʼ");
				System.out.println("sessionID"+getSessionId());
				
				List<PlayerBasic> getNameOne = playerService.getAllByUserId(getSessionId());
				System.out.println("getName"+getNameOne);
				System.out.println("Name"+getNameOne.get(0).getPlayerName());
				List<PlayerBasic> getNameTwo = playerService.getAllByUserId(getPlayer.get(0).getUsers().getUserId());
				List<PlayerBasic> getNameThree = playerService.getAllByUserId(getPlayer.get(1).getUsers().getUserId());
				List<PlayerBasic> getNameFour = playerService.getAllByUserId(getPlayer.get(2).getUsers().getUserId());
				List<PlayerBasic> getNameFive = playerService.getAllByUserId(getPlayer.get(3).getUsers().getUserId());
				List<PlayerBasic> getNameSix = playerService.getAllByUserId(getPlayer.get(4).getUsers().getUserId());
				List<PlayerBasic> getNameSeven = playerService.getAllByUserId(getPlayer.get(5).getUsers().getUserId());
				List<PlayerBasic> getNameEight = playerService.getAllByUserId(getPlayer.get(6).getUsers().getUserId());
				
				String teamName = getNameOne.get(0).getPlayerName()+"��"
						+getNameTwo.get(0).getPlayerName()+"��"
						+getNameThree.get(0).getPlayerName()+"��"
						+getNameFour.get(0).getPlayerName()+"��"
						+getNameFive.get(0).getPlayerName()+"��"
						+getNameSix.get(0).getPlayerName()+"��"
						+getNameSeven.get(0).getPlayerName()+"��"
						+getNameEight.get(0).getPlayerName();

				System.out.println("��������Ϊ��"+teamName);
				//����Ա���䵽ͬһ������
				List<Team> getTeamId = teamService.getAll();//���������Ķ���ID
				Integer teamTeamId;
				if(getTeamId.size()==0){
					teamTeamId = 1;
				}
				else{
					teamTeamId = getTeamId.get(0).getTeamTeamId() + 1;
				}
				//���Լ�����Ϣ����team
				Team teamSelf = new Team();
				Users users2 = new Users();
				users2.setUserId(getSessionId());
				teamSelf.setUsers(users2);
				teamSelf.setTeamName(teamName);
				teamSelf.setTeamState("Լ����");
				teamSelf.setTeamTeamId(teamTeamId);
				System.out.println("teamSelf"+teamSelf);
				teamService.saveOrUpdate(teamSelf);
				//��ƥ�䵽�Ķ�����Ϣ����team
				for(int i=0;i<7;i++){
					
					Team team = new Team();
					
					Users user = new Users();
					user.setUserId(getPlayer.get(i).getUsers().getUserId());
					team.setUsers(user);
					
					team.setTeamName(teamName);
					team.setTeamState("Լ����");
					team.setTeamTeamId(teamTeamId);
					System.out.println("team:"+team);
					teamService.saveOrUpdate(team);
				}
				
				//�������ID
				model.setTeamTeamId(teamTeamId);
				matchInfoService.saveOrUpdate(model);
				System.out.println("model:"+model);
				
				for(int i=0;i<7;i++){//�����ݵ�ǰ2�� ����ƥ�� ״̬��ΪԼ����
//					System.out.println("������С��3");
					MatchInfo matchInfo = new MatchInfo();
//					System.out.println("newMatchInfo:"+matchInfo);
//					System.out.println("ID:"+getPlayer.get(i).getMatchInfoId());
					
					matchInfo = matchInfoService.get(getPlayer.get(i).getMatchInfoId());
//					System.out.println("matchInfoID"+matchInfo);
					matchInfo.setMatchInfoState("Լ����");
					matchInfo.setTeamTeamId(teamTeamId);
//					System.out.println("matchInfo"+matchInfo);
					matchInfoService.saveOrUpdate(matchInfo);
				
					inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
				}
			}
			else{
				
				model.setMatchInfoState("ƥ����");
				
				matchInfoService.saveOrUpdate(model);
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			}
		}
		else if(matchInfoTeamType.equals("ʮ���Ŷ�")){//��Ϊʮ���Ŷ�
			
			if(getPlayer.size()>=9){
				
				//����Ա��Լ����Ϣ����
				model.setMatchInfoState("Լ����");
				
				
				//��ȡ��ǰ�û���name
//				System.out.println("��ȡName��ʼ");
//				System.out.println("sessionID"+getSessionId());
				
				List<PlayerBasic> getNameOne = playerService.getAllByUserId(getSessionId());
//				System.out.println("getName"+getNameOne);
//				System.out.println("Name"+getNameOne.get(0).getPlayerName());
				List<PlayerBasic> getNameTwo = playerService.getAllByUserId(getPlayer.get(0).getUsers().getUserId());
				List<PlayerBasic> getNameThree = playerService.getAllByUserId(getPlayer.get(1).getUsers().getUserId());
				List<PlayerBasic> getNameFour = playerService.getAllByUserId(getPlayer.get(2).getUsers().getUserId());
				List<PlayerBasic> getNameFive = playerService.getAllByUserId(getPlayer.get(3).getUsers().getUserId());
				List<PlayerBasic> getNameSix = playerService.getAllByUserId(getPlayer.get(4).getUsers().getUserId());
				List<PlayerBasic> getNameSeven = playerService.getAllByUserId(getPlayer.get(5).getUsers().getUserId());
				List<PlayerBasic> getNameEight = playerService.getAllByUserId(getPlayer.get(6).getUsers().getUserId());
				List<PlayerBasic> getNameNine = playerService.getAllByUserId(getPlayer.get(7).getUsers().getUserId());
				List<PlayerBasic> getNameTen = playerService.getAllByUserId(getPlayer.get(8).getUsers().getUserId());
				
				String teamName = getNameOne.get(0).getPlayerName()+"��"
						+getNameTwo.get(0).getPlayerName()+"��"
						+getNameThree.get(0).getPlayerName()+"��"
						+getNameFour.get(0).getPlayerName()+"��"
						+getNameFive.get(0).getPlayerName()+"��"
						+getNameSix.get(0).getPlayerName()+"��"
						+getNameSeven.get(0).getPlayerName()+"��"
						+getNameEight.get(0).getPlayerName()+"��"
						+getNameNine.get(0).getPlayerName()+"��"
						+getNameTen.get(0).getPlayerName();

				System.out.println("��������Ϊ��"+teamName);
				//����Ա���䵽ͬһ������
				List<Team> getTeamId = teamService.getAll();//���������Ķ���ID
				Integer teamTeamId;
				if(getTeamId.size()==0){
					teamTeamId = 1;
				}
				else{
					teamTeamId = getTeamId.get(0).getTeamTeamId() + 1;
				}
				//���Լ�����Ϣ����team
				Team teamSelf = new Team();
				Users users2 = new Users();
				users2.setUserId(getSessionId());
				teamSelf.setUsers(users2);
				teamSelf.setTeamName(teamName);
				teamSelf.setTeamState("Լ����");
				teamSelf.setTeamTeamId(teamTeamId);
				System.out.println("teamSelf"+teamSelf);
				teamService.saveOrUpdate(teamSelf);
				//��ƥ�䵽�Ķ�����Ϣ����team
				for(int i=0;i<9;i++){
					
					Team team = new Team();
					
					Users user = new Users();
					user.setUserId(getPlayer.get(i).getUsers().getUserId());
					team.setUsers(user);
					
					team.setTeamName(teamName);
					team.setTeamState("Լ����");
					team.setTeamTeamId(teamTeamId);
					System.out.println("team:"+team);
					teamService.saveOrUpdate(team);
				}
				
				//�������ID
				model.setTeamTeamId(teamTeamId);
				matchInfoService.saveOrUpdate(model);
				System.out.println("model:"+model);
				
				for(int i=0;i<9;i++){//�����ݵ�ǰ2�� ����ƥ�� ״̬��ΪԼ����
//					System.out.println("������С��3");
					MatchInfo matchInfo = new MatchInfo();
//					System.out.println("newMatchInfo:"+matchInfo);
//					System.out.println("ID:"+getPlayer.get(i).getMatchInfoId());
					
					matchInfo = matchInfoService.get(getPlayer.get(i).getMatchInfoId());
//					System.out.println("matchInfoID"+matchInfo);
					matchInfo.setMatchInfoState("Լ����");
					matchInfo.setTeamTeamId(teamTeamId);
//					System.out.println("matchInfo"+matchInfo);
					matchInfoService.saveOrUpdate(matchInfo);
				
					inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
				}
			}
			else{
				
				model.setMatchInfoState("ƥ����");
				
				matchInfoService.saveOrUpdate(model);
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			}
		}
		
		
		return "ajax-success";
	}
	
	
	//��ȡ������Ա��ϸ��Ϣ
	public String showTeamPlayerInfo() throws JsonGenerationException, JsonMappingException, IOException{
				
		try {
			System.out.println("showTeamPlayerInfo����");
			System.out.println("teamUserId"+teamUserId);
			List<PlayerBasic> getTeamPlayerInfo = playerService.getAllByUserId(teamUserId);
			System.out.println("getTeamPlayerInfo"+getTeamPlayerInfo);
			//����json����
//			ObjectMapper mapper=new ObjectMapper();
//			String resultTeamPlayerInfo = mapper.writeValueAsString(getTeamPlayerInfo);
//			System.out.println("resultInfo:"+resultTeamPlayerInfo);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ajax-success";
	}
	
	//ͼƬ�ϴ�
	public String imageUpload(){
		
		
		return "imageUpload";
	}
	private File image; //�ϴ����ļ�  
    private String imageFileName; //�ļ�����  
    private String imageContentType; //�ļ�����  
	
    public void setImage(File image) {
		this.image = image;
	}
    public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
    public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
    
    private ImageService imageService;
    public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}
    
	public String imageSave(){
		
		String realpath = ServletActionContext.getServletContext().getRealPath("/images");  
        System.out.println("realpath: "+realpath);  
        if(image != null){  
            File savefile = new File(new File(realpath), imageFileName);  
            System.out.println(savefile);  
            System.out.println(savefile.getParentFile());  
            if(savefile.getParentFile().exists()){  
                try {  
                    savefile.getParentFile().mkdirs();  
                    FileUtils.copyFile(image, savefile);  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
                ActionContext.getContext().put("message", "�ļ��ϴ��ɹ�");  
                System.out.println("imageName:"+imageFileName);
                System.out.println("url:"+savefile.toString());
                
                String url = "/images"+"/"+imageFileName;
                Image image = new Image();//���ɶ���
                image.setImageName(imageFileName);//ͼ��name
                image.setImageUrl(url);//��file��ʽ ת��ΪString �������ݿ� ͼ��·��
                imageService.saveOrUpdate(image);//����
                
            }  
        }
        /** 
         * ��Ҫ�������ݿ� 
         * fileName����entityʵ��������������ļ����Ƶı��� 
         * yu.setFileName(imageFileName) �������ļ����ƴ������ݿ� 
         * �ļ�·��Ϊ��savefile 
         */ 
        return "success";
	}
	
	//ͼƬ��ʾ
	public String imageShow(){
		
		List<Image> getValue = imageService.getAllById(7);
		String url = getValue.get(0).getImageUrl();
		String data[] = url.split("\\*");
		 for (int i = 0 ; i <data.length ; i++ ) { System.out.println("--"+data[i]); }
		 for(int i = 0 ; i <data.length ; i++){
			 
			 request.put("url"+i,data[i]);
		 }
		
		
		return "imageShow";
	}
	
	//��ȡ�����Ա��ϸ��Ϣ
	public String getTeamPlayerInfo() throws JsonGenerationException, JsonMappingException, IOException {
		
		System.out.println("start:getTeamPlayerInfo() ");
		List<PlayerBasic> playerInfo = playerService.getAllByUserId(teamPlayerId);
		System.out.println("playerInfo:"+playerInfo);
		
		//���ڶ��һ�Ĺ�ϵ   �ᵼ��ʵ��������ѭ����� ���Խ�������ƴװһ��Json����
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("playerName", playerInfo.get(0).getPlayerName());
		map.put("playerSex", playerInfo.get(0).getPlayerSex());
		map.put("playerAge", playerInfo.get(0).getPlayerAge());
		map.put("playerHeight", playerInfo.get(0).getPlayerHeight());
		map.put("playerPosition", playerInfo.get(0).getPlayerPosition());
		map.put("playerAddress", playerInfo.get(0).getPlayerAddress());
		System.out.println("map:"+map);
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
	
	//��ȡ�����Ա����
	public String getEvaluateName() throws JsonGenerationException, JsonMappingException, IOException{
		
		List<PlayerBasic> playerInfo = playerService.getAllByUserId(evaluatePlayerId);
				
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("playerName", playerInfo.get(0).getPlayerName());
		map.put("evaluateEvaluator", evaluatePlayerId);
		
		List<EvaluateInfo> evaluateInfo = evaluateServcie.getAllById(evaluatePlayerId, teamId,getSessionId());
		System.out.println("evaluateInfo:"+evaluateInfo);
		System.out.println("size:"+evaluateInfo.size());
		if(evaluateInfo.size()>0){//���Ѿ�����
			
			map.put("evaluateState", "1");	
		}
		else{//��û����
			map.put("evaluateState", "0");
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
	
	//�ύ������Ϣ
	public String setEvaluateInfo(){
		
		EvaluateInfo info = new EvaluateInfo();
		
		Users users = new Users();
		users.setUserId(getSessionId());
		info.setUsers(users);
		
		
		info.setTeamTeamId(teamId);
		
		info.setEvaluateInfo(evaluateInfo);
		info.setEvaluateLevel(evaluateLevel);
		info.setEvaluateEvaluateId(evaluateEvaluator);
		System.out.println("info:"+info);
		try {
			
			evaluateServcie.saveOrUpdate(info);
			
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		return "ajax-success";
	}

	//����Լ��
	public String endMatch(){
		
		try{
			//��MatchInfo��״̬�޸�
			MatchInfo getValue = matchInfoService.getAllByStateAndId("Լ����", getSessionId()).get(0);
			getValue.setMatchInfoState("�����");
			matchInfoService.saveOrUpdate(getValue);
			//��team��״̬�޸�
			Team getTeam = teamService.getTeamById(getSessionId(), "Լ����").get(0);
			getTeam.setTeamState("�����");
			teamService.saveOrUpdate(getTeam);
			
			return "endMatchSuccess";
		}
		catch (Exception e) {
			// TODO: handle exception
			return "endMatchError";
		}
		
		
	}
	
	

	//�ӿڷ���
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	} 
	
	private MatchInfo model;
	
	@Override
	public MatchInfo getModel() {
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
