<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>error</title>
</head>
<body>


<%
String s=request.getParameter("message");
int message=Integer.parseInt(s);


switch (message){

	case 1:{
		
		%>
		
		<H2>添加失败</H2>
		
		<% 
		return;
	}
	
	case 2:{
		
		%>
		
		
		<H2>修改失败</H2>
		
		
		<% 
		return;
	}
	
	case 3:{
		
		%>
		
		<H2>删除失败</H2>
		
		
		<% 
		return;
		
		
		
	}
	
	case 4:{
		
		%>
		
		<H2>查找不到你要的数据</H2>
		
		
		<% 
		
		
		
		return;
	}
	
		
	
	case 5:{
		
		%>
		
		<H2>传入数据为空</H2>
		
		
		<% 
		
		
		
		return;
	}

	case 6:{
		
		%>
		
		<H2>用户为空</H2>
		
		
		<% 
		
		
		
		return;
	}

	
	case 7:{
		
		%>
		
		<H2>加载失败</H2>
		
		
		<% 
		
		
		
		return;
	}
	
	case 404:{
		
		%>
		
		<H2>FountNot</H2>
		
		
		<% 
		
		
		
		return;
	}
	case 500:{
		
		%>
		
		<H2>NullPointException</H2>
		
		
		<% 
		
		
		
		return;
	}
	
}
%>

<!-- /PersonnelInquiry
		<a href="/PersonnelInquiry/checkUserServlet">返回</a> -->
		
		
		
		
		
		
		
		
</body>
</html>