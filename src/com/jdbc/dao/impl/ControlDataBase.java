package com.jdbc.dao.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.jdbc.tools.FieldSet;
import com.jdbc.tools.FileCtrl;
import com.student.model.MainModel;
import com.student.model.Model;
import com.student.util.DynamicClass;

public  class ControlDataBase {
	
	
	
	private  static  ControlDataBase cdm;
	
	private ControlDataBase(){}
	
	public static synchronized ControlDataBase getDataBaseControl(){
		if(cdm==null){
			cdm=new ControlDataBase(){};
			
		}
			return cdm;
		
	}
	
	
	
	
	public ConnectPoolManage cpm=new ConnectPoolManage();
	
	
	//插入model_list ，未提交，未初始化连接
		public int[] insertTables(List model_list,Model model) {
			int[] result=null;
			Class model_class=model.getClass();
			Field[] model_fields=model_class.getFields();
			String memS="";
			String valS="";
			for(Field f:model_fields){
				memS=memS+f.getName()+",";
				valS=valS+"?,";
			}
			memS=memS.substring(0, memS.length()-1);
			valS=valS.substring(0, valS.length()-1);
			String sql="insert into "+model_class.getSimpleName()+"("+memS+")"+"  values ("+valS+")";
			System.out.println(sql);
			PreparedStatement pstmt= cpm.getConnAndPstmt(sql);
			Iterator it=model_list.iterator();
			while(it.hasNext()){
				Model m=(Model)it.next();
				for(int i=1;i<model_fields.length+1;i++){
				//pstmt.setString(i,model_fields[i-1].getName());
				try {
					pstmt.setString(i,String.valueOf(model_fields[i-1].get(m)));
				} catch (IllegalArgumentException | IllegalAccessException
						| SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				try {
					pstmt.addBatch();
					result= pstmt.executeBatch();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
			return result;	
			
		
		}
		
		//查询
			public List select(String sql) {
				List list=new ArrayList();
				List memberList=new ArrayList();
				PreparedStatement pstmt= cpm.getConnAndPstmt(sql);
				ResultSet rs;
				try{
					rs = pstmt.executeQuery();
				
				ResultSetMetaData rsmd=rs.getMetaData();  
				int columncount=0;
				columncount= rsmd.getColumnCount();
				
				for(int i=1;i<columncount+1;i++){
					Map map1=new HashMap();
					map1.put("Name", FieldSet.dataTranslateJava(rsmd.getColumnName(i)));
					map1.put("Type", FieldSet.dataTranslateJava(rsmd.getColumnTypeName(i)));
					memberList.add(map1);
				}
				
				while(rs.next()){
					Map map=new HashMap();
			
					columncount= rsmd.getColumnCount();
					for(int i=1;i<columncount+1;i++){
						map.put(rsmd.getColumnName(i),rs.getObject(i)+"");
					}
					
					list.add(map);  

				}
				Model model=(Model) DynamicClass.getDynamicClass(Arrays.asList("com.student.model.Model"), "Temporary",memberList,Arrays.asList("Model"), null);
				list=FileCtrl.setMember(list,model);
				}catch(Exception e){
					
				}
				cpm.release();
				return list;
			}

		
		//查询
		public List select(String sql,Model model)throws Exception{
			List list=new ArrayList();
			PreparedStatement pstmt= cpm.getConnAndPstmt(sql);
			ResultSet rs=pstmt.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();  
			int columncount=0;
		
			while(rs.next()){
				Map map=new HashMap();
				columncount= rsmd.getColumnCount();
				for(int i=1;i<columncount+1;i++){
					map.put(rsmd.getColumnName(i),rs.getObject(i)+"");   	
				}
				
				list.add(map);  
			}
			
			  List model_list=FileCtrl.setMember(list,model);   
			cpm.release();	
			
		return model_list;
		
		}
		
		
		//执行增删改
			public boolean operation(String sql){
				try{
				PreparedStatement pstmt= cpm.getConnAndPstmt(sql);
				pstmt.executeUpdate();
				//Release();	
				}catch(Exception e){
				e.printStackTrace();
					return false;
				}
				
				
				return true;
			}

			
			

			//执行批操作
			public int[] batchSql(List<String> sqlList)  {
				int i[]=null;
				Connection conn1= cpm.getConnection();
			
				Statement stmt;

				try {
					stmt = conn1.createStatement();
					for(String sql:sqlList){
						System.out.println(sql);

						stmt.addBatch(sql);	
					}
					i=stmt.executeBatch();
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				

				return i;
			}
				
		/*	public boolean commit(){
			  return cpm.commit();
			}*/
			
			public void release(){
				 cpm.release();
			}

			
			
			
			public List execute(String sql,MainModel model){
				System.out.println(sql);
				List list=new ArrayList();
				if(sql==null){
					System.out.println("no input");
				}
				else if(sql.startsWith("select")){
				 try {
					list=select(sql,model);
				} catch (Exception e) {
					e.printStackTrace();
				}
				 if(list==null){
					 System.out.println("集合为空");
				 }else if(list.size()==0){
					System.out.println("未找到匹配");

				}
				
				}else {
					if(operation(sql)){
					cpm.release();
					String sql1="select *from "+(model.getClass()).getSimpleName();
					execute(sql1,model);
					}
				}
			return list;
			
			}
			

			
			
			public List execute(String sql){
				System.out.println(sql);
				List<MainModel> list=new ArrayList<MainModel>();
				if(sql==null){
					System.out.println("no input");
				}
				
				else if(sql.startsWith("select")){
				
			
				list=select(sql);
				
				}else if(!operation(sql)){
					
					try {
						throw new Exception();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				}
				cpm.release();
				return list;
			}	
			

			public boolean commit() {
				Connection conn= cpm.tl.get();
				try {
					conn.commit();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				
					e.printStackTrace();
					return false;
				}
				
				return true;
			}
			
			
				
	/*	//使用反射获取model的属性结构，用于填充模型层数据
		public List setMember(List list,Object models) throws IllegalArgumentException, IllegalAccessException, IOException, ClassNotFoundException, InstantiationException{
			 Class model_class=models.getClass();
			 System.out.println(model_class.getName());
			 Field[] model_fields=model_class.getFields();
			Model model=(Model) model_class.newInstance();
			List<Model> model_list=new ArrayList<Model>();
			Iterator it=list.iterator();
			while(it.hasNext()){
				
				Map map=(Map)it.next();
				
				for(Field f:model_fields){
					//f.setAccessible(true);
					
					if(map.get(f.getName())!=null)
					Variable.toField(f,model,map.get(f.getName()));
				
				}
				
				//序列化model对象，将其存入model_list中
				  ByteArrayOutputStream	 bos=new ByteArrayOutputStream();
				ObjectOutputStream out=new ObjectOutputStream(bos);
				out.writeObject(model);
				ObjectInputStream in=new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
				Model model_copy=(Model) in.readObject();
				model_list.add(model_copy);
			}
			
			return model_list;
		}
	*/


		
	
	
}
