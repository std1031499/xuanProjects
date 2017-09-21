<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'emp-login.jsp' starting page</title>
    
	<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
    	//是否需要删除信息
    	$(function(){
    		$(".delete").click(function(){
    		
    			var username = $(this).next(":input").val();
    			var flag = confirm("确定需要删除"+username+"的信息吗?");//jQuery
    			if(flag){
    				var $tr = $(this).parent().parent();//当前行
    				//删除，使用ajax的方式
    				var url = this.href;
    				var args = {"time":new Date()};
    				$.post(url,args,function(data){
    					//根据data返回值判断
    					if(data=="1"){
    						alert("删除成功！");
    						$tr.remove();//删除当前行
    					}
    					else{
    						alert("删除失败!");
    					}
    				})
    			}
    			//取消超链接的默认行为
    			return false;
    		})
    	})
    </script>
	
  </head>
  
  <body>
    	<h4>user show test</h4>
    	
    	<s:if test="#request.users == null || #request.users.size() == 0">
    		没有用户信息
    	</s:if>
    	<s:else>
    		<table border="1" cellpadding="10" cellspacing="0">
    			<tr>
    				<td>user_Id</td>
    				<td>用户名</td>
    				 <td>密码</td> 
    				<td>等级</td>
    				<td>删除</td>    
    				<td>编辑</td>							
    			</tr>
    			<!-- 进行遍历  -->
    			<s:iterator value="#request.users">
    				<tr>
    					<td>${user_Id }</td>
    					<td>${c_Username }</td>
    					<td>${c_Password }</td> 
    					<td>${c_Level }</td>
    					<td>
    						<a href="emp-delete?user_Id=${user_Id }" class="delete">删除</a>
    						<input type="hidden" value=${c_Username }>
    					</td>
    					<td>
    						<a href="emp-register?user_Id=${user_Id }" >编辑</a>
    					</td>
    					
    				</tr>
    			</s:iterator>
    		</table>
    	</s:else>
  </body>
</html>
