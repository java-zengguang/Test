<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.student.model.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/datepicker.css" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>ѧλ��Ϣ</title>
<link rel="stylesheet" type="text/css" href="user.css" />

<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/datepicker.js"></script>
    <script type="text/javascript" src="js/eye.js"></script>

    <script type="text/javascript" src="js/layout.js?ver=1.0.2"></script>

<script type="text/javascript">


	


	function addLine(){
	var newElement=document.createElement("tr");
	newElement.align="center";
	newElement.innerHTML=" <td bgcolor= '#D1DAE9' width='1%'> <input type='checkbox' name='check' checked='checked' style='width:100px'/>"
	+"</td> <td bgcolor= '#D1DAE9' width='8%'><input type='text' name='teacherNumber' style='width:100px'/></td>"
	+"</td> <td bgcolor= '#D1DAE9' width='8%'><input type='text' name='firstDegree' style='width:100px'/></td>"
	+"<td bgcolor= '#D1DAE9' width='8%'><input type='text' name='firstEducation' style='width:100px'/></td>"
	+"<td bgcolor= '#D1DAE9' width='8%'><input type='text' name='firstDegreeUniversity' style='width:100px'/></td>"   
	+"<td bgcolor= '#D1DAE9'  width='8%'><input type='text' name='firstMajor' style='width:100px' /></td>" 
	+"<td bgcolor= '#D1DAE9' width='8%'><input type='text' name='firstDegreeTime' style='width:100px' /></td>"  
	+"<td bgcolor= '#D1DAE9' width='8%'><input type='text' name='supremeDegree' style='width:100px'/></td>"   
	+"<td bgcolor= '#D1DAE9' width='8%'><input type='text' name='supremeDegreeUnit' style='width:100px'/></td>" 
	+"<td bgcolor= '#D1DAE9' width='8%'><input type='text' name='supremeMajor' style='width:100px'/></td>"  
	+"<td bgcolor= '#D1DAE9' width='8%'><input type='text'  name='supremeMajorTime' style='width:100px'/></td>" 
	+"<td bgcolor= '#D1DAE9' width='8%'></td>" ;
	document.getElementById("table1").appendChild(newElement);
	}

	
 	function deleteEducation(){
 	
		var forms=document.getElementById("forms");
		
		forms.setAttribute("action","DeleteEducationIndex");
		alert("ɾ���ɹ�");
		forms.submit();
	} 
 	
 	function findEducation(){
  		var terms = prompt("�������ѯ����:","tercherNumber=3");
 		if (terms != null){
 			alert(terms);
 			var x="FindEducation?terms="+terms;
 		window.self.location.href=x;
 		}else{
 		alert("�㰴��[ȡ��]��ť");
 	}
 	}
 	
 		function addEducation(){
 			alert("��ӳɹ�");
 			var forms=document.getElementById("forms");
 			forms.setAttribute("action","AddEducation");
 			
 			forms.submit();
 		} 
 	 		
 		function submit(){
 	 		
 	 		var xmlhttp=new XMLHttpRequest();
 	 		
 	 		xmlhttp.open("GET","/PersonnelInquiry/Submit?biz=EducationManagerBiz&url=FindEducation",true);
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
		
		forms.setAttribute("action","UpdateEducation");
		alert("���³ɹ�");
		forms.submit();
 	}
 	
 	function alterInput( i){
 		var tr=document.getElementById(i);
 		var data=tr.childNodes;
 		tr.innerHTML=" <tr bgcolor='#D1DAE9' align='center' id=i> <td bgcolor= '#D1DAE9' width='1%'> <input type='checkbox'  name='check' checked='checked' value='"+i+"' style='width:100px'/> </td>"
 		+"</td> <td  width='8%'><input type='text' name='teacherNumber' value='"+data[3].innerHTML+"' style='width:100px'/></td>"
 		+"</td> <td  width='8%'><input type='text' name='firstDegree'value='"+data[5].innerHTML+"' style='width:100px'/></td>"
 		+"<td  width='8%'><input type='text' name='firstEducation' value='"+data[7].innerHTML+"' style='width:100px'/></td>"
 		+"<td  width='8%'><input type='text' name='firstDegreeUniversity' value='"+data[9].innerHTML+"' style='width:100px'/></td>"   
 		+"<td   width='8%'><input type='text' name='firstMajor' value='"+data[11].innerHTML+"' style='width:100px' /></td>" 
 		+"<td width='8%'><input  class='firstDegreeTime' id='firstDegreeTime' name='firstDegreeTime' value='"+data[13].innerHTML+"' style='width:100px' /></td>"  
 		+"<td  width='8%'><input type='text' name='supremeDegree' value='"+data[15].innerHTML+"' style='width:100px'/></td>"   
 		+"<td  width='8%'><input type='text' name='supremeDegreeUnit' value='"+data[17].innerHTML+"' style='width:100px'/></td>" 
 		+"<td  width='8%'><input type='text' name='supremeMajor' value='"+data[19].innerHTML+"' style='width:100px'/></td>"  
 		+"<td  width='8%'><input class='supremeMajorTime' id='supremeMajorTime' name='supremeMajorTime' value='"+data[21].innerHTML+"'  style='width:100px'/></td>" 
 		+"<td  width='8%'></td>" ;
 		$('.supremeMajorTime').DatePicker({
			format:'m/d/Y',
			date: $('#supremeMajorTime').val(),
			current: $('#supremeMajorTime').val(),
			starts: 1,
			position: 'right',
			onBeforeShow: function(){
				$('#supremeMajorTime').DatePickerSetDate($('#supremeMajorTime').val(), true);
			},
			onChange: function(formated, dates){
				$('#supremeMajorTime').val(formated);
				if ($('#closeOnSelect input').attr('checked')) {
					$('#supremeMajorTime').DatePickerHide();
				}
			}
		});
 		
 		$('.firstDegreeTime').DatePicker({
			format:'m/d/Y',
			date: $('#firstDegreeTime').val(),
			current: $('#firstDegreeTime').val(),
			starts: 1,
			position: 'right',
			onBeforeShow: function(){
				$('#firstDegreeTime').DatePickerSetDate($('#firstDegreeTime').val(), true);
			},
			onChange: function(formated, dates){
				$('#firstDegreeTime').val(formated);
				if ($('#closeOnSelect input').attr('checked')) {
					$('#firstDegreeTime').DatePickerHide();
				}
			}
		});
 	
 	}

</script>

</head>

<body  bgColor="#D1DAE9" >


<% 
List<Tb_education> modelList=(List)request.getAttribute("modelList");

%>

<h1 style="text-align:center">ѧλ��Ϣ</h1>

<div id="filter" >

<form id="from1" action="/PersonnelInquiry/SimpleFindEducation" method="post">
 <p id="p" algin="center">&nbsp;&nbsp;�̹���ţ�<input type="text" name="teacherNumber" /> &nbsp;&nbsp; ���ѧλ��<input type="text" name="supremeDegree" />  &nbsp;&nbsp;��һѧ����<input type="text" name="firstEducation" />&nbsp;&nbsp;  <input type="submit" value="��ѯ"/> &nbsp;&nbsp; <input type="reset" value="����"/> </p>
</form>
</div>

<div id="botton">
 <p> &nbsp;&nbsp; &nbsp;&nbsp; <button type="button" onclick="findEducation()" >��ѯ</button> &nbsp;&nbsp; <button onclick="update()">����</button> &nbsp;&nbsp; <button type="button" onclick="deleteEducation()">ɾ��</button> &nbsp;&nbsp;<button onclick="addEducation()">���</button> &nbsp;&nbsp;<button onclick="addLine()">���һ��</button> &nbsp;&nbsp; <button onclick="submit()">�ύ</button> </p>
</div>

 
<div id="table">
<form id="forms" action="" >
<table  high=20 id="table1"  border="0" cellspacing="1" cellpadding="0" style="background-color:#F5F5DC" >
<tr bgcolor= '#D1DAE9'><th width="2%" ><input type="checkbox" name="ckball" id="ckball" onclick="selectall();" /> </th> 
<th width="8%" id="b">�̹����</th>  <th  width="8%">��һѧλ</th>  <th  width="8%">��һѧ��</th><th width="8%">��һѧ����ҵԺУ</th>
 <th width="8%">��һѧ��רҵ</th> <th width="8%">��һѧ����ҵʱ��</th> <th width="8%">���ѧλ</th>
 <th width="8%">���ѧλ���赥λ</th><th width="8%">���ѧλרҵ</th> <th width="8%">���ѧ�����ʱ��</th><th width="4%"></th></tr>


<% 
if(modelList!=null){
for(int i=0;i<modelList.size();i++){

%>
<tr bgcolor="#D1DAE9" align="center" id='<%=i %>'> <td width="1%"> <input type="checkbox" name="check" value="<%=i %>"/> 
</td>  <td width="8%"  ><%=modelList.get(i).teacherNumber+"" %></td>  
   <td  width="8%"><%=modelList.get(i).firstDegree %></td> 
   <td  width="8%"><%=modelList.get(i).firstEducation %></td>
    <td  width="8%"><%=modelList.get(i).firstDegreeUniversity %></td>
   <td  width="8%"><%=modelList.get(i).firstMajor %></td>
    <td width="8%"><%=modelList.get(i).firstDegreeTime %></td>  
    <td width="8%"><%=modelList.get(i).supremeDegree %></td> 
    <td  width="8%"><%=modelList.get(i).supremeDegreeUnit %></td>
     <td  width="8%"><%=modelList.get(i).supremeMajor %> </td>
      <td  width="8%"><%=modelList.get(i).supremeMajorTime %></td>  
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