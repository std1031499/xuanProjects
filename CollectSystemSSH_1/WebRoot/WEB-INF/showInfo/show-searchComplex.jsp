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
    
    <title>My JSP 'show-searchComplex.jsp' starting page</title>
		<link href="css/button.css" rel="stylesheet" type="text/css"/>
		<link href="css/MyTable.css" rel="stylesheet" type="text/css"/>
		<link href="css/MyForm.css" rel="stylesheet" type="text/css"/>
		
		<!-- 确认按钮 -->
		<style type="text/css">
			.sub {
			    background: #FFF;
			    border: 1px solid #CCC;
			    padding: 8px 15px 8px 15px;
			    color: black;
			    border-radius: 4px;
			}
			.sub:hover {
			    color: #333;
			    background-color: #EBEBEB;
			    border-color: #ADADAD;
			}
		</style>
		
		<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
		<script type="text/javascript">
			
			$(function(){				
				var num=0;
				$("#add").click(function(){
					
					//alert("hhh");
					 if(num<4){
					 	 $tr = '';
					 	 $tr+="<tr>";
					 	 $tr+="<td><select name='selectAnother'><option value='1'>并且</option><option value='0'>或者</option><option value='-1'>不含</option></select></td>";
					 	 $tr+="<td><select name='selectTypes'><option value='技术需求名称'>技术需求名称</option><option value='科技活动类型'>科技活动类型</option><option value='技术需求解决方式'>技术需求解决方式</option><option value='关键字'>关键字</option></select></td>";
					 	 $tr+="<td ><label><input type='text' name='selectInputsType' /></label></td>";
					 	 $tr+="<td ><select name='includeOrNot'><option value='1'>并含</option><option value='0'>或含</option><option value='-1'>不含</option></select></td>";
					 	 $tr+="<td ><input type='text' name='selectInputsInclude' /></td>";
					 	 $tr+=" <td><select name='exactOrNot'><option value='1'>精确</option><option value='0'>模糊</option></select></td>";
					 	 $tr+="</tr>";
					 	
					 	 $("#top").append($tr);					 	 
					 	 num++;
					 }
					 return false;					 
				});
				
				$("#delete").click(function(){
					
					//var $tr = $(this).parent().parent().parent();
					if(num>0){
						
						$("#top tr:last").remove();
						num--;
					}
					return false;
				});
				
				
			});
			
		</script>
  </head>
  
  <body>
  		<br>
  		<h2 class="press" align="center" >填报信息</h2>
  		<s:form action="show-selectComplex" method="post">
  		
	    	<table id="top" class="hovertable"  border="1" align="center" cellspacing="0">
	    	
			  <tr id="firstSelect" >
			  	<s:hidden name="selectAnother" value="1"></s:hidden>
			    <td >
			      <label>
			      	<button id="add" class="button button-square button-tiny" style="font-size: 20px;">+<i class="fa fa-plus"></i></button>
			      </label>		     
			      <label>
			     	<button id="delete" class="button button-square button-tiny" style="font-size: 20px;">-<i class="fa fa-plus"></i></button>
			      </label>
			    </td>
			     
			    <td >
			    	<select name="selectTypes">
				      <option>技术需求名称</option>
				      <option>科技活动类型</option>
				      <option>技术需求解决方式</option>
				      <option>关键字</option>
			        </select>
			    </td>
			    
			    <td >
			      <label>
			        <input type="text" name="selectInputsType" />
			        </label>
				</td>
			    <td >
			    	<select name="includeOrNot">
				      <option value="1">并含</option>
				      <option value="0">或含</option>
				      <option value="-1">不含</option>
			        </select>
			    </td>
			    
			    <td >
			    	<input type="text" name="selectInputsInclude" />
			    </td>
			    
			    <td>
			    	<select name="exactOrNot">
				      <option value="1">精确</option>
				      <option value="0">模糊</option>
			        </select>
			    </td>
			  </tr>
			  <s:hidden name="user_IdS" value="%{#session.user_Id}"/> 
		</table>
		<center>
			<br>
        	<s:submit cssClass="sub" value="查询"></s:submit>
        </center> 
	</s:form>
	
	
	 <!-- 显示查询的信息*************************************************************** -->
   		<table class="hovertable" width="1050" height="40" border="1" align="center" cellspacing="0">
   			<tr>
    			<th width="77"><div align="center">序号</div></td>
    			<th width="236"><div align="center">技术需求名称</div></td>
    			<th width="147"><div align="center">需求时限</div></td>
    			<th width="173"><div align="center">科技活动类型</div></td>
    			<th width="100"><div align="center">审核状态</div></td>
    			<th width="100"><div align="center">审核意见</div></td>
    			<th width="65"><div align="center">编辑</div></td>
    			<th width="65"><div align="center">查看</div></td>
    			<th width="65"><div align="center">删除</div></td>
  			</tr>
  			
  			<!-- 进行遍历 -->
  			<s:iterator value="#request.selectSkillHigh">
  				<tr onmouseover="this.style.backgroundColor='#D1EEEE';" onmouseout="this.style.backgroundColor='#a9c6c9';">
    				<td width="77" height="40"><div align="center">${skill_Id }</div></td>
    				<td width="236" height="40"><div align="center">${t_Name }</div></td>
    				<td width="147" height="40"><div align="center">${t_TimeMin }年至${t_TimeMax }年</div></td>
    				<td width="173" height="40"><div align="center">${t_Type }</div></td>
    				<td width="100"><div align="center" style="color: red">${auditState }</div>
    				</td>
    				<td width="100">
    					<div align="center">
    						<s:if test="%{#request.auditInfomation!=null}">
    							<a href="show-auditInfomation?skill_Id=${skill_Id }" class="audit">审核意见</a>
    						</s:if>
    						<s:else>
    							无
    						</s:else>
    						
    					</div>
    				</td>
    				<td width="65" height="40">
    					<div align="center">
    						<!-- 灰色并取消链接-->
    						<s:if test="%{#request.auditState == '待审核' }">
    							<a href="show-edit?skill_Id=${skill_Id }">编辑</a>
    						</s:if>
    						<s:else>
    							<a href="JavaScript:return false;" style="opacity: 0.2">编辑</a>
    						</s:else>
    					</div>    				
    				</td>
    				<td width="65" height="40">
    					<div align="center">
    						<a href="show-check?skill_Id=${skill_Id }">查看</a>
    					</div>
    				</td>
    				<td width="65" height="40">
    					<div align="center">
    						<s:if test="%{#request.auditState != '已通过' }">
	    						<a href="show-delete?skill_Id=${skill_Id }" class="delete">删除</a>
	    						<input type="hidden" value="${t_Name }">
    						</s:if>
    						<s:else>
    							<a href="JavaScript:return false;" style="opacity: 0.2">删除</a>
    						</s:else>
    					</div>
    				</td>
  			</tr>
  			</s:iterator>
   		</table>
  </body>
</html>
