package com.student.servlet.persion;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.biz.inter.PersionManagerInte;
import com.student.model.Tb_persion;
import com.student.util.Session;
import com.student.util.Util;

/**
 * Servlet implementation class SimpleFind
 */
//@WebServlet("/SimpleFind")
public class SimpleFindPersion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleFindPersion() {
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
		List<Tb_persion> list=new ArrayList<Tb_persion>();
		
		//PersionManagerInte sm=(PersionManagerInte) Util.getBiz("PersionManagerBiz",request);
		Session ss=Util.getSession(request);
		//PersionManagerInte sm=(PersionManagerInte) ss.getBiz("Tb_persion");
		
		
		List t=new ArrayList();
		if(request.getParameter("teacherNumber")!=null && !((String)request.getParameter("teacherNumber")).equals("")){
		t.add("teacherNumber="+request.getParameter("teacherNumber").trim());}
		
		if(request.getParameter("idCard")!=null && !((String)request.getParameter("idCard")).equals("") ){
		t.add("idCard="+request.getParameter("idCard").trim());}
		if(request.getParameter("name")!=null && !((String)request.getParameter("name")).equals("")){
		t.add("name="+request.getParameter("name").trim());}
		String terms[]=new String[t.size()];
		for(int i=0;i<t.size();i++){
			terms[i]=(String) t.get(i);	
		}
		list=ss.find("Tb_persion",terms);
		/*if(list.size()==0){
			 request.getRequestDispatcher("/error.jsp?message=4").forward(request, response);
			 return;
		 }*/
		
		request.setAttribute("modelList", list);
		//response.sendRedirect("/html/StudentManager.jsp");
		request.getRequestDispatcher("/html/PersionManager.jsp").forward(request, response);
	
		
	}

}
