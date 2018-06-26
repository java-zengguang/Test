<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
        <%@ page import="com.student.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript">

     var t = null;

    t = setTimeout(time,1000);//开始执行

    function time()

    {

       clearTimeout(t);//清除定时器

       dt = new Date();

var y=dt.getYear()+1900;

var mm=dt.getMonth()+1;

var d=dt.getDate();

var weekday=["星期日","星期一","星期二","星期三","星期四","星期五","星期六"];

var day=dt.getDay();

       	var h=dt.getHours();

       	var m=dt.getMinutes();

       	var s=dt.getSeconds();

if(h<10){h="0"+h;}

if(m<10){m="0"+m;}

if(s<10){s="0"+s;}

       	document.getElementById("timeShow").innerHTML =  ""+y+"年"+mm+"月"+d+"日"+weekday[day]+" "+h+":"+m+":"+s+"";

       	t = setTimeout(time,1000); //设定定时器，循环执行           

    }
   
    
  </script>

<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body background="../img/top.PNG" style="background-repeat:no-repeat">

<script language="javascript">
function getCurDate()
{
var d = new Date();
var week;
switch (d.getDay()){
case 1: week="星期一"; break;
case 2: week="星期二"; break;
case 3: week="星期三"; break;
case 4: week="星期四"; break;
case 5: week="星期五"; break;
case 6: week="星期六"; break;
default: week="星期天";
}
var years = d.getFullYear();
var month = add_zero(d.getMonth()+1);
var days = add_zero(d.getDate());
var hours = add_zero(d.getHours());
var minutes = add_zero(d.getMinutes());
var seconds=add_zero(d.getSeconds());
var ndate = years+"年"+month+"月"+days+"日 "+hours+":"+minutes+":"+seconds+" "+week;
//var divT=document.getElementById("logInfo");
divT.innerHTML= ndate;
}
function add_zero(temp)
{
if(temp<10) return "0"+temp;
else return temp;
}
setInterval("getCurDate()",100);
</script>
   <style>

    .time1{width:100%; height:50px; color:red;  font-size:18px; line-height:50px; text-align:center;}

  </style>
<div id="timeShow" class="time1" ></div>
<% 
Users user=(Users)session.getAttribute("userId");
String name=user.name;

%>
<br>
<br>
  <%-- 欢迎:&nbsp;<font aligin=right color=blue><%=name %>&nbsp;</font>登录  
  <a href ="/PersonnelInquiry/Exit"  target="_parent" style="aligin:right">退出</a> --%>


</body>
</html>