package com.student.servlet.position;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.biz.inter.PositionManagerInte;
import com.student.model.Tb_position;
import com.student.util.Session;
import com.student.util.Util;

public class AddPosition extends HttpServlet {
	private static final long serialVersionUID=1L;

	public AddPosition() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//PositionManagerInte pmi=(PositionManagerInte) Util.getBiz("PositionManagerBiz", request);
		Session ss=Util.getSession(request);
		
		
		//PositionManagerInte pmi=(PositionManagerInte) ss.getBiz("Tb_position");
		
		
		String department[]=request.getParameterValues("department");
		String[] threeLevelInstitution=request.getParameterValues("threeLevelInstitution");
		String postNature[]=request.getParameterValues("postNature");
		String postGrade[]=request.getParameterValues("postGrade");
		String appointmentCurrentTime[]=request.getParameterValues("appointmentCurrentTime");
		String appointmentTime[]=request.getParameterValues("appointmentTime");
		String aboveMiddleLevel[]=request.getParameterValues("aboveMiddleLevel");
		String aboveSubtropicalHigh[]=request.getParameterValues("aboveSubtropicalHigh");
		String frontlineTeachers[]=request.getParameterValues("frontlineTeachers");
		String status[]=request.getParameterValues("status");
		String post[]=request.getParameterValues("post");
		String fullTimeTeacher[]=request.getParameterValues("fullTimeTeacher");
		String divisionSystem[]=request.getParameterValues("divisionSystem");
		String divisionTeachingOffices[]=request.getParameterValues("divisionTeachingOffices");
		String wageExecutionSeries[]=request.getParameterValues("wageExecutionSeries");
		String allowanceRate[]=request.getParameterValues("allowanceRate");
		String administrativeLevelTime[]=request.getParameterValues("administrativeLevelTime");
		String teacherNumber[]=request.getParameterValues("teacherNumber");
		System.out.println("Ìí¼Ó");
		if(teacherNumber==null){
			request.getRequestDispatcher("/error.jsp?message=1").forward(request, response);
			return;	
		}
		for(int i=0;i<teacherNumber.length;i++){
			
			boolean bind= ss.add("Tb_position",new Tb_position(new String(department[i].getBytes("ISO-8859-1"),"GBK"),
					new String(threeLevelInstitution[i].getBytes("ISO-8859-1"),"GBK"),
					new String(postNature[i].getBytes("ISO-8859-1"),"GBK"),
					new String(postGrade[i].getBytes("ISO-8859-1"),"GBK"),
					new String(appointmentCurrentTime[i].getBytes("ISO-8859-1"),"GBK"),
					new String(appointmentTime[i].getBytes("ISO-8859-1"),"GBK"),
					new String(aboveMiddleLevel[i].getBytes("ISO-8859-1"),"GBK"),
					new String(aboveSubtropicalHigh[i].getBytes("ISO-8859-1"),"GBK"),
					new String(frontlineTeachers[i].getBytes("ISO-8859-1"),"GBK"),
					new String(status[i].getBytes("ISO-8859-1"),"GBK"),
					new String(post[i].getBytes("ISO-8859-1"),"GBK"),
					new String(fullTimeTeacher[i].getBytes("ISO-8859-1"),"GBK"),
					new String(divisionSystem[i].getBytes("ISO-8859-1"),"GBK"),
					new String(divisionTeachingOffices[i].getBytes("ISO-8859-1"),"GBK"),	
					new String(wageExecutionSeries[i].getBytes("ISO-8859-1"),"GBK"),
					new String(allowanceRate[i].getBytes("ISO-8859-1"),"GBK"),
					new String(administrativeLevelTime[i].getBytes("ISO-8859-1"),"GBK"),
					new String(teacherNumber[i].getBytes("ISO-8859-1"),"GBK")));
			if(!bind){
				request.getRequestDispatcher("/error.jsp?message=1").forward(request, response);
				return;
			}
		}
	
		request.getRequestDispatcher("FindPosition").forward(request, response);
	}
}
