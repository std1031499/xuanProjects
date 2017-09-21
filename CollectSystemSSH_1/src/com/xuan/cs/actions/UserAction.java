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

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.xuan.cs.entities.User;
import com.xuan.cs.service.UserService;


public class UserAction extends ActionSupport implements RequestAware,SessionAware,
ModelDriven<User>, Preparable{
	
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	//显示用户信息*******************************************************************
	public String list(){
		request.put("users", userService.getAll());
		return "list";
	}
	
	public String loginCheck(){
		return "loginCheck";
	}
	
	//判断用户信息是否正确***************************************************************	
	private String c_Username;
	private String c_Password;
	
	public void setC_Username(String c_Username) {
		this.c_Username = c_Username;
	}
	
	public void setC_Password(String c_Password) {
		this.c_Password = c_Password;
	}
	
	private Integer user_Id;
	
	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}
	
	public String loginSave(){
		
		List<User> getValue = userService.loginSave(c_Username, c_Password, user_Id);
		//判断是否存在这个用户
		if(getValue.size()>0)
		{
			
			request.put("r_userAll", userService.loginSave(c_Username,c_Password,user_Id));
			
			session.put("user_Id", getValue.get(0).getUser_Id());
			
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
		
	}
	
	//注册跳转
	public String registerMain(){
		//System.out.println("hahah");
		return "registerMain";
	}
	
	
	
	//添加用户信息*******************************************************************
	public String register(){
		
		return "register";
	}
	
	//register的prepare方法
	public void prepareRegister() {
		//System.out.println(user_Id+"h1");
		if(user_Id!=null){
			model = userService.get(user_Id);
			//System.out.println(model+"h2");
		}
		else{
			session.put("user_Id", null);
		}
	}
	
	public String registerSave(){
		//userService.saveOrUpdate(model);//执行保存操作
		//System.out.println("12");
		try {
			//System.out.println(model+"begin");
			userService.saveOrUpdate(model);//执行保存操作
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			//System.out.println(inputStream+"in1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
				//System.out.println(inputStream+"in0");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return "ajax-success";
	}
	
	
	
	public void prepareRegisterSave(){
		if(user_Id == null){
			model = new User();//若user_Id 为null 则进行初始化
		}
		else{
			model =userService.get(user_Id);//若 不为null 则获取user_Id
		}
	}
	
	//Ajax判断注册用户名是否可用**********************************************************
	public String validateUserName() throws UnsupportedEncodingException{
		if(userService.userNameIsValid(c_Username)){
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));			
		}
		else{
			inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));			
		}
		return "ajax-success";
	}
	
	
	
	//删除用户信息*******************************************************************

	//ajax在Struts2  的使用 返回data Struts.xml文件中添加
	//<result type="stream" name="delete">
	//	<param name="contentType">text/html</param>
	//	<param name="inputName">inputStream</param>
	//</result>
	private InputStream inputStream;
	
	//public 类型
	public InputStream getInputStream(){
		return inputStream;
	}
	
	public String delete(){
		
		try {
			userService.delete(user_Id);
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
			
	//显示系统介绍界面*****************************************************************
	public String systemIntro(){
		return "systemIntro";
	}
	
	
	//判断用户类型
	public String judgeLevel(){
		
		//获取session中的user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("user_Id");
		user_Id = new Integer((Integer) u_Id);
				
		List<User> getUserLevel = userService.getUserByUser_Id(user_Id);
		String getLevel = getUserLevel.get(0).getC_Level();
		
		if(getLevel.equals("1")){
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(getLevel.equals("2")){
			try {
				inputStream = new ByteArrayInputStream("2".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		}
		else if(getLevel.equals("3")){
			try {
				inputStream = new ByteArrayInputStream("3".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "ajax-success";
	}
	
	
	//Request
	private Map<String, Object> request;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
	
	//Session
	private Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}
	//struts.xml文件修改拦截器 不会调用此方法
	@Override
	public void prepare() throws Exception {}
	
	private User model;
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return model;
	}

}
