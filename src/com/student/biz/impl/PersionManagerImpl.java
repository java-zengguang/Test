package com.student.biz.impl;

import com.student.biz.inter.PersionManagerInte;
import com.student.dao.impl.ModelControlImpl;
import com.student.model.Tb_persion;
import com.student.model.Tb_position;

public class PersionManagerImpl extends GenericManager implements PersionManagerInte{

	

	{
		super.model=new Tb_persion();
	}
	
	
	
	public PersionManagerImpl(){
		super();
	}
	public PersionManagerImpl(String fileName,ModelControlImpl modelControl) {
		super(fileName,modelControl);
	}
	
	@Override
	public boolean load() {
		String sql="SELECT * FROM Tb_persion";
		try {
			modelControl.downLoadDatabese(model, sql);
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
