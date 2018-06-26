package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.biz.inter.ModelManagerInte;
import com.student.biz.inter.PersionManagerInte;
import com.student.biz.inter.UsersManagerInte;
import com.student.util.Session;
import com.student.util.Util;

/**
 * Servlet implementation class Submit
 */
//@WebServlet("/Submit")
public class Submit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Submit() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String biz=request.getParameter("biz");
		String url=request.getParameter("url");
		Session smi=Util.getSession(request);
		
		if(smi.upLoad()){
			
			
			if(smi.load()){
				System.out.println("重新加载");
			}else{
				System.out.println("重新加载失败");
			}
		}else{
			 request.getRequestDispatcher("/error.jsp?message=4").forward(request, response);
			 return;
		}
		request.getRequestDispatcher("/"+url).forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		
	}

}
