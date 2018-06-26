package com.student.biz.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.student.biz.inter.ModelManagerInte;
import com.student.dao.ModelControlInte;
import com.student.dao.impl.ModelControlImpl;
import com.student.model.Model;
import com.student.model.Model;
import com.student.util.FileCtrl;

public abstract class GenericManager implements ModelManagerInte{
	public ModelControlInte modelControl;
	public String fileName;
	public Model model;
	public GenericManager(){
		
	}
	public GenericManager(String fileName,ModelControlInte modelControl) {
		this.fileName=fileName;
		this.modelControl = modelControl;
	}


	@Override
	public boolean add(Model model) {
		modelControl.appendList(Arrays.asList(model));
		return true;
	}
	@Override
	public boolean add(List<Model> model_list) {
		modelControl.appendList(model_list);
		return true;
	}

	
	@Override
	public boolean delete(String... terms) {

		
		try {
			modelControl.deleteModel(terms);
		} catch (Exception e) {
		
			return false;
		}

		return true;	
	}
	
	public boolean delete(int index){
		
		return modelControl.deleteModel(index);
	}
	
	public boolean updata(int x, String... terms) {
		try {
			modelControl.updateList( model,terms);
		} catch (Exception e) {
			return false;
		}

		return true;

	}

	@Override
	public boolean update(Model model, String... terms) {
		modelControl.updateList(model, terms);
		return true;
	}

	public boolean update(Model model,int index){
		modelControl.updateListIndex(model, index);
		return true;
	}
	@Override
	public List find( String... terms) {

		//写出查询不到的错误提示
		List model_list=new ArrayList();
		try {
			model_list= modelControl.findModel( terms);
		} catch (Exception e) {	
		}

		return model_list;

	}
	
	@Override
	public List getData() {
		List list=modelControl.getList();
		return list;
	}

	
	@Override
	public boolean sort( String... terms) {

		try {
			modelControl.toOrder(  terms);
		} catch (Exception e) {
			return false;
		}

		return true;

	}
	
	@Override
	public boolean read() {
		modelControl.readFild( new File(FileCtrl.getProjectPath()+fileName));
		return true;
	}

	
	@Override
	public boolean memory(boolean isCover) {
	
			try {
				modelControl.writeFild(  new File(FileCtrl.getProjectPath()+fileName), isCover);
			} catch (Exception e) {

				return false;
			}
			return true;
	}
	
	@Override
	public boolean submit() {
		modelControl.submit();
		return false;
	}
	@Override
	public boolean upLoad() {
	
		return 	modelControl.upLoadDatabase();
	}
	
	public boolean enSure() {

		return true;
	}

	public boolean backSpace() {

		return true;
	}

	public boolean toSimple() {
		return true;
	}

}
