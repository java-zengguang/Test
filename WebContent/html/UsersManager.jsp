<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.student.model.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>�û�����</title>
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
		alert("ɾ���ɹ�");
		forms.submit();
	} 
 	function findStudent(){
  		var terms = prompt("�������ѯ����:","id=3");
 		if (terms != null){
 			alert(terms);
 			var x="FindUsers?terms="+terms;
 		window.self.location.href=x;
 		}else{
 		alert("�㰴��[ȡ��]��ť");
 	}
 	}
 		function addStudent(){
 			alert("��ӳɹ�");
 			var forms=document.getElementById("forms");
 			forms.setAttribute("action","AddUsers");
 			
 			forms.submit();
 		} 
 	function submit(){
 		
 		var xmlhttp=new XMLHttpRequest();
 		
 		xmlhttp.open("GET","/PersonnelInquiry/Submit?biz=UsersManagerBiz&url=FindUsers",true);
 		alert("�ύ");
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
		alert("���³ɹ�");
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

<h1 style="text-align:center">�û�����</h1>

<div id="filter" >

<form id="from1" action="/PersonnelInquiry/SimpleFindUsers" method="post">
 <p id="p" algin="center">&nbsp;&nbsp;�û�����<input type="text" name="userName" /> &nbsp;&nbsp; 
 Ȩ�ޣ�<input type="text" name="power" />  &nbsp;&nbsp;
 ������<input type="text" name="name" />&nbsp;&nbsp; 
  <input type="submit" value="��ѯ"/> &nbsp;&nbsp; <input type="reset" value="����"/> </p>
</form>
</div>

<div id="botton">
 <p> &nbsp;&nbsp; &nbsp;&nbsp; <button type="button" onclick="findStudent()" >��ѯ</button> &nbsp;&nbsp; <button onclick="update()">����</button> &nbsp;&nbsp; <button type="button" onclick="deleteStudent()">ɾ��</button>&nbsp;&nbsp; <button onclick="addStudent()">���</button>&nbsp;&nbsp; <button onclick="addLine()">���һ��</button> &nbsp;&nbsp; <button onclick="submit()">�ύ</button> </p>
</div>

 
<div id="table">
<form id="forms" action=""  method="post">
<table   high=20 id="table1"   border="0" cellspacing="1" cellpadding="0" style="background-color:#F5F5DC" >
<tr bgcolor="#D1DAE9"><th width="2%" ><input type="checkbox" name="ckball" id="ckball" onclick="selectall();"/></th> 
<th  width="8%" id="b">�û���</th>  <th  width="8%">����</th> <th  width="8%">Ȩ��</th> 
 <th  width="8%">����</th> <th  width="8%">��¼����</th><th  width="8%">����¼ʱ��</th>
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
      <td  width="8%" ><button  type="button" onclick="alterInput('<%=i%>')">�޸�</button></td></tr> 
  
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