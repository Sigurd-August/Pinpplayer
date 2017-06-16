package com.pinp.dao;

import java.util.List;

import com.pinp.model.Music;
import com.pinp.utils.AppException;

public interface MusicDao {
	public boolean isExist(String name) throws AppException;

	public Music getById(int id) throws AppException;

	public List<Integer> getIds() throws AppException;
	/**get all of id of the mv which is not be deleted*/

	public List<Music> getbynums(int num) throws AppException;
	
	public boolean addMusic(List<Music> mList) throws AppException;
}
