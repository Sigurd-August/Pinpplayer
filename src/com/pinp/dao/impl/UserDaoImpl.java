package com.pinp.dao.impl;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.pinp.dao.UserDao;
import com.pinp.model.User;
import com.pinp.utils.*;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean isExist(String name) throws AppException {
		Connection conn = null; // Define database connection object
		PreparedStatement psmt = null;// Define PreparedStatement object
		ResultSet rs = null;// Define ResultSet object

		boolean flag = false;// Operation flag
		try {
			conn = DBUtil.getConnection();// Create database connection
			// Declare operation statement, query records based on user name, "?" is a placeholder
			String sql = "select id from user where name = ? and del = 1";

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
	public boolean add(User user) throws AppException {
		System.out.println("addUser:"+user.getName());
		Connection conn = null; // Define database connection object
		PreparedStatement psmt = null;// Define PreparedStatement object
		
		boolean flag = false;// Operation flag
		int result = -1;
		try {
			conn = DBUtil.getConnection();// Create database connection
			// Declare operation statement,save user information into database, "?" is a placeholder
			String sql = "insert into user (name,password)"
					+ " values (?,?)";
			
			psmt = conn.prepareStatement(sql);// Pre-compiled sql
			// Set values for the placeholder 
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getPassword());

			result = psmt.executeUpdate();// Execute the update operation,return the affected rows
			if (result > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("impl.UserDaoImpl.add");
		} finally {
			DBUtil.closeStatement(psmt);//  Close database object pretreatment
			DBUtil.closeConnection(conn);// Close database connection object
		}
		return flag;
	}

	@Override
	public int login(String name, String password) throws AppException {
		int userId = -1; // Initialize userId
		//Declare database connection object, pre-compiled object and result set object
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		System.out.println(name+password);

		try {
			// Create database connection
			conn = DBUtil.getConnection();
			// Declare operation statement:query user id according to the user name and password , "?" is a placeholder
			String sql = "select id from user where name = ? and password = ? and del = 1";
			//  pre-compiled sql
			psmt = conn.prepareStatement(sql);
			// Set values for the placeholder
			psmt.setString(1, name);
			psmt.setString(2, password);
			// Execute the query operation
			rs = psmt.executeQuery();
			// Query record and get  user id
			System.out.println(name);
			System.out.println(password);
			if (rs.next()) {
				userId = rs.getInt("id");
				System.out.println(userId);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("impl.UserDaoImpl.login");
		} finally {
			// Close database object operation, release resources
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return userId;
	}

	@Override
	public User getById(int id) throws AppException {
		// Declare user object
				User user = null;
				//Declare database connection object, pre-compiled object and result set object
				Connection conn = null;
				PreparedStatement psmt = null;
				ResultSet rs = null;
				try {
					// Create database connection
					conn = DBUtil.getConnection();
					// Declare operation statement:query user information according to the user id , "?" is a placeholder
					String sql = "select id,name,password "
							+"from user "
							+"where id = ? and del = 1";
					// pre-compiled sql
					psmt = conn.prepareStatement(sql);
					// Set values for the placeholder
					psmt.setInt(1, id);
					// Query resultSet
					rs = psmt.executeQuery();
					
					// Save user information in Pole entity object when queried out resultSet
					if (rs.next()) {
						user = new User(); // Instantiate user objects
						// Set value to user object
						user.setId(rs.getInt("id"));
						user.setName(rs.getString("name"));
						user.setPassword(rs.getString("password"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new AppException("com.ruanko.dao.impl.UserDaoImpl.getById");
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
		// Initialiaze ids
				List<Integer> ids = new ArrayList<Integer>();
				
				//Declare Connection object,PreparedStatement object and ResultSet object
				Connection conn = null;
				PreparedStatement psmt = null;
				ResultSet rs = null;
				
				try {
					// Create database connection
					conn = DBUtil.getConnection();
					// Declare operation statement:query user id set,"?" is a placeholder
					String sql = "select id from user where del = 1";
					
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

	@SuppressWarnings("resource")
	@Override
	public boolean setUserDel(int user_id) throws AppException {
		boolean flag = false;// Operation flag
		// Declare database connection object, pre-compiled object
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			// Create database connection
			conn = DBUtil.getConnection();
			// Declare sql:update contract information according to contract id
			String sql = "update t_user set del = 1 where id = ?";
			// Pre-compiled sql, and set the parameter values
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, user_id);

			// Execute update,return affected rows
			flag = psmt.execute();
			
			if (flag == true) {// If affected lines greater than 0, so update success
				String content = "User " + user_id + " update data in t_user";
				String sql5 = "insert into t_log(time,content)values(?,?,?)";
				psmt = conn.prepareStatement(sql5); // pre-compiled sql
				SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd   hh:mm:ss");   
				String date = sDateFormat.format(new java.util.Date());  
				psmt.setInt(1, user_id);
				psmt.setString(2, date);
				psmt.setString(3, content);
				psmt.executeUpdate();
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("dao.impl.ContractDaoImpl.updateById");
		} finally {
			// Close database operation object
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}
}
