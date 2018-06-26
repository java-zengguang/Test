package com.student.servlet.education;

import java.io.IOException;

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
 * Servlet implementation class AddStudent
 */
//@WebServlet("/AddStudent")
public class AddEducation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEducation() {
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
	//	EducationManagerInte sm=(EducationManagerInte) Util.getBiz("EducationManagerBiz",request);
		
		Session se=Util.getSession(request);
		//EducationManagerInte sm=(EducationManagerInte) se.getBiz("Tb_education");
		//sm.load();
		
		String firstEducation[]=request.getParameterValues("firstEducation");
		String firstDegree[]=request.getParameterValues("firstDegree");
		String[] firstDegreeUniversity=request.getParameterValues("firstDegreeUniversity");
		String firstMajor[]=request.getParameterValues("firstMajor");
		String firstDegreeTime[]=request.getParameterValues("firstDegreeTime");
		String supremeDegree[]=request.getParameterValues("supremeDegree");
		String supremeDegreeUnit[]=request.getParameterValues("supremeDegreeUnit");
		String supremeMajor[]=request.getParameterValues("supremeMajor");
		String supremeMajorTime[]=request.getParameterValues("supremeMajorTime");
		String teacherNumber[]=request.getParameterValues("teacherNumber");
		if(teacherNumber==null){
			request.getRequestDispatcher("/error.jsp?message=1").forward(request, response);
			return;	
		}
		
		
		
		for(int i=0;i<teacherNumber.length;i++){																																																																																																							

			boolean b=se.add("Tb_education",new Tb_education(new String(firstEducation[i].getBytes("ISO-8859-1"),"GBK"), 
				new String(firstDegree[i].getBytes("ISO-8859-1"),"GBK"),
				new String(firstDegreeUniversity[i].getBytes("ISO-8859-1"),"GBK"),  
				new String(firstMajor[i].getBytes("ISO-8859-1"),"GBK"),
				new String(firstDegreeTime[i].getBytes("ISO-8859-1"),"GBK"),
				new String(supremeDegree[i].getBytes("ISO-8859-1"),"GBK"),
				new String(supremeDegreeUnit[i].getBytes("ISO-8859-1"),"GBK"),
				new String(supremeMajor[i].getBytes("ISO-8859-1"),"GBK"),
				new String(supremeMajorTime[i].getBytes("ISO-8859-1"),"GBK"),
				new String(teacherNumber[i].getBytes("ISO-8859-1"),"GBK")));
	

		if(!b){
			request.getRequestDispatcher("/error.jsp?message=1").forward(request,response);
			return;
		}
	}
	request.getRequestDispatcher("FindEducation").forward(request,response);
}


}
