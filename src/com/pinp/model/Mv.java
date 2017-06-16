package com.pinp.model;

public class Mv {
	private int id;
	private String name;
	private int del;
	
	public Mv(String name){
		this.name=name;
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

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}
}
