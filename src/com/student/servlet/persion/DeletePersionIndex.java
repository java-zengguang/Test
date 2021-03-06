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
import com.student.util.OrderUtil;
import com.student.util.Session;
import com.student.util.Util;

/**
 * Servlet implementation class DeleteIndex
 */
//@WebServlet("/DeleteIndex")
public class DeletePersionIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePersionIndex() {
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
			List<Tb_persion> list=new ArrayList<Tb_persion>();
			//PersionManagerInte sm=(PersionManagerInte) Util.getBiz("PersionManagerBiz",request);
			Session ss=Util.getSession(request);
			//PersionManagerInte sm=(PersionManagerInte) ss.getBiz("Tb_persion");
			
			/*if(sm.load()){
				out.println("�������");
			}*/
			for(int x:index){
				boolean b=ss.delete("Tb_persion",x);
				
				if(!b){
					request.getRequestDispatcher("/error.jsp?message=3").forward(request,response);
					return; 
				}
			}
		}
		request.getRequestDispatcher("FindPersion").forward(request,response);
	}

}
