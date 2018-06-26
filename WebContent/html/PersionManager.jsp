<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ page import="com.student.model.*" %>
<%@ page import="java.util.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="css/datepicker.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>基本信息</title>
<link rel="stylesheet" type="text/css" href="user.css" />

   <script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/datepicker.js"></script>
    <script type="text/javascript" src="js/eye.js"></script>

    <script type="text/javascript" src="js/layout.js?ver=1.0.2"></script>

<script type="text/javascript" >
/* 
$(function(){
	
	$("#forms").load(function(){
		
		$.ajax({
			
			type:"get",
			url:"FindPersion",
			success:function(result){
			result=$.parseJSON(result);
			$(result).each(function(index,element){
				$("#data").append(result);
			});
			}
			
		});
	});
	
	
	
}); */



	function addLine(){
	var newElement=document.createElement("tr");
	newElement.align="center";

	newElement.innerHTML=" <td bgcolor='#D1DAE9' width='1%'> <input type='checkbox' name='check' checked='checked' style='width:100px'/> </td>"
	+"<td bgcolor='#D1DAE9' width='6%'><input type='text' name='teacherNumber' style='width:100px'/></td> "
	+"<td bgcolor='#D1DAE9' width='6%'><input type='text' name='name' style='width:100px'/></td> "
	+" <td bgcolor='#D1DAE9' width='6%'><input type='text' name='sex' style='width:100px'/></td> "
	+"  <td bgcolor='#D1DAE9' width='6%'><input type='text' name='birth' style='width:100px' /></td>"
	+" <td bgcolor='#D1DAE9' width='6%'><input type='text' name='idCard' style='width:100px' /></td> "
	+" <td bgcolor='#D1DAE9' width='6%'><input type='text' name='nation' style='width:100px'/></td>  "
	+" <td bgcolor='#D1DAE9' width='6%'><input type='text' name='nativePlace' style='width:100px'/></td> "
	+"<td bgcolor='#D1DAE9' width='6%'><input type='text' name='placeBirth' style='width:100px'/></td>  "
	+" <td bgcolor='#D1DAE9' width='6%'><input type='text' name='politicalStatus' style='width:100px'/></td>"
	+" <td bgcolor='#D1DAE9' width='6%'><input type='text' name='joinPartyTime' style='width:100px'/></td>  "
	+" <td bgcolor='#D1DAE9' width='6%'><input type='text' name='workingHours' style='width:100px'/></td> "
	+"<td bgcolor='#D1DAE9' width='6%'><input type='text' name='admissionTime' style='width:100px'/></td> "
	+" <td bgcolor='#D1DAE9' width='5%'>&nbsp;</td>";
	document.getElementById("table1").appendChild(newElement);
	}
	
 	function deleteStudent(){
 	
		var forms=document.getElementById("forms");
		
		forms.setAttribute("action","DeletePersionIndex");
		alert("删除成功");
		forms.submit();
	} 
 	
 	function findStudent(){
  		var terms = prompt("请输入查询条件:","id=3");
 		if (terms != null){
 			alert(terms);
 			var x="FindPersion?terms="+terms;
 		window.self.location.href=x;
 		}else{
 		alert("你按了[取消]按钮");
 	}
 	}
 	
 		function addStudent(){
 			alert("添加成功");
 			var forms=document.getElementById("forms");
 			forms.setAttribute("action","AddPersion");
 			
 			forms.submit();
 		} 
 	 		
 /* 	function submit(){
 		alert("提交");
 		var x="Submit";
 		window.self.location.href=x;
 	}	 */
 	
 	function submit(){
 		
 		var xmlhttp=new XMLHttpRequest();
 		
 		xmlhttp.open("GET","/PersonnelInquiry/Submit?biz=PersionManagerBiz&url=FindPersion",true);
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
		
		forms.setAttribute("action","UpdatePersion");
		alert("更新成功");
		forms.submit();
 	}
 	
 	function alterInput( i){
 		var tr=document.getElementById(i);
 		var data=tr.childNodes;
 		
 		tr.innerHTML="<tr bgcolor='#D1DAE9' align='center' id=i> <td width='1%'> <input type='checkbox' name='check' checked='checked' value='"+i+"'/> </td> "
 			+"<td width='6%'><input type='text' name='teacherNumber' value='"+data[3].innerHTML+"' style='width:100px'/></td> "
 			+"<td width='6%'><input type='text' name='name' value='"+data[5].innerHTML+"' style='width:100px'/></td> "
 			+" <td width='6%'><input type='text' name='sex' value='"+data[7].innerHTML+"' style='width:100px'/></td> "
 			+"  <td  width='6%'><input class='birth' id='birth' name='birth' value='"+data[9].innerHTML+"' style='width:100px' /></td>"
 			+" <td width='6%'><input type='text' name='idCard' value='"+data[11].innerHTML+"' style='width:100px' /></td> "
 			+" <td width='6%'><input type='text' name='nation'value='"+data[13].innerHTML+"' style='width:100px'/></td>  "
 			+" <td width='6%'><input type='text' name='nativePlace' value='"+data[15].innerHTML+"' style='width:100px'/></td> "
 			+"<td width='6%'><input type='text' name='placeBirth' value='"+data[17].innerHTML+"' style='width:100px'/></td>  "
 			+" <td width='6%'><input type='text' name='politicalStatus' value='"+data[19].innerHTML+"' style='width:100px'/></td>"
 			+" <td width='6%'><input class='joinPartyTime' id='joinPartyTime' name='joinPartyTime' value='"+data[21].innerHTML+"' style='width:100px'/></td>  "
 			+" <td width='6%'><input class='workingHours' id='workingHours' name='workingHours'value='"+data[23].innerHTML+"' style='width:100px'/></td> "
 			+"<td width='6%'><input class='admissionTime' id='admissionTime' name='admissionTime' value='"+data[25].innerHTML+"' style='width:100px'/></td> "
 			+" <td width='6%'>&nbsp;</td>";
 			
 		$('.birth').DatePicker({
			format:'m/d/Y',
			date: $('#birth').val(),
			current: $('#birth').val(),
			starts: 1,
			position: 'right',
			onBeforeShow: function(){
				$('#birth').DatePickerSetDate($('#birth').val(), true);
			},
			onChange: function(formated, dates){
				$('#birth').val(formated);
				if ($('#closeOnSelect input').attr('checked')) {
					$('#birth').DatePickerHide();
				}
			}
		});
 		
 		$('.joinPartyTime').DatePicker({
			format:'m/d/Y',
			date: $('#joinPartyTime').val(),
			current: $('#joinPartyTime').val(),
			starts: 1,
			position: 'right',
			onBeforeShow: function(){
				$('#joinPartyTime').DatePickerSetDate($('#joinPartyTime').val(), true);
			},
			onChange: function(formated, dates){
				$('#joinPartyTime').val(formated);
				if ($('#closeOnSelect input').attr('checked')) {
					$('#joinPartyTime').DatePickerHide();
				}
			}
		});
 		
 		$('.workingHours').DatePicker({
			format:'m/d/Y',
			date: $('#workingHours').val(),
			current: $('#workingHours').val(),
			starts: 1,
			position: 'right',
			onBeforeShow: function(){
				$('#workingHours').DatePickerSetDate($('#workingHours').val(), true);
			},
			onChange: function(formated, dates){
				$('#workingHours').val(formated);
				if ($('#closeOnSelect input').attr('checked')) {
					$('#workingHours').DatePickerHide();
				}
			}
		});
 		
 		
 		$('.admissionTime').DatePicker({
			format:'m/d/Y',
			date: $('#admissionTime').val(),
			current: $('#admissionTime').val(),
			starts: 1,
			position: 'right',
			onBeforeShow: function(){
				$('#admissionTime').DatePickerSetDate($('#admissionTime').val(), true);
			},
			onChange: function(formated, dates){
				$('#admissionTime').val(formated);
				if ($('#closeOnSelect input').attr('checked')) {
					$('#admissionTime').DatePickerHide();
				}
			}
		});
 		
 		
 	
 		
 		
 			
 			
 	}
 	
 	
 	
 	
 	
</script>

</head>

<body bgColor="#D1DAE9"  >

<% 

List<Tb_persion> modelList=(List)request.getAttribute("modelList");

%>

<h1 style="text-align:center">基本信息</h1>



<div id="filter" >

<form id="from1" action="/PersonnelInquiry/SimpleFindPersion" method="post">
 <p id="p" algin="center">&nbsp;&nbsp;教师编号：<input type="text" name="teacherNumber" /> &nbsp;&nbsp; 
 姓名：<input type="text" name="name" />  &nbsp;&nbsp;
 身份证号：<input type="text" name="idCard" />&nbsp;&nbsp; 
  <input type="submit" value="查询"/> &nbsp;&nbsp; <input type="reset" value="重置"/> </p>
</form>
</div>

<div id="botton">
 <p> &nbsp;&nbsp; &nbsp;&nbsp; <button type="button" onclick="findStudent()" >查询</button> &nbsp;&nbsp; <button onclick="update()">更新</button> &nbsp;&nbsp; <button type="button" onclick="deleteStudent()">删除</button>  &nbsp;&nbsp; <button onclick="addStudent()">添加</button> &nbsp;&nbsp;  <button onclick="addLine()">添加一行</button>  &nbsp;&nbsp;  <button onclick="submit()">提交</button> </p>
</div>

 
<div id="table">
<form id="forms" action="" >
<table high=20 id="table1" border="0" cellspacing="1" cellpadding="0" style="background-color:#F5F5DC" >
<tr bgcolor="#D1DAE9"><th width="2%" ><input type="checkbox" name="ckball" id="ckball" onclick="selectall();"/></th> 
<th  width="6%" id="b">教工编号</th>  <th   width="6%">姓名</th> <th  width="6%">性别</th> 
 <th width="6%">出生年月</th> <th width="6%">身份证号</th><th  width="6%">民族</th>
 <th  width="6%"> 籍贯</th> <th  width="6%"> 出生地</th> <th  width="6%">政治面貌</th>
 <th  width="6%">入党时间</th>  <th  width="6%"> 参加工作时间</th> <th width="6%">入校时间</th><th width="4%"  ></th> </tr>



<% 
if(modelList!=null){
for(int i=0;i<modelList.size();i++){

%>
<tr bgcolor="#D1DAE9" align="center" id='<%=i %>'> <td  width="1%"> <input type="checkbox" name="check" value="<%=i %>"/> </td> 
 <td width="6%"><%=modelList.get(i).teacherNumber %></td>    
  <td  width="6%"><%=modelList.get(i).name %></td>
   <td width="6%"><%=modelList.get(i).sex %></td> 
   <td width="6%"><%=modelList.get(i).birth%></td>
    <td width="6%"><%=modelList.get(i).idCard %></td> 
    <td width="6%"><%=modelList.get(i).nation %></td> 
       <td width="6%"><%=modelList.get(i).nativePlace %></td>
       <td width="6%"><%=modelList.get(i).placeBirth %></td> 
       <td width="6%"><%=modelList.get(i).politicalStatus%></td> 
       <td width="6%"><%=modelList.get(i).joinPartyTime%></td>
        <td width="6%"><%=modelList.get(i).workingHours%></td>
         <td width="6%"><%=modelList.get(i).admissionTime%></td>
          <td><button type="button" onclick="alterInput('<%=i%>')">修改</button></td></tr> 

<% 
}
}
%>



<%-- <c:forEach var="i" items="${requestScope.modelList}" varStatus="s">

<tr align="center" id='${s.index}'> <td width="5%"> <input type="checkbox" name="check" value="${s.index}"/> </td> 
  <td width="8%">${i.teacherNumber}</td>      
  <td  width="8%">${i.name}</td>
   <td width="8%">${i.sex}</td> 
   <td width="8%">${i.birth}</td>
    <td width="8%">${i.idCard }</td> 
    <td width="10%">${i.nation }</td> 
       <td width="8%">${i.nativePlace}</td>
       <td width="8%">${i.placeBirth}</td> 
       <td width="8%">${i.politicalStatus}</td>
        <td width="8%">${i.joinPartyTime}</td>
        <td>${i.workingHours}</td>
        <td> ${i.admissionTime}</td>
          <td><button type="button" onclick="alterInput('${s.index}')">修改</button></td></tr> 
</c:forEach> 
 --%>





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