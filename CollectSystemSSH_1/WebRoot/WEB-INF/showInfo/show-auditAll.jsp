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
    
    <title>My JSP 'show-auditAll.jsp' starting page</title>
    
	

  </head>
  
  <body>
    	<br>
	    <h2 align="center">审核信息</h2>
	    <s:form action="show-auditSelect" method="post">
	    	<table width="350" height="50" border="0" align="center" cellspacing="0">
	          <tr>
	            <td><div align="right">标引条件:</div></td>
	            <td>
	              <div align="left">
	                <s:select name="selectInfo" list="#{'1':'技术需求名称','2':'科技活动类型'}" headerKey="0" headerValue="--请选择--"  multiple="false"/>                			
	                <s:textfield name="inputInfo"></s:textfield>
	              </div>
	             </td>
	          </tr>   
	          <s:hidden name="user_IdS" value="%{#session.user_Id}"/>    
	        </table>
	        <center>
	        	<s:submit value="查询"></s:submit>
	        </center>        
    	</s:form>
    	
    	<!-- 显示查询的信息*************************************************************** -->
	   	
	   	
	   		<table width="1050" height="40" border="1" align="center" cellspacing="0">
	   			<tr>
	    			<td width="77"><div align="center">序号</div></td>
	    			<td width="236"><div align="center">技术需求名称</div></td>
	    			<td width="147"><div align="center">需求时限</div></td>
	    			<td width="173"><div align="center">科技活动类型</div></td>
	    			<td width="100"><div align="center">审核状态</div></td>	
	    			<td width="100"><div align="center">审核</div></td> 			
	  			</tr>
	  			
	  			<!-- 进行遍历 -->
	  			<s:iterator value="#request.selectSkillsAudit">
	  				<tr>
	    				<td width="77" height="40"><div align="center">${skill_Id }</div></td>
	    				<td width="236" height="40"><div align="center">${t_Name }</div></td>
	    				<td width="147" height="40"><div align="center">${t_TimeMin }年至${t_TimeMax }年</div></td>
	    				<td width="173" height="40"><div align="center">${t_Type }</div></td>
	    				<td width="100"><div align="center" style="color: red">${auditState }</div>
	    				<td width="100">
	    					<div align="center">	    					
	    						<a href="show-audit?skill_Id=${skill_Id }">审核</a>
	    					</div>
	    				</td>
	  			</tr>
	  			</s:iterator>
	   		</table>
	   	
  </body>
</html>
