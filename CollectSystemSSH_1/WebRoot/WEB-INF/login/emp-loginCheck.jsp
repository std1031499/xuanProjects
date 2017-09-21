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
    
    <title>My JSP 'emp-loginCheck.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    	<h4>登录界面</h4>
    	
    	<s:form action="emp-loginSave" method="post">
    		<table border="0">
    			<tr>
    				<td>
    					<s:textfield name="c_Username" label="用户名"></s:textfield>
    				</td>
    			</tr>
    			<tr>
    				<td>
    					<s:textfield name="c_Password" label="密码"></s:textfield>
    				</td>
    			</tr>
    			<tr>
    				<td>
    					<s:textfield name="c_Level" label="等级"></s:textfield>
    				</td>
    			</tr>
    			<s:submit value="登录"></s:submit>
    		</table>
    	</s:form>
  </body>
</html>
