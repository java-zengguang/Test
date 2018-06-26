package com.student.servlet.technology;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.biz.inter.TechnologyManagerInte;
import com.student.model.Tb_technology;
import com.student.util.Session;
import com.student.util.Util;

/**
 * Servlet implementation class SimpleFind
 */
//@WebServlet("/SimpleFind")
public class SimpleFindTechnology extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleFindTechnology() {
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
		List<Tb_technology> list=new ArrayList<Tb_technology>();
		//TechnologyManagerInte sm=(TechnologyManagerInte) Util.getBiz("TechnologyManagerBiz",request);
		Session ss=Util.getSession(request);

		//TechnologyManagerInte sm=(TechnologyManagerInte) ss.getBiz("Tb_technology");
		
		
		List t=new ArrayList();
		if(request.getParameter("teacherNumber")!=null && !((String)request.getParameter("teacherNumber")).equals("")){
		t.add("teacherNumber="+request.getParameter("teacherNumber").trim());}
		
		if(request.getParameter("belongAProfession")!=null && !((String)request.getParameter("belongAProfession")).equals("") ){
		t.add("belongAProfession="+request.getParameter("belongAProfession").trim());}
		if(request.getParameter("secondaryDiscipline")!=null && !((String)request.getParameter("secondaryDiscipline")).equals("")){
		t.add("secondaryDiscipline="+request.getParameter("secondaryDiscipline").trim());}
		String terms[]=new String[t.size()];
		for(int i=0;i<t.size();i++){
			terms[i]=(String) t.get(i);	
		}
		list=ss.find("Tb_technology",terms);
		
		/* if(list.size()==0){
			 request.getRequestDispatcher("/error.jsp?message=4").forward(request, response);
			 return;
		 }*/
		
		request.setAttribute("modelList", list);
		//response.sendRedirect("/html/StudentManager.jsp");
		request.getRequestDispatcher("/html/TechnologyManager.jsp").forward(request, response);
	
		
	}

}
