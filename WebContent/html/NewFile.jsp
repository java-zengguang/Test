<%@ page contentType="text/html; charset=GBK" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>统计表</title>
<style>
#title{
color:#F00;
font-size:28px
}</style>
</head>
    
<body>
 <center>
  <strong> 统计表 </strong>
</center>
   <br />
    <center>
   <form id="form1"  name="form1" method="post" action="" >
所属系部<select name="department"></select>&nbsp;&nbsp;&nbsp;&nbsp;


教研室<select name="staff"></select>&nbsp;&nbsp;&nbsp;


专业方向<select name=" Professional">
</select>

  &nbsp;&nbsp;<input type="submit" name="select" id="select" value="查询" />
</form>
</center>
<br />
<br />
<br />
<table width="752" border="1" align="center">
  <tr>
    <td width="135">教职工总人数</td>
    <td width="135">博士学历人数</td>
    <td width="115">硕士学历人数</td>
    <td width="120">一线教师人数</td>
    <td width="114">副高以上人数</td>
    <td width="93">党员人数</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>



</body>
</html>