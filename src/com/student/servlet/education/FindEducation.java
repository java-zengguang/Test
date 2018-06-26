package com.student.servlet.education;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.biz.inter.EducationManagerInte;
import com.student.model.Tb_education;
import com.student.util.Session;
import com.student.util.Util;

/**
 * Servlet implementation class FindStudent
 */
//@WebServlet("/FindStudent")
public class FindEducation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindEducation() {
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
		String terms=request.getParameter("terms");
	
		response.setCharacterEncoding("GBK");
		PrintWriter out=response.getWriter();
		List<Tb_education> list=new ArrayList<Tb_education>();
		Session se=Util.getSession(request);
		//EducationManagerInte sm=(EducationManagerInte) se.getBiz("Tb_education");
	//	sm.load();
		if(terms==null || terms.equals("")){
		System.out.println("查询条件为空");
		 list=se.getData("Tb_education");
		
			 
		/*	 if(list.size()==0){
				 request.getRequestDispatcher("/error.jsp?message=4").forward(request, response);
				 return;
			 
		 }*/
		}
		else{
			terms=new String(terms.getBytes("iso8859-1"),"GB18030");
			System.out.println("terms="+terms);
		String term[]=terms.split(",");
		 list=se.find("Tb_education",term);
		}
	
		request.setAttribute("modelList", list);
		request.getRequestDispatcher("/html/EducationManager.jsp").forward(request, response);
	
		
		
	}

}



