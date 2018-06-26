package com.student.servlet.technology;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.biz.inter.TechnologyManagerInte;
import com.student.model.Tb_technology;
import com.student.util.Session;
import com.student.util.Util;

/**
 * Servlet implementation class AddStudent
 */
//@WebServlet("/AddStudent")
public class AddTechnology extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTechnology() {
        super();
        
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
		//TechnologyManagerInte sm=(TechnologyManagerInte) Util.getBiz("TechnologyManagerBiz",request);
		Session ss=Util.getSession(request);

		//TechnologyManagerInte sm=(TechnologyManagerInte) ss.getBiz("Tb_technology");
		
		
		String  TPQL[]=request.getParameterValues("TPQL");
		String eligibilityTime[]=request.getParameterValues("eligibilityTime");
		String employmentTechnicalPosts[]=request.getParameterValues("employmentTechnicalPosts");
		String[] technicalJobLevel=request.getParameterValues("technicalJobLevel");
		String belongAProfession[]=request.getParameterValues("belongAProfession");
		String belongProfessionTruth[]=request.getParameterValues("belongProfessionTruth");
		String belongProfessionalSchool[]=request.getParameterValues("belongProfessionalSchool");
		String secondaryDiscipline[]=request.getParameterValues("secondaryDiscipline");
		String professionalLeader[]=request.getParameterValues("professionalLeader");
		String cSCSB[]=request.getParameterValues("CSCSB");
		String cCDI[]=request.getParameterValues("CCDI");
		String professionalClassification[]=request.getParameterValues("professionalClassification");
		String TQC[]=request.getParameterValues("TQC");
		String teacherNumber[]=request.getParameterValues("teacherNumber");
		
		if(teacherNumber==null){
			request.getRequestDispatcher("/error.jsp?message=1").forward(request, response);
			return;	
		}
		for(int i=0;i<teacherNumber.length;i++){
			boolean bind=ss.add("Tb_technology",new Tb_technology( 
				new String(TPQL[i].getBytes("ISO-8859-1"),"GBK"),
				new String(eligibilityTime[i].getBytes("ISO-8859-1"),"GBK"),
				new String(employmentTechnicalPosts[i].getBytes("ISO-8859-1"),"GBK"),
				new String(technicalJobLevel[i].getBytes("ISO-8859-1"),"GBK"),
				new String(belongAProfession[i].getBytes("ISO-8859-1"),"GBK"),
				new String(belongProfessionTruth[i].getBytes("ISO-8859-1"),"GBK"),
				new String(belongProfessionalSchool[i].getBytes("ISO-8859-1"),"GBK"),
				new String(secondaryDiscipline[i].getBytes("ISO-8859-1"),"GBK"),
				new String(professionalLeader[i].getBytes("ISO-8859-1"),"GBK"),
				new String(cSCSB[i].getBytes("ISO-8859-1"),"GBK"),
				new String(cCDI[i].getBytes("ISO-8859-1"),"GBK"),
				new String(professionalClassification[i].getBytes("ISO-8859-1"),"GBK"),
				new String(TQC[i].getBytes("ISO-8859-1"),"GBK"),
				new String(teacherNumber[i].getBytes("ISO-8859-1"),"GBK")));
		
			if(!bind){
				request.getRequestDispatcher("/error.jsp?message=1").forward(request, response);
				return;
			}
		}
		request.getRequestDispatcher("FindTechnology").forward(request,response);
	}
	

	

}
