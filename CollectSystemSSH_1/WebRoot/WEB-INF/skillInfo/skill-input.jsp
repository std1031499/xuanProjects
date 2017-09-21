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
    
    <title>技术信息填写</title>
    <script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
   <script type="text/javascript">
   		
   		//科技活动类型填写的规则**********************************************************
   		$(function(){
   			$("input[value='基础研究']").click(function(){
   				//alert("hhh");
   				//隐藏所属领域和需求技术所属领域 显示学科分类
   				if($("#tr_skillPlace").css("display") != 'none' && $("#tr_skillTrade").css("display") != 'none' )
   				{
   					$("#tr_skillPlace").hide();
   					$("#tr_skillTrade").hide();
   				}
   				if($("#tr_subject").css("display") == 'none')
   				{
   					$("#tr_subject").show();
   				}
   			
   			});
   			
   			$("input[value='应用研究'],input[value='试验发展'],input[value='研究发展与成果应用'],input[value='技术推广与科技服务'],input[value='生产性活动']").click(function(){
   				//alert("hhh");
   				//隐藏学科分类    显示所属领域和需求技术所属领域
   				if( $("#tr_subject").css("display") != 'none')
   				{
   					$("#tr_subject").hide();
   				}
   				if($("#tr_skillPlace").css("display") == 'none' && $("#tr_skillTrade").css("display") == 'none')
   				{
   					
   					$("#tr_skillPlace").show();
   					$("#tr_skillTrade").show();
   				}
   			});
   			
   			//关键字顺序输入**********************************************************
   			$("#t_Key1").change(function(){   			
   				var val = $("#t_Key1").val();
   				val  = $.trim(val);
   				 if(val ==""){
   					$("#t_Key2").attr("readonly",true) ;	
   				}
   				else{  					
   					$("#t_Key2").attr("readonly",false) ;
   				} 
   			});
   			
   			$("#t_Key2").change(function(){
   				var val = $("#t_Key2").val();
   				val  = $.trim(val);
   				//alert(val);
   				if(val == ""){
   					//alert("k1");
   					$("#t_Key3").attr("readonly",true) ;   							
				}
   				else{
   					//alert("k2");
   					$("#t_Key3").attr("readonly",false) ;
   					//alert("k3");
   				}  						
   			});
   			
   			$("#t_Key3").change(function(){
	   			var val = $("#t_Key3").val();
		   			val  = $.trim(val);
		   			if(val == ""){
		   				$("#t_Key4").attr("readonly",true) ;
		   									
		   			}
		   			else{
		   				$("#t_Key4").attr("readonly",false) ;
		   			} 
		   	});					
   							
   			$("#t_Key4").change(function(){
   				var val = $("#t_Key4").val();
   				val  = $.trim(val);
   				if(val == ""){
   					$("#t_Key5").attr("readonly",true) ;
   				}
   				else{
   					$("#t_Key5").attr("readonly",false) ;
   				}
   			});
   			
   			//三级联动list*********************************************************
   			//list1
   			 $("#list1").change(function(){
   				//alert("hhh");
   				$("#list2 option:not(:first)").remove();
				$("#list3 option:not(:first)").remove();
				
   				var val = $("#list1").val();
   				val = $.trim(val);
   				if(val !=""){
   					var url = "skill-linkageSecondList";
   					var args = {"listFirstId":val,"time":new Date()};
   					//async: false;
   					$.getJSON(url,args,function(data){
   						//alert("kkk");
   						//data为json数组类型
   						if(data.length==0){
   							alert("无此情况");
   						}
   						else{
   							for(var i=0;i<data.length;i++)
   							{
   								var listSecondId = data[i].listSecondId;
   								var listSecondoName = data[i].listSecondoName;
   								//alert(listSecondId);
   								$("#list2").append("<option value='"+listSecondId+"'>"+listSecondoName+"</option>");
   							} 							
   						}
   					});
   				}
   			});
			
			//list2
			$("#list2").change(function(){
			
			//alert("kkk");
				$("#list3 option:not(:first)").remove();
				var val = $("#list2").val();
				//alert(val);
				val = $.trim(val);
				if(val != ""){
				//alert(val);
					var url = "skill-linkageThirdList";
					var args = {"listSecondId":val,"time":new Date()};
					$.getJSON(url,args,function(data){
						  if(data.length==0){
							alert("无此情况");
						}
						else{
							for(var i=0;i<data.length;i++)
							{
								var listThirdId = data[i].listThirdId;
								var listThirdName = data[i].listThirdName;
								$("#list3").append("<option value='"+listThirdId+"'>"+listThirdName+"</option>");
							}
						}  
					});
				}
			});
		
			//三级联动trade*********************************************************
			$("#trade1").change(function(){
				//alert("hhh");
				$("#trade2 option:not(:first)").remove();
				$("#trade3 option:not(:first)").remove();
				
				var val = $("#trade1").val();
				val = $.trim(val);
				if(val != ""){
					var url = "skill-linkageSecondTrade";
					var args = {"tradeFirstId":val,"time":new Date()};
					$.getJSON(url,args,function(data){
						if(data.length==0){
							alert("无此情况");
						}
						else{
							for(var i=0;i<data.length;i++)
							{
								var tradeSecondId = data[i].tradeSecondId;
								var tradeSecondName = data[i].tradeSecondName;
								$("#trade2").append("<option value='"+tradeSecondId+"'>"+tradeSecondName+"</option>")
							}
						}
					});
				}
			});
	
			$("#trade2").change(function(){
				//alert("hhh");
				$("#trade3 option:not(:first)").remove();
				var val = $("#trade2").val();
				val = $.trim(val);
				if(val != ""){
					var url = "skill-linkageThirdTrade";
					var args = {"tradeSecondId":val,"time":new Date()};
					$.getJSON(url,args,function(data){
						if(data.length==0){
							alert("无此情况");
						}
						else{
							for(var i=0;i<data.length;i++)
							{
								var tradeThirdId = data[i].tradeThirdId;
								var tradeThirdName = data[i].tradeThirdName;
								$("#trade3").append("<option value='"+tradeThirdId+"'>"+tradeThirdName+"</option>");
							}
						}
					});
				}
			});
	
			//返回添加成功
			
	
	
	
   		});
   		
   		//最大输入字数***********************************************************
   		function getNum(textarea,span){
   			//alert("sasa");
   			 var len = document.getElementById(textarea).value.length;
   			if(len>499){
   				document.getElementById(textarea).value = 
   					document.getElementById(textarea).value.substring(0,500);
   			}
   			document.getElementById(span).innerHTML = len; 
   		}
   		
   </script>

  </head>
  
  <body>
    	<h2 align="center">技术信息填写</h2>
  		<form action="skill-save" method="post">
    		<table width="900" height="1224" border="1" align="center" cellspacing="0">
    			<tr>
    				<td width="150" height="45" align="center" valign="middle">*技术需求名称</td>
    				<td height="45" colspan="2" align="center" valign="middle" >
						<s:textfield name="t_Name"></s:textfield></td>
    				<td width="200" height="45" align="center" valign="middle">*需求时限</td>
    				<td width="243" height="45" align="center" valign="middle">
      				<label>
						<s:select name="t_TimeMin" list="{'2001','2002','2003'}" headerKey="-1" headerValue="--请选择--"  multiple="false"/>        
        			年至
    					<s:select name="t_TimeMax" list="{'2001','2002','2003'}" headerKey="-1" headerValue="--请选择--"  multiple="false"/>
    				年     
    				</label>
    				</td>
 				</tr>
 
 				<tr>
     				<td width="79" height="184" rowspan="3" align="center" valign="middle">*科技需求概述(限500字)</td>
     				<td height="182" colspan="4" align="center" valign="middle"><p align="left">主要问题</p>       				
	   					<s:textarea  name="t_MainProblem"  id="mainProblem" onkeyup="getNum('mainProblem','mainProblemNum')"
	   					cols="80" rows="10" cssStyle="resize:none"/>
	   					<br>
     					<span id="mainProblemNum">0</span>/500字
	   				</td>
  				</tr>
  
  				<tr>
   					<td height="188" colspan="4" align="center" valign="middle"><p align="left">技术关键</p>     			
       					<s:textarea  name="t_SkillKey" id="skillKey" onkeyup="getNum('skillKey','skillKeyNum')"
       					 cols="80" rows="10" cssStyle="resize:none"/>
       					<br>
     					<span id="skillKeyNum">0</span>/500字
     				</td>
 				</tr>
 
 				<tr>
   					<td height="184" colspan="4" align="center" valign="middle"><p align="left">预期目标 </p>    
       					<s:textarea  name="t_Aim" id="aim" onkeyup="getNum('aim','aimNum')"
       					 cols="80" rows="10" cssStyle="resize:none"/>
       					<br>
     					<span id="aimNum">0</span>/500字
       				</td>
 				</tr>
 
 				<tr>
    				<td height="67" align="center" valign="middle">*关键字(1-5个顺序输入)</td>
    				<td colspan="4" align="center" valign="middle">
						<s:textfield name="t_Key1" id="t_Key1" size="15"/>
						,
						<s:textfield name="t_Key2" id="t_Key2" size="15" readonly="true"/>
						,
						<s:textfield name="t_Key3" id="t_Key3" size="15" readonly="true"/>
						,
						<s:textfield name="t_Key4" id="t_Key4" size="15" readonly="true"/>
						,
						<s:textfield name="t_Key5" id="t_Key5" size="15" readonly="true"/>
						
   						</td>
  				</tr>
  
  				<tr>
    				<td height="67" align="center" valign="middle">拟投入自有资金总额</td>
    				<td colspan="4" align="center" valign="middle">
						<s:textfield name="t_MoneySet" size="15"></s:textfield>万元
					</td>
  				</tr>
  
  				<tr>
    				<td height="67" rowspan="2" align="center" valign="middle">*技术需求解决方式</td>
    				<td height="41" colspan="4" align="center" valign="middle">						
						<s:radio list="#{'独立开发':'独立开发','委托研发':'委托研发','合作研发':'合作研发','其他':'其他'}" 
						name="t_Cooperate" value="独立开发"/>
   	     			</td>
  				</tr>
  
				<tr>
    				<td height="40" colspan="4" align="center" valign="middle"><span class="STYLE1">合作意向单位</span>
      					<s:textfield name="t_Unit" size="60"></s:textfield>
    					<span class="STYLE1">(选填)</span></td>
  				</tr>
  
  				<tr>
    				<td height="67" align="center" valign="middle">*科技活动类型</td>   
    				<td colspan="4" align="center" valign="middle">
        				<s:radio list="#{'基础研究':'基础研究','应用研究':'应用研究','试验发展':'试验发展','研究发展与成果应用':'研究发展与成果应用','技术推广与科技服务':'技术推广与科技服务','生产性活动 ':'生产性活动 '}"  value="基础研究"
        				name="t_Type" /> </td>
  				</tr>  
  
  				<tr id="tr_subject" style="display:none;">									
					<td height="61" align="center" valign="middle">			
						<p>*学科分类</p>
    					<p>（限基础研究填写）</p>
    				</td>    		
    				<td colspan="4" align="center" valign="middle">   		
    					 <s:select list="#request.listFirsts"
							listKey="listFirstId" listValue="listFirstName" name="listFirst.listFirstId" id="list1" headerKey="0" headerValue="--请选择--">				
						</s:select>	 		
						<s:select name="listSecond.listSecondId" id="list2" list="{}" headerKey="0" headerValue="--请选择--"  multiple="false"/>
						<s:select name="listThird.listThirdId" id="list3" list="{}" headerKey="0" headerValue="--请选择--"  multiple="false"/>						
					</td>
				</tr>
 
 				<tr id="tr_skillPlace" style="display:none;">
    				<td height="96" align="center" valign="middle"><p>*需求技术所属领域(非基础研究填写)</p>    </td>
    				<td colspan="4" align="center" valign="middle">
				    <p id="ssly">
				    	<s:checkboxlist name="t_Territory"  list="{'电子信息技术','光机电一体化','软件','生物制药技术','新材料及应用技术','先进制造技术'
				    		,'现代农业技术','新能源与高效节能技术','资源与环境','高技术服务业','海洋','社会公共事业','其他技术'}" />
				    </p>
					</td>
				</tr>
  	
    			<tr id="tr_skillTrade" style="display:none;">
					<td height="47" align="center" valign="middle">
    				<p>*需求技术应用行业(非基础研究填写)</p></td>
					<td colspan="4" align="center" valign="middle">
						
						<s:select list="#request.tradeFirsts"
							listKey="tradeFirstId" listValue="tradeFirstName" name="tradeFirst.tradeFirstId" id="trade1" headerKey="0" headerValue="--请选择--">				
						</s:select>
						<s:select name="tradeSecond.tradeSecondId" id="trade2" list="{}" headerKey="0" headerValue="--请选择--"  multiple="false"/>
						<s:select name="tradeThird.tradeThirdId" id="trade3" list="{}" headerKey="0" headerValue="--请选择--"  multiple="false"/>
					
					</td>
				</tr>
			<s:hidden name="user_IdS" value="%{#session.user_Id}"/>
			<s:hidden name="auditState" value="待审核"/>
    		</table>
    		<center>
			<br>
			<s:submit value="确定"></s:submit>
			</center>
    	</form>
  </body>
</html>
