package com.TCWL.system.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.omg.CORBA.Request;

import com.TCWL.system.entities.Ordersend;
import com.TCWL.system.entities.Sender;
import com.TCWL.system.entities.Usualuserinfolist;
import com.TCWL.system.services.OrderSendService;
import com.TCWL.system.services.SenderService;
import com.TCWL.system.services.UserLoginListService;
import com.TCWL.system.util.GetDate;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class OrderSendAction extends ActionSupport implements RequestAware,SessionAware,
ModelDriven<Ordersend>, Preparable{
	
	private static final long serialVersionUID = 1L;
	
	//连接service
	private OrderSendService orderSendService;
	
	public void setOrderSendService(OrderSendService orderSendService) {
		this.orderSendService = orderSendService;
	}
	
	private SenderService senderService;
	
	public void setSenderService(SenderService senderService) {
		this.senderService = senderService;
	}
	
	private UserLoginListService userLoginListService;
	
	public void setUserLoginListService(
			UserLoginListService userLoginListService) {
		this.userLoginListService = userLoginListService;
	}
	
	//获取传值*********************************************************************
	private String orderId;
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	private Integer senderId;
	
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	
	//inputStream
	private InputStream inputStream;
	
	//public 类型
	public InputStream getInputStream(){
		return inputStream;
	}
	
	
	//添加订单
	public String add(){
		//附表单号 ： 000+yyyy+mm+dd+00000
		//设置ID
		String date = GetDate.getDate();
		//System.out.println(date);
		int size = orderSendService.getTodayNum(date);
		size = size + 1;
//		System.out.println("size:"+size);
		String orderId = date + String.format("%05d", size);
//		SimpleDateFormat simpleDateFormat
//		System.out.println(orderId);
		orderModel.setOrderId(orderId);
		//设置日期
		Date NowDate = new Date();
		Timestamp nousedate = new Timestamp(NowDate.getTime());
		
		orderModel.setOrderSendDate(nousedate.toString());
		//设置状态
		orderModel.setOrderStatus("未安排");
		
		orderSendService.saveOrUpdate(orderModel);
		return "allordersend";
	}
	
	// 未安排的订单******************************************************************
	public String noDeal(){
		
		//获取session中的user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer scId = new Integer((Integer) u_Id);
		//System.out.println(scId+"s1");
		//System.out.println(orderSendService.getNoDealById(scId)+"s2");
		request.put("noDealInfos", orderSendService.getNoDealById(scId));
		return "noDeal";
	}
	
	// 为未安排的订单添加配送人员
	public String addSender(){
		
		//获取session中的user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer scId = new Integer((Integer) u_Id);
				
		request.put("senderInfos", senderService.getSenderInfosById(scId));
		request.put("orderId", orderId);//当前订单的id
		return "addSender";
	}
	
	public String addSenderSave(){
		
		/*try {
			Sender sender = new Sender();
			orderModel.setSender(sender.setSenderId(senderId));
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			e.printStackTrace();
		}*/
		Sender sender = new Sender();
		sender.setSenderId(senderId);
		orderModel.setSender(sender);
		orderModel.setOrderStatus("未派送");
		//System.out.println(orderModel);
		orderSendService.saveOrUpdate(orderModel);
		return "addSenderSave";
	}
	
	public void prepareAddSenderSave(){
		
		orderModel = orderSendService.getOrderById(orderId);
	}
	
	// 未派送的订单******************************************************************
	public String noSend(){
		
		//获取session中的user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer scId = new Integer((Integer) u_Id);
		
		request.put("noSendInfos", orderSendService.getNoSendById(scId));
						
		return "noSend";
	}
	
	
	// 正在派送的订单*****************************************************************
	public String sendNow(){
		
		//获取session中的user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer scId = new Integer((Integer) u_Id);
		
		request.put("sendNowInfos", orderSendService.getSendNowById(scId));
				
		return "sendNow";
	}
	
	
	// 已送达的订单******************************************************************
	public String sendReady(){
		
		//获取session中的user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer scId = new Integer((Integer) u_Id);
				
		request.put("sendReadyInfos", orderSendService.getSendReadyById(scId));
		return "sendReady";
	}
	

	public void prepareAdd(){
		orderModel = new Ordersend();
	}
	
	
	//配送员**********************************************************************
	
	// 未派送的订单 --配送员
	public String noSendBySender(){
		
		//获取session中的user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer user_Id = new Integer((Integer) u_Id);
		
		//获取userSenderId
		String userSenderId = userLoginListService.getRoleByUserId(user_Id).get(0).getUserSenderId();
		Integer senderId = Integer.valueOf(userSenderId);
		
		//获取配送员所属的服务商id	
		Integer scId = senderService.getOneSenderById(senderId).getServicecompany().getScId();
		//System.out.println(scId+"ss"+senderId);
		request.put("noSendInfosBySender", orderSendService.getNoSendBySenderId(scId, senderId));
		return "noSendBySender";
	}
	
	//确认接受订单
	public String  acceptOrder(){
		
		orderModel = orderSendService.getOrderById(orderId);
		orderModel.setOrderStatus("正派送");
		orderSendService.saveOrUpdate(orderModel);
		return "acceptOrder";
	}
	
	//正在派送的订单
	public String sendNowBySender(){
		
		//获取session中的user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer user_Id = new Integer((Integer) u_Id);
		
		//获取userSenderId
		String userSenderId = userLoginListService.getRoleByUserId(user_Id).get(0).getUserSenderId();
		Integer senderId = Integer.valueOf(userSenderId);
		
		//获取配送员所属的服务商id	
		Integer scId = senderService.getOneSenderById(senderId).getServicecompany().getScId();
		//System.out.println(scId+"ss"+senderId);
		request.put("sendNowInfosBySender", orderSendService.getsendNowBySenderId(scId, senderId));
		return "sendNowBySender";
	}
	
	//确认已送达
	public String overOrder(){
		
		orderModel = orderSendService.getOrderById(orderId);
		orderModel.setOrderStatus("已送达");
		orderSendService.saveOrUpdate(orderModel);
		return "overOrder";
	}
	
	//已送达订单
	public String sendReadyBySender(){
		
		//获取session中的user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer user_Id = new Integer((Integer) u_Id);
		
		//获取userSenderId
		String userSenderId = userLoginListService.getRoleByUserId(user_Id).get(0).getUserSenderId();
		Integer senderId = Integer.valueOf(userSenderId);
		
		//获取配送员所属的服务商id	
		Integer scId = senderService.getOneSenderById(senderId).getServicecompany().getScId();
		//System.out.println(scId+"ss"+senderId);
		request.put("sendReadyInfosBySender", orderSendService.getsendReadyBySenderId(scId, senderId));
		
		return "sendReadyBySender";
	}
	
	//已评价订单
	public String sendJudgeBySender(){
		
		//获取session中的user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer user_Id = new Integer((Integer) u_Id);
		
		//获取userSenderId
		String userSenderId = userLoginListService.getRoleByUserId(user_Id).get(0).getUserSenderId();
		Integer senderId = Integer.valueOf(userSenderId);
		
		//获取配送员所属的服务商id	
		Integer scId = senderService.getOneSenderById(senderId).getServicecompany().getScId();
		//System.out.println(scId+"ss"+senderId);
		request.put("sendJudgeInfosBySender", orderSendService.getsendJudgeBySenderId(scId, senderId));
		
		return "sendJudgeBySender";
	}
	
	
	//接口方法*********************************************************************
	public void prepare() throws Exception {}

	private Ordersend orderModel;
	
	public Ordersend getModel() {
		return orderModel;
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
