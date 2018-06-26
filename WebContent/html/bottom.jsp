<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.student.model.*" %>
<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style type="text/css">
		<!-- body { background-color: #FFFFFF; margin: 0px;}
		body,td,th { font-size: 12px; color: #000000; }
		--> 
		</style>
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
		
	</HEAD>
	
	<body background="../img/bottom .png">
<% 
Users user=(Users)session.getAttribute("userId");
String name=user.name;

%>
		<table width="100%" border="0" cellspacing="0" cellpadding="10" height="64">
			<tr>
			  
				<td   style= valign="top" >
				
    <p id="timeShow" class="time1" ></p>
            <font class="font12">
			</font></td>
			
				<td  width="180px" style= valign="top" bgColor="white">
				欢迎管理员:&nbsp;<font aligin=right color=blue><%=name %>&nbsp;</font>登录  
  <a href ="/PersonnelInquiry/Exit"  target="_parent" style="aligin:right">退出</a>&nbsp;
    
            <font class="font12">
			</font></td>
			
		
           </tr>
		</table>
		
	</body>
</HTML>