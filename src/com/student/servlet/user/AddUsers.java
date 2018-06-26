package com.student.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.biz.inter.UsersManagerInte;
import com.student.model.Users;
import com.student.util.Session;
import com.student.util.Util;

public class AddUsers extends HttpServlet {
private static final long serialVersionUID = 1L;
public AddUsers(){
	super();
}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//UsersManagerInte ui=(UsersManagerInte)Util.getBiz("UsersManagerBiz", request);
	Session ss=Util.getSession(request);
	//UsersManagerInte ui=(UsersManagerInte)ss.getBiz("Users");
	
	String userName[]=request.getParameterValues("userName");
	 String password[]=request.getParameterValues("password");
	 String power[]=request.getParameterValues("power");
	 String name[]=request.getParameterValues("name");
     String loginCount[]=request.getParameterValues("loginCount");
	 String lastLoginTime[]=request.getParameterValues("lastLoginTime");
	 String email[]=request.getParameterValues("email");
	 
	 if(userName==null){
			request.getRequestDispatcher("/error.jsp?message=1").forward(request, response);
			return;	
		}
	 
	for(int i=0;i<userName.length;i++){
		boolean bind=ss.add("Users",new Users( userName[i],
			password[i],
			power[i],
			name[i],
			loginCount[i],
			lastLoginTime[i],
			email[i],
			null, 
			null));
		
		if(!bind){
			request.getRequestDispatcher("/error.jsp?message=1").forward(request, response);
			return;
		}
	}
}
}