<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ page import="com.student.model.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link rel="stylesheet" href="css/datepicker.css" type="text/css" />
<title>ְ����Ϣ</title>
<link rel="stylesheet" type="text/css" href="user.css" />

<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/datepicker.js"></script>
    <script type="text/javascript" src="js/eye.js"></script>

    <script type="text/javascript" src="js/layout.js?ver=1.0.2"></script>

<script type="text/javascript">

	function addLine(){
	var newElement=document.createElement("tr");
	newElement.align="center";

	newElement.innerHTML=" <td bgcolor='#D1DAE9' width='1%'> <input type='checkbox' name='ckb' checked='checked' style='width:100px'/> </td>"
		   +"<td bgcolor='#D1DAE9' width='4%'><input type='text' name='teacherNumber' style='width:80px'/></td> "
	        +"<td bgcolor='#D1DAE9' width='4%'><input type='text' name='department' style='width:80px'/></td> "
			+"<td bgcolor='#D1DAE9' width='4%'><input type='text' name='threeLevelInstitution' style='width:80px'/></td> "
			+" <td bgcolor='#D1DAE9' width='4%'><input type='text' name='postNature' style='width:80px'/></td> "
			+"  <td bgcolor='#D1DAE9'  width='4%'><input type='text' name='postGrade' style='width:80px' /></td>"
			+" <td bgcolor='#D1DAE9' width='4%'><input type='text' name='appointmentCurrentTime' style='width:80px' /></td> "
			+" <td bgcolor='#D1DAE9' width='4%'><input type='text' name='appointmentTime' style='width:80px'/></td>  "
			+" <td bgcolor='#D1DAE9' width='4%'><input type='text' name='aboveMiddleLevel' style='width:80px'/></td> "
			+"<td bgcolor='#D1DAE9'  width='4%'><input type='text' name='aboveSubtropicalHigh' style='width:80px'/></td>  "
			+" <td bgcolor='#D1DAE9' width='4%'><input type='text' name='frontlineTeachers' style='width:80px'/></td>"
			+" <td bgcolor='#D1DAE9' width='4%'><input type='text' name='status' style='width:80px'/></td>  "
			+" <td bgcolor='#D1DAE9' width='4%'><input type='text' name='post' style='width:80px'/></td> "
			+"<td bgcolor='#D1DAE9' width='4%'><input type='text' name='fullTimeTeacher' style='width:80px'/></td> "
			+" <td bgcolor='#D1DAE9' width='4%'><input type='text' name='divisionSystem' style='width:80px'/></td> "
			+"<td bgcolor='#D1DAE9' width='4%'><input type='text' name='divisionTeachingOffices' style='width:80px'/></td>  "
			+" <td bgcolor='#D1DAE9' width='4%'><input type='text' name='wageExecutionSeries' style='width:80px'/></td>"
			+" <td bgcolor='#D1DAE9' width='4%'><input type='text' name='allowanceRate' style='width:80px'/></td>  "
			+" <td bgcolor='#D1DAE9' width='4%'><input type='text' name='administrativeLevelTime' style='width:80px'/></td> "	
			+" <td bgcolor='#D1DAE9' width='4%'>&nbsp;</td>";
	document.getElementById("table1").appendChild(newElement);
	}
	
 	function deleteStudent(){
 	
		var forms=document.getElementById("forms");
		
		forms.setAttribute("action","DeletePositionIndex");
		alert("ɾ���ɹ�");
		forms.submit();
	} 
 	
 	function findStudent(){
  		var terms = prompt("�������ѯ����:","id=3");
 		if (terms != null){
 			alert(terms);
 			var x="FindPosition?terms="+terms;
 		window.self.location.href=x;
 		}else{
 		alert("�㰴��[ȡ��]��ť");
 	}
 	}
 	
 		function addStudent(){
 			alert("��ӳɹ�");
 			var forms=document.getElementById("forms");
 			forms.setAttribute("action","AddPosition");
 			
 			forms.submit();
 		} 
 	 		
 /* 	function submit(){
 		alert("�ύ");
 		var x="Submit";
 		window.self.location.href=x;
 	}	 */
 	
 	function submit(){
 		
 		var xmlhttp=new XMLHttpRequest();
 		
 		xmlhttp.open("GET","/PersonnelInquiry/Submit?biz=PositionManagerBiz&url=FindPosition",true);
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
		
		forms.setAttribute("action","UpdatePosition");
		alert("���³ɹ�");
		forms.submit();
 	}
 	
 	function alterInput( i){
 		var tr=document.getElementById(i);
 		var data=tr.childNodes;
 		tr.innerHTML="<tr bgcolor='#D1DAE9' align='center' id=i> <td width='1%'> <input type='checkbox' name='check' checked='checked' value='"+i+"'/> </td> "
 			+"<td width='3%'><input type='text' name='teacherNumber'  value='"+data[3].innerHTML+"' style='width:80px'/></td> "	
 			+"<td width='3%'><input type='text' name='department'  value='"+data[5].innerHTML+"' style='width:80px'/></td> "
 			+"<td width='3%'><input type='text' name='threeLevelInstitution'  value='"+data[7].innerHTML+"' style='width:80px'/></td> "
 			+" <td width='3%'><input type='text' name='postNature'  value='"+data[9].innerHTML+"' style='width:80px'/></td> "
 			+"  <td  width='3%'><input type='text' name='postGrade'  value='"+data[11].innerHTML+"' style='width:80px' /></td>"
 			+" <td width='3%'><input class='appointmentCurrentTime' id='appointmentCurrentTime' name='appointmentCurrentTime'  value='"+data[13].innerHTML+"' style='width:80px' /></td> "
 			+" <td width='3%'><input class='appointmentTime' id='appointmentTime' name='appointmentTime'  value='"+data[15].innerHTML+"' style='width:80px'/></td>  "
 			+" <td width='3%'><input type='text' name='aboveMiddleLevel'  value='"+data[17].innerHTML+"' style='width:80px'/></td> "
 			+"<td width='3%'><input type='text' name='aboveSubtropicalHigh'  value='"+data[19].innerHTML+"' style='width:80px'/></td>  "
 			+" <td width='3%'><input type='text' name='frontlineTeachers'  value='"+data[21].innerHTML+"' style='width:80px'/></td>"
 			+" <td width='3%'><input type='text' name='status'  value='"+data[23].innerHTML+"' style='width:80px'/></td>  "
 			+" <td width='3%'><input type='text' name='post'  value='"+data[25].innerHTML+"' style='width:80px'/></td> "
 			+"<td width='3%'><input type='text' name='fullTimeTeacher'  value='"+data[27].innerHTML+"' style='width:80px'/></td> "
 			+" <td width='3%'><input type='text' name='divisionSystem'  value='"+data[29].innerHTML+"' style='width:80px'/></td> "
 			+"<td width='3%'><input type='text' name='divisionTeachingOffices'  value='"+data[31].innerHTML+"' style='width:80px'/></td>  "
 			+" <td width='3%'><input type='text' name='wageExecutionSeries'  value='"+data[33].innerHTML+"' style='width:80px'/></td>"
 			+" <td width='3%'><input type='text' name='allowanceRate'  value='"+data[35].innerHTML+"' style='width:80px'/></td>  "
 			+" <td width='3%'><input class='administrativeLevelTime' id='administrativeLevelTime' name='administrativeLevelTime'  value='"+data[37].innerHTML+"' style='width:80px'/></td> "
 			+" <td width='3%'>&nbsp;</td>";
 			
 			$('.appointmentCurrentTime').DatePicker({
 				format:'m/d/Y',
 				date: $('#appointmentCurrentTime').val(),
 				current: $('#appointmentCurrentTime').val(),
 				starts: 1,
 				position: 'right',
 				onBeforeShow: function(){
 					$('#appointmentCurrentTime').DatePickerSetDate($('#appointmentCurrentTime').val(), true);
 				},
 				onChange: function(formated, dates){
 					$('#appointmentCurrentTime').val(formated);
 					if ($('#closeOnSelect input').attr('checked')) {
 						$('#appointmentCurrentTime').DatePickerHide();
 					}
 				}
 			});
 	 			
 			
 			
 			
 		$('.appointmentTime').DatePicker({
			format:'m/d/Y',
			date: $('#appointmentTime').val(),
			current: $('#appointmentTime').val(),
			starts: 1,
			position: 'right',
			onBeforeShow: function(){
				$('#appointmentTime').DatePickerSetDate($('#appointmentTime').val(), true);
			},
			onChange: function(formated, dates){
				$('#appointmentTime').val(formated);
				if ($('#closeOnSelect input').attr('checked')) {
					$('#appointmentTime').DatePickerHide();
				}
			}
		});
 		
 		
 		$('.administrativeLevelTime').DatePicker({
			format:'m/d/Y',
			date: $('#administrativeLevelTime').val(),
			current: $('#administrativeLevelTime').val(),
			starts: 1,
			position: 'right',
			onBeforeShow: function(){
				$('#administrativeLevelTime').DatePickerSetDate($('#administrativeLevelTime').val(), true);
			},
			onChange: function(formated, dates){
				$('#administrativeLevelTime').val(formated);
				if ($('#closeOnSelect input').attr('checked')) {
					$('#administrativeLevelTime').DatePickerHide();
				}
			}
		});
 			
 			
 			
 			
 			
 	}
 	
 	
 	
 	
 	
</script>

</head>

<body   bgColor="#D1DAE9" >

<%
	List<Tb_position> modelList=(List)request.getAttribute("modelList");
%>

<h1 style="text-align:center">ְ����Ϣ</h1>

<div id="filter" >

<form id="from1" action="/PersonnelInquiry/SimpleFindPosition" method="post">
 <p id="p" algin="center">&nbsp;&nbsp;�̹���ţ�<input type="text" name="teacherNumber" /> &nbsp;&nbsp; 
���ţ�<input type="text" name="department" />  &nbsp;&nbsp;
��λ��<input type="text" name="post" />&nbsp;&nbsp; 
  <input type="submit" value="��ѯ"/> &nbsp;&nbsp; <input type="reset" value="����"/> </p>
</form>
</div>

<div id="botton">
 <p> &nbsp;&nbsp; &nbsp;&nbsp; <button type="button" onclick="findStudent()" >��ѯ</button> &nbsp;&nbsp; <button onclick="update()">����</button> &nbsp;&nbsp; <button type="button" onclick="deleteStudent()">ɾ��</button>&nbsp;&nbsp; <button onclick="addStudent()">���</button>&nbsp;&nbsp; <button onclick="addLine()">���һ��</button> &nbsp;&nbsp; <button onclick="submit()">�ύ</button> </p>
</div>

 
<div id="table">
<form id="forms" action="/PersonnelInquiry/UpdatePosition" >
<table  high=20 id="table1" border="0" cellspacing="1" cellpadding="0" style="background-color:#F5F5DC" >
<tr bgcolor="#D1DAE9"><th width="2%" ><input type="checkbox" name="ckball" id="ckball" onclick="selectall();"/></th> 
 <th width="5%" >�̹����&nbsp; </th>
<th width="3%" id="b">����</th> 
 <th width="5%">��������</th> 
 <th width="5%">��λ���� </th> 
 <th width="5%">��λ�ȼ�</th> 
 <th width="6%">Ƹ�ָ�ʱ�� </th>
 <th width="5%">Ƹ��ʱ��</th>
 <th width="7%"> �Ƿ��в�����</th> 
 <th width="6%">�Ƿ񸱸�����</th> 
 <th width="6%">�Ƿ�һ�߽�ʦ </th>
 <th width="3%">���</th> 
 <th width="3%">��λ</th>
 <th width="6%">�Ƿ�ת�ν�ʦ</th>
 <th width="5%">����ϵ��</th> 
 
 <th width="6%" >���ֽ�����</th> 
 <th width="5%" >����ִ��ϵ��</th>
 <th width="5%" >������׼ </th>
 <th width="6%" >��������ʱ�� </th>
 <th></th>

 
  
 </tr>

<% 
if(modelList!=null){
for(int i=0;i<modelList.size();i++){
%>
<tr bgcolor="#D1DAE9" align="center" id='<%=i %>'> <td width="1%"> <input type="checkbox" name="check" value="<%=i %>"/> </td> 
   <td> <%=modelList.get(i).teacherNumber %></td>
  <td  width="3%"><%=modelList.get(i).department %></td>
   <td width="3%"><%=modelList.get(i).threeLevelInstitution+"" %></td> 
   <td width="3%"><%=modelList.get(i).postNature+"" %></td>
    <td width="3%"><%=modelList.get(i).postGrade %></td> 
       <td width="3%"><%=modelList.get(i).appointmentCurrentTime %></td>
       <td width="3%"><%=modelList.get(i).appointmentTime %></td> 
       <td width="3%"><%=modelList.get(i).aboveMiddleLevel%></td>
        <td width="3%"><%=modelList.get(i).aboveSubtropicalHigh%></td>
        <td><%=modelList.get(i).frontlineTeachers %></td>
        <td> <%=modelList.get(i).status %></td>
         <td width="2%"><%=modelList.get(i).post%></td>
        <td><%=modelList.get(i).fullTimeTeacher %></td>
        <td> <%=modelList.get(i).divisionSystem %></td>
         <td><%=modelList.get(i).divisionTeachingOffices %></td>
        <td> <%=modelList.get(i).wageExecutionSeries %></td>
         <td width="3%"><%=modelList.get(i).allowanceRate%></td>
        <td><%=modelList.get(i).administrativeLevelTime %></td>
      <td><button type="button" onclick="alterInput('<%=i%>')">�޸�</button></td></tr> 

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