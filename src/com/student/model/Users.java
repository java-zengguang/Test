package com.student.model;

import java.io.Serializable;

import com.student.node.Biz;
import com.student.node.Table;
@Table(name="Users")
@Biz(name="UsersManagerBiz", className = "com.student.biz.impl.UsersManagerImpl")
public class Users implements MainModel,Serializable{
	
	public String userName;
	public String password;
	public String power;
	public String name;
    public String loginCount;
	public String lastLoginTime;
	public String email;
	public String Find_question;
	public String Find_answer;
	
	public Users(){}
	public Users(String userName, String password, String power, String name,
			 String loginCount, String lastLoginTime, String email,String Find_question,String Find_answer) {
		super();
		this.userName = userName;
		this.password = password;
		this.power = power;
		this.name = name;
		this.loginCount = loginCount;
		this.lastLoginTime = lastLoginTime;
		this.email = email;
		this.Find_question=Find_question;
		this.Find_answer=Find_answer;
	}

	
	public Users(String userName) {
		super();
		this.userName = userName;
	}
	public String getFind_question() {
		return Find_question;
	}

	public void setFind_question(String find_question) {
		Find_question = find_question;
	}

	public String getFind_answer() {
		return Find_answer;
	}

	public void setFind_answer(String find_answer) {
		Find_answer = find_answer;
	}

	public String toString() {
		return "Users [userName=" + userName + ", password=" + password
				+ ", power=" + power + ", name=" + name + ", loginCount="
				+ loginCount + ", lastLoginTime=" + lastLoginTime + ", email="
				+ email + ", Find_question=" + Find_question + ", Find_answer="
				+ Find_answer + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getLoginCount() {
		return loginCount;
	}
	public void setLoginCount(String loginCount) {
		this.loginCount = loginCount;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
