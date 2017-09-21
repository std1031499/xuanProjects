<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Free Bootstrap Admin Template : Dream</title>
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
    
    <style type="text/css" > 
        html{            
            background-color:#ADD9E6; 
    color:#000000; 
    font-size:12px; 
    font-family:SimSun; 
    border-left:#ECF1F4 0px solid; 
    border-right:#ECF1F4 0px solid; 
    margin:0;                              /*控制滚动条左右侧实线颜色*/ 
            overflow-x:hidden;                      /*隐藏底部的横向滚动条*/ 
            scrollbar-arrow-color:#034079;          /*三角箭头的颜色*/ 
            scrollbar-3dlight-color:#ADD9E6;        /*立体滚动条亮边的颜色*/ 
            scrollbar-highlight-color:#89C4D5;      /*滚动条空白部分的颜色*/ 
            scrollbar-shadow-color:#89C4D5;        /*立体滚动条阴影的颜色*/ 
            scrollbar-darkshadow-color:#ADD9E6;    /*滚动条强阴影颜色*/ 
            scrollbar-track-color:#ADD9E6;          /*立体滚动条背景颜色*/ 
            scrollbar-base-color:#ADD9E6;          /*滚动条的基本颜色*/ 
      } 
    </style> 
</head>
  
  <body>
    	<div id="wrapper">
    	
    		<!-- 左侧栏开始 -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">

                    <li>
                        <a class="active-menu" href="manage-homePage" target="rightfrm" ><i class="fa fa-dashboard"></i> 首页</a>
                    </li>
                    
                    <!-- <li>
                        <a href="ui-elements.html"><i class="fa fa-desktop"></i> UI Elements</a>
                    </li> -->
                    
					<!-- <li>
                        <a href="dataInput-chartInput" target="rightfrm"><i class="fa fa-bar-chart-o"></i> 图表分析</a>
                    </li> -->
                    
                    <!-- <li>
                        <a href=""><i class="fa fa-qrcode"></i> Tabs & Panels</a>
                    </li> -->
                    
                    <li>
                        <a href="#" id="hdData"><i class="fa fa-table"></i>导入数据<span class="fa arrow"></span></a>
                        <ul id="data" class="nav nav-second-level" >
                            <li>
                                <a href="dataInput-dataInput" target="rightfrm">进项发票数据</a>
                            </li>
                            <li>
                                <a href="dataOutput-dataInput" target="rightfrm">销项发票数据</a>
                            </li>
                            
                        </ul>
                    </li>
                    
                    <!-- <li>
                        <a href="form.html"><i class="fa fa-edit"></i> Forms </a>
                    </li> -->


                    <li>
                        <a href="#" id="hdFirst"><i class="fa fa-sitemap"></i> 数据分析<span class="fa arrow" ></span></a>
                        <ul id="first" class="nav nav-second-level" >
                        
                            <li>
                                <a id="hdSecondOutput" href="#">销项发票分析<span class="fa arrow"></span></a>
                                <ul  id="secondOutput" class="nav nav-third-level">
                                    <li>
                                        <a href="dataOutput-areaCustomerOutput" target="rightfrm">客户地区分析</a>
                                    </li>
                                    <li>
                                        <a href="dataOutput-seasonOutput" target="rightfrm">季节性分布</a>
                                    </li>
                                    <li>
                                        <a href="dataOutput-keyCustomerOutput" target="rightfrm">重点大客户</a>
                                    </li>
                                    <!-- <li>
                                        <a href="#">历史同比</a>
                                    </li> -->
                                    <!-- <li>
                                        <a href="#">环比增长率</a>
                                    </li> -->
                                </ul>
                            </li>
                            
                            <li>
                                <a id="hdSecondInput" href="#">进项发票分析<span class="fa arrow"></span></a>
                                <ul  id="secondInput" class="nav nav-third-level">
                                    <!-- <li>
                                        <a href="dataInput-areaPieInput" target="rightfrm">供应商地区分析</a>
                                    </li> -->
                                    <li>
                                        <a href="dataInput-seasonInput" target="rightfrm">季节性分布</a>
                                    </li>
                                    <li>
                                        <a href="dataInput-supplierPieInput" target="rightfrm">重点供应商</a>
                                    </li>
                                    <li>
                                        <a href="dataInput-historyInput" target="rightfrm">历史同比</a>
                                    </li>
                                    <!-- <li>
                                        <a href="#">环比增长率</a>
                                    </li> -->
                                </ul>
                            </li>
                            
                            <!-- <li>
                                <a id="hdSecondAll" href="#">进销结合分析<span class="fa arrow"></span></a>
                                <ul  id="secondAll" class="nav nav-third-level">
                                    <li>
                                        <a href="#">库存备货</a>
                                    </li>
                                    <li>
                                        <a href="#">季节性价格波动</a>
                                    </li>
                                    <li>
                                        <a href="#">平滑税负</a>
                                    </li>

                                </ul>

                            </li> -->
                        </ul>
                    </li>
                                     
                   <!--  <li>
                        <a href="empty.html"><i class="fa fa-fw fa-file"></i> Empty Page</a>
                    </li> -->
                    
                    <li>
                        <a ><i class="fa" style="height: 500px;"></i> </a>
                    </li>
                   
                  
                </ul>
					
            </div>

        </nav>
        <!-- 左侧栏结束 -->
        
        <!-- /. NAV SIDE  -->
        
        <!-- JS Scripts-->
	    <!-- jQuery Js -->
	    <script src="assets/js/jquery-1.10.2.js"></script>
	    <!-- Bootstrap Js -->
	    <script src="assets/js/bootstrap.min.js"></script>
	    <!-- Metis Menu Js -->
	    <script src="assets/js/jquery.metisMenu.js"></script>
	    <!-- Morris Chart Js -->
	    <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
	    <script src="assets/js/morris/morris.js"></script>
	    <!-- Custom Js -->
	    
	    <script type="text/javascript">
	    
			$(function(){
				
				$(document).ready(function(){
					$("#first").hide();
					$("#secondAll").hide();
					$("#secondOutput").hide();
					$("#secondInput").hide();
					$("#data").hide();
				});
				//点击隐藏
				$("#hdFirst").bind("click",function(){
					//alert("hhh");
					$("#first").slideToggle();
				});
				
				$("#hdSecondAll").bind("click",function(){
					//alert("hhh");
					$("#secondAll").slideToggle();
				});
				
				$("#hdSecondOutput").bind("click",function(){
					//alert("hhh");
					$("#secondOutput").slideToggle();
				});
				
				$("#hdSecondInput").bind("click",function(){
					//alert("hhh");
					$("#secondInput").slideToggle();
				});
				
				$("#hdData").bind("click",function(){
					//alert("hhh");
					$("#data").slideToggle();
				});
			});
	    
	    </script>
   
        
    	</div>
  </body>
</html>
