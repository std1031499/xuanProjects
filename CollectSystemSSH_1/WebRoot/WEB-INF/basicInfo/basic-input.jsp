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
    
    <title>基础信息录入</title>
    <script type="text/javascript">
    	
    </script>

  </head>
  	
  	
  <body>
  
		<s:if test="#session.basic_Id == null">
  			<h2 align="center">基础信息填写</h2>
  		</s:if>
   		<s:else>
   			<h2 align="center">基础信息</h2>
   		</s:else>
  		
   		
   		
   		<s:form action="basic-save" method="post"> 
   		<!-- 若未填写 则填写基础信息*********************** -->
   		 <s:if test="#session.basic_Id == null">
   			<table width="850" height="477" border="1" align="center" cellspacing="0">  				 	
 	 			<tr>
    				<td width="77" height="34" align="center" valign="middle">*机构全称</td>
    				<td height="34" colspan="2" align="center" valign="middle">
        				<s:textfield name="c_Name"></s:textfield></td>
  	    			<td height="34" colspan="2" align="center" valign="middle">归口管理部门</td>
      		 		<td height="34" align="center" valign="middle">
        				<s:select list="#request.managements"
								listKey="management_Id" listValue="managementName" name="management.management_Id">				
						</s:select>
       
       				</td>
    			</tr>
  
    			<tr>
    				<td height="35" align="center" valign="middle">*通讯地址</td>
    				<td height="34" colspan="2" align="center" valign="middle">
    					<s:textfield name="c_AddressT"></s:textfield></td>
    				<td height="34" colspan="2" align="center" valign="middle">*所在地域</td>
   	  				<td height="34" align="center" valign="middle">
	  					<s:select list="#request.areas"
								listKey="area_Id" listValue="areaName" name="area.area_Id" >				
						</s:select>
         			</td>
    			</tr>
  
    			<tr>
    				<td align="center" valign="middle">网址</td>
    				<td colspan="2" align="center" valign="middle">       
        				<s:textfield name="c_AddressW"></s:textfield>    	</td>
    				<td width="212" align="center" valign="middle">*电子信箱</td>
    				<td colspan="2" align="center" valign="middle">   
        				<s:textfield name="c_AddressE"></s:textfield>    </td>
   				</tr>
  
  				<tr>
    				<td align="center" valign="middle">*法人代表</td>
    				<td colspan="2" align="center" valign="middle">    
        				<s:textfield name="c_Person"></s:textfield>    	</td>
    				<td align="center" valign="middle">邮政编码</td>
    				<td colspan="2" align="center" valign="middle">   
        				<s:textfield name="c_Code"></s:textfield>    </td>
  				</tr>
  
  				<tr>
    				<td height="69" rowspan="2" align="center" valign="middle">*联系人</td>
    				<td width="191" rowspan="2" align="center" valign="middle">   
      					<s:textfield name="c_contact"></s:textfield>       
      				</td>       
    				<td width="96" align="center" valign="middle">*电话</td>
    				<td colspan="2" align="left" valign="middle">
    					<p>1固定
            			<s:textfield name="c_Phone"></s:textfield>
    					</p>   	   
    				</td>   
   	 				<td width="251" align="left" valign="middle">2手机  
      					<s:textfield name="c_Telephone"></s:textfield>    </td>
  				</tr>
  
  				<tr>
    				<td align="center" valign="middle">传真</td>
   					<td colspan="3" align="center" valign="middle">
        				<s:textfield name="c_Mail"></s:textfield>   	
        			</td>
  				</tr>
  
  				<tr>
    				<td align="center" valign="middle">*机构属性</td>
   	   				<td colspan="5" align="center" valign="middle">
   	     				<s:radio name="c_Property" list="#{'企业':'企业','高等院校':'高等院校','研究机构':'研究机构','其他':'其他'}"  value="企业"></s:radio>
   	     
         			</td>
    			</tr>
  
  				<tr>
    				<td align="center" valign="middle">*机构简介(限200字)</td>
   	 				<td colspan="5" align="center" valign="middle">
      	  				<p>
      	    			<s:textarea  name="c_Introduction" cols="40" rows="10"/>
      	  				</p>
      					<p>&nbsp;</p>
      				</td>	
  				</tr>
  				 
  				<s:hidden name="user_IdB" value="%{#session.user_Id}"></s:hidden>
  						  			  				
		</table>
	</s:if>
		
	<!-- *********************************若已填写,则显示填写的基础信息*************************************** -->
	<s:else>
		<table width="850" height="477" border="1" align="center" cellspacing="0">
			
			
			<s:iterator value="#request.basics">
 	 			<tr>
    				<td width="77" height="34" align="center" valign="middle">*机构全称</td>
    				<td height="34" colspan="2" align="center" valign="middle">
        				${c_Name }</td>
  	    			<td height="34" colspan="2" align="center" valign="middle">归口管理部门</td>
      		 		<td height="34" align="center" valign="middle">
        				${management.managementName }     
       				</td>
    			</tr>
  
    			<tr>
    				<td height="35" align="center" valign="middle">*通讯地址</td>
    				<td height="34" colspan="2" align="center" valign="middle">
    					${c_AddressT }</td>
    				<td height="34" colspan="2" align="center" valign="middle">*所在地域</td>
   	  				<td height="34" align="center" valign="middle">
	  					${area.areaName }
         			</td>
    			</tr>
  
    			<tr>
    				<td align="center" valign="middle">网址</td>
    				<td colspan="2" align="center" valign="middle">       
        				${c_AddressW }    	</td>
    				<td width="212" align="center" valign="middle">*电子信箱</td>
    				<td colspan="2" align="center" valign="middle">   
        				${c_AddressE }    </td>
   				</tr>
  
  				<tr>
    				<td align="center" valign="middle">*法人代表</td>
    				<td colspan="2" align="center" valign="middle">    
        				${c_Person }    	</td>
    				<td align="center" valign="middle">邮政编码</td>
    				<td colspan="2" align="center" valign="middle">   
        				${c_Code }    </td>
  				</tr>
  
  				<tr>
    				<td height="69" rowspan="2" align="center" valign="middle">*联系人</td>
    				<td width="191" rowspan="2" align="center" valign="middle">   
      					${c_contact }       
      				</td>       
    				<td width="96" align="center" valign="middle">*电话</td>
    				<td colspan="2" align="left" valign="middle">
    					<p>1固定
            			${c_Phone }
    					</p>   	   
    				</td>   
   	 				<td width="251" align="left" valign="middle">2手机  
      					${c_Telephone }    </td>
  				</tr>
  
  				<tr>
    				<td align="center" valign="middle">传真</td>
   					<td colspan="3" align="center" valign="middle">
        				${c_Mail } 	
        			</td>
  				</tr>
  
  				<tr>
    				<td align="center" valign="middle">*机构属性</td>
   	   				<td colspan="5" align="center" valign="middle">
   	     				${c_Property }
         			</td>
    			</tr>
  
  				<tr>
    				<td align="center" valign="middle">*机构简介(限200字)</td>
   	 				<td colspan="5" align="center" valign="middle">
      	  				<p>
      	    			${c_Introduction }
      	  				</p>
      					<p>&nbsp;</p>
      				</td>	
  				</tr>
  			</s:iterator>
  			
		</table>
	</s:else>
				
		<center>
			<br><br>
			<s:if test="#session.basic_Id == null">
				<s:submit value="确定"></s:submit>
			</s:if>
			<s:else>
				<a href="basic-edit?basic_Id=${basic_Id }">编辑</a>
			</s:else>			
		</center>
	</s:form>
   		
  </body>
</html>
