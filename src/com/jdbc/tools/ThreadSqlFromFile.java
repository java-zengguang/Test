package com.jdbc.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.student.model.MainModel;


public class ThreadSqlFromFile implements Runnable {
	
private FromSql fromsql;
private synchronized List<String> sqlFromFile(File file,String charset) throws IOException {
	if(file==null)
		return null;
	
	
	
	List<String> list=new ArrayList<String>();
	BufferedReader in=new BufferedReader(new InputStreamReader(new FileInputStream(file),charset));
	String line=null;
	while((line=in.readLine())!=null){
		list.add(line);
	}
	in.close();
	return list;
}



private synchronized void sqlToFile(File file,List <String>list) throws IOException{
	
	
	BufferedWriter out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true)));
	Iterator it=list.iterator();
	String sql=null;
	while(it.hasNext()){
		sql=(String)it.next();
		out.newLine();
		out.write(sql);
		
	}
	out.close();
}



//将table写入文件中，其中table用list<Model>来储存
public static void tableToFile(File file,List<MainModel> list,String charset,boolean append) throws IOException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException{
	
	BufferedWriter out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,append),charset));

	List<String> slist=new ArrayList<String>();   //list<String>用于存放List<Model>中的每行数据转化为String数据
	String line=new String();
	MainModel model=(MainModel)list.get(0);//获得一个model
	Field fs[]=model.getClass().getFields();
	//构造table的表头
	for(Field f:fs){
		String s=f.getName()+"         ";    //每个属性中间隔多个空格
		line=line+s+"   ";
	}
	slist.add(line.toString());     //将表头放在第一行
	//将model的数据转化为String放入list中
	Iterator it=list.iterator();
	while(it.hasNext()){
		line=new String();
		model=(MainModel) it.next();
		fs=model.getClass().getFields();
		for(Field f:fs){
			/*f.isAccessible();
			String name=f.getName();
			  name = name.substring(0, 1).toUpperCase() + name.substring(1);//构造出get方法的名字
			  Method m=model.getClass().getMethod("get"+name);//使用get方法实现数据修改
			  
			line=line+m.invoke(model)+"           ";*/
			line=line+f.get(model)+"           ";
			
		}
	slist.add(line);
	}
	
	//将list写入文件中
	it=slist.iterator();
	while(it.hasNext()){
	out.write((String)it.next());
	out.newLine();
	}
	out.close();
}

public static List<MainModel> tableFromFile(File file,MainModel model,String charset) throws IOException, IllegalArgumentException, IllegalAccessException, ClassNotFoundException{
	BufferedReader in=new BufferedReader(new InputStreamReader(new FileInputStream(file),charset));
	String line=null;
	
	List<Map> list=new ArrayList<Map>();
	List<MainModel> list_model=new ArrayList<MainModel>();
	line=in.readLine();
	String mem_name[]=line.split("\\s{1,}|/t");  //正则表达式表示多个空格
	while((line=in.readLine()) != null){
		Map map=new HashMap();    //每列的map必须是新的对象，否则压入list的map永远都是一个，而map的值是最后一次修改的值
		String mem[]=line.split("\\s{1,}|/t");
	
		for(int i=0;i<mem.length;i++){
	
			map.put(mem_name[i], mem[i]);
			
		}
		list.add(map);
	}

	
	list_model=setMember(list,model);

	return list_model;
}

/**
 * 用于通过model获取创建数据库表的sql语句
 * */
/*public static String createTable(Model model){
	StringBuffer sql=new StringBuffer();
	Field fields[]=model.getClass().getFields();
	List member_list=new ArrayList();
	String tableName=model.getClass().getSimpleName();
	sql.append("create table ");
	sql.append(tableName);
	sql.append(" (");
	for(Field f:fields){
		sql.append(f.getName());
		sql.append(" ");
		
	}

	return sql.toString();
}*/

//使用反射获取model的属性结构，用于填充模型层数据
	public static List setMember(List list,MainModel model) throws IllegalArgumentException, IllegalAccessException, IOException, ClassNotFoundException{
		Field[] model_fields=model.getClass().getFields();
		Map map=new HashMap();
		List model_list=new ArrayList();
		for(int i=0;i<list.size();i++){
			
			map=(Map)list.get(i);
			
			for(Field f:model_fields){
				f.setAccessible(true);
				if(map.get(f.getName())!=null)
				f.set(model,map.get(f.getName()));
			
			}
			//序列化对象，实现深度克隆
			  ByteArrayOutputStream	 bos=new ByteArrayOutputStream();
			ObjectOutputStream out=new ObjectOutputStream(bos);
			out.writeObject(model);
			ObjectInputStream in=new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
			MainModel model_copy=(MainModel) in.readObject();   //此处不能直接用旧对象的引用，因为model会影响下一轮循环
			//将对象放入list中
			model_list.add(model_copy);
		}
		return model_list;
	}

private int explainOrder(){
	return 0;
}


@Override
public void run() {
	// TODO Auto-generated method stub
	
	
}



}
