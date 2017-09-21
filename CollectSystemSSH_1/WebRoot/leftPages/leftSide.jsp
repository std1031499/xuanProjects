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
	
	<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		
		$(function(){
			
			//进行用户类型的判断
			$("#leftReady").ready(function(){
				//alert("hhh");
				var url = "emp-judgeLevel";
				var args = {"time":new Date()};
				//$("#editFillers").hide();
				$.post(url,args,function(data){
					if(data=="3"){
						//填报员
						$("#auditAuditors").hide();						
					}
					else if(data=="2"){
						//审核员
						$("#editFillers").hide();	
						$("#showFillers").hide();	
					}
					else if(data=="1"){
						//管理员
						$("#auditAuditors").hide();	
						$("#editFillers").hide();	
						$("#showFillers").hide();
					}
				});
			});
			
		});
		
	</script>
  </head>
  	
  <body leftFrame="true" id="leftReady">
    	 <div id="scrollContent">
		<div class="arrowlistmenu" >
			<div class="menuheader expandable" >系统菜单</div>	
					
			<ul class="categoryitems" id="1">
			
				<!-- 共有的 -->
				<li><a><span>用户信息</span></a>
					<ul >
						<li>
							<a href="emp-register?user_Id=${user_Id }" target="frmright"><span class="text_slice"> 修改信息</span>
							</a>
							
						</li>
					</ul>
				</li>
				
				
				<li><a href="emp-systemIntro" target="frmright"><span class="text_slice">系统简介</span></a></li>
				
				<!-- 普通用户 -->
				<li id="editFillers"><a><span>信息编辑</span></a>
					<ul>
						<li><a href="basic-input?user_Id=${user_Id }" target="frmright"><span
							class="text_slice">基础信息</span></a></li>
						<li><a href="skill-input?user_Id=${user_Id }" target="frmright"><span
							class="text_slice">技术信息</span></a></li>												
					</ul>
				</li>
				
				<li id="showFillers"><a><span>显示信息</span></a>
					<ul>
						<li><a href="show-search?user_Id=${user_Id }" target="frmright"><span class="text_slice">简单查询</span></a></li>
					
					
						<li><a href="show-searchComplex?user_Id=${user_Id }" target="frmright"><span class="text_slice">高级查询</span></a></li>
						
						<li><a href="show-tree" target="frmright"><span class="text_slice">分类检索</span></a></li>
					</ul>
				</li>
				
				<!-- 审核员 -->
				<li id="auditAuditors"><a><span>网络审核</span></a>
					<ul>
						<li><a  href="show-auditAll?user_Id=${user_Id }" target="frmright"><span
							class="text_slice">审核信息</span></a></li>
					</ul>
				</li>	
				
				<!-- 管理员 -->
				<%-- <li ><a><span>权限分配</span></a>
					<ul>
						<li><a  href="" target="frmright"><span
							class="text_slice">分配权限</span></a></li>
						<li><a  href="" target="frmright"><span
							class="text_slice">角色编辑</span></a></li>
					</ul>
				</li> --%>
				
			</ul>			
			</div>
			</div> 
  </body>
</html>
