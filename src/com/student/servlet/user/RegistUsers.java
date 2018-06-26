package com.student.servlet.user;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.biz.inter.UsersManagerInte;
import com.student.model.Users;
import com.student.util.Session;
import com.student.util.Util;

public class RegistUsers  extends HttpServlet{
private static final long serialVersionUID = 1L;
public RegistUsers()
{
	super();
	}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	Session ss=Util.getSession(request);
	UsersManagerInte ui=(UsersManagerInte)ss.getBiz("Users");
	
	
	String userName =request.getParameter("userName");
	 String password=request.getParameter("password");
	 String name=request.getParameter("name");
     String loginCount=request.getParameter("loginCount");
	 String lastLoginTime=request.getParameter("lastLoginTime");
	 String email=request.getParameter("email");
	 String Find_qusetion=request.getParameter("Find_question");
	 String Find_answer=request.getParameter("Find_answer");
	 
	 
	 
	 
	 Date d = new Date();
	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	ui.registUser(new Users( userName,password,"1",name,null, sdf.format(d),email,Find_qusetion, Find_answer));
	response.sendRedirect("login.html");
}
}
 