<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>�˵�</title>
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

	<a href="javascript: d.openAll();">չ������</a> | <a href="javascript: d.closeAll();">�ر�����</a>
	<link rel="StyleSheet" href="../css/dtree.css" type="text/css" />
	<script type="text/javascript" src="../js/dtree.js"></script>
	<script type="text/javascript">

		d = new dTree('d');
        d.add(0,-1,'ϵͳ�˵���');
		d.add(1,0,'��Ϣ����','${pageContext.request.contextPath}/Home/home1.html','','mainFrame');
		d.add(2,0,'�û�����','${pageContext.request.contextPath}/Home/home1.html','','mainFrame');
		/* d.add(11,0,'�û��˳�','${pageContext.request.contextPath}/Home/home1.html','','mainFrame'); */
		
		
		d.add(3,1,'������Ϣ','/PersonnelInquiry/FindPersion','','mainFrame');
		d.add(4,1,'ѧ����Ϣ','/PersonnelInquiry/FindEducation','','mainFrame');
		d.add(5,1,'������Ϣ','/PersonnelInquiry/FindTechnology','','mainFrame');
		d.add(6,1,'ְ����Ϣ','/PersonnelInquiry/FindPosition','','mainFrame');
		d.add(7,1,'ͳ��','/PersonnelInquiry/html/XManager.jsp','','mainFrame');
		d.add(8,2,'�û�����','/PersonnelInquiry/FindUsers','','mainFrame');
		/* d.add(9,11,'�˳�','','','');        */     
		
		document.write(d);   
	/* 	d.s=function(nodeId){ //��ӽڵ����¼�   
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
