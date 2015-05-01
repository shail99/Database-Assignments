package edu.neu.cs5200.assg4.ds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.neu.cs5200.assg4.ds.model.*;

public class UserManager {
	
		DataSource ds;
		
		public UserManager()
		{
			try{
				Context ctx = new InitialContext();
				ds = (DataSource)ctx.lookup("java:comp/env/jdbc/JDBCDataSource");
				System.out.println(ds);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		
		// a. create a User
		public void createUser(User newUser)
		{
			String sql = "insert into user values (?,?,?,?,?,?)";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, newUser.getUsername());
				statement.setString(2, newUser.getPassword());
				statement.setString(3, newUser.getFirstName());
				statement.setString(4, newUser.getLastName());
				statement.setString(5, newUser.getEmail());
				statement.setDate(6, newUser.getDateOfBirth());
				statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// b. retrieve all users
		public List<User> readAllUsers()
		{
			List<User> users = new ArrayList<User>();			
			String sql = "select * from user";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery();
				while(results.next())
				{
					User user = new User();
					user.setUsername(results.getString("username"));
					user.setPassword(results.getString("password"));
					user.setFirstName(results.getString("firstName"));
					user.setLastName(results.getString("lastName"));
					user.setEmail(results.getString("email"));
					user.setDateOfBirth(results.getDate(6));
					
					users.add(user);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return users;
		}
		
		// c. retrieve a particular user
		public User readUser(String username)
		{
			User user = new User();
			String sql = "select * from user where username = ?";
			
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, username);
				ResultSet result = statement.executeQuery();
				if(result.next())
				{
					user.setUsername(result.getString("username"));
					user.setPassword(result.getString("password"));
					user.setFirstName(result.getString("firstName"));
					user.setLastName(result.getString("lastName"));
					user.setEmail(result.getString("email"));
					user.setDateOfBirth(result.getDate(6));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return user;			
		}
		
		// d. update a particular user
		public void updateUser(String username, User user)
		{
			String sql = "update user set username = ?, password = ?, firstName = ?, lastName = ?, email = ?, dateOfBirth = ? where username = ?";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, user.getUsername());
				statement.setString(2, user.getPassword());
				statement.setString(3, user.getFirstName());
				statement.setString(4, user.getLastName());
				statement.setString(5, user.getEmail());
				statement.setDate(6, user.getDateOfBirth());
				statement.setString(7, username);
				
				statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// e. delete a particular User
		public void deleteUser(String username)
		{
			String sql = "delete from user where username = ?";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, username);
				statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
