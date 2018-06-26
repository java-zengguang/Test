package com.jdbc.tools;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

import org.dom4j.DocumentException;
import org.dom4j.Element;

import com.jdbc.tools.FileUtil;

public class BeanFactory {
	public static Object createBean(String id) {
		Object o=null;
		Element root;
		try {
			root = FileUtil.getRootElement("BeanConfig.xml");
		
		for(Element bean:root.elements("bean")){
			String beanName=bean.attributeValue("id");
			
			if(beanName.equals(id)){
			String beanClassName=bean.attributeValue("class");
			o=Class.forName(beanClassName).newInstance();
			for(Element property:bean.elements("property")){
			String name=property.attributeValue("name");
			Field field=Class.forName(beanClassName).getField(name);
			field.setAccessible(true);
			if(property.attributeValue("type")!=null){
				FieldSet.setField(field, o, property.getStringValue());
			}
			if(property.attributeValue("ref")!=null){
			field.set(o, BeanFactory.createBean(property.attributeValue("ref")));
			}
			}
			}//
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			o=createProxy(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return o;
		
	}

	  
	  public static Object createProxy(Object target) throws NoSuchMethodException, SecurityException, ClassNotFoundException, DocumentException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
	
		  String pName=target.getClass().getPackage().getName();
		  Element root= FileUtil.getRootElement("BeanConfig.xml");
		  for(Element proxy:root.elements("proxy")){
			 String className=proxy.attributeValue("handler");
			 if(pName.equals(proxy.attributeValue("package"))){
				 System.out.println(pName+"±»´úÀí");
				Constructor constructor= Class.forName(className).getConstructor(Object.class,String.class);
				InvocationHandler hand=(InvocationHandler) constructor.newInstance(target, proxy.attributeValue("method"));
				target=Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), hand);
			 }
		  }
		  return target;  
	  }
	
}
