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
    
    <title>My JSP 'chartBSP.jsp' starting page</title>
    
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
	<style type="text/css">
		ul{
		    position:absolute;
		    right:20px;
		    top:80px;
		}

		ul li{
		    padding:5px 10px;
		    margin-top:5px;
		    text-align:center;
		    color:black;
		    list-style-type:none
		}
		
		ul li:nth-child(1){
		    background-color:#CCCCFF;
		}
		
		ul li:nth-child(2){
		    background-color:#CCFFCC;
		}
		
		ul li:nth-child(3){
		    background-color:#FFFFCC;
		}
		
		
	</style>
	<script type="text/javascript">
	
	 
	function bar(Data){
	
		if(Data.length == null || Data.length == 0)
			return;
			//alert("h2"); 
		var barData={};
		barData.labels=[];
		barData.datasets=[];
		
		var inputMoneyData={};
		inputMoneyData.data=[];
		inputMoneyData.fillColor = "#CCCCFF";
		inputMoneyData.strokeColor = "rgba(220,220,220,1)"; 
		
		var inputTaxData={};
		inputTaxData.data=[];
		inputTaxData.fillColor = "#CCFFCC";
		inputTaxData.strokeColor = "#CCFFCC"; 
		//alert("h3"); 
		
		var inputMoneySumData={};
		inputMoneySumData.data=[];
		inputMoneySumData.fillColor = "#FFFFCC";
		inputMoneySumData.strokeColor = "#FFFFCC"; 
		
		for(var i=0;i<Data.length;i++){
// 			
			var date = getDate(Data[i][0]);
			
			barData.labels.push(date);
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
		myNewChart.Bar(barData);
	}

	$(function () {
		
		$(document).ready(function(){
			
			var val = $("#chartType").val();
			var url = "dataInput-historyChartBar";
			var args = {"chartType":val,"time":new Date()};
					
			$.getJSON(url,args,function(data){
				console.info(data); 
				//alert("h1"); 
	             bar(data);
			});
			
			$("#titleBar").show();
			historyResult();
		});
		
		//获取同比增长速率
		$("#history").click(function(){
						
			
			var valOne = $("#historyYearOne").val();						
			var urlOne = "dataInput-historySpeedAddOne";
			var argsOne = {"historyYearOne":valOne,"time":new Date()};
			
		    var valTwo = $("#historyYearTwo").val();
		    var urlTwo = "dataInput-historySpeedAddTwo";
			var argsTwo = {"historyYearTwo":valTwo,"time":new Date()};
			
			
			
		    
			$.getJSON(urlOne,argsOne,function(data1){
				
				if(data1==""){
					alert("无此年份！");
				}
				else{
					
					$.getJSON(urlTwo,argsTwo,function(data2){
				
						if(data2==""){
						
							alert("无此年份！");
						}
						else{
							compareSpeed(data1,data2);
							//给出结果
						}
					});
				}
				
				
			});
				
			
			//比较数据
			function compareSpeed(Data1,Data2)
			{
				var compare = new Array();
				for(var i=1;i<13;i++)
				{
					compare[i] = new Array();
					compare[i][0] = i;
					compare[i][1] = (Data2[i-1][1]-Data1[i-1][1])/Data1[i-1][1]*100;
					
				}
				
				historyResult(compare);
			}		
			
			
		});
	    
	});
	
	//分析结果*********************************************************************
	function historyResult(compare){
		//alert("ss");
		$tr = '';
		$tr+="<thead><tr><th>月份 </th><th>同比增长速率 </th></tr></thead>";
		$tr+="<tbody>";
		for(var i=1;i<13;i++)
		{
			$tr+="<tr><td>"+i+" </td><td>"+compare[i][1]+"% </td></tr>";	
		}			
		//$tr+="<tr><td>1 </td><td>100元 </td></tr>";		
	    $tr+="</tbody>";
	    //数据结果
		//$("#seasonResults tr").remove();
		$("#historyResults").append($tr);
		
		//分析建议
		$tr = '';
		$tr = "<tr><td>建议：</td></tr>";
		$tr+="<tr><td>&nbsp&nbsp 在&nbsp&nbsp";
		
		for(var i=1;i<13;i++)
		{	
			if(compare[i][1]>0)
			{
				$tr+=compare[i][0]+"月&nbsp&nbsp";
			}
		}
		
		$tr+="：&nbsp&nbsp增长率大于0，公司发展良好"+"</td></tr>";
		$tr+="<tr><td>&nbsp&nbsp 在&nbsp&nbsp";
		for(var i=1;i<13;i++)
		{	
			
			if(compare[i][1]<0)
			{	
				
				$tr+=compare[i][0]+"月&nbsp&nbsp";
			}
		}
		$tr+="：&nbsp&nbsp增长率小于0，公司发展差"+"</td></tr>";
		
		$("#historySuggestions tr").remove();
		$("#historySuggestions").append($tr);
	}
	
	//将字符串转化为日期
	function getDate(strDate){
		
// 		var st = strDate;
//         var a = st.split(" ");
//         var b = a[0].split("-");
//         var c = a[1].split(":");
//         var date = new Date(b[0], b[1], b[2], c[0], c[1], c[2])
//         return date;
		//获取前四位
		//alert("ss");
		var year = strDate.substring(0,4);
		var month = strDate.substr(4) ;
		var date = year + "-" +month;
		//alert(year);
		
		return date;
	}
	
	


	</script>
  </head>
  
  <body>
  		<div >
            <div id="page-inner">


                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                             <small>历史同比图</small>
                        </h1>
                    </div>
                </div>
                <!-- /. ROW  -->
                
               
                     
		    	
		    	
		    	<canvas id="myChart" width="1000" height="400"></canvas>
		    	
		    	<s:hidden name="chartType" id="chartType" value="bar"></s:hidden>
    	
		    	<ul id="titleBar" style="display: none">  
		                <li>进项金额</li>  
		                <li>进项税金</li>  
		                <li>进项价税合计金额</li>  
		                
		        </ul>
		    	<div class="form-group" >
		    	
		    		<s:select style="width:275px" id="historyYearOne" cssClass="form-control"  list="{'2010','2011','2012','2013','2014','2015','2016','2017','2018','2019'}" headerKey="-1" headerValue="--请选择年份--"  multiple="false"/> 
		    		<br>					
               		<s:select style="width:275px" id="historyYearTwo" cssClass="form-control"  list="{'2010','2011','2012','2013','2014','2015','2016','2017','2018','2019'}" headerKey="-1" headerValue="--请选择比较年份--"  multiple="false"/>  					  					
  					<br>
  					<input type="button" class="btn btn-default" value="查看具体情况" id="history">                
               </div>
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
		                         	  同比增长速度
		                        </div>
		                        <div class="panel-body" >
		                        	<div class="table-responsive">
                                <table id="historyResults" class="table table-striped table-bordered table-hover" style="width: 300px;">
                                    
                                   
                                </table>
                            </div>                  
		                        </div>
		                        
                          </div>
                           <div class="panel panel-default" style="width: 1000px">
		                       	<div class="panel-heading">
		                         	  分析建议
		                        </div>
		                        <div class="panel-body" >
		                        	<table id="historySuggestions">
		                        		
		                        	</table>                     
		                        </div>
                          </div>
                     </div>
                </div>
                
              </div>
        </div>
  		
    	
    	
    	
  </body>
</html>
