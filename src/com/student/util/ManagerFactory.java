package com.student.util;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.student.biz.inter.ModelManagerInte;
import com.student.dao.ModelControlInte;

public class ManagerFactory {
	public static ModelManagerInte createManager(String configPath) throws Exception{
		Properties ps=ConfigReader.read(FileCtrl.getProjectPath()+configPath);
		String daoName=ps.getProperty("daoName");	
		String bizName=ps.getProperty("bizName");
		String modelName=ps.getProperty("modelName");
		String modelInte=ps.getProperty("modelInte");
		String filePath=ps.getProperty("filePath");
		
		Class bizClass=Class.forName(bizName);
		Class daoClass=Class.forName(daoName);
		Class modelClass=Class.forName(modelName);
		Map message=new HashMap();

		
		
		Constructor daoC=daoClass.getConstructor(Class.forName(modelInte),java.util.Map.class);
		Constructor bizC=bizClass.getConstructor(java.util.List.class,Class.forName(modelInte),java.io.File.class,daoClass.getInterfaces()[0]);
		
		ModelControlInte dao=(ModelControlInte) daoC.newInstance(modelClass.newInstance(),message);
		
		ModelManagerInte biz=(ModelManagerInte) bizC.newInstance(new ArrayList(),modelClass.newInstance(),new File(filePath),dao);
		
		
		return biz;
	}
}
