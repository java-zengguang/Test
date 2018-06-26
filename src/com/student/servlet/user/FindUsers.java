package com.student.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.biz.inter.UsersManagerInte;
import com.student.model.Tb_technology;
import com.student.model.Users;
import com.student.util.Session;
import com.student.util.Util;

public class FindUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public FindUsers(){
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String terms=request.getParameter("terms");
	
		response.setCharacterEncoding("GBK");
		PrintWriter out=response.getWriter();
		List<Users> list=new ArrayList<Users>();

		Session ss=Util.getSession(request);
		//UsersManagerInte ui=(UsersManagerInte)ss.getBiz("Users");
		//ui.load();
	
		if(terms==null || terms.equals("")){
		System.out.println("查询条件为空");
		 list=ss.getData("Users");
		
			 
			 
		/*	 if(list.size()==0){
				 request.getRequestDispatcher("/error.jsp?message=4").forward(request, response);
				 return;
			 
			 
		 }*/
		}
		else{
			terms=new String(terms.getBytes("iso8859-1"),"GB18030");
			System.out.println("terms="+terms);
		String term[]=terms.split(",");
		 list=ss.find("Users",term);
		}
		request.setAttribute("modelList", list);
		request.getRequestDispatcher("/html/UsersManager.jsp").forward(request, response);
	}

}