<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
        <%@ page import="com.student.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript">

     var t = null;

    t = setTimeout(time,1000);//��ʼִ��

    function time()

    {

       clearTimeout(t);//�����ʱ��

       dt = new Date();

var y=dt.getYear()+1900;

var mm=dt.getMonth()+1;

var d=dt.getDate();

var weekday=["������","����һ","���ڶ�","������","������","������","������"];

var day=dt.getDay();

       	var h=dt.getHours();

       	var m=dt.getMinutes();

       	var s=dt.getSeconds();

if(h<10){h="0"+h;}

if(m<10){m="0"+m;}

if(s<10){s="0"+s;}

       	document.getElementById("timeShow").innerHTML =  ""+y+"��"+mm+"��"+d+"��"+weekday[day]+" "+h+":"+m+":"+s+"";

       	t = setTimeout(time,1000); //�趨��ʱ����ѭ��ִ��           

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
case 1: week="����һ"; break;
case 2: week="���ڶ�"; break;
case 3: week="������"; break;
case 4: week="������"; break;
case 5: week="������"; break;
case 6: week="������"; break;
default: week="������";
}
var years = d.getFullYear();
var month = add_zero(d.getMonth()+1);
var days = add_zero(d.getDate());
var hours = add_zero(d.getHours());
var minutes = add_zero(d.getMinutes());
var seconds=add_zero(d.getSeconds());
var ndate = years+"��"+month+"��"+days+"�� "+hours+":"+minutes+":"+seconds+" "+week;
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
  <%-- ��ӭ:&nbsp;<font aligin=right color=blue><%=name %>&nbsp;</font>��¼  
  <a href ="/PersonnelInquiry/Exit"  target="_parent" style="aligin:right">�˳�</a> --%>


</body>
</html>