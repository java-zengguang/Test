package com.student.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.biz.inter.UsersManagerInte;
import com.student.model.Users;
import com.student.util.OrderUtil;
import com.student.util.Session;
import com.student.util.Util;

public class DeleteUsers extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	public DeleteUsers (){
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String[] in=request.getParameterValues("check");
		if(in!=null){
		int index[]=new int[in.length];
		for(int i=0;i<in.length;i++){
			index[i]=Integer.valueOf(in[i]);
		}
	
		OrderUtil.bubbleSort(index,false);
		System.out.println("index"+index);
		response.setCharacterEncoding("GBK");
		try {
			PrintWriter out=response.getWriter();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Users> list=new ArrayList<Users>();

		Session ss=Util.getSession(request);
	//	UsersManagerInte ui=(UsersManagerInte)ss.getBiz("Users");

		/*if(sm.load()){
			out.println("º”‘ÿÕÍ≥…");
		}*/

			for(int x:index){
				boolean b=ss.delete("Users",x);
				if(!b){
					try {
						request.getRequestDispatcher("/error.jsp?message=3").forward(request,response);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return;
				}
				
			}
			
			
		}
		try {
			request.getRequestDispatcher("FindUsers").forward(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

