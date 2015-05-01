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

public class CommentManager {

	DataSource ds;
	
	public CommentManager()
	{
		try{
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/JDBCDataSource");
			System.out.println(ds);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// a. create a comment
	public void createComment(Comment newComment)
	{
		String sql = "insert into comment values (?,?,?,?,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newComment.getId());
			statement.setString(2, newComment.getUsername());
			statement.setString(3, newComment.getMovieId());
			statement.setString(4, newComment.getComment());
			statement.setDate(5, newComment.getDate());
	
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// b. retrieve all comments
	public List<Comment> readAllComments()
	{
		List<Comment> comments = new ArrayList<Comment>();			
		String sql = "select * from comment";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Comment comment = new Comment();
				comment.setId(results.getString("id"));
				comment.setUsername(results.getString("username"));
				comment.setMovieId(results.getString("movieId"));
				comment.setComment(results.getString("comment"));
				comment.setDate(results.getDate("date"));
				
				comments.add(comment);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comments;
	}
	
	// c. read all comments for username
	public List<Comment> readAllCommentsForUsername(String username)
	{
		List<Comment> comments = new ArrayList<Comment>();			
		String sql = "select * from comment where username = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Comment comment = new Comment();
				comment.setId(results.getString("id"));
				comment.setUsername(results.getString("username"));
				comment.setMovieId(results.getString("movieId"));
				comment.setComment(results.getString("comment"));
				comment.setDate(results.getDate("date"));
				
				comments.add(comment);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comments;
	}
	
	// d. read all comments for movie
		public List<Comment> readAllCommentsForMovie(String movieId)
		{
			List<Comment> comments = new ArrayList<Comment>();			
			String sql = "select * from comment where movieId = ?";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, movieId);
				ResultSet results = statement.executeQuery();
				while(results.next())
				{
					Comment comment = new Comment();
					comment.setId(results.getString("id"));
					comment.setUsername(results.getString("username"));
					comment.setMovieId(results.getString("movieId"));
					comment.setComment(results.getString("comment"));
					comment.setDate(results.getDate("date"));
					
					comments.add(comment);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return comments;
		}
		
	
	//e.  retrieve a particular comment by id
	public Comment readCommentForId(String commentId)
	{
		Comment comment = new Comment();
		String sql = "select * from comment where id = ?";
		
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, commentId);
			ResultSet result = statement.executeQuery();
			if(result.next())
			{
				comment.setId(result.getString("id"));
				comment.setUsername(result.getString("username"));
				comment.setMovieId(result.getString("movieId"));
				comment.setComment(result.getString("comment"));
				comment.setDate(result.getDate("date"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return comment;			
	}
	
	// f. update a particular comment
	public void updateComment(String commentId, String newComment)
	{
		String sql = "update comment set comment = ? where id = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newComment);
			statement.setString(2, commentId);
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// g. delete a particular Comment
	public void deleteComment(String commentId)
	{
		String sql = "delete from comment where id = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, commentId);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
