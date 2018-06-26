package com.student.biz.impl;

import com.student.biz.inter.EducationManagerInte;
import com.student.biz.inter.PersionManagerInte;
import com.student.dao.impl.ModelControlImpl;
import com.student.model.Tb_education;
import com.student.model.Tb_persion;

public class EducationManagerImpl extends GenericManager implements EducationManagerInte{

	

	{
		super.model=new Tb_education();
	}
	
	
	
	public EducationManagerImpl(){
		super();
	}
	public EducationManagerImpl(String fileName,ModelControlImpl modelControl) {
		super(fileName,modelControl);
	}
	
	@Override
	public boolean load() {
		String sql="SELECT * FROM tb_education";
		try {
			modelControl.downLoadDatabese(new Tb_education(), sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean x() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
