<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.student.model.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" href="css/datepicker.css" type="text/css" />
<title>技术信息</title>
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
		alert("删除成功");
		forms.submit();
	} 
 	
 	function findTechnology(){
  		var terms = prompt("请输入查询条件:","id=3");
 		if (terms != null){
 			alert(terms);
 			var x="FindTechnology?terms="+terms;
 		window.self.location.href=x;
 		}else{
 		alert("你按了[取消]按钮");
 	}
 	}
 	
 		function addTechnology(){
 			alert("添加成功");
 			var forms=document.getElementById("forms");
 			forms.setAttribute("action","AddTechnology");
 			
 			forms.submit();
 		} 
 	 		
 		function submit(){
 	 		
 	 		var xmlhttp=new XMLHttpRequest();
 	 		
 	 		xmlhttp.open("GET","/PersonnelInquiry/Submit?biz=TechnologyManagerBiz&url=FindTechnology",true);
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
		
		forms.setAttribute("action","UpdateTechnology");
		alert("修改成功");
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

<h1 style="text-align:center">技术信息</h1>

<div id="filter" >

<form id="from1" action="/PersonnelInquiry/SimpleFindTechnology" method="post">
 <p id="p" algin="center">&nbsp;&nbsp;教师编号：<input type="text" name="teacherNumber" /> &nbsp;&nbsp; 
 归属专业：<input type="text" name="belongAProfession" />  &nbsp;&nbsp;
 二级学科 ：<input type="text" name="secondaryDiscipline" />&nbsp;&nbsp; 
  <input type="submit" value="查询"/> &nbsp;&nbsp; <input type="reset" value="重置"/> </p>
</form>
</div>

<div id="botton">
 <p> &nbsp;&nbsp; &nbsp;&nbsp; <button type="button" onclick="findTechnology()" >查询</button> &nbsp;&nbsp; <button onclick="update()">更新</button> &nbsp;&nbsp; <button type="button" onclick="deleteTechnology()">删除</button>&nbsp;&nbsp; <button onclick="addTechnology()">添加</button>&nbsp;&nbsp; <button onclick="addLine()">添加一行</button> &nbsp;&nbsp; <button onclick="submit()">提交</button> </p>
</div>

 
<div id="table">
<form id="forms" action="" >
<table  high=20 id="table1" border="0" cellspacing="1" cellpadding="0" style="background-color:#F5F5DC" >
<tr bgcolor="#D1DAE9"><th width="2%" ><input type="checkbox" name="ckball" id="ckball" onclick="selectall();"/></th> 
<th  width="6%" id="b">教工编号</th>  <th  width="6%">归属专业</th> <th  width="8%">归属专业（真实）</th> 
 <th  width="6%">归属专业全校范围</th> <th  width="6%">二级学科 </th><th  width="6%">专业带头人</th>
 <th  width="6%"> 地震局综合统计分类 </th> <th  width="8%"> 事业单位机构编制数据采集分类</th> <th  width="6%">专业分类</th>
 <th  width="6%">教师资格证书</th>  <th  width="6%"> 技术职务级别</th> <th  width="6%">技术职务资格级别</th>
  <th  width="6%">聘任技术职务</th>   <th  width="6%">取得资格时间</th> <th  ></th> </tr>

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
          <td ><button type="button" onclick="alterInput('<%=i%>')">修改</button></td></tr> 

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