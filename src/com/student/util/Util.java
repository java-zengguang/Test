package com.student.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Util {
	private static final ThreadLocal tl=new ThreadLocal();
	private static Map<HttpSession,Map> map=new HashMap<HttpSession,Map>();
	private static Map<HttpSession,Session> sessionMap=new HashMap<HttpSession,Session>();
	
/*	public static Object getBiz(String bizName,HttpServletRequest request){
		HttpSession session=request.getSession();
		Object o=null;
		Set keySet=map.keySet();
		System.out.println(session);
		if(keySet.contains(session) ){
			if( map.get(session).get(bizName)!=null){
				o=map.get(session).get(bizName);	
				}else{
					o=BeanFactory.createBean(bizName);
					map.get(session).put(bizName, o);
		}
		
	}else{
		o=BeanFactory.createBean(bizName);
		Map<String,Object> m=new HashMap<String,Object>();
		m.put(bizName, o);
		map.put(session, m);
		}
		System.out.println(o);
	return o;
	}*/
	
	
	public static Session getSession(HttpServletRequest request){
		HttpSession session=request.getSession();
		Set keySet=sessionMap.keySet();
		if(keySet.contains(session) &&  sessionMap.get(session)!=null){
			return sessionMap.get(session);
		}else{
			Session s=new Session();
			sessionMap.put(session, s);
			return getSession(request);
		}
		
	}
	
	

}
