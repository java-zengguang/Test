package com.student.biz.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jdbc.tools.BeanFactory;
import com.student.biz.inter.UsersManagerInte;
import com.student.dao.ModelControlInte;
import com.student.model.Model;
import com.student.model.Users;

public  class UsersManagerImpl extends GenericManager implements UsersManagerInte{

	
	{ 
		super.model=new Users();
	}
	public UsersManagerImpl(){
		super();
	}
	
	public UsersManagerImpl( String fileName,ModelControlInte modelControl) {
	super(fileName,modelControl);
		
	}


	public boolean checkPassword(String user, String password, String power) {

		List li = new ArrayList();
		try {
			modelControl.downLoadDatabese(new Users(), "select *from users");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			li=find( "userName="+user, "password="+password);
		} catch (Exception e) {
			e.printStackTrace();

		}
		if (li.size() == 0) {
			return false;
		} else {
			return true;
		}

	}
	
	


	@Override
	public boolean checkUser(String user) throws Exception {
		List lis = new ArrayList();
		if (user == null) {
			throw new Exception();
		} else {
			try {
				lis = modelControl.findModel( "userName=" + user.trim());
			} catch (Exception e) {
				
				e.printStackTrace();
				return false;
			}
		}
		if (lis.size() == 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean registUser(Users user){
		

	System.out.println(user);
			try {
				if(checkUser(user.userName)){
					//不存在用户
					add(user);
					upLoad();
					modelControl.submit();
					
				}else{
					//存在用户
				return false;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return true;
			
	}




	@Override
	public boolean x() throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean load() {
		String sql="select *from users";
		try {
			modelControl.downLoadDatabese(new Users(), sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
}
