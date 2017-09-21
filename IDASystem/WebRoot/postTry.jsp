<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'postTry.jsp' starting page</title>
    
    <script src="assets/js/jquery-1.10.2.js"></script>
	<script type="text/javascript">
        $(function() {

            $("#file_form").submit(
                    function() {
                        //首先验证文件格式
                        var fileName = $('#file_input').val();
                        if (fileName == '') {
                            alert('请选择文件');
                            return false;
                        }
                        var fileType = (fileName.substring(fileName
                                .lastIndexOf(".") + 1, fileName.length))
                                .toLowerCase();
                        if (fileType !== 'xls' && fileType !== 'xlsx') {
                            alert('文件格式不正确，excel文件！');
                            return false;
                        }

                        $("#file_form").ajaxSubmit({
                            dataType : "json",
                            success : function(data, textStatus) {
                                if (data['result'] === 'OK') {
                                    console.log('上传文件成功');
                                } else {
                                    console.log('文件格式错误');
                                }
                                return false;
                            }
                        });
                        return false;
                    });

        });
    </script>
	
  </head>
  
  <body>
    	<form id="file_form" action="UpdFile" enctype="multipart/form-data"
        method="post">
        <input type="file" name="file" id="file_input" /> 
        <input type="submit" value="文件上传" id='upFile-btn'>
    </form>
  </body>
</html>
