package com.student.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.student.biz.inter.XManagerInte;
import com.student.dao.ModelControlInte;
import com.student.dao.impl.ModelControlImpl;
import com.student.model.MainModel;
import com.student.model.Tb_persion;
import com.student.model.X;

public class XManagerImpl extends GenericManager implements XManagerInte{
	


	{
		super.model=new X();
	}
	
	
	
	public XManagerImpl(){
		super();
	}
	public XManagerImpl(String fileName,ModelControlImpl modelControl) {
		super(fileName,modelControl);
	}
	

	public boolean load() {
		String sql="select *from Tb_education,Tb_persion,Tb_technology,Tb_position where  Tb_persion.teacherNumber=Tb_technology.teacherNumber and Tb_persion.teacherNumber=Tb_position.teacherNumber and Tb_education.teacherNumber=Tb_persion.teacherNumber";
		try {
			modelControl.downLoadDatabese(model, sql);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return true;
	}
	
	public List getData() {
		List list=modelControl.getList();
		return list;
	}

	
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
	public boolean x() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
