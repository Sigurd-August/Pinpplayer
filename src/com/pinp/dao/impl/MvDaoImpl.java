package com.pinp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pinp.dao.MvDao;
import com.pinp.model.Mv;
import com.pinp.utils.AppException;
import com.pinp.utils.DBUtil;

public class MvDaoImpl implements MvDao{

	public boolean isExist(String name) throws AppException {
		Connection conn = null; // Define database connection object
		PreparedStatement psmt = null;// Define PreparedStatement object
		ResultSet rs = null;// Define ResultSet object

		boolean flag = false;// Operation flag
		try {
			conn = DBUtil.getConnection();// Create database connection
			// Declare operation statement, query records based on user name, "?" is a placeholder
			String sql = "select id from music where name = ? and del = 1";

			psmt = conn.prepareStatement(sql);//  Pre-compiled sql
			psmt.setString(1, name);// Set values for the placeholder 

			rs = psmt.executeQuery();// Execute the query, return the query results
			if (rs.next()) {// Determine whether there are values in results set
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(
					"UserDaoImpl.isExist");
		} finally {
			DBUtil.closeResultSet(rs);// Close database query result set
			DBUtil.closeStatement(psmt);//  Close database object pretreatment
			DBUtil.closeConnection(conn);// Close database connection object
		}
		return flag;
	}

	@Override
	public Mv getById(int id) throws AppException {
		Mv user = null;
		//Declare database connection object, pre-compiled object and result set object
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// Create database connection
			conn = DBUtil.getConnection();
			// Declare operation statement:query user information according to the user id , "?" is a placeholder
			String sql = "select id,name "
					+"from music "
					+"where id = ? and del = 1";
			// pre-compiled sql
			psmt = conn.prepareStatement(sql);
			// Set values for the placeholder
			psmt.setInt(1, id);
			// Query resultSet
			rs = psmt.executeQuery();
			
			// Save user information in Pole entity object when queried out resultSet
			if (rs.next()) {
				user = new Mv("unNamed"); // Instantiate user objects
				// Set value to user object
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.pinp.dao.impl.MusicDaoImpl.getById");
		} finally {
			// Close database object operation, release resources
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return user;
	}

	@Override
	public List<Integer> getIds() throws AppException {
		// Initialize id
		List<Integer> ids = new ArrayList<Integer>();
		
		//Declare Connection object,PreparedStatement object and ResultSet object
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			// Create database connection
			conn = DBUtil.getConnection();
			// Declare operation statement:query user id set,"?" is a placeholder
			String sql = "select id from music where del = 1";
			
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();// Return result set
			// Loop to get information in result set,and save in ids
			while (rs.next()) {
				ids.add(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(
					"dao.impl.UserDaoImpl.getIds");
		} finally {
			// Close database operation object, release resources
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return ids;
	}

	@Override
	public List<Mv> getbynums(int num) throws AppException {
		// Initialize id
				List<Mv> ids = new ArrayList<Mv>();
				
				//Declare Connection object,PreparedStatement object and ResultSet object
				Connection conn = null;
				PreparedStatement psmt = null;
				ResultSet rs = null;
				
				try {
					// Create database connection
					conn = DBUtil.getConnection();
					// Declare operation statement:query user id set,"?" is a placeholder
					String sql = "select id,name from mv where del = 1";
					
					psmt = conn.prepareStatement(sql);
					
					rs = psmt.executeQuery();// Return result set
					// Loop to get information in result set,and save in ids
					int i = 0;
					while (rs.next()) {
						Mv music = new Mv(rs.getString("name"));
						music.setId(rs.getInt("id"));
						ids.add(music);
						i++;
						if(i == num)
							break;
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new AppException(
							"dao.impl.MvDaoImpl.getIds");
				} finally {
					// Close database operation object, release resources
					DBUtil.closeResultSet(rs);
					DBUtil.closeStatement(psmt);
					DBUtil.closeConnection(conn);
				}
				return ids;
	}

	@Override
	public boolean addMv(List<Mv> mList) throws AppException {
		Connection conn = null; // Define database connection object
		PreparedStatement psmt = null;// Define PreparedStatement object
		
		boolean flag = false;// Operation flag
		int result = -1;
		try {
			conn = DBUtil.getConnection();// Create database connection
			// Declare operation statement,save user information into database, "?" is a placeholder
			for(Mv mbm: mList){
			String sql = "insert into mv (name)"
					+ " values (?)";
			
			psmt = conn.prepareStatement(sql);// Pre-compiled sql
			// Set values for the placeholder 
			psmt.setString(1, mbm.getName());

			result = psmt.executeUpdate();// Execute the update operation,return the affected rows
			}
			if (result > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("impl.MvDaoImpl.add");
		} finally {
			DBUtil.closeStatement(psmt);//  Close database object pretreatment
			DBUtil.closeConnection(conn);// Close database connection object
		}
		return flag;
	}
}
