<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>统计表</title>
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
	

		
		var obj1 = document.getElementById("select1"); //定位id

	var index1 =obj1.selectedIndex;  // 选中索引

	var divisionTeachingOffices= obj1.options[index1].value;
	
	var obj2 = document.getElementById("select2"); //定位id
	var index2 =obj2.selectedIndex;  // 选中索引
	var department=obj2.options[index2].value; 
	
	var obj3 = document.getElementById("select3"); //定位id
	var index3 =obj3.selectedIndex;  // 选中索引
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
  <strong> 统计表 </strong>
</center>
   <br />
    <center>
   <form id="form1"  name="form1" method="post" action="" >
教学单位(教研室)<select name="divisionTeachingOffices" id="select1">
<option value="">---请--选--择---</option>
<option value="防灾仪器系">防灾仪器系</option>
<option value="防灾工程系">防灾工程系</option>
<option value="经济管理系">经济管理系</option>
<option value="人文社科系">人文社科系</option>
<option value="外语系 ">外语系</option>
<option value="灾害信息工程系">灾害信息工程系</option>

</select>&nbsp;&nbsp;&nbsp;&nbsp;


行政部门<select name="department" id="select2">
<option value="">---请--选--择---</option>
<option value="办公室">办公室</option>
<option value="教务处">教务处</option>
<option value="人事处">人事处</option>
<option value="科研处">科研处</option>
<option value="招生就业处">招生就业处</option>
<option value="发展与财务处">发展与财务处</option>
<option value="基建处">基建处</option>


</select>&nbsp;&nbsp;&nbsp;


专业方向(专业分类)<select name="professionalClassification" id="select3">
<option value="">---请--选--择---</option>
<option value="软件开发">软件开发</option>
<option value="网络工程">网络工程</option>
<option value="计算机网络原理">计算机网络原理</option>
<option value="javaSE">javaSE</option>
<option value="javaEE">javaEE</option>
<option value="javaME">javaME</option>
<option value="WEB前段">WEB前段</option>
<option value="大数据">大数据</option>
<option value="云计算">云计算</option>
<option value="UI设计">UI设计</option>
<option value="Python">Python</option>


</select>

  &nbsp;&nbsp;<button type="button" onclick="getData()" >查询</button>
</form>
</center>
<br />
<br />
<br />
<table width="752" border="1" align="center"  id="table1">
  <tr>
    <td width="135">教职工总人数</td>
    <td width="135">博士学历人数</td>
    <td width="115">硕士学历人数</td>
    <td width="120">一线教师人数</td>
    <td width="114">副高以上人数</td>
    <td width="93">党员人数</td>
  </tr>
	
</table>



</body >





   




</html>