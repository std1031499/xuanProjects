package com.xuan.bs.actions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import com.xuan.bs.entities.RoleMenu;
import com.xuan.bs.entities.UserRole;
import com.xuan.bs.entities.UserRoleId;
import com.xuan.bs.entities.Users;
import com.xuan.bs.service.MainService;

public class MainAction extends ActionSupport implements RequestAware,SessionAware,
ModelDriven<Users>, Preparable{
	
	private static final long serialVersionUID = 1L;
	
	//����service****************************************************************
	private MainService mainService;
	
	public void setMainService(MainService mainService) {
		this.mainService = mainService;
	}
	
	
	//��ȡ��ֵ*********************************************************************
	public String userName;
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String userPwd;
	
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	
	
	private InputStream inputStream;
	
	public InputStream getInputStream(){
		return inputStream;
	}
	
	//��ת***********************************************************************
	public String leftSide() 
	{				
		return "leftSuccess";
	}
	
	public String topSide()
	{
		return "topSuccess";
	}
	
	public String homePage()
	{
		return "homeSuccess";
	}
	
	
	
	//��¼�ж�*********************************************************************
	public String loginCheck() throws UnsupportedEncodingException
	{
			
		List<Users> getValue  = mainService.loginCheck(userName, userPwd);
//		System.out.println(userName+userPwd);
		
		//�û��������Ƿ�ƥ��
		if(getValue.size()>0){
			
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));		
			System.out.println("�û�������ƥ��");
			session.put("userId", getValue.get(0).getUserId());
						
		}
		else{
			
			inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			//System.out.println("0");
		}
		return "ajax-success";
		
	}
	
	//�ж��û���ɫ ��ȡ��˵���Ȩ��**********************************************************		
	public String getMenuByRole(){
		
		//��ȡSession�е�userId
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer user_Id = new Integer(u_Id.toString());
		System.out.println("sessionID:"+user_Id);
		//��ȡ��ɫ
		List<UserRole> getRole = mainService.getRoleById(user_Id);
		System.out.println("�û���ɫ��"+getRole);
		System.out.println("�û���ɫ���֣�"+getRole.get(0).getId().getRole().getRoleName());
		//��ȡ��ɫ��ӵ�еĲ˵���ID
		try {
			
			if(getRole.get(0).getId().getRole().getRoleName().equals("player")){//��Ա
				
				inputStream = new ByteArrayInputStream("player".getBytes("UTF-8"));
			}
			else if(getRole.get(0).getId().getRole().getRoleName().equals("organizer")){
				
				inputStream = new ByteArrayInputStream("organizer".getBytes("UTF-8"));
			}
			else if(getRole.get(0).getId().getRole().getRoleName().equals("assessor")){
				
				inputStream = new ByteArrayInputStream("assessor".getBytes("UTF-8"));
			}
			else if(getRole.get(0).getId().getRole().getRoleName().equals("scorer")){
	
				inputStream = new ByteArrayInputStream("scorer".getBytes("UTF-8"));
			}
			System.out.println("inputstream"+inputStream);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		/*try {
			Integer permiss = 1;//�˵�Ȩ��Ϊ1
			List<RoleMenu> getMenu = mainService.getMenuById(user_Id, permiss);					
			//����һ��JSON����
			ObjectMapper mapper=new ObjectMapper();
			String result=mapper.writeValueAsString(getMenu);
			System.out.println("JSON����"+result);
			inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		*/
				
		return "ajax-success";
	}
	
	
	
	
	
	
	
	
	
	//�ӿڷ���
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	private Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}


	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
