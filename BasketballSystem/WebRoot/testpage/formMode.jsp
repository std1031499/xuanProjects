<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'playerBasic.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="assets/css/fonts/linecons/css/linecons.css">
	<link rel="stylesheet" href="assets/css/fonts/fontawesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/css/bootstrap.css">
	<link rel="stylesheet" href="assets/css/xenon-core.css">
	<link rel="stylesheet" href="assets/css/xenon-forms.css">
	<link rel="stylesheet" href="assets/css/xenon-components.css">
	<link rel="stylesheet" href="assets/css/xenon-skins.css">
	<link rel="stylesheet" href="assets/css/custom.css">

	<script src="assets/js/jquery-1.11.1.min.js"></script>
	
  </head>
  
  <body class="page-body">
  
  <div class="page-container">
  
  		<div class="page-title">
				
			<div class="title-env">
				<h1 class="title">Form Validation</h1>
				<p class="description">Plain text boxes, select dropdowns and other basic form elements</p>
			</div>
								
		</div>
			
  		<div class="panel panel-default">
			
				<div class="panel-heading">
					<div class="panel-title">
						Input validation
					</div>
					
				</div>
				
				<div class="panel-body">
				
					<form role="form" id="form1" method="post" class="validate">
						
						<div class="form-group">
							<label class="control-label">Required Field + Custom Message</label>
							
							<input type="text" class="form-control" name="name" data-validate="required" data-message-required="This is custom message for required field." placeholder="Required Field" />
						</div>
						
						<div class="form-group">
							<label class="control-label">Email Field</label>
							
							<input type="text" class="form-control" name="email" data-validate="email" placeholder="Email Field" />
						</div>
						
						<div class="form-group">
							<label class="control-label">Input Min Field</label>
							
							<input type="text" class="form-control" name="min_field" data-validate="number,minlength[4]" placeholder="Numeric + Minimun Length Field" />
						</div>
						
						<div class="form-group">
							<label class="control-label">Input Max Field</label>
							
							<input type="text" class="form-control" name="max_field" data-validate="maxlength[2]" placeholder="Maximum Length Field" />
						</div>
						
						<div class="form-group">
							<label class="control-label">Numeric Field</label>
							
							<input type="text" class="form-control" name="number" data-validate="number" placeholder="Numeric Field" />
						</div>
						
						<div class="form-group">
							<label class="control-label">URL Field</label>
							
							<input type="text" class="form-control" name="url" data-validate="required,url" placeholder="URL" />
						</div>
						
						<div class="form-group">
							<label class="control-label">Credit Card Field</label>
							
							<input type="text" class="form-control" name="creditcard" data-validate="required,creditcard" placeholder="Credit Card" />
						</div>
						
						<div class="form-group">
							<button type="submit" class="btn btn-success">Validate</button>
							<button type="reset" class="btn btn-white">Reset</button>
						</div>
					
					</form>
				
				</div>
			
			</div>
			</div>
			
			
			
			<!-- Bottom Scripts -->
			<script src="assets/js/bootstrap.min.js"></script>
			<script src="assets/js/TweenMax.min.js"></script>
			<script src="assets/js/resizeable.js"></script>
			<script src="assets/js/joinable.js"></script>
			<script src="assets/js/xenon-api.js"></script>
			<script src="assets/js/xenon-toggles.js"></script>
		
		
			<!-- Imported scripts on this page -->
			<script src="assets/js/jquery-validate/jquery.validate.min.js"></script>
		
		
			<!-- JavaScripts initializations and stuff -->
			<script src="assets/js/xenon-custom.js"></script>
  </body>
</html>
