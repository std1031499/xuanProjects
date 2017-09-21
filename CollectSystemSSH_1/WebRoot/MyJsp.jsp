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
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
   <script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
    		
    		$(function(){
    		$(":input[name=c_Username]").change(function(){
    			alert(c_Username+"kk");
    			var val = $(this).val();
    			
    			val  = $.trim(val);
    			
    			if(val != ""){
    				alert("发送Ajax请求");
    			}
    			else{
    				alert("不能为空！");
    				this.focus();
    			}
    		});
    	});
    </script>

  </head>
  
  <body>
    <s:textfield name="c_Username" label="LastName"></s:textfield>			
			
			
			<s:textfield name="email" label="Email"></s:textfield>
			<s:textfield name="birth" label="Birth"></s:textfield>
			
			
			<a href="emp-nmb">sss</a>
  </body>
</html>
