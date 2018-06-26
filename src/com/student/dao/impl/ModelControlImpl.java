package com.student.dao.impl;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.jdbc.dao.impl.ConnectPoolManage;
import com.jdbc.dao.impl.ControlDataBase;
import com.jdbc.tools.FieldSet;
import com.jdbc.tools.FromSql;
import com.jdbc.tools.JdbcCtrlFactory;
import com.student.dao.ModelControlInte;
import com.student.model.ContainModel;
import com.student.model.MainModel;
import com.student.model.Model;
import com.student.model.Model;
import com.student.model.Users;
import com.student.util.FileCtrl;

public class ModelControlImpl implements ModelControlInte{
	public Model model;
	public ControlDataBase cpm=ControlDataBase.getDataBaseControl();
	
	private List model_list=new ArrayList();
	private List bank_list=new ArrayList();
	
	public ModelControlImpl(){}
	
	public ModelControlImpl(Model model,ControlDataBase cpm){
		this.model=model;
		this.cpm=cpm;
	}
	
	
	protected Scanner input=new Scanner(System.in);
	
	

		
		/*	读取文件*/
public boolean readFild(File file) {
			try {
				try {
				//	model_list=FileCtrl.tableFromFile(file, model, "GBK");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		
			return true;
		}

		/*写文件*/
public boolean writeFild(File file,boolean append) {
			try {
				FileCtrl.tableToFile(file, model_list, "GBK", append);
			} catch (IllegalArgumentException | IllegalAccessException
					| NoSuchMethodException | SecurityException
					| InvocationTargetException | IOException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		/*根据查询条件更新*/


private String [] getValues(String valueS){

	String sub[]=valueS.split(":");
	for(int i=0;i<sub.length;i++){
		sub[i]=sub[i].trim();
	}
	return sub;		
}


public boolean updataList(String valueS,int index) throws IllegalArgumentException, IllegalAccessException, InstantiationException{
	String[] values=getValues(valueS);
	Field fields[]=model.getClass().getFields();
	if(values.length==fields.length){
		int i=0;
		model=model.getClass().newInstance();
		for(Field f:fields){
			FieldSet.setField(f, model, values[i].trim());
			i++;
		}
		model_list.set(index,model);	
	}	
	else{
		//System.out.println(message.get("error_print_1"));	
	}
return true;
}

 List appendModelList(List list) throws IllegalArgumentException, IllegalAccessException, InstantiationException{
	model_list.addAll(list);
	return model_list;
}



		/*删除数据*/
public boolean deleteModel(String... terms){
	List num_list;
	try {
		num_list = findModelIndex(terms);
	} catch (NoSuchFieldException | SecurityException
			| IllegalArgumentException | IllegalAccessException e) {
		e.printStackTrace();
		return false;
	}
	if(num_list.size()>0){

	ListIterator it=num_list.listIterator(num_list.size());
	int i=0;
	while(it.hasPrevious()){
		i=(int) it.previous();
		model_list.remove(i);
	//	System.out.println(message.get("delete_print_1")+i);
	}
	}	
	return true;
}

	
public boolean toOrder(String ... terms ) {
	for(int i=0;i<model_list.size();i++){
		for(int j=0;j<model_list.size()-i-1;j++){
			try {
				if(FieldSet.toCompare(model_list.get(j),model_list.get(j+1),terms)>0){
					Object copyJ=model_list.get(j);
					model_list.set(j, model_list.get(j+1));
					model_list.set(j+1, copyJ);
				}
			} catch (NoSuchFieldException | SecurityException
					| IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
				return false;
			}

		}
	}
	return true;
	
}	
	
public boolean toSimple(String primayKey){
	Set modelSet=new HashSet(model_list);
	List model_list=new ArrayList(modelSet);
	return true;
}
		
 List <Integer> findModelIndex(String... terms) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
	List num_list=new ArrayList();
	Class modelClass=model.getClass();
	Map termMap=new HashMap();
	for(String term:terms){
		String[] subS=term.split("=");
		termMap.put(subS[0].trim(), subS[1].trim());

	}
	Iterator it=model_list.iterator();
	for(int i=0;i<model_list.size();i++){
		
		Model modelX=(Model) model_list.get(i);
		if(FieldSet.toCompare(modelX,termMap)==0){
			num_list.add(i);
		
		}
	} 
		return num_list;	
}

public List findModel(String... terms) {
	List sub_list=new ArrayList();
	List num_list=new ArrayList();
	try {
		num_list = findModelIndex(terms);
	} catch (NoSuchFieldException | SecurityException
			| IllegalArgumentException | IllegalAccessException e) {
	
		e.printStackTrace();
		
	}
	Iterator it=num_list.iterator();
	while(it.hasNext()){
		
		sub_list.add(model_list.get((int) it.next()));
	}
		return sub_list;	
}





public  boolean upLoadDatabase(){
	try {
		List <String> sqlList=new ArrayList<String>();
		if(model instanceof MainModel){
		sqlList=FromSql.replaceListSql(model_list,bank_list,  model);
		}else if(model instanceof ContainModel){
		Field[] fields=	model.getClass().getFields();
		for(Field field:fields){
			if(field.getType()!=int.class && field.getType()!=String.class){
				List <String> subSqlList=new ArrayList();
				List <Object> subModelList=new ArrayList<Object>();
				List <Object> subBankList=new ArrayList<Object>();
				
				for(int i=0;i<model_list.size();i++){
					Object o=field.get(model_list.get(i));
					
					subModelList.add(o);
				}
				for(int i=0;i<bank_list.size();i++){
					Object o=field.get(bank_list.get(i));
					subBankList.add(o);
				}
				subSqlList=FromSql.replaceListSql(subModelList, subBankList, field.get(model));
				subSqlList.addAll(sqlList);
				sqlList=subSqlList;
			}
		}	
		}
		cpm.batchSql(sqlList);
	
	} catch (Exception  e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
	return true;
}

public boolean downLoadDatabese(Model model,String sql) throws Exception{
	
	List list=cpm.select(sql, model);
	Iterator it= list.iterator();

	bank_list=list;
	model_list=cpm.select(sql, model);
	return true;
}



@Override
public List getList() {
	return model_list;
}

public boolean updateListIndex(Model model,int index){
	model_list.set(index, model);
	return true;
}

@Override
public boolean updateList(Model model, String... terms) {
	try {
		List<Integer> num_list=findModelIndex(terms);
		for(int num:num_list){
			model_list.set(num, model);
		}
			
	} catch (NoSuchFieldException | SecurityException
			| IllegalArgumentException | IllegalAccessException e) {
		e.printStackTrace();
	}
	return false;
}

@Override
public boolean appendList(List list) {
	model_list.addAll(list);
	return true;
}

@Override
public boolean submit() {
	cpm.commit();
	cpm.release();
	System.out.println("提交成功，重置链接");
	return true;
}

public boolean deleteModel(int index) {
	
	model_list.remove(index);
	return true;
}

/*@Override
public boolean release() {
	cpm.release();
	return true;
}*/
}






/*public static boolean upLoadSql(List model_list,Model model) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//ConnectPoolManage cpm=new ConnectPoolManage(OptionFactory.getOption(DataBaseType.Oracle));
JdbcCtrl jc=JdbcCtrlFactory.createJdbcCtrl(FileCtrl.getProjectPath()+"configDatabase.txt");
try {

	jc.insertTable(model_list, model);
	
} catch (Exception e) {
	
	System.out.println("失败");
	return false;
	
}
return true;
}*/
/* Model inputModel() throws IllegalArgumentException, IllegalAccessException, InstantiationException{
	
	Scanner input=new Scanner(System.in);
	Field fields[]=model.getClass().getFields();
	String outS=message.get("input_print_1");
	for(Field f:fields){
		outS=outS+f.getName()+":";
	}
	outS=outS.substring(0, outS.length()-1);
	while(true){
		System.out.println(outS);
		String inS=input.next();
		String sub[]=inS.split(":");
		if(sub.length==fields.length){
			int i=0;
			model=model.getClass().newInstance();
			for(Field f:fields){
				FieldSet.setField(f, model, sub[i].trim());
				i++;
			}
			break;
		}else{
			System.out.println("输入错误请重新输入");
		}
	}
	return model;
}*/


 /*List inputModelList() throws IllegalArgumentException, IllegalAccessException, InstantiationException{
	List list=new ArrayList();
	Scanner input=new Scanner(System.in);
	Field fields[]=model.getClass().getFields();
	//String outS=message.get("input_print_1");
	for(Field f:fields){
		outS=outS+f.getName()+":";
	}
	outS=outS.substring(0, outS.length()-1);
	while(true){
		System.out.println(outS);
		String inS=input.next();
		if(inS.equals("exit")){
			break;
		}
		String sub[]=inS.split(":");
		if(sub.length==fields.length){
			int i=0;
			model=model.getClass().newInstance();
			for(Field f:fields){
				FieldSet.setField(f, model, sub[i].trim());
				i++;
			}
			list.add(model);
		}else{
			System.out.println("输入错误请重新输入");
		}
	}
	return list;
}*/
/*
public boolean updataList(Model model,String... terms) {
	List<Integer> index_list;
	try {
		index_list = findModelIndex(terms);
	} catch (NoSuchFieldException | SecurityException
			| IllegalArgumentException | IllegalAccessException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		return false;
	}
	for(int index:index_list){
	//	System.out.println(message.get("updata_print_1")+model_list.get(index));
		try {
			//updataList( index);
			model_list.set(index, model);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	return true;
}

*/

/*根据索引更新*/
/*public boolean updataList(int index) throws IllegalArgumentException, IllegalAccessException, InstantiationException{
	
model_list.add(inputModel());
	return true;
}*/

/*添加数据到model_list,   bind代表是否多次输入*/
/*public boolean appendList(boolean bind) {
if(bind){
try {
	List list=appendModelList(inputModelList());
} catch (IllegalArgumentException | IllegalAccessException
		| InstantiationException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	return false;
}
}else{
try {
	Model model=inputModel();
} catch (IllegalArgumentException | IllegalAccessException
		| InstantiationException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	return false;
}

}

return true;
}
*/

