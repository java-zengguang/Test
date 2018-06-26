package com.student.biz.inter;

import com.student.model.Users;

public interface UsersManagerInte extends ModelManagerInte {

	public boolean checkPassword(String name,String password,String power);

	public boolean checkUser(String user)throws Exception;
	
	public boolean registUser(Users user);
}
