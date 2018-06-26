package com.student.servlet.x;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.tools.FieldSet;
import com.jdbc.tools.PassValue;
import com.student.biz.impl.XManagerImpl;
import com.student.biz.inter.UsersManagerInte;
import com.student.biz.inter.XManagerInte;
import com.student.model.Count;
import com.student.util.Session;
import com.student.util.Util;

/**
 * Servlet implementation class Count
 */
@WebServlet("/Count")
public class FindX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindX() {
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
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		Session ss=Util.getSession(request);
		XManagerInte xm=(XManagerInte) ss.getBiz("X");
		List list=new ArrayList();
		String term1=request.getParameter("department");
		String term2=request.getParameter("divisionTeachingOffices");
		String term3=request.getParameter("professionalClassification");
		String terms=null;
		
	
	
	
			if(term1!=null && !term1.equals("")){
				term1=URLDecoder.decode(term1, "GBK");
				System.out.println(term1+"term1");
				terms="tb_po.department="+term1+",";
			}
			if(term2!=null && !term2.equals("")){
				term2=URLDecoder.decode(term2, "GBK");
				terms=terms+"tb_po.divisionTeachingOffices="+term2+",";
			}
		
			if(term3!=null && !term3.equals("")){
				term3=URLDecoder.decode(term3, "GBK");
				terms=terms+"tb_t.professionalClassification="+term3+",";
			}
		
		
		if(terms==null){
			list=xm.getData();  
		}else{
			terms.substring(0, terms.length()-2);
	
		System.out.println("terms="+terms);
		list=xm.find(terms);
		System.out.println("list="+list);
			}
		//(String tn, String dn, String mn, String ftn, String fg,String psn)  politicalStatus
		Count count=new Count(xm.getData().size()+"",xm.find("tb_e.supremeDegree=博士").size()+"",
				xm.find("tb_e.supremeDegree=博士").size()+"",xm.find("tb_po.frontlineTeachers=是").size()+"",
				xm.find("tb_po.aboveSubtropicalHigh=是").size()+"",xm.find("tb_p.politicalStatus=中国共产党员").size()+"");
		
		
		String modelJson=null;
		try {
			 modelJson=PassValue.objectToJson(count).toString();
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(modelJson);
		out.print(modelJson);
		//request.setAttribute("modelJson", modelJson);
		//request.getRequestDispatcher("/html/XManager.jsp").forward(request, response);
	}

}
