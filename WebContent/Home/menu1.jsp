<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
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
		d.add(2,0,'��Ϣ����','${pageContext.request.contextPath}/Home/home1.html','','mainFrame');
		
		
		d.add(3,2,'������Ϣ','/PersonnelInquiry/FindPersion','','mainFrame');
		d.add(4,2,'ѧ����Ϣ','/PersonnelInquiry/FindEducation','','mainFrame');
		d.add(5,2,'������Ϣ','/PersonnelInquiry/FindTechnology','','mainFrame');
		d.add(6,2,'ְ����Ϣ','/PersonnelInquiry/FindPosition','','mainFrame');
		document.write(d);   
     
		
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>














