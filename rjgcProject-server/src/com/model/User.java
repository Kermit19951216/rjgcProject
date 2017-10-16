package com.model;

public class User {

	private int id;
	private String name;
	private String password;
	private String contactway;
	private String school=null;
	private boolean authority=false;
	
	public void setid(int id){
		this.id=id;
	}
	public void setname(String name){
		this.name=name;
	}
	public void setpassword(String password){
		this.password=password;
	}
	public void setcontactway(String contactway){
		this.contactway=contactway;
	}
	public void setschool(String school){
		this.school=school;
	}
	public void setauthority(boolean authority){
		this.authority=authority;
	}
}
