package com.student.view;


import java.util.List;

import com.jdbc.dao.impl.ControlDataBase;
import com.jdbc.tools.FileUtil;
import com.student.node.Table;
import com.student.util.Session;
import com.student.util.Util;


public class test {
public static void main(String args[]) throws Exception{
	Session session=new Session();
	session.load();
	//List list=session.getData("Tb_education");
	//System.out.println("List ___________----------"+list);
	session.showRelationShip();
	//List list= FileUtil.getClassFormPackage("com.student.model", true, Table.class);
	//System.out.println(list);
	
	//System.out.println(ControlDataBase.getDataBaseControl());
}
}