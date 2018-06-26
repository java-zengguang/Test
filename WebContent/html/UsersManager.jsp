<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.student.model.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>用户管理</title>
<link rel="stylesheet" type="text/css" href="user.css" />



<script type="text/javascript">

	function addLine(){
	var newElement=document.createElement("tr");
	newElement.align="center";

	newElement.innerHTML=" <td bgcolor='#D1DAE9' width='1%'> <input type='checkbox' name='check' checked='checked' style='width:100px'/> </td>"
	+"<td bgcolor='#D1DAE9' width='8%'><input type='text' name='userName' style='width:80px'/></td> "
 			+"<td bgcolor='#D1DAE9'  width='8%'><input type='text' name='password' style='width:80px'/></td> "
 			+" <td bgcolor='#D1DAE9' width='8%'><input type='text3' name='power' style='width:80px'/></td> "
 			+" <td bgcolor='#D1DAE9' width='8%'><input type='text' name='name' style='width:80px'/></td> "
 			+"  <td bgcolor='#D1DAE9' width='8%'><input type='text' name='loginCount' style='width:80px' /></td>"
 			+" <td bgcolor='#D1DAE9' width='8%'><input type='text' name='lastLoginTime' style='width:80px' /></td> "
 			+" <td bgcolor='#D1DAE9' width='8%'><input type='text' name='email' style='width:80px'/></td>  "
 			+" <td bgcolor='#D1DAE9' width='8%'></td>  ";
	document.getElementById("table1").appendChild(newElement);
	}
	
 	function deleteStudent(){
		var forms=document.getElementById("forms");
		forms.setAttribute("action","DeleteUsers");
		alert("删除成功");
		forms.submit();
	} 
 	function findStudent(){
  		var terms = prompt("请输入查询条件:","id=3");
 		if (terms != null){
 			alert(terms);
 			var x="FindUsers?terms="+terms;
 		window.self.location.href=x;
 		}else{
 		alert("你按了[取消]按钮");
 	}
 	}
 		function addStudent(){
 			alert("添加成功");
 			var forms=document.getElementById("forms");
 			forms.setAttribute("action","AddUsers");
 			
 			forms.submit();
 		} 
 	function submit(){
 		
 		var xmlhttp=new XMLHttpRequest();
 		
 		xmlhttp.open("GET","/PersonnelInquiry/Submit?biz=UsersManagerBiz&url=FindUsers",true);
 		alert("提交");
 		xmlhttp.send();
 		
 		xmlhttp.onreadystatechange=function()
 		{
 		    if (xmlhttp.readyState==4 && xmlhttp.status==200)
 		    {
 		    	  alert(mlhttp.responseText);
 		    }
 		}
 		
 	}	
 	
 	function update(){
	var forms=document.getElementById("forms");
		
		forms.setAttribute("action","UpdateUsers");
		alert("更新成功");
		forms.submit();
 	}
 	
 	   function alterInput( i){
 		var tr=document.getElementById(i);
 		var data=tr.childNodes;
 		tr.innerHTML="<tr bgcolor='#D1DAE9' align='center' id=i> <td width='1%'> <input type='checkbox' name='check' checked='checked' value='"+i+"'/> </td> "
 			+"<td  width='8%'><input type='text' name='userName' value='"+data[3].innerHTML+"' style='width:80px'/></td> "
 			+"<td  width='8%'><input type='text' name='password' value='"+data[5].innerHTML+"' style='width:80px'/></td> "
 			+" <td  width='8%'><input type='text' name='power' value='"+data[7].innerHTML+"' style='width:80px'/></td> "
 			+" <td  width='8%'><input type='text' name='name' value='"+data[9].innerHTML+"' style='width:80px'/></td> "
 			+"  <td  width='8%'><input type='text' name='loginCount' value='"+data[11].innerHTML+"' style='width:80px' /></td>"
 			+" <td  width='8%'><input type='text' name='lastLoginTime'  value='"+data[13].innerHTML+"' style='width:80px' /></td> "
 			+" <td  width='8%'><input type='text' name='email' value='"+data[15].innerHTML+"' style='width:80px'/></td>  "
 		    +" <td  width='8%'></td>  ";
 	}
</script>

</head>

<body bgColor="#D1DAE9"  >



<%
	List<Users> modelList=(List)request.getAttribute("modelList");
%>

<h1 style="text-align:center">用户管理</h1>

<div id="filter" >

<form id="from1" action="/PersonnelInquiry/SimpleFindUsers" method="post">
 <p id="p" algin="center">&nbsp;&nbsp;用户名：<input type="text" name="userName" /> &nbsp;&nbsp; 
 权限：<input type="text" name="power" />  &nbsp;&nbsp;
 姓名：<input type="text" name="name" />&nbsp;&nbsp; 
  <input type="submit" value="查询"/> &nbsp;&nbsp; <input type="reset" value="重置"/> </p>
</form>
</div>

<div id="botton">
 <p> &nbsp;&nbsp; &nbsp;&nbsp; <button type="button" onclick="findStudent()" >查询</button> &nbsp;&nbsp; <button onclick="update()">更新</button> &nbsp;&nbsp; <button type="button" onclick="deleteStudent()">删除</button>&nbsp;&nbsp; <button onclick="addStudent()">添加</button>&nbsp;&nbsp; <button onclick="addLine()">添加一行</button> &nbsp;&nbsp; <button onclick="submit()">提交</button> </p>
</div>

 
<div id="table">
<form id="forms" action=""  method="post">
<table   high=20 id="table1"   border="0" cellspacing="1" cellpadding="0" style="background-color:#F5F5DC" >
<tr bgcolor="#D1DAE9"><th width="2%" ><input type="checkbox" name="ckball" id="ckball" onclick="selectall();"/></th> 
<th  width="8%" id="b">用户名</th>  <th  width="8%">密码</th> <th  width="8%">权限</th> 
 <th  width="8%">姓名</th> <th  width="8%">登录次数</th><th  width="8%">最后登录时间</th>
 <th  width="8%"> e-mail</th> <th  width="8%"></th> </tr>

<% 
if(modelList!=null){
for(int i=0;i<modelList.size();i++){

%>

<tr bgcolor="#D1DAE9"  align="center" id='<%=i %>'> <td   width="1%"> <input type="checkbox" name="check" value="<%=i %>"/> </td> 
 <td  width="8%"><%=modelList.get(i).userName+"" %></td>    
  <td   width="8%"><%=modelList.get(i).password %></td>
   <td  width="8%"><%=modelList.get(i).power+"" %></td> 
   <td  width="8%"><%=modelList.get(i).name+"" %></td>
    <td  width="8%"><%=modelList.get(i).loginCount%></td> 
     <td  width="8%"><%=modelList.get(i).lastLoginTime %></td>
     <td  width="8%"><%=modelList.get(i).email %></td> 
      <td  width="8%" ><button  type="button" onclick="alterInput('<%=i%>')">修改</button></td></tr> 
  
<% 
}
}
%>

</table>
</form>
</div >
<script>
function selectall()
{
	var ckball=document.getElementsByName("check");
	for(var i=0;i<ckball.length;i++)
	ckball.item(i).checked=document.getElementById("ckball").checked;
	
	}
</script>
</body>
</html>