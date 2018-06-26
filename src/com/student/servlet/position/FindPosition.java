package com.student.servlet.position;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class FindStudent
 */
//@WebServlet("/FindStudent")
public class FindPosition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPosition() {
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
		List<Tb_position> list=new ArrayList<Tb_position>();
	//	PositionManagerInte pmi=(PositionManagerInte) Util.getBiz("PositionManagerBiz",request);
		Session ss=Util.getSession(request);
		//PositionManagerInte pmi=(PositionManagerInte) ss.getBiz("Tb_position");
		//pmi.load();
		
	
		if(terms==null || terms.equals("")){
		System.out.println("查询条件为空");
		 list=ss.getData("Tb_position");
		
			 
		/*	 if(list.size()==0){
				 request.getRequestDispatcher("/error.jsp?message=4").forward(request, response);
				 return;
			 
		 }*/
		}
		else{
			terms=new String(terms.getBytes("iso8859-1"),"GB18030");
			System.out.println("terms="+terms);
		String term[]=terms.split(",");
		 list=ss.find("Tb_position",term);
		}
	
		request.setAttribute("modelList", list);
		request.getRequestDispatcher("/html/PositionManager.jsp").forward(request, response);
		
		
		
	}

}


//response.sendRedirect("StudentManager.jsp");

/*out.println("<tr><td>学号</td><td>性别</td><td>姓名</td><td>年龄</td><td>班级</td><td>Email</td><td>手机</td></tr>");
for(Student s:list){
out.println("<tr><td>"+s.id+"</td><td>"+s.id+"</td><td>"+s.name+"</td><td>"+s.age+"</td><td>"+s.clubName+"</td><td>"+s.email+"</td><td>"+s.telNumber+"</td></tr>");
}

out.println("</table>");*/
