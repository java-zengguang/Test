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

public class SimpleFindPosition extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SimpleFindPosition() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		
		PrintWriter out=response.getWriter();
		List<Tb_position> list=new ArrayList<Tb_position>();
		//PositionManagerInte sm=(PositionManagerInte) Util.getBiz("PositionManagerBiz",request);
		Session ss=Util.getSession(request);
		//PositionManagerInte sm=(PositionManagerInte) ss.getBiz("Tb_position");
		
		List t=new ArrayList();
		if(request.getParameter("teacherNumber")!=null && !((String)request.getParameter("teacherNumber")).equals("")){
		t.add("teacherNumber="+request.getParameter("teacherNumber").trim());}
		
		if(request.getParameter("department")!=null && !((String)request.getParameter("department")).equals("") ){
		t.add("department="+request.getParameter("department").trim());}
		if(request.getParameter("post")!=null && !((String)request.getParameter("post")).equals("")){
		t.add("post="+request.getParameter("post").trim());}
		String terms[]=new String[t.size()];
		for(int i=0;i<t.size();i++){
			terms[i]=(String) t.get(i);	
		}
		list=ss.find("Tb_position",terms);
		
		/* if(list.size()==0){
			 request.getRequestDispatcher("/error.jsp?message=4").forward(request, response);
			 return;
		 }*/
		 
		
		request.setAttribute("modelList", list);
		//response.sendRedirect("/html/StudentManager.jsp");
		request.getRequestDispatcher("/html/PositionManager.jsp").forward(request, response);
	}
}
