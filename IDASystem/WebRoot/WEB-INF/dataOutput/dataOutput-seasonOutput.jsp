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
    
    <title>季节性分析</title>
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
	
	//显示曲线图********************************************************************
	function line(Data){
	
		if(Data.length == null || Data.length == 0)
			return;
			//alert("h2"); 
		var barData={};
		barData.labels=[];
		barData.datasets=[];
		
		var inputMoneyData={};
		inputMoneyData.data=[];
		inputMoneyData.fillColor = "rgba(220,220,220,0.5)";//填充颜色 rgba颜色中最后一个值代表透明度
		inputMoneyData.strokeColor = "rgba(220,220,220,1)";// 线的颜色
		inputMoneyData.pointColor = "rgba(220,220,220,1)";// 点的填充颜色
		inputMoneyData.pointStrokeColor ="#fff";// 点的边线颜色
		
		var inputTaxData={};
		inputTaxData.data=[];
		inputTaxData.fillColor = "rgba(151,187,205,0.5)";
		inputTaxData.strokeColor = "rgba(151,187,205,1)"; 
		inputTaxData.pointColor = "rgba(151,187,205,1)";
		inputTaxData.pointStrokeColor ="#fff";
		//alert("h3"); 
		
		var inputMoneySumData={};
		inputMoneySumData.data=[];
		inputMoneySumData.fillColor = "rgba(151,187,215,0.5)";
		inputMoneySumData.strokeColor = "rgba(151,187,205,1)"; 
		inputMoneySumData.pointColor = "rgba(151,187,205,1)";
		inputMoneySumData.pointStrokeColor ="#fff";
		
		for(var i=0;i<Data.length;i++){
		
			barData.labels.push(Data[i][0]);
			inputMoneyData.data.push(Data[i][1]);
			inputTaxData.data.push(Data[i][2]);
			inputMoneySumData.data.push(Data[i][3]);
		}
		//alert("h4"); 
		barData.datasets.push(inputMoneyData,inputTaxData,inputMoneySumData); //封装一个规定格式的barData。
		
		//alert(barData.datasets);
		console.info(barData); 
		
		var ctx = $("#myChart").get(0).getContext("2d");
		var myNewChart = new Chart(ctx);
		myNewChart.Line(barData);
		
		
	}
	
	//Begin********************************************************************
	$(function () {
		
		$("#show").click(function(){
		
			var year = $("#seasonYear").val();
			var url = "dataOutput-seasonLine";
			var args = {seasonYear:year,"time":new Date()};
					
			$.getJSON(url,args,function(data){
				
				//alert(data);
				if(data!=""){
				
					console.info(data); 
					//alert("h1"); 
		             line(data);//曲线图
		             seasonResult(data);//分析结果
				}
				else{
					alert("该年份不存在！");
				} 
				
			});
			
			
		});
		
	    
	});
	
	//分析结果*********************************************************************
	function seasonResult(Data){
		
		//最大
		var moneyMax=Data[0][1];
		var moneyMaxMonth=Data[0][0];
		
		var taxMax=Data[0][2];
		var taxMaxMonth=Data[0][0];
		
		var sumMax=Data[0][3];
		var sumMaxMonth=Data[0][0];
		//alert(Data.length);
		for(var i=0;i<Data.length;i++)
		{
			if(moneyMax<Data[i][1])
			{
				moneyMax = Data[i][1];
				moneyMaxMonth = Data[i][0];
			}
			
			if(taxMax<Data[i][2])
			{
				taxMax = Data[i][2];
				taxMaxMonth = Data[i][0];
			}
			
			if(sumMax<Data[i][3])
			{
				sumMax = Data[i][3];
				sumMaxMonth = Data[i][0];
			}
		}
		
		//最小
		var moneyMin =Data[0][1];
		var moneyMinMonth=Data[0][0];
		
		var taxMin=Data[0][2];
		var taxMinMonth=Data[0][0];
		
		var sumMin=Data[0][3];
		var sumMinMonth=Data[0][0];
		//alert(Data.length);
		for(var i=0;i<Data.length;i++)
		{
			if(moneyMin>Data[i][1])
			{
				moneyMin = Data[i][1];
				moneyMinMonth = Data[i][0];
			}
			
			if(taxMin>Data[i][2])
			{
				taxMin = Data[i][2];
				taxMinMonth = Data[i][0];
			}
			
			if(sumMin>Data[i][3])
			{
				sumMin = Data[i][3];
				sumMinMonth = Data[i][0];
			}
		} 
		
		//销售情况不好的季度 (取前三)
		var badSeason = new Array();	
		//var arr2 = new Array(2);
		for(var i=0;i<Data.length;i++)
		{
			badSeason[i] = new Array();
			for(var j=0;j<Data.length;j++)
			{
				badSeason[i][j] = Data[i][j];
			}
			
		}
		
		//只要flag在下一次外循环条件检测的时候值为false，就说明已经排好序，不用继续循环
		var flag = true;	
		for(var i=0;i<badSeason.length&&flag;i++)
		{
			flag = false;
			for(var j=badSeason.length-1;j>i;j--)
			{
				if(badSeason[j][3]<badSeason[j-1][3])
				{
					//冒泡排序
					var temp1,temp2;
					temp1 = badSeason[j][3];
					temp2 = badSeason[j][0];
					badSeason[j][3] = badSeason[j-1][3];
					badSeason[j][0] = badSeason[j-1][0];
					badSeason[j-1][3] = temp1;
					badSeason[j-1][0] = temp2;
					flag = true;//如果有交换，就将标记变量赋true
				}
			}
			
		}   
		//alert(badSeason); 
		//销售情况好的季度 (取前三)
		
		
		
		
		//获取选择年份
		var seasonYear = $("#seasonYear").val();
		
		$tr = '';
		$tr+="<tr><td>"+seasonYear+"年"+moneyMaxMonth+"月&nbsp&nbsp有最大销项金额："+moneyMax+"元 </td>";
		$tr+="<td>"+seasonYear+"年"+moneyMinMonth+"月&nbsp&nbsp有最小销项金额："+moneyMin+"元 </td></tr>";
		$tr+="<tr><td>"+seasonYear+"年"+taxMaxMonth+"月&nbsp&nbsp有最大销项税金："+taxMax+"元 </td>";
		$tr+="<td>"+seasonYear+"年"+taxMinMonth+"月&nbsp&nbsp有最小销项税金："+taxMin+"元 </td></tr>";
		$tr+="<tr><td>"+seasonYear+"年"+sumMaxMonth+"月&nbsp&nbsp有最大销项价税合计金额："+sumMax+"元 </td>";
		$tr+="<td>"+seasonYear+"年"+sumMinMonth+"月&nbsp&nbsp有最小销项价税合计金额："+sumMin+"元 </td></tr>";
		$tr+="<tr><td>"+seasonYear+"年最大销项："+badSeason[9][0]+"、"+badSeason[10][0]+"、"+badSeason[11][0]+"月"+"</td></tr>";
		$tr+="<tr><td>"+seasonYear+"年最小销项："+badSeason[0][0]+"、"+badSeason[1][0]+"、"+badSeason[2][0]+"月"+"</td></tr>";
	    //数据结果
		$("#seasonResults tr").remove();
		$("#seasonResults").append($tr);
		
		//分析建议
		$tr = '';
		$tr = "<tr><td>建议：</td></tr>";
		$tr+="<tr><td>&nbsp&nbsp 在&nbsp&nbsp<a style='color:red'>"+badSeason[9][0]+"、"+badSeason[10][0]+"、"+badSeason[11][0]+"</a>&nbsp&nbsp月销售额大幅提高，建议在此月份进行货物处理"+"</td></tr>";
		$tr+="<tr><td>&nbsp&nbsp 在&nbsp&nbsp<a style='color:red'>"+badSeason[0][0]+"、"+badSeason[1][0]+"、"+badSeason[2][0]+"</a>&nbsp&nbsp月销售额大幅减少，建议在此月份进行货物清仓"+"</td></tr>";
		
		$("#seasonSuggestions tr").remove();
		$("#seasonSuggestions").append($tr);
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
                             <small>季节性分布图</small>
                        </h1>
                    </div>
                </div>
                <!-- /. ROW  -->
                
               <div class="form-group" >
              
               		<s:select style="width:275px" id="seasonYear" cssClass="form-control"  list="{'2010','2011','2012','2013','2014','2015','2016','2017','2018','2019'}" headerKey="-1" headerValue="--请选择年份--"  multiple="false"/>
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
		                        	<table id="seasonResults">
		                        		
		                        	</table>                     
		                        </div>
		                        
                          </div>
                           <div class="panel panel-default" style="width: 1000px">
		                       	<div class="panel-heading">
		                         	  分析建议
		                        </div>
		                        <div class="panel-body" >
		                        	<table id="seasonSuggestions">
		                        		
		                        	</table>                     
		                        </div>
                          </div>
                     </div>
                </div>
                
              </div>
        </div>
  		
  		
    	
  </body>
</html>
