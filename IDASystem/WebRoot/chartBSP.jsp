<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<script type="text/javascript">
	
		var data = {
			    labels: ["January", "February", "March", "April", "May", "June", "July"],
			    datasets: [
			        {
			            fillColor: "#CCCCFF",
			            strokeColor: "rgba(220,220,220,1)",
			            label: "2010年",
			            data: [65, 59, 90, 81, 56, 55, 40]
			        },
			        {
			            fillColor: "#CCFFCC",
			            strokeColor: "#CCFFCC",
			            label:"2011年",
			            data: [28, 48, 40, 19, 96, 27, 100]
			        },
			        {
			            fillColor: "#FFFFCC",
			            strokeColor: "#FFFFCC",
			            label: "2012年",
			            data: [13, 55, 40, 19, 23, 27, 64]
			        },
			        {
			            fillColor: "#99FFFF",
			            strokeColor: "#99FFFF",
			            label: "2013年",
			            data: [98, 11, 52, 19, 65, 20, 77]
			        }
			    ]
		}

		$(function () {
			
			$("#show").click(function(){
				var ctx = $("#myChart").get(0).getContext("2d");
			    var myNewChart = new Chart(ctx);
			    myNewChart.Bar(data);
			});
		    
		});
	</script>
  </head>
  
  <body>
    	<canvas id="myChart" width="400" height="400"></canvas>
    	<input type="button" value="显示图片" id="show">
  </body>
</html>
