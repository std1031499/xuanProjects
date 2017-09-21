<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'show-auditPassNo.jsp' starting page</title>
    
	

  </head>
  
  <body>
  		<h2 align="center">审核意见填写</h2>
  		<s:form action="show-auditInfoSave" method="post">
	    	<table width="500" height="250" border="1" align="center" cellspacing="0">
	    		<s:iterator value="#request.getSkillInfosPassNo">
		 			<tr>
		   				<td width="150" height="43"><div align="center">技术需求名称</div></td>
		   				<td width="350">
		   					<div align="center">${t_Name }</div>
		   				</td>
		 			</tr>
		 			<tr>
		   				<td>
		   					<div align="center">审核意见</div>
		   				</td>
		   				<td>
		   					<s:textarea  name="auditInfomation" cols="40" rows="15"/>
		   				</td>
		 			</tr>
		 			<s:hidden name="skill_Id" value="%{#session.skill_IdPassNo}"></s:hidden>
		 		</s:iterator>
		 		
			</table>
			<br>
			<center>
				<s:submit value="确定"></s:submit>
			</center>
		</s:form>
  </body>
</html>
