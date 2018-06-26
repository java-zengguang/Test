package com.jdbc.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.jdbc.dao.impl.ConnectPoolManage;

public class JdbcUtil {
	private static final String DRIVERNAME;
	private static final String URL;
	private static final String USERNAME;
	private static final String PASSWORD;
	private static final ThreadLocal tl=new ThreadLocal();
	static{
	
		String fileName=FileUtil.PATH+"configDatabase.ini";//获取文件的全路径
		Properties ps=FileUtil.read(fileName);
		DRIVERNAME=ps.getProperty("drivername");
		URL=ps.getProperty("url");
		USERNAME=ps.getProperty("username");
		PASSWORD=ps.getProperty("password");
	}      
	
	// 获取数据库连接
	public static Connection getConnection() throws Exception {
		//System.out.println("====="+JdbcUtil.DRIVERNAME);
		// 1
		Class.forName(JdbcUtil.DRIVERNAME);               
		 
		Connection conn = DriverManager.getConnection(
				JdbcUtil.URL, JdbcUtil.USERNAME, JdbcUtil.PASSWORD);    
		conn.setAutoCommit(false);
		tl.set(conn);
		
		return conn;
	}


	
	// 资源释放
	public static void release(PreparedStatement pstm, Connection conn) {
		try {
			
			if (null != pstm) {
				pstm.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (null != conn) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 资源释放
	public static void release(ResultSet rs, PreparedStatement pstm, Connection conn) {
		try {
			if (null != rs) {
				rs.close();
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if (null != pstm) {
				pstm.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (null != conn) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
