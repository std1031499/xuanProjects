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
    
    <title>重点大客户分析</title>
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
	<script type="text/javascript">
	
	//显示柱状图********************************************************************
	function bar(Data){
	
		if(Data.length == null || Data.length == 0)
			return;
			//alert("h2"); 
		var barData={};
		barData.labels=[];
		barData.datasets=[];
		
		var outputAreaData={};
		outputAreaData.data=[];
		outputAreaData.fillColor = "rgba(220,220,220,0.5)";//填充颜色 rgba颜色中最后一个值代表透明度
		outputAreaData.strokeColor = "rgba(220,220,220,1)";// 线的颜色
		outputAreaData.pointColor = "rgba(220,220,220,1)";// 点的填充颜色
		outputAreaData.pointStrokeColor ="#fff";// 点的边线颜色
		
		
		for(var i=0;i<Data.length;i++){
		
			barData.labels.push(Data[i][0]);
			outputAreaData.data.push(Data[i][1]);
			// inputTaxData.data.push(Data[i][2]);
			//outputAreaSumData.data.push(Data[i][3]);
		}
		//alert("h4"); 
		barData.datasets.push(outputAreaData); //封装一个规定格式的barData。
		
		//alert(barData.datasets);
		console.info(barData); 
		
		var ctx = $("#myChart").get(0).getContext("2d");
		var myNewChart = new Chart(ctx);
		myNewChart.Bar(barData);
		
		
	}
	
	//Begin********************************************************************
	$(function () {
		
		$("#show").click(function(){
// 			clearCanvas();
// 			var val = $("#chartType").val();
			var year = $("#keyCustomerYear").val();
			var url = "dataOutput-customerBar";
			var args = {keyCustomerYear:year,"time":new Date()};
					
			$.getJSON(url,args,function(data){
				
				if(data!=""){
				
					console.info(data); 
					//alert("h1"); 
		             bar(data);//柱状图
		             areaResult(data);//分析结果
				}
				else{
					alert("该年份不存在！");
				} 
				
			});
			
			
		});
		
	    
	});
	
	//分析结果*********************************************************************
	function areaResult(Data){ 
		
		//客户地区分布 取前三
		var goodArea = new Array();	
		//var arr2 = new Array(2);
		for(var i=0;i<Data.length;i++)
		{
			goodArea[i] = new Array();
			for(var j=0;j<Data.length;j++)
			{
				goodArea[i][j] = Data[i][j];
			}
			
		}
		
		//只要flag在下一次外循环条件检测的时候值为false，就说明已经排好序，不用继续循环
		var flag = true;	
		for(var i=0;i<goodArea.length&&flag;i++)
		{
			flag = false;
			for(var j=goodArea.length-1;j>i;j--)
			{
				if(goodArea[j][1]<goodArea[j-1][1])
				{
					//冒泡排序
					var temp1,temp2;
					temp1 = goodArea[j][1];
					goodArea[j][1] = goodArea[j-1][1];
					goodArea[j-1][1] = temp1;
					
					temp2 = goodArea[j][0];
					goodArea[j][0] = goodArea[j-1][0];
					goodArea[j-1][0] = temp2;
					
					flag = true;//如果有交换，就将标记变量赋true
				}
			}
			
		}   
		
		
		//获取选择年份
		var keyCustomerYear = $("#keyCustomerYear").val();
		
		$tr = '';
		$tr+="<tr><td>"+keyCustomerYear+"年重点大客户 ："+goodArea[goodArea.length-1][0]+"、"+goodArea[goodArea.length-2][0]+"、"+goodArea[goodArea.length-3][0]+"</td></tr>";
	    //数据结果
		$("#areaResults tr").remove();
		$("#areaResults").append($tr);
		
		//分析建议
		$tr = '';
		$tr = "<tr><td>建议：</td></tr>";
 		$tr+="<tr><td>&nbsp&nbsp 与&nbsp&nbsp<a style='color:red'>"+goodArea[0][0]+"、"+goodArea[1][0]+"、"+goodArea[2][0]+"</a>&nbsp&nbsp客户进行少量合作，与该客户进行交易次数较少</td></tr>";
		$tr+="<tr><td>&nbsp&nbsp 在&nbsp&nbsp<a style='color:red'>"+goodArea[goodArea.length-1][0]+"、"+goodArea[goodArea.length-2][0]+"、"+goodArea[goodArea.length-3][0]+"</a>&nbsp&nbsp客户进行大量合作，与该客户进行交易次数频繁"+"</td></tr>";
		
		$("#areaSuggestions tr").remove();
		$("#areaSuggestions").append($tr);
	}
		
	
	
	
	
	//清除 canvas画布
    function clearCanvas()
    {
         var cxt=document.getElementById("myChart").getContext("2d");
         var c=document.getElementById("myChart");
    	 cxt.clearRect(0,0,c.width,c.height);  
    }  
	
	//
 
	


	</script>
  </head>
  
  <body>
  		<div >
            <div id="page-inner">

                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                             <small >重点大客户分布图</small>
                        </h1>
                    </div>
                </div>
                <!-- /. ROW  -->
                
               <div class="form-group" >
              
               		<s:select style="width:275px" id="keyCustomerYear" cssClass="form-control"  list="{'2010','2011','2012','2013','2014','2015','2016','2017','2018','2019'}" headerKey="-1" headerValue="--请选择年份--"  multiple="false"/>
  					<br>
  					<input type="button" class="btn btn-default" value="查看分布图" id="show">
              
               	                            
               </div>
                     
		    	
		    	
		    	<canvas id="myChart" width="1000" height="400"></canvas>
		    	
		    	
		    	
		    	
		    	<div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                             <small>分析结果</small>
                        </h1>
                    </div>
                    <div class="col-md-6" >
                          <div class="panel panel-default" style="width: 1000px">
		                       	<div class="panel-heading">
		                         	  本季度
		                        </div>
		                        <div class="panel-body" >
		                        	<table id="areaResults">
		                        		
		                        	</table>                     
		                        </div>
		                        
                          </div>
                           <div class="panel panel-default" style="width: 1000px">
		                       	<div class="panel-heading">
		                         	  分析建议
		                        </div>
		                        <div class="panel-body" >
		                        	<table id="areaSuggestions">
		                        		
		                        	</table>                     
		                        </div>
                          </div>
                     </div>
                </div>
                
              </div>
        </div>
  		
  		
    	
  </body>
</html>
