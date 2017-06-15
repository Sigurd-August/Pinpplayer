package com.pinp.model;

public class Music {
	private int id;
	private String name;
	private String path;
	private int del;
	
	public Music(String name,String path){
		this.name=name;
		this.path=path;
		del = 1;
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

	public String getPath() {
		return this.path;
	}

	public void setPath(String password) {
		this.path = password;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}
}
