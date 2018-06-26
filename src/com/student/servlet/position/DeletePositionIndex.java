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
import com.student.util.OrderUtil;
import com.student.util.Session;
import com.student.util.Util;

public class DeletePositionIndex extends HttpServlet {

	public DeletePositionIndex() {
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
		String[] in = request.getParameterValues("check");
		if(in !=null){
			int index[]=new int [in.length];
			for(int i =0;i<in.length;i++){
				index[i]=Integer.valueOf(in[i]);
			}
			OrderUtil.bubbleSort(index, false);
			System.out.println(index);
			response.setCharacterEncoding("GBK");
			PrintWriter PW = response.getWriter();
			List<Tb_position>list=new ArrayList<Tb_position>();
			//PositionManagerInte pmi=(PositionManagerInte) Util.getBiz("PositionManagerBiz", request);
			Session ss=Util.getSession(request);
			//PositionManagerInte pmi=(PositionManagerInte) ss.getBiz("Tb_position");
			
			for(int x:index){
					boolean b=ss.delete("Tb_position",x);
					if(!b){
						request.getRequestDispatcher("/error.jsp?message=3").forward(request, response);
						return;
					}
			}
			request.getRequestDispatcher("FindPosition").forward(request, response);
			
		}
	}
}
