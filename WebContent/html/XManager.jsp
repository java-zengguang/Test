<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>ͳ�Ʊ�</title>
<style>
#title{
color:#F00;
font-size:28px
}</style>
<% String modelJson=(String)session.getAttribute("modelJson"); %>
<script >
	
function getData(){
	
xmlhttp=new XMLHttpRequest();
	
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4 && xmlhttp.status==200){
			
		var table= JSON.parse(xmlhttp.responseText);
			var tableline="";
			
			var newElement=document.createElement("tr");
			newElement.innerHTML="<td>"+table.tn+"</td> <td>"+table.dn+"</td> <td>"+table.mn+"</td> <td>"+table.ftn+"</td> <td>"+table.fg+"</td> <td>"+table.psn+"</td>"
			
			document.getElementById("table1").appendChild(newElement);
				
		
			
		}


	}
	
	/* xmlhttp.open("GET","/PersonnelInquiry/FindX",true);
	
	xmlhttp.send(); */
	
	xmlhttp.open("POST","/PersonnelInquiry/FindX",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=GBK");
	

		
		var obj1 = document.getElementById("select1"); //��λid

	var index1 =obj1.selectedIndex;  // ѡ������

	var divisionTeachingOffices= obj1.options[index1].value;
	
	var obj2 = document.getElementById("select2"); //��λid
	var index2 =obj2.selectedIndex;  // ѡ������
	var department=obj2.options[index2].value; 
	
	var obj3 = document.getElementById("select3"); //��λid
	var index3 =obj3.selectedIndex;  // ѡ������
	var professionalClassification=obj3.options[index3].value; 
	var xx="divisionTeachingOffices="+divisionTeachingOffices+"&department="+department+"&professionalClassification="+professionalClassification;
	var x=encodeURI(encodeURI(xx,"GBK"),"GBK");
	alert(x);
	xmlhttp.send(x);
	
}




</script>

</head>








<body   bgColor="#D1DAE9"  onload="init()">
 <center>
  <strong> ͳ�Ʊ� </strong>
</center>
   <br />
    <center>
   <form id="form1"  name="form1" method="post" action="" >
��ѧ��λ(������)<select name="divisionTeachingOffices" id="select1">
<option value="">---��--ѡ--��---</option>
<option value="��������ϵ">��������ϵ</option>
<option value="���ֹ���ϵ">���ֹ���ϵ</option>
<option value="���ù���ϵ">���ù���ϵ</option>
<option value="�������ϵ">�������ϵ</option>
<option value="����ϵ ">����ϵ</option>
<option value="�ֺ���Ϣ����ϵ">�ֺ���Ϣ����ϵ</option>

</select>&nbsp;&nbsp;&nbsp;&nbsp;


��������<select name="department" id="select2">
<option value="">---��--ѡ--��---</option>
<option value="�칫��">�칫��</option>
<option value="����">����</option>
<option value="���´�">���´�</option>
<option value="���д�">���д�</option>
<option value="������ҵ��">������ҵ��</option>
<option value="��չ�����">��չ�����</option>
<option value="������">������</option>


</select>&nbsp;&nbsp;&nbsp;


רҵ����(רҵ����)<select name="professionalClassification" id="select3">
<option value="">---��--ѡ--��---</option>
<option value="�������">�������</option>
<option value="���繤��">���繤��</option>
<option value="���������ԭ��">���������ԭ��</option>
<option value="javaSE">javaSE</option>
<option value="javaEE">javaEE</option>
<option value="javaME">javaME</option>
<option value="WEBǰ��">WEBǰ��</option>
<option value="������">������</option>
<option value="�Ƽ���">�Ƽ���</option>
<option value="UI���">UI���</option>
<option value="Python">Python</option>


</select>

  &nbsp;&nbsp;<button type="button" onclick="getData()" >��ѯ</button>
</form>
</center>
<br />
<br />
<br />
<table width="752" border="1" align="center"  id="table1">
  <tr>
    <td width="135">��ְ��������</td>
    <td width="135">��ʿѧ������</td>
    <td width="115">˶ʿѧ������</td>
    <td width="120">һ�߽�ʦ����</td>
    <td width="114">������������</td>
    <td width="93">��Ա����</td>
  </tr>
	
</table>



</body >





   




</html>