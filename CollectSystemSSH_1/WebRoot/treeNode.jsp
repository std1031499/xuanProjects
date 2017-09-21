<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<title>JS无级树树形菜单</title>
<style type="text/css">
.menuTree{ margin-left:-30px;}
.menuTree div{ padding-left:30px;}
.menuTree div ul{ overflow:hidden; display:none; height:auto;}
.menuTree span{ display:block; height:25px; line-height:25px; padding-left:5px; margin:1px 0; cursor:pointer; border-bottom:1px solid #CCC;}
.menuTree span:hover{ background-color:#e6e6e6; color:#cf0404;}
.menuTree a{ color:#333; text-decoration:none;}
.menuTree a:hover{ color:#06F;}
.btn{ height:30px; margin-top:10px; border-bottom:1px solid #CCC;}
</style>
</head>
<body>
<div class="btn">
<input name="" type="button" id="btn_open" value="全部展开" />  
<input name="" type="button" id="btn_close" value="全部收缩" />
</div>
<div id="menuTree" class="menuTree"></div>
</body>
</html>
<script type="text/javascript">
var json = [{"name":"*a","list":[
 {"name":"**a","url":"#a1"},
 {"name":"**aa","list":[
  {"name":"***a","url":"#a11"},  {"name":"***aa","list":[ {"name":"****a","url":"#a111"},  {"name":"****aa","list":[ {"name":"*****a","url":"#a1111"},  {"name":"*****aa","url":"#a1112"}
  ]}
 ]},
  {"name":"***aaa","url":"#a13"},
  {"name":"***aaaa","url":"#a14"}
  ]
  },
  {"name":"**a","url":"#a3"}
 ]
 },
 {"name":"*b","list":[
 {"name":"**b","url":"#b1"},
 {"name":"**bb","list":[
   {"name":"****b","url":"#b111"},
   {"name":"****bb","url":"#b112"}
   ]
 },
 ]
 },
 {"name":"*c","list":[
 {"name":"**c","url":"#c1"},
 {"name":"**cc","url":"#c2"}
 ]
 },
 {"name":"*d"}
 ]
/*递归实现获取无级树数据并生成DOM结构*/
var str = "";
var forTree = function(o){
 for(var i=0;i<o.length;i++){
 var urlstr = "";
 try{
 if(typeof o[i]["url"] == "undefined"){
 urlstr = "<div><span>"+ o[i]["name"] +"</span><ul>";
 }else{
 urlstr = "<div><span><a href="+ o[i]["url"] +">"+ o[i]["name"] +"</a></span><ul>"; 
 }
 str += urlstr;
 if(o[i]["list"] != null){
 forTree(o[i]["list"]);
 }
 str += "</ul></div>";
 }catch(e){}
 }
 return str;
}
/*添加无级树*/
document.getElementById("menuTree").innerHTML = forTree(json);
/*树形菜单*/
var menuTree = function(){
 //给有子对象的元素加[+-]
 $("#menuTree ul").each(function(index, element) {
 var ulContent = $(element).html();
 var spanContent = $(element).siblings("span").html();
 if(ulContent){
 $(element).siblings("span").html("[+] " + spanContent) 
 }
 });
 $("#menuTree").find("div span").click(function(){
 var ul = $(this).siblings("ul");
 var spanStr = $(this).html();
 var spanContent = spanStr.substr(3,spanStr.length);
 if(ul.find("div").html() != null){
 if(ul.css("display") == "none"){
 ul.show(300);
 $(this).html("[-] " + spanContent);
 }else{
 ul.hide(300);
 $(this).html("[+] " + spanContent);
 }
 }
 })
}()
/*展开*/
$("#btn_open").click(function(){
 $("#menuTree ul").show(300);
 curzt("-");
})
/*收缩*/
$("#btn_close").click(function(){
 $("#menuTree ul").hide(300);
 curzt("+");
})
function curzt(v){
 $("#menuTree span").each(function(index, element) {
 var ul = $(this).siblings("ul");
 var spanStr = $(this).html();
 var spanContent = spanStr.substr(3,spanStr.length);
 if(ul.find("div").html() != null){
 $(this).html("["+ v +"] " + spanContent);
 }
 }); 
}
</script>