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
    
	<script src="Chart.js-master/Chart.js"></script>
	<script src="assets/js/jquery-1.10.2.js"></script>
	<style type="text/css">
		ul{
		    position:absolute;
		    right:20px;
		    top:10px;
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
		
			barData.labels.push(Data[i].inputInvoiceDate);
			inputMoneyData.data.push(Data[i].inputMoney);
			inputTaxData.data.push(Data[i].inputTax);
			inputMoneySumData.data.push(Data[i].inputMoneySum);
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
		
		$("#show").click(function(){
			
			var val = $("#chartType").val();
			var url = "dataInput-chartBar";
			var args = {"chartType":val,"time":new Date()};
					
			$.getJSON(url,args,function(data){
				console.info(data); 
				//alert("h1"); 
	             bar(data);
			});
			
			$("#titleBar").show();
		});
	    
	});
	
	


	</script>
  </head>
  
  <body>
    	<canvas id="myChart" width="1000" height="400"></canvas>
    	<input type="button" value="显示条形图" id="show">
    	<s:hidden name="chartType" id="chartType" value="bar"></s:hidden>
    	
    	<ul id="titleBar" style="display: none">  
                <li>进项金额</li>  
                <li>进项税金</li>  
                <li>进项价税合计金额</li>  
                
        </ul>
  </body>
</html>
