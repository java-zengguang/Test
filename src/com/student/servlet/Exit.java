package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Exit extends HttpServlet {

	public Exit() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

                      HttpSession   session=	request.getSession();
                      	session.removeAttribute("userId");
                      	session.invalidate();
                      	System.out.println("Çå³ýsession");
                      	 Cookie killMyCookie = new Cookie("username", null);
                         killMyCookie.setMaxAge(0);
                         killMyCookie.setPath("/PersonnelInquiry");
                         response.addCookie(killMyCookie);
                         Cookie killMyCookie1 = new Cookie("password", null);
                         killMyCookie1.setMaxAge(0);
                         killMyCookie1.setPath("/PersonnelInquiry");
                         response.addCookie(killMyCookie1);
                      	System.out.println("Çå³ýcoolie");
                      	response.sendRedirect("/PersonnelInquiry/login.html");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}


}
