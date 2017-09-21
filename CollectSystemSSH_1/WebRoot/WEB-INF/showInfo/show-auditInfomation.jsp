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
    
    <title>显示审核意见</title>
   
  </head>
  
  <body>
    	<h2 align="center">审核意见</h2>
  		
	    	<table width="500" height="250" border="1" align="center" cellspacing="0" style="TABLE-LAYOUT: fixed">
	    		<s:iterator value="#request.auditInfomationById">
		 			<tr>
		   				<td width="150" height="40"><div align="center">技术需求名称</div></td>
		   				<td >
		   					<div align="center">${t_Name }</div>
		   				</td>
		 			</tr>
		 			<tr >
		   				<td >
		   					<div align="center">审核意见</div>
		   				</td>
		   				<td style="WORD-WRAP: break-word" width="20">
		   					${auditInfomation }
		   				</td>
		 			</tr>
		 			
		 		</s:iterator>
		 		
			</table>
			
		
  </body>
</html>
