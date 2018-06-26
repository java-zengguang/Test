package com.student.biz.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.jdbc.dao.impl.ConnectPoolManage;
import com.student.biz.inter.ModelManagerInte;
import com.student.biz.inter.ModelManagerSqlInte;
import com.student.util.FileCtrl;

public abstract class GenericManagerSql implements ModelManagerSqlInte{
	public	ConnectPoolManage cpm;
	public GenericManagerSql(){
		
	}
	public GenericManagerSql(ConnectPoolManage cpm) {
		this.cpm = cpm;
	}




}
