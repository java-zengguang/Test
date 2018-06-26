package com.jdbc.tools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jdbc.dao.impl.ConnectPoolManage;
import com.student.biz.impl.XManagerImpl;
import com.student.biz.inter.XManagerInte;
import com.student.model.Tb_education;
import com.student.model.Tb_persion;
import com.student.model.X;

public class test {
	public static void main(String args[]) throws Exception{
		List list=new ArrayList();
		String sql="select *from Tb_education as e,Tb_persion as p where e.teacherNumber=p.teacherNumber";
		
		XManagerInte xmi= (XManagerInte) BeanFactory.createBean("XManagerBiz");
		xmi.load();
		System.out.println("____________________________________");

		list=xmi.getData();
		for(Object o:list){
			System.out.println(o);
		}
	/*	X x=new X();
		x.tb_e=new Tb_education("1","6","0","0","0","0","0","0","0","6");
		x.tb_p=new Tb_persion("0", "6", "1","9", "9", "9", "9" ,"9", "9", "9","9","9");
		xmi.add(x);
		System.out.println("____________________________________");
		list=xmi.getData();
		for(Object o:list){
			System.out.println(o);
		}
		*/
		list=xmi.find("tb_e.firstEducation=0","tb_p.name=9");
		for(Object o:list){
			System.out.println(o);
		}
		/*xmi.upLoad();
		xmi.submit();*/
		//System.out.println(FieldSet.toCompare(list.get(0), list.get(2)));
		
	
	
}
}