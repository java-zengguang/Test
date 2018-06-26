package com.jdbc.tools;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.student.model.MainModel;



public class FromSql {
	
	//private static Model models;
	private static List<String> member_list=new ArrayList<String>();
	private static List values_list=new ArrayList();
	
	public static void fillSql(Object models) throws IllegalArgumentException, IllegalAccessException{
		member_list.clear();
		values_list.clear();
		Field fields[]=models.getClass().getFields();
		
		
		for(Field f : fields){
		String name=(String)f.getName();

		member_list.add(name);
	
		f.setAccessible(true);
		values_list.add(FieldSet.getFieldOrcale(f, models));	
		}
		
		}
	
	
	public static String getSelect(MainModel model,String... terms) throws IllegalArgumentException, IllegalAccessException{
		String table=model.getClass().getSimpleName();
		//models=model;
		fillSql(model);
		String sql=null;
		StringBuffer member=new StringBuffer();
		String condition=" ";
		for(String term:terms){
			condition=condition+term+" and ";
		}
		condition=condition.substring(0, condition.length()-4);
		for(String b:member_list){
			member.append(b+",");
			}
		
		member.setCharAt(member.length()-1, ' ');
		sql="select "+member.toString()+" from "+table+" where "+condition;
		return sql;
	}  //准确查询
	
	//向数据库中插入model
	public static String insert(Object model) throws IllegalArgumentException, IllegalAccessException{
		String table=model.getClass().getSimpleName();
		//models=model;
		fillSql(model);
		String sql=null;
		StringBuffer member=new StringBuffer();
		StringBuffer values=new StringBuffer();
		for(int i=0;i<member_list.size();i++){
			member.append(member_list.get(i)+",");
			values.append(""+values_list.get(i)+",");
		}
		member.deleteCharAt(member.length()-1);
		values.deleteCharAt(values.length()-1);
		sql="insert into "+table+" ("+member+") values ("+values+")";
		return sql;
	}



	public static String delete(MainModel model,String... terms){
		String condition=" ";
		for(String term:terms){
			condition=condition+term+" and ";
		}
		String table=model.getClass().getSimpleName();
		String sql=null;
		sql="delete from "+table+" where "+condition;
		return sql;
	}

	public static String delete(String table,String condition){
		String sql=null;
		sql="delete from "+table+" where "+condition;
		return sql;
	}
	
	
	public static String delete(Object o) throws Exception{
		StringBuffer condition=new StringBuffer();
		Field[] fields=o.getClass().getFields();
		for(Field field:fields){
			condition.append(field.getName()+"="+FieldSet.getField(field, o)+" and ");
		}
		condition=condition.delete(condition.length()-4, condition.length());
		String sql=delete(o.getClass().getSimpleName(),condition.toString());
		System.out.println(sql);
		return sql;
	}
	

	public static String update(MainModel model,String... terms) throws IllegalArgumentException, IllegalAccessException{
		String condition=" ";
		for(String term:terms){
			condition=condition+term+" and ";
		}
		String table=model.getClass().getSimpleName();
		//models=model;
		fillSql(model);
		String sql=null;
		StringBuffer member_values=new StringBuffer();
		
		for(int i=0;i<member_list.size();i++){
			member_values.append(" "+member_list.get(i)+"='"+values_list.get(i)+"',");
		}
		member_values.setCharAt(member_values.length()-1,' ');
		sql="update "+table+" set"+member_values+"where "+condition;
		
		return sql;
	}
	
	
	
	
	
		
	
public static String getSelect(String table,List <String> member_list,String ...terms){
	String condition=" ";
	for(String term:terms){
		condition=condition+term+" and ";
	}
	String sql=null;
	StringBuffer member=new StringBuffer();
	for(String b:member_list){
		member.append(b+",");
		}
	
	member.setCharAt(member.length()-1, ' ');
	sql="select "+member.toString()+" from "+table+" where "+condition;
	
	return sql;
}  //准确查询


//} //模糊查询
public static String insert(String table,List<String> member_list,List values_list){
	String sql=null;
	StringBuffer member=new StringBuffer();
	StringBuffer values=new StringBuffer();
	for(int i=0;i<member_list.size();i++){
		member.append(member_list.get(i)+",");
		values.append("'"+values_list.get(i)+"',");
	}
	member.setCharAt(member.length()-1, ' ');
	values.setCharAt(values.length()-1, ' ');
	sql="insert into "+table+" ("+member+") values ("+values+")";
	return sql;
}







public static String update(String table,List member_list,List values_list,String... terms){
	String condition=" ";
	for(String term:terms){
		condition=condition+term+" and ";
	}
	String sql=null;
	StringBuffer member_values=new StringBuffer();
	
	for(int i=0;i<member_list.size();i++){
		member_values.append(" "+member_list.get(i)+"='"+values_list.get(i)+"',");
	}
	member_values.setCharAt(member_values.length()-1,' ');
	sql="update "+table+" set"+member_values+"where "+condition;
	
	return sql;
}

public static String update(String table,String oldfield,String newfield,String... terms){
	String condition=" ";
	for(String term:terms){
		condition=condition+term+" and ";
	}
	String sql=null;
	StringBuffer member_values=new StringBuffer();
	
	
		member_values.append(" "+oldfield+"='"+newfield+"'");
	
	sql="update "+table+" set"+member_values+" where "+condition;
	
	return sql;
}


public static List replaceListSql(List source,List target,Object object) throws Exception{
	System.out.println("replaceListSql开始运行");
	System.out.println("源list"+source);
	System.out.println("目的list"+target);
	List deleteList=new ArrayList();
	//空值转换
	for(Object o:target){
		o=FieldSet.Nulltranslate(o);
	}
	
	for(Object o:source){
		o=FieldSet.Nulltranslate(o);
	}
	
	//
	
	for(Object o:target){
		if(!FieldSet.contains(o,source)){
			deleteList.add(o);
		}
	}
	List addList=new ArrayList();
	for(Object o:source){
		if(!FieldSet.contains(o,target)){
			addList.add(o);
		}
	}
	List<String> sqlList=new ArrayList<String>();
	for(Object o:deleteList){
		String sql=FromSql.delete(o);
		sqlList.add(sql);
	}
	for(Object o:addList){
		String sql=FromSql.insert(o);
		sqlList.add(sql);
	}
	
System.out.println("sqlList="+sqlList);
	
	return sqlList;
	
	
}

}
