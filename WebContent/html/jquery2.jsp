<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jquery2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="jquery-3.2.1.js"></script>    
    <script type="text/javascript">   
    $(function(){
    //--------------
       document.getElementById("div2").onclick=function(){
              alert("ddddd");
        };
        //jquery 事件绑定
        $("#div3").click(function(){
           alert("0000000000");
        });      
    //-----------------
    $.ajax({
        type:"get",
        url:"getCountry",      
        data:{},
        success:function(result){
        alert(result);
          result= $.parseJSON(result); //dom对象
         //  console.log(typeof result); 
         $(result).each(function(index,element){     
            //alert(element.id);
           // alert(element.name);
            var option= $("<option></option>").text(element.name).val(element.id);  
            $("#country").append(option);
         });                    
        }
    });
      
    
    //--------------------------------
    
    $("#b1").click(    
        function(){
        	
        $.ajax({
              type:"get",
              url:"FindX",
              data:{},
              success:function(result){
                result=$.parseJSON(result);
                 
                
                $(result).each(function(index,element){
                var tr=$("<tr></tr>").text(element.name).val(element.id);
                   $("#table1").append(option);         
                   
                });
                
              
              }
        });       
        
        
        });
    
    
    
    });     
    
    
    
   
   
   
   
   
   
   
   
   </script>
  </head>
  
  
  <body>
     <div onclick="alert('777')">dsd</div> 
     <div id="div2">66666</div> 
     
     <div id="div3">888888</div>       
     <hr/>    
       country: <select id="country">
          <option value="0">---请选择---</option>
      </select>
      <button type="button" id="b1">查询</button>
     <table id="table1">
     
     </table>            
  </body>
</html>
