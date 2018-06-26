package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbc.tools.BeanFactory;
import com.student.biz.inter.EducationManagerInte;
import com.student.biz.inter.PersionManagerInte;
import com.student.biz.inter.PositionManagerInte;
import com.student.biz.inter.TechnologyManagerInte;
import com.student.util.Session;
import com.student.util.Util;

public class Home1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Session ss=Util.getSession(request);
		ss.load();
		response.sendRedirect("/PersonnelInquiry/Home/frameset1.html");
	
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	
	}
	
	
	
}
