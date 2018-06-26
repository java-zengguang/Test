package com.student.biz.inter;

import java.lang.reflect.Method;
import java.util.List;

import com.student.model.Model;

public interface ModelManagerInte {




	
	boolean delete(String... terms);
	
	boolean update(Model model,String... terms);
	
	boolean update(Model model,int index);
	
	List find(String... terms);
	
	boolean sort(String... terms);
	
	boolean memory(boolean isCover);
	
	boolean read();
	
	boolean submit();
	
	boolean load();
	
	boolean upLoad();
	
	List getData();
	
	boolean enSure();
	
	boolean backSpace();

	boolean add(Model model);
	
	boolean add(List<Model> model_list);
	
	boolean x()throws Exception;
	
	boolean delete(int index);

	
	
	

	
}
