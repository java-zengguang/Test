package com.student.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.biz.inter.UsersManagerInte;
import com.student.model.Users;
import com.student.util.Session;
import com.student.util.Util;

/**
 * Servlet implementation class SimpleFind
 */
//@WebServlet("/SimpleFind")
public class SimpleFindUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleFindUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("GBK");
		
		PrintWriter out=response.getWriter();
		List<Users> list=new ArrayList<Users>();
		Session ss=Util.getSession(request);
		//UsersManagerInte ui=(UsersManagerInte)ss.getBiz("Users");
		
		
		List t=new ArrayList();
		if(request.getParameter("userName")!=null && !((String)request.getParameter("userName")).equals("")){
		t.add("userName="+request.getParameter("userName").trim());}
		
		if(request.getParameter("power")!=null && !((String)request.getParameter("power")).equals("") ){
		t.add("power="+request.getParameter("power").trim());}
		if(request.getParameter("name")!=null && !((String)request.getParameter("name")).equals("")){
		t.add("name="+request.getParameter("name").trim());}
		String terms[]=new String[t.size()];
		for(int i=0;i<t.size();i++){
			terms[i]=(String) t.get(i);	
		}
		list=ss.find("Users",terms);
		/*if(list.size()==0){
			 request.getRequestDispatcher("/error.jsp?message=4").forward(request, response);
			 return;
		 }*/
		
		request.setAttribute("modelList", list);
		//response.sendRedirect("/html/StudentManager.jsp");
		request.getRequestDispatcher("/html/UsersManager.jsp").forward(request, response);
	
		
	}

}
