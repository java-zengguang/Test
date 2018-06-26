package com.jdbc.tools;

import java.lang.reflect.Field;
import java.util.List;




public class Variable {



	
	public static void toField(Field field,Object object,Object value) throws NumberFormatException, IllegalArgumentException, IllegalAccessException{
		
		switch (field.getGenericType().toString()){
		
		case "int":{
			//System.out.println("是int型");
			field.set(object,Integer.valueOf(String.valueOf(value)));
			break;
		}
		case "class java.lang.String":{
			//System.out.println("是string型");
			field.set(object, String.valueOf(value));
			break;
		}
		}	
	
		}
}