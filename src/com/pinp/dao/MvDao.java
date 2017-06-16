package com.pinp.dao;

import java.util.List;

import com.pinp.model.Mv;
import com.pinp.utils.AppException;

public interface MvDao {
	public boolean isExist(String name) throws AppException;

	public Mv getById(int id) throws AppException;

	public List<Integer> getIds() throws AppException;
	/**get all of id of the mv which is not be deleted*/

	public List<Mv> getbynums(int num) throws AppException;
}
