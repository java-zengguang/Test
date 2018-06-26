package com.student.dao;

import java.io.File;
import java.util.Collection;
import java.util.List;

import com.student.model.Model;
import com.student.model.Model;

public interface ModelControlInte {

	 List getList();
	 boolean readFild(File file);
	 boolean writeFild(File file,boolean append);
	 boolean updateList(Model model,String... terms);
	 boolean updateListIndex(Model model,int index);
	 
	 boolean appendList(List list) ;

	 boolean deleteModel(String... terms);
	 boolean deleteModel(int index);
	 boolean toOrder(String ... terms );
	 boolean toSimple(String primayKey);
	 List findModel(String... terms);

	 boolean downLoadDatabese(Model model,String sql) throws Exception;
	 boolean upLoadDatabase();
	 boolean submit();
	
}
