<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>菜单</title>
<link    type="text/css" href="../css/left.css" rel="stylesheet">
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	<link rel="StyleSheet" href="../css/dtree.css" type="text/css" />
	<script type="text/javascript" src="../js/dtree.js"></script>
	<script type="text/javascript">

		d = new dTree('d');
        d.add(0,-1,'系统菜单树');
		d.add(1,0,'信息管理','${pageContext.request.contextPath}/Home/home1.html','','mainFrame');
		d.add(2,0,'用户管理','${pageContext.request.contextPath}/Home/home1.html','','mainFrame');
		/* d.add(11,0,'用户退出','${pageContext.request.contextPath}/Home/home1.html','','mainFrame'); */
		
		
		d.add(3,1,'基本信息','/PersonnelInquiry/FindPersion','','mainFrame');
		d.add(4,1,'学历信息','/PersonnelInquiry/FindEducation','','mainFrame');
		d.add(5,1,'技术信息','/PersonnelInquiry/FindTechnology','','mainFrame');
		d.add(6,1,'职务信息','/PersonnelInquiry/FindPosition','','mainFrame');
		d.add(7,1,'统计','/PersonnelInquiry/html/XManager.jsp','','mainFrame');
		d.add(8,2,'用户管理','/PersonnelInquiry/FindUsers','','mainFrame');
		/* d.add(9,11,'退出','','','');        */     
		
		document.write(d);   
	/* 	d.s=function(nodeId){ //添加节点点击事件   
			if(this.aNodes[nodeId].id==9){
			window.location.href="/PersonnelInquiry/Exit";
			}
		} */
	</script>
</div>	</td>
  </tr>
</table>


</body>
</html>
