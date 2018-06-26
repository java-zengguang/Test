<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <script text="text/javascript">
    function checkForm(){
   
    	var username=document.getElementById("userName").value;

    	if(username==""){
    		alert("用户名不能为空");
    		return false;
    	}
    	
    	var password=document.getElementById("password").value;
    
    	if(password==""){
    		alert("密码不能为空");
    		return false;
    	}
    }	
    	
    
    	
    	
    	
    
    	</script>

  </head>
  
  <body>
 <form action ="RegistUsers" method="Post" onsubmit="return checkForm()">
        <table align="center" border="0", width="500">
        <tr>
           <td align ="right" width ="30%">用户名:</td>
           <td><input type ="text" name ="userName" class="box" id="userName"></td>           
        </tr>
         <tr>
           <td align ="right" width ="30%">密码:</td>
           <td><input type ="text" name ="password" class="box" id="password"></td>           
        </tr>
         <tr>
           <td align ="right" width ="30%">姓名</td>
              <td><input type ="text" name ="name" ></td>    
        </tr>
         <tr>
           <td align ="right" width ="30%">密码找回问题:</td>
           <td><input type ="text" name ="Find_question" class="box"></td>           
        </tr>
        <tr>
           <td align ="right" width ="30%">密码找回答案:</td>
           <td><input type ="text" name ="Find_answer" class="box"></td>           
        </tr>
        <tr>
           <td align ="right" width ="30%">邮箱:</td>
           <td><input type ="text" name ="email" class="box"></td>           
        </tr>
        <tr>
            <td colspan="2" align="center" height="40">
            <input type ="submit" value="注册">
            <input type ="reset" value="重置">
            </td>
        </tr> 
	<table align="center">
		 
</table>

  </body>
</html>
