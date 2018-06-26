package com.student.biz.impl;

import java.util.List;

import com.student.biz.inter.EducationManagerInte;
import com.student.biz.inter.PersionManagerInte;
import com.student.biz.inter.TechnologyManagerInte;
import com.student.dao.impl.ModelControlImpl;
import com.student.model.Tb_education;
import com.student.model.Tb_persion;
import com.student.model.Tb_technology;

public class TechnologyManagerImpl extends GenericManager implements TechnologyManagerInte{

	

	{
		super.model=new Tb_technology();
	}
	
	
	
	public TechnologyManagerImpl(){
		super();
	}
	public TechnologyManagerImpl(String fileName,ModelControlImpl modelControl) {
		super(fileName,modelControl);
	}
	
	@Override
	public boolean load() {
		String sql="SELECT * FROM tb_technology";
		try {
			modelControl.downLoadDatabese(new Tb_technology(), sql);
		
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
