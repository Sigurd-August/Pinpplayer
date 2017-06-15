package com.pinp.service;

import com.pinp.dao.UserDao;
import com.pinp.dao.impl.UserDaoImpl;

import com.pinp.model.User;
import com.pinp.utils.AppException;

public class UserService {
	private UserDao userDao = null;
	
	public UserService(){
		userDao = new UserDaoImpl();
	}
	
	public boolean register(User user) throws AppException{
		boolean flag = false;//  Define flag 
		try {
			if (!userDao.isExist(user.getName())) {// Execute save operation when the user does not exist
				flag = userDao.add(user);// Return the operation result back to flag
			}
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("service.UserService.register");
		}
		return flag;
	}
	
	public int login(String name, String password) throws AppException {
		int userId = -1; // Declare userId
		try {
			//Get userId
			userId = userDao.login(name, password); 
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("service.UserService.login");
		}
		// Return userId
		return userId;
	}
	
	public int getRole(int userId) throws AppException{
		int type = -1;
		try{
			User user = new User("Mu","123456");
			user = userDao.getById(userId);
			type = user.getType();
		} catch(AppException e){
			e.printStackTrace();
			throw new AppException("service.UserService.getRole");
		}
		return type;
	}
}
