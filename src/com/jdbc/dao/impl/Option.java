package com.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.student.model.MainModel;



public  class Option {
		public String url=null;
		public int maxConnectNum=5;
		public  String Driver=null;
		public String username=null;
		public String password=null;

		public Option( String url, int maxConnectNum,
				String driver, String username, String password) {
		
			this.url = url;
			this.maxConnectNum = maxConnectNum;
			Driver = driver;
			this.username = username;
			this.password = password;
		
		}
		public Option(){}
	
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public int getMaxConnectNum() {
			return maxConnectNum;
		}
		public void setMaxConnectNum(int maxConnectNum) {
			this.maxConnectNum = maxConnectNum;
		}
		public String getDriver() {
			return Driver;
		}
		public void setDriver(String driver) {
			Driver = driver;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}


	
}
