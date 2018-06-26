package com.student.servlet.persion;











import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.biz.inter.PersionManagerInte;
import com.student.model.Tb_persion;
import com.student.util.Session;
import com.student.util.Util;

/**
 * Servlet implementation class AddStudent
 */
//@WebServlet("/AddStudent")
public class AddPersion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPersion() {
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
	//	PersionManagerInte pmi=(PersionManagerInte) Util.getBiz("PersionManagerBiz",request);
		Session ss=Util.getSession(request);
		//PersionManagerInte pmi=(PersionManagerInte) ss.getBiz("Tb_persion");
		
		
		String teacherNumber[]=request.getParameterValues("teacherNumber");
		String[] name=request.getParameterValues("name");
		String sex[]=request.getParameterValues("sex");
		String birth[]=request.getParameterValues("birth");
		String idCard[]=request.getParameterValues("idCard");
		String nation[]=request.getParameterValues("nation");
		String joinPartyTime[]=request.getParameterValues("joinPartyTime");
		String politicalStatus[]=request.getParameterValues("politicalStatus");
		String nativePlace[]=request.getParameterValues("nativePlace");
		String placeBirth[]=request.getParameterValues("placeBirth");
		String workingHours[]=request.getParameterValues("workingHours");
		String admissionTime[]=request.getParameterValues("admissionTime");
		
		if(teacherNumber==null){
			request.getRequestDispatcher("/error.jsp?message=1").forward(request, response);
			return;	
		}
		
		
		for(int i=0;i<teacherNumber.length;i++){
			boolean b=ss.add("Tb_persion",new Tb_persion(new String(name[i].getBytes("ISO-8859-1"),"GBK"),
					new String(teacherNumber[i].getBytes("ISO-8859-1"),"GBK"),
					new String(idCard[i].getBytes("ISO-8859-1"),"GBK"),
					new String(nation[i].getBytes("ISO-8859-1"),"GBK"),
					new String(sex[i].getBytes("ISO-8859-1"),"GBK"),new String(birth[i].getBytes("ISO-8859-1"),"GBK"),
					new String(joinPartyTime[i].getBytes("ISO-8859-1"),"GBK"),
					new String(nativePlace[i].getBytes("ISO-8859-1"),"GBK"),
					new String(placeBirth[i].getBytes("ISO-8859-1"),"GBK"),
					new String(politicalStatus[i].getBytes("ISO-8859-1"),"GBK"),
					new String(workingHours[i].getBytes("ISO-8859-1"),"GBK"),
					new String(admissionTime[i].getBytes("ISO-8859-1"),"GBK")));
			
			if(!b){
				request.getRequestDispatcher("/error.jsp?message=1").forward(request,response);
				return;
			}
		}
		request.getRequestDispatcher("FindPersion").forward(request,response);
	}


	
	

}
