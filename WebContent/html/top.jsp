<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    <%@ page import="com.student.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body background="../img/top.PNG" style="background-repeat:no-repeat">



<% 
	Users user=(Users)session.getAttribute("userId");
	String name=user.name;
%>

<br>
<br>
 


</body>
</html>