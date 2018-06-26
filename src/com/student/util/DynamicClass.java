package com.student.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.io.StringReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject.Kind;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;


public class DynamicClass {


	
	private static String produceEntityJavaCode(List<String> referenceList,String calssName,List<Map<String,String>> natureList,List<String> interfaceList,String parentClass) throws Exception{
		
		StringBuffer sb=new StringBuffer();
		if(calssName==null || natureList.size()==0  ){
			throw new Exception();
		}else{
			
		
			for(String reference:referenceList){
				sb.append("import "+reference+";\r\n");
			}
			sb.append("public class ");
			sb.append(calssName);
			if(parentClass!=null)
				 sb.append(" extends "+parentClass);
			if(interfaceList.size()>0)
				sb.append(" implements ");
			for(String inter:interfaceList){
				sb.append(inter+" ");
			}
			sb.append("{\r\n");
			for(Map natureMap:natureList){
			sb.append("public "+natureMap.get("Type")+" "+natureMap.get("Name")+";\r\n");	
			}
			sb.append("}");
		}
		System.out.println(sb);
		
		return sb.toString();
	}
	
	
	
	//生成对象
	public static Object getDynamicClass(List<String> referenceList,String className,List<Map<String,String>> natureList,List<String> interfaceList,String parentClass){
		String javaCode;
		try {
			javaCode = produceEntityJavaCode( referenceList, className,natureList, interfaceList, parentClass);
			  return getDynamicClass(className,javaCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		return null;
		}
	  
	}
	
	
	private static Object getDynamicClass(String name,String javaCode) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Object o=null;
		Map<String, byte[]> results;
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		JavaFileManager stdManager = compiler.getStandardFileManager(null, null, null);
		JavaFileObject jfo=new StringJavaFileObject(name,javaCode);
		List<String> options=new ArrayList<String>();
		options.addAll(Arrays.asList("-d","./bin"));
		
		List<? extends JavaFileObject> jfos=Arrays.asList(jfo);
		JavaCompiler.CompilationTask task=compiler.getTask(null, stdManager, null, options, null, jfos);
		if(task.call()){
			o=Class.forName(name).newInstance();
			return o;
		}else{
			return null;
		}
		
		
		}
	
}



class StringJavaFileObject extends SimpleJavaFileObject{
	private String content=null;
	protected StringJavaFileObject(String name, String javaCode) {
		super(StringJavaFileObject.createURI(name), Kind.SOURCE);
		content=javaCode;
	}
	
	private static URI createURI(String name){
		URI uri=URI.create("String:///"+name+Kind.SOURCE.extension);
		return uri;
	}
	
	public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException{
		return content;
	}
}
