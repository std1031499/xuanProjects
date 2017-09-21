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
    
    <title></title>
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
    
  	<script src="assets/js/jquery-1.10.2.js"></script>
	

  </head>
  
  <body>
  		
  		<div >
            <div id="page-inner">

                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                             <small >进项数据文件上传</small>
                        </h1>
                    </div>
                </div>
                <!-- /. ROW  -->
                
               <div class="form-group" >   
    
    				<s:form id="file_form" action="dataInput-dataInputSave" enctype="multipart/form-data" method="post" theme="simple">             		
	             		<table>
			    			<tr>
			    				<td>
			    					<s:file name="ufile" accept="excel/*" id="file_input" filename="ufileFileName"></s:file>
			    				</td>
			    				<td>
			    					<s:submit value="进项数据文件上传" ></s:submit>
			    				</td>
			    			</tr>
		    			</table>			    					    		
    				</s:form>
    			</div>
 
              </div>
        </div>
    	
  </body>
</html>
