package com.jdbc.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.student.model.Model;
import com.student.model.Model;

public interface ConnectPoolManageInte {
	boolean release(Connection conn);
	void release();
	/*int[] batchSql(List<String> sqlList);
	List select(String sql,Model model) throws Exception;
	boolean operation(String sql);
	List<Map> select(String sql);*/
	boolean commit();
	//int[] insertTables(List<Model> model_list,Model model);
}
