package com.student.servlet.education;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.biz.inter.EducationManagerInte;
import com.student.model.Tb_education;
import com.student.util.Session;
import com.student.util.Util;

/**
 * Servlet implementation class SimpleFind
 */
//@WebServlet("/SimpleFind")
public class SimpleFindEducation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleFindEducation() {
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
		List<Tb_education> list=new ArrayList<Tb_education>();
		Session se=Util.getSession(request);
		//EducationManagerInte sm=(EducationManagerInte) se.getBiz("Tb_education");
	
		List t=new ArrayList();
		if(request.getParameter("teacherNumber")!=null && !((String)request.getParameter("teacherNumber")).equals("")){
		t.add("teacherNumber="+request.getParameter("teacherNumber").trim());}
		
		if(request.getParameter("firstEducation")!=null && !((String)request.getParameter("firstEducation")).equals("") ){
		t.add("firstEducation="+request.getParameter("firstEducation").trim());}
		if(request.getParameter("supremeDegree")!=null && !((String)request.getParameter("supremeDegree")).equals("")){
		t.add("supremeDegree="+request.getParameter("supremeDegree").trim());}
		String terms[]=new String[t.size()];
		for(int i=0;i<t.size();i++){
			terms[i]=(String) t.get(i);	
		}
		list=se.find("Tb_education",terms);
		
		/* if(list.size()==0){
			 request.getRequestDispatcher("/error.jsp?message=4").forward(request, response);
			 return;
		 }*/
		
		request.setAttribute("modelList", list);
		//response.sendRedirect("/html/StudentManager.jsp");
		request.getRequestDispatcher("/html/EducationManager.jsp").forward(request, response);
	
		
	}

}
