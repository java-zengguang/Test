package com.jdbc.tools;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class PassValue {
	public static JSONObject objectToJson(Object obj) throws IllegalArgumentException, IllegalAccessException{
	
	
		
			JSONObject jo=new JSONObject();
			Field fields[]=obj.getClass().getFields();
			for(Field f:fields){
			jo.put(f.getName(), f.get(obj));
			if(f.getType()!=String.class && !f.getType().isPrimitive()){
				JSONObject jso=objectToJson(f.get(obj));
				jo.element(f.getName(), jso);
			}
			
				}
			

		return jo;
	}
	
	
	
	
	public static JSONArray objectListToJson(List list) throws IllegalArgumentException, IllegalAccessException{
		JSONArray jsa=new JSONArray();
		for(Object obj:list){
			JSONObject jso=objectToJson(obj);
			jsa.add(jso);
		}
		return jsa;
	}
	
	
}
