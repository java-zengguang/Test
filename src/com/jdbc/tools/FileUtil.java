package com.jdbc.tools;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class FileUtil {
	public static final String PATH;
    static{
	   //获取项目的相对路径
    	String path="";
	  try {
		   path=FileUtil.class.getResource("/").toURI().getPath();
		   System.out.println(path);
	} catch (URISyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  PATH=path;
   }
    
   //读取文件,并把文件信息放入到Properties 容器中
    public static Properties read(String fileName){
    	Properties ps=new Properties();
    	InputStream in=null;
    	try {
    		in=new BufferedInputStream(new FileInputStream(fileName));
    		ps.load(in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
    	return ps;
    	
    }
    
   
   public static Element getRootElement(String fileName) throws DocumentException{
	   SAXReader reader=new SAXReader();
	  Document  doc=reader.read(new File(FileUtil.PATH+fileName));
	 Element root= doc.getRootElement();
	   return root;
   }
   
   
   
	public static List getClassFormPackage(String packageName,boolean isAnnotation,Class annotation) throws ClassNotFoundException{
		List classList=new ArrayList();
		String packagePath=PATH+packageName.replace(".", "/");
		System.out.println(packagePath);
		File packageFile=new File(packagePath);
		File files[]= packageFile.listFiles();
		for(File file: files){
			if(!file.getName().endsWith(".class")){
				continue;
			}
			
			//ClassLoader loader=Object.class.getClassLoader();
		 	String className=packageName+"."+file.getName().substring(0,file.getName().length()-6);
		 	Class c= Class.forName(className);
		 	if( !isAnnotation || !c.isAnnotationPresent(annotation) ){
		 		continue;
		 	}
		 	classList.add(c);
		}
		return classList;
	}
	
   
}
