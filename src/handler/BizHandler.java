package handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.tools.JdbcUtil;



public class BizHandler implements InvocationHandler{
	private Object target;
	private List methodList=new ArrayList();
	
	public BizHandler(Object target,String method){
		this.target=target;
		for(String m:method.split(",")){
		methodList.add(m);
	}
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Method m1=target.getClass().getMethod("submit");
		//Method m2=target.getClass().getMethod("release");
		//Connection conn=JdbcUtil.getConnectPool();
		if(methodList.contains(method.getName())){
			
			
		
			Object x=method.invoke(target, args);
			System.out.println(method.getName()+"            :commit");
			m1.invoke(target);
		//	m2.invoke(target);
			return x;
		}else {
	
			Object result=  method.invoke(target, args);
			System.out.println(method.getName()+"            £ºno commit");
		//	m2.invoke(target);
			return result;
		}
		
	}

}
