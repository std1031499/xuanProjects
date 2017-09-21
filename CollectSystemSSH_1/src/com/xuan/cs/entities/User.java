package com.xuan.cs.entities;

public class User {
		
	private Integer user_Id;
	private String c_Username;
	private String c_Password;
	private String c_Level;
	


	public Integer getUser_Id() {
		return user_Id;
	}



	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}



	public String getC_Username() {
		return c_Username;
	}



	public void setC_Username(String c_Username) {
		this.c_Username = c_Username;
	}



	public String getC_Password() {
		return c_Password;
	}



	public void setC_Password(String c_Password) {
		this.c_Password = c_Password;
	}



	public String getC_Level() {
		return c_Level;
	}



	public void setC_Level(String c_Level) {
		this.c_Level = c_Level;
	}



	@Override
	public String toString() {
		return "User [user_Id=" + user_Id + ", c_Username=" + c_Username
				+ ", c_Password=" + c_Password + ", c_Level=" + c_Level + "]";
	}



	
				
	
	


	
	
	
}
