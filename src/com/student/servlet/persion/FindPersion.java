package com.student.servlet.persion;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.tools.BeanFactory;
import com.jdbc.tools.FieldSet;
import com.jdbc.tools.FileCtrl;
import com.student.biz.inter.PersionManagerInte;
import com.student.model.Tb_persion;
import com.student.model.Users;
import com.student.util.Session;
import com.student.util.Util;

/**
 * Servlet implementation class FindStudent
 */
//@WebServlet("/FindStudent")
public class FindPersion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPersion() {
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
		List<Tb_persion> list=new ArrayList<Tb_persion>();
		//PersionManagerInte sm=(PersionManagerInte) Util.getBiz("PersionManagerBiz",request);
		Session ss=Util.getSession(request);
	//	PersionManagerInte sm=(PersionManagerInte) ss.getBiz("Tb_persion");
	//	sm.load();
	
		if(terms==null || terms.equals("")){
		System.out.println("查询条件为空");
				list=ss.getData("Tb_persion");
			
				/* if(list.size()==0){
					 request.getRequestDispatcher("/error.jsp?message=4").forward(request, response);
					 return;
				 }*/
				
			 
		}
		else{
			terms=new String(terms.getBytes("iso8859-1"),"GB18030");
			System.out.println("terms="+terms);
			String term[]=terms.split(",");
			list=ss.find("Tb_persion",term);
			
			
		}
	
		request.setAttribute("modelList", list);
		request.getRequestDispatcher("/html/PersionManager.jsp").forward(request, response);
		
	}
}



