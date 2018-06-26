package com.student.model;

import com.student.model.MainModel;
import com.student.model.Tb_education;
import com.student.model.Tb_persion;
import com.student.node.Biz;
import com.student.node.Table;

@Table(name="X")
@Biz(name="XManagerBiz", className = "com.student.biz.impl.XManagerImpl")
public class X implements ContainModel{
	public Tb_persion tb_p=new Tb_persion();
	public Tb_education tb_e=new Tb_education();
	public Tb_technology tb_t=new Tb_technology();
	public Tb_position tb_po=new Tb_position();
	@Override
	public String toString() {
		return "X [tb_p=" + tb_p + ", tb_e=" + tb_e + ", tb_t=" + tb_t
				+ ", tb_po=" + tb_po + "]";
	}
	
	
}
