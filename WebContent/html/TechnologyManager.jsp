<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.student.model.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" href="css/datepicker.css" type="text/css" />
<title>������Ϣ</title>
<link rel="stylesheet" type="text/css" href="user.css" />
<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/datepicker.js"></script>
    <script type="text/javascript" src="js/eye.js"></script>

    <script type="text/javascript" src="js/layout.js?ver=1.0.2"></script>


<script type="text/javascript">

	function addLine(){
	var newElement=document.createElement("tr");
	newElement.align="center";

	newElement.innerHTML=" <td bgcolor='#D1DAE9' width='1%'> <input type='checkbox' name='check' checked='checked' style='width:100px'/> </td>"
	+"<td bgcolor='#D1DAE9' width='6%'><input type='text' name='teacherNumber' style='width:80px'/></td> "
	+"<td bgcolor='#D1DAE9' width='6%'><input type='text' name='belongAProfession' style='width:80px'/></td> "
	+" <td bgcolor='#D1DAE9' width='6%'><input type='text' name='belongProfessionTruth' style='width:80px'/></td> "
	+"  <td bgcolor='#D1DAE9'  width='6%'><input type='text' name='belongProfessionalSchool' style='width:80px' /></td>"
	+" <td bgcolor='#D1DAE9' width='6%'><input type='text' name='secondaryDiscipline' style='width:80px' /></td> "
	+" <td bgcolor='#D1DAE9' width='6%'><input type='text' name='professionalLeader' style='width:80px'/></td>  "
	+" <td bgcolor='#D1DAE9' width='6%'><input type='text' name='CSCSB' style='width:80px'/></td> "
	+"<td bgcolor='#D1DAE9' width='6%'><input type='text' name='CCDI' style='width:80px'/></td>  "
	+" <td bgcolor='#D1DAE9' width='6%'><input type='text' name='professionalClassification' style='width:80px'/></td>"
	+" <td bgcolor='#D1DAE9' width='6%'><input type='text' name='TQC' style='width:80px'/></td>  "
	+"<td bgcolor='#D1DAE9' width='6%'><input type='text' name='technicalJobLevel' style='width:80px'/></td> "
	+" <td bgcolor='#D1DAE9'  width='6%'><input type='text' name='TPQL' style='width:80px'/></td> "
	+"<td bgcolor='#D1DAE9' width='6%'><input type='text' name='employmentTechnicalPosts' style='width:80px'/></td> "
	+"<td bgcolor='#D1DAE9' width='6%'><input type='text' name='eligibilityTime' style='width:80px'/></td> "
	+" <td bgcolor='#D1DAE9' width='6%'>&nbsp;</td>";
	document.getElementById("table1").appendChild(newElement);
	}
	
 	function deleteTechnology(){
 	
		var forms=document.getElementById("forms");
		
		forms.setAttribute("action","DeleteTechnologyIndex");
		alert("ɾ���ɹ�");
		forms.submit();
	} 
 	
 	function findTechnology(){
  		var terms = prompt("�������ѯ����:","id=3");
 		if (terms != null){
 			alert(terms);
 			var x="FindTechnology?terms="+terms;
 		window.self.location.href=x;
 		}else{
 		alert("�㰴��[ȡ��]��ť");
 	}
 	}
 	
 		function addTechnology(){
 			alert("��ӳɹ�");
 			var forms=document.getElementById("forms");
 			forms.setAttribute("action","AddTechnology");
 			
 			forms.submit();
 		} 
 	 		
 		function submit(){
 	 		
 	 		var xmlhttp=new XMLHttpRequest();
 	 		
 	 		xmlhttp.open("GET","/PersonnelInquiry/Submit?biz=TechnologyManagerBiz&url=FindTechnology",true);
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
		
		forms.setAttribute("action","UpdateTechnology");
		alert("�޸ĳɹ�");
		forms.submit();
 	}
 	
 	function alterInput( i){
 		var tr=document.getElementById(i);
 		var data=tr.childNodes;
 		tr.innerHTML="<tr bgcolor='#D1DAE9' align='center' id=i> <td bgcolor='#D1DAE9' width='1%'> <input type='checkbox' name='check' checked='checked' value='"+i+"'/> </td> "
 			+"<td  width='6%'><input type='text' name='teacherNumber'  value='"+data[3].innerHTML+"'  style='width:80px'/></td> "
 			+"<td width='6%'><input type='text' name='belongAProfession' value='"+data[5].innerHTML+"'  style='width:80px'/></td> "
 			+" <td  width='6%'><input name='belongProfessionTruth' value='"+data[7].innerHTML+"'  style='width:80px'/></td> "
 			+"  <td   width='6%'><input type='text' name='belongProfessionalSchool' value='"+data[9].innerHTML+"'  style='width:80px' /></td>"
 			+" <td  width='6%'><input type='text' name='secondaryDiscipline' value='"+data[11].innerHTML+"'  style='width:80px' /></td> "
 			+" <td  width='6%'><input type='text' name='professionalLeader' value='"+data[13].innerHTML+"'  style='width:80px'/></td>  "
 			+" <td  width='6%'><input type='text' name='CSCSB' value='"+data[15].innerHTML+"'  style='width:80px'/></td> "
 			+"<td  width='6%'><input type='text' name='CCDI' value='"+data[17].innerHTML+"'  style='width:80px'/></td>  "
 			+" <td  width='6%'><input type='text' name='professionalClassification' value='"+data[19].innerHTML+"'  style='width:80px'/></td>"
 			+" <td  width='6%'><input type='text' name='TQC' value='"+data[21].innerHTML+"'  style='width:80px'/></td>  "
 			+"<td  width='6%'><input type='text' name='technicalJobLevel' value='"+data[23].innerHTML+"'  style='width:80px'/></td> "
 			+" <td  width='6%'><input type='text' name='TPQL' value='"+data[25].innerHTML+"'  style='width:80px'/></td> "
 			+"<td  width='6%'><input type='text' name='employmentTechnicalPosts' value='"+data[27].innerHTML+"'  style='width:80px'/></td> "
 			+"<td  width='6%'><input class='eligibilityTime' id='eligibilityTime' name='eligibilityTime' value='"+data[29].innerHTML+"'  style='width:80px'/></td> "
 			+" <td  width='6%'>&nbsp;</td>";
 		$('.eligibilityTime').DatePicker({
			format:'m/d/Y',
			date: $('#eligibilityTime').val(),
			current: $('#eligibilityTime').val(),
			starts: 1,
			position: 'right',
			onBeforeShow: function(){
				$('#eligibilityTime').DatePickerSetDate($('#eligibilityTime').val(), true);
			},
			onChange: function(formated, dates){
				$('#eligibilityTime').val(formated);
				if ($('#eligibilityTime').attr('checked')) {
					$('#eligibilityTime').DatePickerHide();
				}
			}
		});
 			
 			
 	}
 	
</script>

</head>

<body  bgColor="#D1DAE9"   >

<% 

List<Tb_technology> modelList=(List)request.getAttribute("modelList");

%>

<h1 style="text-align:center">������Ϣ</h1>

<div id="filter" >

<form id="from1" action="/PersonnelInquiry/SimpleFindTechnology" method="post">
 <p id="p" algin="center">&nbsp;&nbsp;��ʦ��ţ�<input type="text" name="teacherNumber" /> &nbsp;&nbsp; 
 ����רҵ��<input type="text" name="belongAProfession" />  &nbsp;&nbsp;
 ����ѧ�� ��<input type="text" name="secondaryDiscipline" />&nbsp;&nbsp; 
  <input type="submit" value="��ѯ"/> &nbsp;&nbsp; <input type="reset" value="����"/> </p>
</form>
</div>

<div id="botton">
 <p> &nbsp;&nbsp; &nbsp;&nbsp; <button type="button" onclick="findTechnology()" >��ѯ</button> &nbsp;&nbsp; <button onclick="update()">����</button> &nbsp;&nbsp; <button type="button" onclick="deleteTechnology()">ɾ��</button>&nbsp;&nbsp; <button onclick="addTechnology()">���</button>&nbsp;&nbsp; <button onclick="addLine()">���һ��</button> &nbsp;&nbsp; <button onclick="submit()">�ύ</button> </p>
</div>

 
<div id="table">
<form id="forms" action="" >
<table  high=20 id="table1" border="0" cellspacing="1" cellpadding="0" style="background-color:#F5F5DC" >
<tr bgcolor="#D1DAE9"><th width="2%" ><input type="checkbox" name="ckball" id="ckball" onclick="selectall();"/></th> 
<th  width="6%" id="b">�̹����</th>  <th  width="6%">����רҵ</th> <th  width="8%">����רҵ����ʵ��</th> 
 <th  width="6%">����רҵȫУ��Χ</th> <th  width="6%">����ѧ�� </th><th  width="6%">רҵ��ͷ��</th>
 <th  width="6%"> ������ۺ�ͳ�Ʒ��� </th> <th  width="8%"> ��ҵ��λ�����������ݲɼ�����</th> <th  width="6%">רҵ����</th>
 <th  width="6%">��ʦ�ʸ�֤��</th>  <th  width="6%"> ����ְ�񼶱�</th> <th  width="6%">����ְ���ʸ񼶱�</th>
  <th  width="6%">Ƹ�μ���ְ��</th>   <th  width="6%">ȡ���ʸ�ʱ��</th> <th  ></th> </tr>

<% 
if(modelList!=null){
for(int i=0;i<modelList.size();i++){

%>
<tr bgcolor="#D1DAE9" align="center" id='<%=i %>'> <td  width="1%"> <input type="checkbox" name="check" value="<%=i %>"/> </td> 
 <td  width="6%"><%=modelList.get(i).teacherNumber %></td>    
  <td  width="6%"><%=modelList.get(i).belongAProfession %></td>
   <td  width="8%"><%=modelList.get(i).belongProfessionTruth %></td> 
   <td  width="6%"><%=modelList.get(i).belongProfessionalSchool%></td>
    <td  width="6%"><%=modelList.get(i).secondaryDiscipline %></td> <td  width="6%"><%=modelList.get(i).professionalLeader %></td> 
       <td  width="6%"><%=modelList.get(i).CSCSB %></td>
       <td  width="6%"><%=modelList.get(i).CCDI %></td> 
       <td  width="8%"><%=modelList.get(i).professionalClassification%></td>
        <td  width="6%"><%=modelList.get(i).TQC%></td>
         <td  width="6%"><%=modelList.get(i).technicalJobLevel%></td>
        <td ><%=modelList.get(i).TPQL %></td>
        <td > <%=modelList.get(i).employmentTechnicalPosts %></td>
          <td > <%=modelList.get(i).eligibilityTime %></td>
          <td ><button type="button" onclick="alterInput('<%=i%>')">�޸�</button></td></tr> 

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