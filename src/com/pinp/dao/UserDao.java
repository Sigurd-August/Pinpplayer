package com.pinp.dao;

import java.util.List;

import com.pinp.model.User;
import com.pinp.utils.AppException;

/**
 * User Data Access Layer Interface
 */
public interface UserDao {
	
	public boolean isExist(String name) throws AppException;
	
	public boolean add(User user) throws AppException;
	
	public int login(String name,String password) throws AppException;
	
	public User getById(int id) throws AppException;
	
	public List<Integer> getIds() throws AppException;
	
	public boolean setUserDel(int user_id) throws AppException;
	
}