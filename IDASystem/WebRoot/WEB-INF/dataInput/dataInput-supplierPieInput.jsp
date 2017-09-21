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
    
    <title>My JSP 'dataInput-supplierPieInput.jsp' starting page</title>
    <!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    
	<script src="Chart.js-master/Chart.js"></script>
	<script src="assets/js/jquery-1.10.2.js"></script>
	<link href="MyCss/button.css" rel="stylesheet" type="text/css"/>
	<link href="MyCss/MyTable.css" rel="stylesheet" type="text/css"/>
	<link href="MyCss/MyForm.css" rel="stylesheet" type="text/css"/>
	
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
			
			ul{
			    
			}

			ul li{
			    
			    color:white;
			    list-style-type:none
			}
		
			
		</style>
		
	<script type="text/javascript">
			
			//生成随机颜色
			function getRandomColor()
			{
				var c = '#';
				var cArray = ['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'];
				for(var i = 0; i < 6;i++)
				{
				var cIndex = Math.round(Math.random()*15);
				c += cArray[cIndex];
				}
				return c;
			} 
			
			//生成饼状图
			function pie(Data){
				
				if(Data.length == null || Data.length == 0)
					return;
					 
				var pieData=[];
				var nameData = new Array();
				var colorNum = 0;
				var valuePercent;//所占百分比
				var valueSum=0;//总数
				for(var i=0;i<Data.length;i++){
					valueSum = valueSum+Data[i][1];
				}
				//alert(valueSum);
				for(var i=0;i<Data.length;i++){
					
					nameData[i] = {};
					valuePercent =  Data[i][1]/valueSum;
					//alert(valuePercent);
					nameData[i].value = valuePercent;
					nameData[i].color = getRandomColor();
					//jquery 设置多个css属性
					$("ul li").eq(colorNum).css({"background-color" : nameData[i].color});
					//document.getElementById('navition').style.cssText = "您的CSS代码';
					colorNum++;
				}
				
				for(var i=0;i<Data.length;i++){
					pieData.push(nameData[i]);
				}

				console.info(pieData); 
				
				//cxt.clearRect(0,0,900,400);
				var ctx = $("#myChart").get(0).getContext("2d");
				
				var myNewChart = new Chart(ctx);
				 
				myNewChart.Pie(pieData);
				
				
			}
				
				
				
			$(function(){
				
				
				//添加删除查询条件	***************************************************		
				var num=0;
				$("#add").click(function(){
					
					//alert("hhh");
					 if(num<3){
					 	 $tr = '';
					 	 $tr+="<tr>";
					 	 $tr+="<td><select name='selectAnother'><option value='1'>并且</option value='0'><option>或者</option><option value='-1'>不含</option></select></td>";
					 	 $tr+="<td><select name='selectTypes'><option value='year'>进项日期(年)</option><option value='tax'>进项税金</option><option value='money'>进项金额</option><option value='sum'>进项合计金额</option></select></td>";
					 	 $tr+="<td ><label><input type='text' name='selectInputsMin' />(最小值)</label></td>";
					 	 $tr+="<td><label>至</label></td>";
					 	 $tr+="<td ><label><input type='text' name='selectInputsMax' />(最大值)</label></td>";
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
				
				
				
				//显示pie图
				 		
				$("#show").click(function(){
					$("#supplierForm").serialize();
					//var val = $("#chartType").val();
					var url = "dataInput-supplierPieInputShow";
					
					//var args = {"chartType":val,"time":new Date()};
					//$("#supplierForm").serialize();
					//Ruselt=encodeURIComponent(JSON.stringify($("#supplierForm").serialize()),"utf-8");
					$.getJSON(url,$("#supplierForm").serialize(),function(data){
					//alert(data[1][0]);
						if(data==''){
							alert("未查到此结果！");
						}
						else{
							
							/* var ctx = $("#myChart").getContext("2d");
							cxt.clearRect(0,0,c.width,c.height); */
							//clearCanvas();  
							console.info(data); 	
							//alert("h2");	
							addTitle(data);			
				            pie(data);//生成饼状图
				            supplierResult(data);//分析结果
						}
						
			             
					});
					
					
					
					return false;
					
				});
				
				//添加title
				function addTitle(Data){
					
					$ul = '';					
					for(var i=0;i<Data.length;i++){
						$ul+="<li>"+Data[i][0]+"</li>";
					}
					$("#titlePie li").remove();
					$("#titlePie").append($ul);
				}
				
				//清空画布
			   /*  function clearCanvas()  
			    {  
			    	alert("gg1");
			        var c=document.getElementById("myChart");  
			        var cxt=c.getContext("2d");  
			        cxt.clearRect(0,0,900,400); 
			        alert("gg2"); 
			    }   */
			    
			    
			    /* function clearCanvas()  
			    {  
			        var c=document.getElementById("myChart");  
			        var cxt=c.getContext("2d");  
			          
			        ctx.fillStyle="red";
					ctx.fillRect(0,0,900,400);
					ctx.clearRect(20,20,100,50);
			    }   */
	    		
	    		//分析结果
	    		function supplierResult(Data){
	    			
	    			//交易次数少的供应商 前三
					var badSupplier = new Array();	
					//var arr2 = new Array(2);
					for(var i=0;i<Data.length;i++)
					{
						badSupplier[i] = new Array();
						for(var j=0;j<Data.length;j++)
						{
							badSupplier[i][j] = Data[i][j];
						}
						
					}
		
					//只要flag在下一次外循环条件检测的时候值为false，就说明已经排好序，不用继续循环
					var flag = true;	
					for(var i=0;i<badSupplier.length&&flag;i++)
					{
						flag = false;
						for(var j=badSupplier.length-1;j>i;j--)
						{
							if(badSupplier[j][1]<badSupplier[j-1][1])
							{
								//冒泡排序
								var temp1,temp2;
								temp1 = badSupplier[j][1];
								temp2 = badSupplier[j][0];
								badSupplier[j][1] = badSupplier[j-1][1];
								badSupplier[j][0] = badSupplier[j-1][0];
								badSupplier[j-1][1] = temp1;
								badSupplier[j-1][0] = temp2;
								flag = true;//如果有交换，就将标记变量赋true
							}
						}
						
					}   
// 					alert(badSupplier); 
		

					// 	数据结果
					$tr = '';					
					$tr+="<tr><td>重点供应商："+badSupplier[badSupplier.length-1][0]+"、"+badSupplier[badSupplier.length-2][0]+"、"+badSupplier[badSupplier.length-3][0]+"</td></tr>";					
			  		
					$("#supplierResults tr").remove();
					$("#supplierResults").append($tr);
					
					//分析建议
					$tr = '';
					$tr = "<tr><td>建议：</td></tr>";
					$tr+="<tr><td>&nbsp&nbsp 与&nbsp&nbsp<a style='color:red'>"+badSupplier[badSupplier.length-1][0]+"、"+badSupplier[badSupplier.length-2][0]+"、"+badSupplier[badSupplier.length-3][0]+"</a>&nbsp&nbsp供应商进行大量合作，与该供应商进行交易次数较多"+"</td></tr>";
					$tr+="<tr><td>&nbsp&nbsp 与&nbsp&nbsp<a style='color:red'>"+badSupplier[0][0]+"、"+badSupplier[1][0]+"、"+badSupplier[2][0]+"</a>&nbsp&nbsp供应商进行少量合作，与该供应商进行交易次数较少"+"</td></tr>";
					
					$("#supplierSuggestions tr").remove();
					$("#supplierSuggestions").append($tr);
	    			
	    		}
				
			});
			
	</script>
  </head>
  
  <body>
  
  		<div >
            <div id="page-inner">


                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                             <small>重点供应商分析</small>
                        </h1>
                    </div>
                </div>
                <!-- /. ROW  -->
                
               <div class="form-group" >
              
               		<s:form id="supplierForm" action="dataInput-supplierPieInputShow" method="post">
			  			<table id="top" class="hovertable" width="350" height="50" border="0" align="center" cellspacing="0">
				           <tr id="firstSelect" >
							  <s:hidden name="selectAnother" value="1"></s:hidden>
							   <td >
							      <label>
							      	<button id="add" class="button button-square button-tiny" style="font-size: 20px;">+</button>
							      </label>		     
							      <label>
							     	<button id="delete" class="button button-square button-tiny" style="font-size: 20px;">-</button>
							      </label>
							   </td>
							     
							   <td >
							    	<select name="selectTypes">
								      <option value='year'>进项日期(年)</option>
								      <option value='tax'>进项税金</option>
								      <option value='money'>进项金额</option>
								      <option value='sum'>进项合计金额</option>
							        </select>
							   </td>
							    
							   <td >
							      <label>
							        <input type="text" name="selectInputsMin" />(最小值)
							       </label>
							   </td>
							    
							   <td>
							    	<label>至</label>
							   </td>
							    
							   <td >
							   		<label>
							    	  <input type="text" name="selectInputsMax" />(最大值)
							    	</label>
							   </td>
							    
							</tr> 
			          		<s:hidden name="chartType" id="chartType" value="pie"></s:hidden>    
			        </table>
			        <center>
			        	<br>
			        	<s:submit id="show" cssClass="btn btn-default" value="查询"></s:submit>
			        </center>
  				</s:form>
  					
              
               	                            
               </div>
                     
		    	<table >
		    		<tr>
		    			<td >
		    				<canvas id="myChart" width="900" height="400"></canvas>
		    			</td>
		    			<td >
		    				<ul id="titlePie">		    	
		    				</ul>
		    			</td>
		    		</tr>
		    	</table>
		    	
		    	
		    	
		    	
		    	<s:hidden name="chartType" id="chartType" value="line"></s:hidden>
		    	
		    	<div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                             <small>分析结果</small>
                        </h1>
                    </div>
                    <div class="col-md-6" >
                          <div class="panel panel-default" style="width: 1000px">
	                       	<div class="panel-heading">
	                         	  供应商
	                        </div>
	                        <div class="panel-body" >
	                        	<table id="supplierResults">
	                        		
	                        	</table>                     
	                        </div>
                          </div>
                          <div class="panel panel-default" style="width: 1000px">
		                       	<div class="panel-heading">
		                         	  分析建议
		                        </div>
		                        <div class="panel-body" >
		                        	<table id="supplierSuggestions">
		                        		
		                        	</table>                     
		                        </div>
                          </div>
                     </div>
                </div>
                
              </div>
        </div>
  		
    	
  </body>
</html>
