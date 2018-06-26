package com.student.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		String request_uri = ((HttpServletRequest) request).getRequestURI(); 
		String ctx_path = ((HttpServletRequest) request).getContextPath(); 
		if ((request_uri.substring(ctx_path.length())).equals( "/login.html")  || request_uri.substring(ctx_path.length()).equals( "/html/RegistUsers.jsp") ||request_uri.substring(ctx_path.length()).equals( "/RegistUsers") )
		{ 	
			chain.doFilter(request, response); 
			return;
		}else{
		
		HttpSession session=( (HttpServletRequest) request).getSession();
		Object username= session.getAttribute("userId");
		
	
		if(username==null){
			System.out.println("非法用户");
			request.getRequestDispatcher("/Login").forward(request, response);
			return;
		}else{
		chain.doFilter(request, response);
	}
		}
	}
	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
