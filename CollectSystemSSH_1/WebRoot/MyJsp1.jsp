<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'show-searchComplex.jsp' starting page</title>
		<link href="css/button.css" rel="stylesheet" type="text/css"/>
		<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
		<script type="text/javascript">
			
			//点击追加触发
$(function(){
$("#button").click(function(){
var div_ = $("#sel").val();
var context = $("#context").val();
append(div_,context);
//$("#tab tr:not(:first)").remove();
//$("#tab tbody").empty();
$("#tab tbody").remove();
query();
});
});
//点击查询全部触发
$(function(){
$("#but").click(function(){
$("#tab tbody").remove();
//$("#tab tr:not(:first)").remove();
//$("#tab tbody").empty();
query();

});
});
//点击模糊查询触发
$(function(){
$("#query").click(function(){
var context = $("#context").val();
alert("您输入的内容为："+context);
$("#tab tr:not(:first)").empty();
//$("table tbody").remove();
queryByContext();


});
});
//删除事件
function del(id){
var url = "testController/delModel";
$.ajax({
type: 'POST',
url: url,
data:{id: id},
dataType: 'json',
success: function(data){
alert("数据库删除成功");
$("#tab tr:not(:first)").empty();
query();


}});
};
//编辑事件
function upd(id){
var url = "";
$.ajax({
type: 'POST',
url: url,
data:{id: id},
dataType: 'json',
success: function(data){
alert("数据库编辑成功");
$("#tab tr:not(:first)").empty();
query();


}});
}
//添加方法
function append(div_,context){
$("#"+div_).append("<tr><td>"+ div_ +"</td>"+"<td>"+context+"</td></tr>");
$.get("testController/addModel",{div_id: div_, context: context }).done(function( data ) {
alert("添加到数据库成功");
});
};
//模糊查询方法
function queryByContext(){
var url = "testController/queryAllDataByContext";
$.ajax({
type: 'POST',
url: url,
data:{context:$("#context").val()},
dataType: 'json',
success: function(data){
alert("数据库查询成功");
console.log(data);
for(var i=0;i<data.length;i++){
var id = data[i].id;
var divId = data[i].divId;
var context = data[i].context;
var dtt = data[i].dtt;
//alert(id);
$("#tab thead").append("<tr><td>"+id+"</td>"+"<td>"+divId+"</td>"+"<td>"+context+"</td>"+"<td>"+dtt+"</td>"+"<td><a class='del'onclick='del("+id+")'>删除</a></td></tr>");



}
},
error:function(){
alert("数据库查询失败");
}

});


};
//查询全部方法
function query(){
var url = "testController/queryAllData";
$.ajax({
type: 'POST',
url: url,
dataType: 'json',
success: function(data){
alert("查询成功");
console.log(data);
for(var i=0;i<data.length;i++){
var id = data[i].id;
var divId = data[i].divId;
var context = data[i].context;
var dtt = data[i].dtt;
//alert(id);
// $("#tab tbody").remove();
$("#tab").append("<tr><td>"+id+"</td>"+"<td>"+divId+"</td>"+"<td>"+context+"</td>"+"<td>"+dtt+"</td>"+"<td><button onclick='del("+id+")'>删除</button></td>"+"<td><button onclick='upd("+id+")'>编辑</button></td></tr>");



}
},
error:function(){
alert("查询失败");
}
});


};
		</script>
  </head>
  
  <body>
		DIV名：<select id="sel">
			<option value="div1">div1</option>
			<option value="div2">div2</option>
			<option value="div3">div3</option>
			
			</select><br />
			DIV值：<input type="text" id="context"/><br />
			<input type="button" id="button" value="添加数据"/>
			<input type="button" id="but" value="查询全部"/>
			<input type="button" id="query" value="模糊查询"/>
			
			<h1>div1数据如下</h1>
			<div >
			<table border="1" width="350" id="t">
			<thead class="head" id="div1">
			<tr>
			<td>DIV名称</td>
			<td>DIV值</td>
			</tr>
			</thead>
			</table>
			</div>
			<h1>div2数据如下</h1>
			<div >
			<table border="1" width="350" id="t">
			<thead class="head" id="div2">
			<tr>
			<td>DIV名称</td>
			<td>DIV值</td>
			</tr>
			</thead>
			</table>
			</div>
			<h1>div3数据如下</h1>
			<div >
			<table border="1" width="350" id="t">
			<thead class="head" id="div3">
			<tr>
			<td>DIV名称</td>
			<td>DIV值</td>
			</tr>
			</thead>
			</table>
			</div>
			
			<h1>数据库的表数据</h1>
			<table border="1" width="350" id="tab">
			<thead>
			<tr>
			<td>字段ID</td>
			<td>字段DIV_ID</td>
			<td>字段CONTEXT</td>
			<td>字段DTT</td>
			<td>是否删除</td>
			<td>是否编辑</td>
			</tr>
			</thead>
			<tbody></tbody>
			</table>
  </body>
</html>
