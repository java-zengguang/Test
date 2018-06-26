package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbc.tools.BeanFactory;
import com.student.biz.inter.UsersManagerInte;
import com.student.model.Users;

/**
 * Servlet implementation class Login
 */
//@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		Cookie cookies[]=request.getCookies();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Cookie userCookie=null;
		Cookie passCookie=null;
		if(username==null || password==null){
		if(cookies!=null){
			
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("username"))
				username=cookie.getValue();
			if(cookie.getName().equals("password"))
				 password=cookie.getValue();
		}
		}

		if(username==null || password==null){
			response.sendRedirect("/PersonnelInquiry/login.html");
			return;
			}
		}
		
		UsersManagerInte manager=(UsersManagerInte) BeanFactory.createBean("UsersManagerBiz");
		manager.load();
		List list=manager.find( "userName="+username, "password="+password);
		
		if(list.size()!=0){
			System.out.println("∆•≈‰"+username+"+"+password);
			userCookie=new Cookie("username",username);
			passCookie=new Cookie("password",password);
			if(userCookie!=null && password!=null){
			response.addCookie(userCookie);
			response.addCookie(passCookie);
			}
			HttpSession session=request.getSession();
			Users user=(Users) list.get(0);
			Date d = new Date();
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			user.lastLoginTime=sdf.format(d);
			manager.update(user,  "userName="+username, "password="+password);
			manager.upLoad();
			session.setAttribute("userId", user);
			request.getRequestDispatcher("/checkUserServlet").forward(request, response);
			return;
		}else{
		
			response.sendRedirect("/PersonnelInquiry/login.html");
			//request.getRequestDispatcher("/login.html").forward(request, response);
			return;
		}
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	
	}

}
