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
	
	//连接service****************************************************************
	
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
	
	
	//传值
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
	
	
	
	//球员匹配*****************************************************************
	//判断球员的匹配状态
	public String playerMatching(){
		
//				System.out.println("匹配开始！");
				System.out.println("地点为："+playerPositionService.getAll());
		request.put("playerPositions", playerPositionService.getAll());
		
		//判断约赛状态
//				List<MatchInfo> getStateOne = matchInfoService.getStateById(getSessionId(),"未约赛");
		List<MatchInfo> getStateTwo = matchInfoService.getStateById(getSessionId(),"匹配中");
		List<MatchInfo> getStateThree = matchInfoService.getStateById(getSessionId(),"约赛中");
//				List<MatchInfo> getStateFour = matchInfoService.getStateById(getSessionId(),"已完成");
		
		if(getStateTwo.size()>0){//匹配中
			
			session.put("matchState", true);
		}
		else if(getStateThree.size()>0){//约赛中
			
			List<Team> teamId = teamService.getTeamById(getSessionId(),"约赛中");
//			System.out.println("teamId.get(0).getTeamTeamId():"+teamId.get(0).getTeamTeamId());
			List<Team> getValue = teamService.getNameById(teamId.get(0).getTeamTeamId());
			
//			System.out.println("getValue:"+getValue);
//			System.out.println("teamName:"+getValue.get(0).getTeamName());
 			request.put("teamName",getValue.get(0).getTeamName());
 			request.put("teamInfo", getValue);
 			
			session.put("matchState", false);
		}
		else{//未约赛
			session.put("matchState",null);
		}
		
		return "playerMatching";
	}
	
	//地图显示  点击显示地点
	public String showMap() throws JsonGenerationException, JsonMappingException, IOException{
		
		try{				
			List<MatchPosition> positionResult = playerPositionService.getAllById(matchPositionId);
			//返回json数组
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
	
	//获取匹配人员
	public String getPlayer() throws UnsupportedEncodingException{
		
		System.out.println("进入匹配"+matchPositionId+matchInfoTeamType+matchInfoMatchType);
		List<MatchInfo> getPlayer = matchInfoService.getPlayerByState("匹配中", matchPositionId, matchInfoTeamType, matchInfoMatchType);
		System.out.println("添加球员信息");
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
		
		if(matchInfoTeamType.equals("六人小队")){//若为六人小队
//			System.out.println("进入三小队1");
			if(getPlayer.size()>=5){
//				System.out.println("进入三小队2");			
					
				//将球员的约赛信息储存
				model.setMatchInfoState("约赛中");
				
				
				//获取当前用户的name
				System.out.println("获取Name开始");
				System.out.println("sessionID"+getSessionId());
				
				List<PlayerBasic> getNameOne = playerService.getAllByUserId(getSessionId());
				System.out.println("getName"+getNameOne);
				System.out.println("Name"+getNameOne.get(0).getPlayerName());
				List<PlayerBasic> getNameTwo = playerService.getAllByUserId(getPlayer.get(0).getUsers().getUserId());
				List<PlayerBasic> getNameThree = playerService.getAllByUserId(getPlayer.get(1).getUsers().getUserId());
				List<PlayerBasic> getNameFour = playerService.getAllByUserId(getPlayer.get(2).getUsers().getUserId());
				List<PlayerBasic> getNameFive = playerService.getAllByUserId(getPlayer.get(3).getUsers().getUserId());
				List<PlayerBasic> getNameSix = playerService.getAllByUserId(getPlayer.get(4).getUsers().getUserId());
			
				String teamName = getNameOne.get(0).getPlayerName()+"、"
						+getNameTwo.get(0).getPlayerName()+"、"
						+getNameThree.get(0).getPlayerName()+"、"
						+getNameFour.get(0).getPlayerName()+"、"
						+getNameFive.get(0).getPlayerName()+"、"
						+getNameSix.get(0).getPlayerName();

				System.out.println("队伍名称为："+teamName);
				//将球员分配到同一个队伍
				List<Team> getTeamId = teamService.getAll();//设置自增的队伍ID
				Integer teamTeamId;
				if(getTeamId.size()==0){
					teamTeamId = 1;
				}
				else{
					teamTeamId = getTeamId.get(0).getTeamTeamId() + 1;
				}
				//将自己的信息加入team
				Team teamSelf = new Team();
				Users users2 = new Users();
				users2.setUserId(getSessionId());
				teamSelf.setUsers(users2);
				teamSelf.setTeamName(teamName);
				teamSelf.setTeamState("约赛中");
				teamSelf.setTeamTeamId(teamTeamId);
				System.out.println("teamSelf"+teamSelf);
				teamService.saveOrUpdate(teamSelf);
				//将匹配到的队友信息放入team
				for(int i=0;i<5;i++){
					
					Team team = new Team();
					
					Users user = new Users();
					user.setUserId(getPlayer.get(i).getUsers().getUserId());
					team.setUsers(user);
					
					team.setTeamName(teamName);
					team.setTeamState("约赛中");
					team.setTeamTeamId(teamTeamId);
					System.out.println("team:"+team);
					teamService.saveOrUpdate(team);
				}
				
				//储存队伍ID
				model.setTeamTeamId(teamTeamId);
				matchInfoService.saveOrUpdate(model);
				System.out.println("model:"+model);
				
				for(int i=0;i<5;i++){//将数据的前2行 进行匹配 状态置为约赛中
//					System.out.println("进入三小队3");
					MatchInfo matchInfo = new MatchInfo();
//					System.out.println("newMatchInfo:"+matchInfo);
//					System.out.println("ID:"+getPlayer.get(i).getMatchInfoId());
					
					matchInfo = matchInfoService.get(getPlayer.get(i).getMatchInfoId());
//					System.out.println("matchInfoID"+matchInfo);
					matchInfo.setMatchInfoState("约赛中");
					matchInfo.setTeamTeamId(teamTeamId);
//					System.out.println("matchInfo"+matchInfo);
					matchInfoService.saveOrUpdate(matchInfo);
				}
				
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			}
			else{
				
				model.setMatchInfoState("匹配中");
				
				matchInfoService.saveOrUpdate(model);
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			}
		}
		else if(matchInfoTeamType.equals("八人中队")){//若为八人中队
			
			if(getPlayer.size()>=7){
				
				//将球员的约赛信息储存
				model.setMatchInfoState("约赛中");
				
				
				//获取当前用户的name
				System.out.println("获取Name开始");
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
				
				String teamName = getNameOne.get(0).getPlayerName()+"、"
						+getNameTwo.get(0).getPlayerName()+"、"
						+getNameThree.get(0).getPlayerName()+"、"
						+getNameFour.get(0).getPlayerName()+"、"
						+getNameFive.get(0).getPlayerName()+"、"
						+getNameSix.get(0).getPlayerName()+"、"
						+getNameSeven.get(0).getPlayerName()+"、"
						+getNameEight.get(0).getPlayerName();

				System.out.println("队伍名称为："+teamName);
				//将球员分配到同一个队伍
				List<Team> getTeamId = teamService.getAll();//设置自增的队伍ID
				Integer teamTeamId;
				if(getTeamId.size()==0){
					teamTeamId = 1;
				}
				else{
					teamTeamId = getTeamId.get(0).getTeamTeamId() + 1;
				}
				//将自己的信息加入team
				Team teamSelf = new Team();
				Users users2 = new Users();
				users2.setUserId(getSessionId());
				teamSelf.setUsers(users2);
				teamSelf.setTeamName(teamName);
				teamSelf.setTeamState("约赛中");
				teamSelf.setTeamTeamId(teamTeamId);
				System.out.println("teamSelf"+teamSelf);
				teamService.saveOrUpdate(teamSelf);
				//将匹配到的队友信息放入team
				for(int i=0;i<7;i++){
					
					Team team = new Team();
					
					Users user = new Users();
					user.setUserId(getPlayer.get(i).getUsers().getUserId());
					team.setUsers(user);
					
					team.setTeamName(teamName);
					team.setTeamState("约赛中");
					team.setTeamTeamId(teamTeamId);
					System.out.println("team:"+team);
					teamService.saveOrUpdate(team);
				}
				
				//储存队伍ID
				model.setTeamTeamId(teamTeamId);
				matchInfoService.saveOrUpdate(model);
				System.out.println("model:"+model);
				
				for(int i=0;i<7;i++){//将数据的前2行 进行匹配 状态置为约赛中
//					System.out.println("进入三小队3");
					MatchInfo matchInfo = new MatchInfo();
//					System.out.println("newMatchInfo:"+matchInfo);
//					System.out.println("ID:"+getPlayer.get(i).getMatchInfoId());
					
					matchInfo = matchInfoService.get(getPlayer.get(i).getMatchInfoId());
//					System.out.println("matchInfoID"+matchInfo);
					matchInfo.setMatchInfoState("约赛中");
					matchInfo.setTeamTeamId(teamTeamId);
//					System.out.println("matchInfo"+matchInfo);
					matchInfoService.saveOrUpdate(matchInfo);
				
					inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
				}
			}
			else{
				
				model.setMatchInfoState("匹配中");
				
				matchInfoService.saveOrUpdate(model);
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			}
		}
		else if(matchInfoTeamType.equals("十人团队")){//若为十人团队
			
			if(getPlayer.size()>=9){
				
				//将球员的约赛信息储存
				model.setMatchInfoState("约赛中");
				
				
				//获取当前用户的name
//				System.out.println("获取Name开始");
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
				
				String teamName = getNameOne.get(0).getPlayerName()+"、"
						+getNameTwo.get(0).getPlayerName()+"、"
						+getNameThree.get(0).getPlayerName()+"、"
						+getNameFour.get(0).getPlayerName()+"、"
						+getNameFive.get(0).getPlayerName()+"、"
						+getNameSix.get(0).getPlayerName()+"、"
						+getNameSeven.get(0).getPlayerName()+"、"
						+getNameEight.get(0).getPlayerName()+"、"
						+getNameNine.get(0).getPlayerName()+"、"
						+getNameTen.get(0).getPlayerName();

				System.out.println("队伍名称为："+teamName);
				//将球员分配到同一个队伍
				List<Team> getTeamId = teamService.getAll();//设置自增的队伍ID
				Integer teamTeamId;
				if(getTeamId.size()==0){
					teamTeamId = 1;
				}
				else{
					teamTeamId = getTeamId.get(0).getTeamTeamId() + 1;
				}
				//将自己的信息加入team
				Team teamSelf = new Team();
				Users users2 = new Users();
				users2.setUserId(getSessionId());
				teamSelf.setUsers(users2);
				teamSelf.setTeamName(teamName);
				teamSelf.setTeamState("约赛中");
				teamSelf.setTeamTeamId(teamTeamId);
				System.out.println("teamSelf"+teamSelf);
				teamService.saveOrUpdate(teamSelf);
				//将匹配到的队友信息放入team
				for(int i=0;i<9;i++){
					
					Team team = new Team();
					
					Users user = new Users();
					user.setUserId(getPlayer.get(i).getUsers().getUserId());
					team.setUsers(user);
					
					team.setTeamName(teamName);
					team.setTeamState("约赛中");
					team.setTeamTeamId(teamTeamId);
					System.out.println("team:"+team);
					teamService.saveOrUpdate(team);
				}
				
				//储存队伍ID
				model.setTeamTeamId(teamTeamId);
				matchInfoService.saveOrUpdate(model);
				System.out.println("model:"+model);
				
				for(int i=0;i<9;i++){//将数据的前2行 进行匹配 状态置为约赛中
//					System.out.println("进入三小队3");
					MatchInfo matchInfo = new MatchInfo();
//					System.out.println("newMatchInfo:"+matchInfo);
//					System.out.println("ID:"+getPlayer.get(i).getMatchInfoId());
					
					matchInfo = matchInfoService.get(getPlayer.get(i).getMatchInfoId());
//					System.out.println("matchInfoID"+matchInfo);
					matchInfo.setMatchInfoState("约赛中");
					matchInfo.setTeamTeamId(teamTeamId);
//					System.out.println("matchInfo"+matchInfo);
					matchInfoService.saveOrUpdate(matchInfo);
				
					inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
				}
			}
			else{
				
				model.setMatchInfoState("匹配中");
				
				matchInfoService.saveOrUpdate(model);
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			}
		}
		
		
		return "ajax-success";
	}
	
	
	//获取队伍人员详细信息
	public String showTeamPlayerInfo() throws JsonGenerationException, JsonMappingException, IOException{
				
		try {
			System.out.println("showTeamPlayerInfo进入");
			System.out.println("teamUserId"+teamUserId);
			List<PlayerBasic> getTeamPlayerInfo = playerService.getAllByUserId(teamUserId);
			System.out.println("getTeamPlayerInfo"+getTeamPlayerInfo);
			//返回json数组
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
	
	//图片上传
	public String imageUpload(){
		
		
		return "imageUpload";
	}
	private File image; //上传的文件  
    private String imageFileName; //文件名称  
    private String imageContentType; //文件类型  
	
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
                ActionContext.getContext().put("message", "文件上传成功");  
                System.out.println("imageName:"+imageFileName);
                System.out.println("url:"+savefile.toString());
                
                String url = "/images"+"/"+imageFileName;
                Image image = new Image();//生成对象
                image.setImageName(imageFileName);//图像name
                image.setImageUrl(url);//将file格式 转化为String 存入数据库 图像路径
                imageService.saveOrUpdate(image);//保存
                
            }  
        }
        /** 
         * 若要存入数据库 
         * fileName是在entity实体类中声明存放文件名称的变量 
         * yu.setFileName(imageFileName) 这样将文件名称存入数据库 
         * 文件路径为：savefile 
         */ 
        return "success";
	}
	
	//图片显示
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
	
	//获取队伍队员详细信息
	public String getTeamPlayerInfo() throws JsonGenerationException, JsonMappingException, IOException {
		
		System.out.println("start:getTeamPlayerInfo() ");
		List<PlayerBasic> playerInfo = playerService.getAllByUserId(teamPlayerId);
		System.out.println("playerInfo:"+playerInfo);
		
		//由于多对一的关系   会导致实体数据死循环输出 所以进行自行拼装一个Json数组
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("playerName", playerInfo.get(0).getPlayerName());
		map.put("playerSex", playerInfo.get(0).getPlayerSex());
		map.put("playerAge", playerInfo.get(0).getPlayerAge());
		map.put("playerHeight", playerInfo.get(0).getPlayerHeight());
		map.put("playerPosition", playerInfo.get(0).getPlayerPosition());
		map.put("playerAddress", playerInfo.get(0).getPlayerAddress());
		System.out.println("map:"+map);
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
	
	//获取队伍队员姓名
	public String getEvaluateName() throws JsonGenerationException, JsonMappingException, IOException{
		
		List<PlayerBasic> playerInfo = playerService.getAllByUserId(evaluatePlayerId);
				
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("playerName", playerInfo.get(0).getPlayerName());
		map.put("evaluateEvaluator", evaluatePlayerId);
		
		List<EvaluateInfo> evaluateInfo = evaluateServcie.getAllById(evaluatePlayerId, teamId,getSessionId());
		System.out.println("evaluateInfo:"+evaluateInfo);
		System.out.println("size:"+evaluateInfo.size());
		if(evaluateInfo.size()>0){//若已经评价
			
			map.put("evaluateState", "1");	
		}
		else{//若没评价
			map.put("evaluateState", "0");
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
	
	//提交评分信息
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

	//结束约赛
	public String endMatch(){
		
		try{
			//将MatchInfo中状态修改
			MatchInfo getValue = matchInfoService.getAllByStateAndId("约赛中", getSessionId()).get(0);
			getValue.setMatchInfoState("已完成");
			matchInfoService.saveOrUpdate(getValue);
			//将team中状态修改
			Team getTeam = teamService.getTeamById(getSessionId(), "约赛中").get(0);
			getTeam.setTeamState("已完成");
			teamService.saveOrUpdate(getTeam);
			
			return "endMatchSuccess";
		}
		catch (Exception e) {
			// TODO: handle exception
			return "endMatchError";
		}
		
		
	}
	
	

	//接口方法
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
