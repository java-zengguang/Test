package com.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.biz.impl.XManagerImpl;
import com.student.biz.inter.EducationManagerInte;
import com.student.biz.inter.PersionManagerInte;
import com.student.biz.inter.PositionManagerInte;
import com.student.biz.inter.TechnologyManagerInte;
import com.student.biz.inter.UsersManagerInte;
import com.student.biz.inter.XManagerInte;
import com.student.util.Session;
import com.student.util.Util;

/**
 * Servlet implementation class Home3
 */
//@WebServlet("/Home3")
public class Home3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	
	
    /**
     * @see HttpServlet#HttpServlet()     */
    public Home3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");

		
		Session ss=Util.getSession(request);
		ss.load();
		
		response.sendRedirect("/PersonnelInquiry/html/frameset.html");
		//request.getRequestDispatcher("/html/frameset.html").forward(request, response);
		/*PrintWriter out=response.getWriter();
		out.println("hello");*/
	}

}
