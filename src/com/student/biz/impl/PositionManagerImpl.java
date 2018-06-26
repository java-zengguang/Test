package com.student.biz.impl;

import com.student.biz.inter.PositionManagerInte;
import com.student.dao.ModelControlInte;
import com.student.model.Tb_position;
import com.student.model.Tb_technology;

public class PositionManagerImpl extends GenericManager implements PositionManagerInte {
		

	{
		super.model= new Tb_position();
	}
	
	
	public PositionManagerImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PositionManagerImpl(String fileName, ModelControlInte modelControl) {
		super(fileName, modelControl);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean load() {
		String sql="SELECT * FROM Tb_position";
		try {
			modelControl.downLoadDatabese(new Tb_position(), sql);
		
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
