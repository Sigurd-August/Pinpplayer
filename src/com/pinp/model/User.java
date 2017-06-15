package com.pinp.model;

public class User {
	private int id;
	private String name;		//User name
	private String password;	//Password
	private int del;            //0 - deleted 1 - not
	private int type;           //0 - user    1 - admin
	
	public User(String name,String password){
		this.name=name;
		this.password=password;
		del = 1;
		this.type = 0;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getType(){
		return type;
	}
	public void setType(int type){
		this.type = type;
	}
	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}
}
