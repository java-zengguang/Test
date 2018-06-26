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
import com.student.util.OrderUtil;
import com.student.util.Session;
import com.student.util.Util;

/**
 * Servlet implementation class DeleteIndex
 */
//@WebServlet("/DeleteIndex")
public class DeleteEducationIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEducationIndex() {
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
		String[] in=request.getParameterValues("check");
		if(in!=null){
			
		
		int index[]=new int[in.length];
		for(int i=0;i<in.length;i++){
			index[i]=Integer.valueOf(in[i]);
		}
		OrderUtil.bubbleSort(index,false);
	
		System.out.println(index);
		response.setCharacterEncoding("GBK");
		PrintWriter out=response.getWriter();
		List<Tb_education> list=new ArrayList<Tb_education>();
		Session se=Util.getSession(request);
	//	EducationManagerInte sm=(EducationManagerInte) se.getBiz("Tb_education");
		//EducationManagerInte sm=(EducationManagerInte) Util.getBiz("EducationManagerBiz",request);
		/*if(sm.load()){
			out.println("º”‘ÿÕÍ≥…");
		}*/
		for(int x:index){
			boolean b=se.delete("Tb_education",x);
			if(!b){
				request.getRequestDispatcher("/error.jsp?message=3").forward(request, response);
				return;
			}
		}
		}
		request.getRequestDispatcher("FindEducation").forward(request,response);
	}

}
