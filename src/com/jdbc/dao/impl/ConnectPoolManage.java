package com.jdbc.dao.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
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

import com.jdbc.dao.ConnectPoolManageInte;
import com.jdbc.tools.BeanFactory;
import com.jdbc.tools.FieldSet;
import com.jdbc.tools.FileCtrl;
import com.jdbc.tools.Variable;
import com.student.model.Model;
import com.student.util.DynamicClass;



public class ConnectPoolManage implements ConnectPoolManageInte {
	private Connection conn1;
	private PreparedStatement pstmt;
	private String url=null;
	private static int maxConnectNum=5;
	private  String Driver=null;
	private String username=null;
	private String password=null;
	public Option option=(Option)BeanFactory.createBean("option");
	public final ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
	private static Connection conn[]=new Connection[5];
	private static List connectPool=new ArrayList();
	private static int flag=0;
	

	

	
		
		
	
	public ConnectPoolManage(){}
	//构造方法
	public ConnectPoolManage(Option option) {
		this.option=option;
		this.url =option.getUrl();
		this.maxConnectNum = option.getMaxConnectNum();
		Driver = option.getDriver();
		this.username = option.getUsername();
		this.password = option.getPassword();

	}




	//初始化线程池
	private void inits(){
		this.url =option.getUrl();
		this.maxConnectNum = option.getMaxConnectNum();
		Driver = option.getDriver();
		this.username = option.getUsername();
		this.password = option.getPassword();
		try{
			for(int i=0;i<maxConnectNum;i++){
				conn[i%5]=getConnectFromDatabase();
				connectPool.add(i,conn[i%5]);
				}
	
			flag=1;
		}catch(Exception e){
			
	}
	}
	
	//获取一个线程池里的数据
	public Connection getConnection() {
		if(flag==0)
			inits();
		Connection conn=null;
		if(connectPool.size()==0){
			try {
				Thread.sleep(1000);
				getConnection();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			conn=(Connection)connectPool.remove(0);
			
		}
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tl.set(conn);
		return conn;
	}
	//创建一个数据库连接
	private Connection getConnectFromDatabase(){
		Connection conn=null;

		try{	
			
			Class.forName(Driver);
			conn=DriverManager.getConnection(url,username,password);
		}catch(Exception e){
			
		e.printStackTrace();
	}
		return conn;
	}
	
	public boolean release(Connection conn){
		
			return 	connectPool.add(conn);
		
		
	}

	//获取连接
	public PreparedStatement getConnAndPstmt(String sql){
		conn1=null;
		conn1=getConnection();
		pstmt=null;
		if(conn1==null){
			System.out.println("获取链接失败");
		}
		try {
			pstmt=conn1.prepareStatement(sql);
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return pstmt;
	}

	
	

	//提交事务
	 public boolean commit(){
		 try {
			conn1.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		 return true;
	 }

	
		//重置连接
		public void release(){
			if(pstmt!=null){
				pstmt=null;
			}
			if(conn1!=null){
				release(conn1);
			}
			
		}




	

}	