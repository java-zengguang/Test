package com.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.student.biz.inter.UsersManagerInte;
import com.student.model.Users;
import com.student.util.Session;
import com.student.util.Util;

public class checkUserServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			HttpSession session=request.getSession();
			String userId=((Users) session.getAttribute("userId")).userName;
			Session ss=Util.getSession(request);
			UsersManagerInte umi=(UsersManagerInte)ss.getBiz("Users");
			
			umi.load();
			System.out.println("userId"+userId);
			List <Users>list=umi.find("userName="+userId.trim());
			String power=null;
			if(list.size()>0){
				power=list.get(0).power;
				System.out.println("power:"+power);
				switch (power){
					case "1":{
					//普通用户
						request.getRequestDispatcher("/Home1").forward(request, response);
						break;
					}
					
					case "2":{
					//系部管理员
						request.getRequestDispatcher("/Home2").forward(request, response);
						break;
					}
					
					case "3":{
					//管理员	
						request.getRequestDispatcher("/Home3").forward(request, response);
						
						break;
					}
				
				
				
				}
			
			}else{
				System.out.println("错误");
			}
			
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	
	}

}
