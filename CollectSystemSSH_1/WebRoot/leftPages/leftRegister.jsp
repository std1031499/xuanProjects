<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>左侧栏</title>
    
    <!--框架必需start-->
	<script type="text/javascript" src="../js/jquery-1.4.js"></script>
	<script type="text/javascript" src="../js/framework.js"></script>
	<link href="../css/import_basic.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" id="skin" />
	
	<!--框架必需end-->
	<script type="text/javascript" src="../js/nav/ddaccordion.js"></script>
	<script type="text/javascript" src="../js/text/text-overflow.js"></script>
	<style>
	a {
		behavior: url(../js/method/focus.htc)
	}

	.categoryitems span {
		width: 160px;
	}
</style>

  </head>
  	
  <body leftFrame="true" >
    	 <div id="scrollContent">
		<div class="arrowlistmenu" >
			<div class="menuheader expandable" >系统菜单</div>	
					
			<ul class="categoryitems" id="1">
			
			
				
						<li>
							<a href="emp-register?user_Id=${null }" target="frmright"><span class="text_slice"> 用户注册</span>
							</a>
							
						</li>
				
				
				
				<li ><a href="emp-systemIntro" target="frmright"><span class="text_slice">系统简介</span></a></li>
				
						
			</ul>			
			</div>
			</div> 
  </body>
</html>
