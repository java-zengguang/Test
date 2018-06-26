package com.jdbc.tools;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FieldSet {
	//为类的公共属性赋值
	public static void setField(Field field,Object object,String value) throws IllegalArgumentException, IllegalAccessException{
		String fieldType=field.getType().getSimpleName();
	
		switch(fieldType){
		case "int" :{
			field.set(object, Integer.valueOf(value));
			break;
		}
		case "String" :{
			field.set(object, value);
			break;
		}
		
		}
	}
	
	
	public static String getField(Field field,Object object) throws IllegalArgumentException, IllegalAccessException{
		String value=null;
		String fieldType=field.getType().getSimpleName();
	
		switch(fieldType){
		case "int" :{
			value=String.valueOf(field.get(object));
			break;
		}
		case "String" :{
			
			value="'"+String.valueOf(field.get(object))+"'";
			
			break;
		}
		
		}
	
		return value;
	}
	
	
	public static Object translateNull(Object o) throws IllegalArgumentException, IllegalAccessException{
		Field fields[]=o.getClass().getFields();
		for(Field field:fields){
			if(String.valueOf(field.get(o)).equals("null"))
			field.set(o, "");
		}
		
		return o;
	}
	
	public static Object Nulltranslate(Object o) throws IllegalArgumentException, IllegalAccessException{
		Field fields[]=o.getClass().getFields();
		for(Field field:fields){
			if(String.valueOf(field.get(o)).equals(""))
			field.set(o, "null");
		}
		
		return o;
	}
	
	
	public static String getFieldOrcale(Field field,Object object) throws IllegalArgumentException, IllegalAccessException{
		String value=null;
		String fieldType=field.getType().getSimpleName();
	
		switch(fieldType){
		case "int" :{
			value=String.valueOf(field.get(object));
			break;
		}
		case "String" :{
			if(field.get(object)==null || field.get(object).equals("")){
				value="'null'";
			}else{
			value="'"+String.valueOf(field.get(object))+"'";
			}
			break;
		}
		
		}
	
		return value;
	}
	
	
	
	public static String dataTranslateJava(String s){
		switch(s){
		case "VARCHAR2":
			s="String";
			break;
		
		case "NUMBER":
			s="int";
			break;
		default:
			s=s.toLowerCase();
			break;
	}
	
		return s;
	}
	/*根据terms来比较object
	 * 返回0时两个相等
	 * terms是传入的比较规则
	 * */
/*	public static int toCompare(Object o1,Object o2,String... terms) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		int fruit=0;
		for(String term:terms){
		Field field=o1.getClass().getField(term);
		Class type= field.getType();


		if(type==int.class ){
			fruit=field.getInt(o1)-field.getInt(o2);
			if(fruit!=0){
				return fruit;
			}	
		}
		if(type==String.class){
			 String s1=(String) field.get(o1);
			 String s2=(String) field.get(o2);
			 fruit=s1.length()-s2.length();
			 if(fruit!=0){
				 return fruit;
			 }
			 fruit=((String)field.get(o1)).compareTo((String)field.get(o2));
			if(fruit!=0){
				return fruit;
			}
			
		}
		
		}
		return fruit;
	}*/
	
	
	public static int toCompare(Object o1,Object o2,String... terms) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		int fruit=0;
		for(String term:terms){
	
		if(term.contains(".")){
			
			String s[]=term.split("\\.");
		
			Field f=o1.getClass().getField(s[0].trim());
			fruit=toCompare(f.get(o1),f.get(o2),s[1]);
			if(fruit!=0){
				return fruit;
			}
		}else{
			
		Field field=o1.getClass().getField(term);
		Class type= field.getType();


		if(type==int.class ){
			fruit=field.getInt(o1)-field.getInt(o2);
			if(fruit!=0){
				return fruit;
			}	
		}
		if(type==String.class){
			 String s1=(String) field.get(o1);
			 String s2=(String) field.get(o2);
			 fruit=s1.length()-s2.length();
			 if(fruit!=0){
				 return fruit;
			 }
		
			 fruit=((String)field.get(o1)).compareTo((String)field.get(o2));
			if(fruit!=0){
				return fruit;
			}
			
		}
		
		}
		
		}
		return fruit;
	}
	
	/*
	 * 比较两个object对象中的数据是否相同
	 * */
	/*public static int toCompare(Object o1,Object o2) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
	
		if(!o1.getClass().equals(o2.getClass())){
			return -1;
		}
		int fruit=0;
		for(Field field:o1.getClass().getFields()){
		Class type= field.getType();

		if(type==int.class ){
			
			fruit=field.getInt(o1)-field.getInt(o2);
			if(fruit!=0){
				return fruit;
			}	
		}
		if(type==String.class){
			 String s1=(String) field.get(o1);
			 String s2=(String) field.get(o2);
			 if(s1==null){
				 if(s2==null){
					 return 0;
				 }else{
					 return 1;
				 }
			 }
			 if(s2==null){
				 if(s1==null){
					 return 0;
				 }else{
					 return -1;
				 }
			 }
			 
			 fruit=s1.length()-s2.length();
			 if(fruit!=0){
				 return fruit;
			 }
			 fruit=((String)field.get(o1)).compareTo((String)field.get(o2));
			if(fruit!=0){
				return fruit;
			}
			
		}
		
		}
		return fruit;
	}
*/
	
	
	
	public static int toCompare(Object o1,Object o2) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		
		if(!o1.getClass().equals(o2.getClass())){
			return -1;
		}
		int fruit=0;
		for(Field field:o1.getClass().getFields()){
		Class type= field.getType();
		
		if(!type.isPrimitive() && type!=String.class){
			fruit=toCompare(field.get(o1),field.get(o2));
			if(fruit!=0){
				return fruit;
			}
			
		}else{
		
		if(type==int.class ){
			
			fruit=field.getInt(o1)-field.getInt(o2);
			if(fruit!=0){
				return fruit;
			}	
		}
		if(type==String.class){
			 String s1=(String) field.get(o1);
			 String s2=(String) field.get(o2);
			 if(s1==null){
				 if(s2==null){
					 return 0;
				 }else{
					 return 1;
				 }
			 }
			 if(s2==null){
				 if(s1==null){
					 return 0;
				 }else{
					 return -1;
				 }
			 }
			 
			 fruit=s1.length()-s2.length();
			 if(fruit!=0){
				 return fruit;
			 }
			 fruit=((String)field.get(o1)).compareTo((String)field.get(o2));
			if(fruit!=0){
				return fruit;
			}
			
		}
		}
		}
		return fruit;
	}
	
	
	/*
	 * 这个方法用来比较object和map格式化的object中的数据
	 * 参数object,map<String name,Object value>
	 * 返回int
	 * */
/*	public static int toCompare(Object o1,Map termMap) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		int fruit=0;
		Set<String> terms=termMap.keySet();
		for(String term:terms){
		Field field=o1.getClass().getField(term);
		Class type= field.getType();


		if(type==int.class ){
			fruit=field.getInt(o1)-Integer.valueOf( (String) termMap.get(term));
			if(fruit!=0){
				return fruit;
			}	
		}
		if(type==String.class){
			 String s1=(String) field.get(o1);
			 String s2=(String) termMap.get(term);
			 fruit=s1.length()-s2.length();
			 if(fruit!=0){
				 return fruit;
			 }
			 fruit=((String)field.get(o1)).compareTo((String) termMap.get(term));
			if(fruit!=0){
				return fruit;
			}
			
		}
		
		}
		return fruit;
	}*/
	
	
	public static int toCompare(Object o1,Map termMap) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		int fruit=0;
		Set<String> terms=termMap.keySet();
		for(String term:terms){
		
			if(term.contains(".")){
				
				String s[]=term.split("\\.");
				Field f=o1.getClass().getField(s[0].trim());
				Map map=new HashMap();
				map.put(s[1], termMap.get(term));
				fruit=toCompare(f.get(o1),map);
				if(fruit!=0){
					return fruit;
				}
			}else{
			
			
		Field field=o1.getClass().getField(term);
		Class type= field.getType();
		

		if(type==int.class ){
			fruit=field.getInt(o1)-Integer.valueOf( (String) termMap.get(term));
			if(fruit!=0){
				return fruit;
			}	
		}
		if(type==String.class){
			 String s1=(String) field.get(o1);
			 String s2=(String) termMap.get(term);
			 fruit=s1.length()-s2.length();
			 if(fruit!=0){
				 return fruit;
			 }
			 fruit=((String)field.get(o1)).compareTo((String) termMap.get(term));
			if(fruit!=0){
				return fruit;
			}
			
		}
			}
		}
		return fruit;
	}
	
	
	
	
	/*判断object是否在集合中
	 * 在则返回true*/
	public static boolean contains(Object object,Collection objectC) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		for(Object o:objectC){
			if(toCompare(object,o)==0)
				return true;
		}
		return false;
	}
	
}
