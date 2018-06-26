package com.jdbc.tools;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.jdbc.dao.impl.ConnectPoolManage;
import com.jdbc.dao.impl.Option;
import com.student.biz.inter.ModelManagerInte;
import com.student.dao.ModelControlInte;
import com.student.model.MainModel;
import com.student.util.ConfigReader;

public class JdbcCtrlFactory {
/*	public static  JdbcCtrl createJdbcCtrl(String configPath) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Properties ps=ConfigReader.read(FileCtrl.getProjectPath()+configPath);
		String database=ps.getProperty("database");
		//"jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=GBK",11,"com.mysql.jdbc.Driver","root","helloworld"
		String url=ps.getProperty("url");
		String poolMax=ps.getProperty("poolMax");
		String databaseDriver=ps.getProperty("databaseDriver");
		String user=ps.getProperty("user");
		String password=ps.getProperty("password");

		String optionName=ps.getProperty("option");
		String daoName=ps.getProperty("daoName");	
		String bizName=ps.getProperty("bizName");
		//String modelName=ps.getProperty("modelName");
		String filePath=ps.getProperty("filePath");
		Option option=new Option(url,Integer.valueOf(poolMax),databaseDriver,user,password);
		
		Class daoClass=Class.forName(daoName);
		Class bizClass=Class.forName(bizName);
		Constructor bizC= bizClass.getConstructor(com.jdbc.dao.impl.Option.class);

		JdbcCtrl jc = (JdbcCtrl) bizC.newInstance(option);
		
		return jc;
	}*/
}
