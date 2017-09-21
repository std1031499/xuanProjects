<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp3.jsp' starting page</title>
    
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
		
<script>
$(function(){   
    $("#getAtr").click(function(){           
        $str='';
        $str+="<tr align='center'>";
        $str+="<td><input type='text' name='advTitle[]'/></td>";
        $str+="<td><input type='file' name='img[]' /></td>";
        $str+="<td><input type='text' name='advContent[]' /></td>";
        $str+="<td><input type='text' name='advSource[]' /></td>";
        $str+="<td><input type='text' name='advAuthor[]' /></td>";
        $str+="<td><input type='text' name='advPosition[]' /></td>";
        $str+="<td onClick='getDel(this)'><a >删除追加</a></td>";     
        $str+="</tr>";
        $("#addTr").append($str);    
    });
});
 
function getDel(k){
    $(k).parent().remove();     
}
</script>

<body>
<table align="center" border="1" cellpadding="0" cellspacing="0" width="100%">
 <tr align="center">
   <td>广告名称</td>
   <td>广告图片</td>
   <td>广告内容</td>
   <td>广告来源</td>
   <td>广告作者</td>
   <td>广告描述</td>
   <td align="center"><a  id="getAtr">追加内容</a></td>
 </tr>
<tbody id="addTr">
 <tr align="center">
   <td><input type="text" name="advTitle[]"/></td>
   <td><input type="file" name="img[]" /></td>
   <td><input type="text" name="advContent[]" /></td>
   <td><input type="text" name="advSource[]" /></td>
   <td><input type="text" name="advAuthor[]" /></td>
   <td><input type="text" name="advPosition[]" /></td>
   <td></td>
  </tr>
</tbody>
 <tr align="center">
  <td colspan="5"><input type="submit" value="全部添加" /></td>
 </tr>
</table>
</body>
</html>
