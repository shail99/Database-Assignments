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

public class CastManager {

	DataSource ds;
	
	public CastManager()
	{
		try{
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/JDBCDataSource");
			System.out.println(ds);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// a. create a cast
	public void createCast(Cast newCast)
	{
		String sql = "insert into cast values (?,?,?,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newCast.getId());
			statement.setString(2, newCast.getMovieId());
			statement.setString(3, newCast.getActorId());
			statement.setString(4, newCast.getCharacterName());
	
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// b. retrieve all casts
	public List<Cast> readAllCast()
	{
		List<Cast> casts = new ArrayList<Cast>();			
		String sql = "select * from cast";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Cast cast = new Cast();
				cast.setId(results.getString("id"));
				cast.setMovieId(results.getString("movId"));
				cast.setActorId(results.getString("actorId"));
				cast.setCharacterName(results.getString("characterName"));
				
				casts.add(cast);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return casts;
	}
	
	// c. read all casts for actor
	public List<Cast> readAllCastForActor(String actorId)
	{
		List<Cast> casts = new ArrayList<Cast>();			
		String sql = "select * from cast where actorId = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, actorId);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Cast cast = new Cast();
				cast.setId(results.getString("id"));
				cast.setMovieId(results.getString("movId"));
				cast.setActorId(results.getString("actorId"));
				cast.setCharacterName(results.getString("characterName"));
				
				casts.add(cast);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return casts;
	}
	
	// d. read all casts for movie
		public List<Cast> readAllCastForMovie(String movieId)
		{
			List<Cast> casts = new ArrayList<Cast>();			
			String sql = "select * from cast where movId = ?";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, movieId);
				ResultSet results = statement.executeQuery();
				while(results.next())
				{
					Cast cast = new Cast();
					cast.setId(results.getString("id"));
					cast.setMovieId(results.getString("movId"));
					cast.setActorId(results.getString("actorId"));
					cast.setCharacterName(results.getString("characterName"));
					
					casts.add(cast);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return casts;
		}
		
	
	//e.  retrieve a particular cast by id
	public Cast readCastForId(String castId)
	{
		Cast cast = new Cast();
		String sql = "select * from cast where id = ?";
		
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, castId);
			ResultSet result = statement.executeQuery();
			if(result.next())
			{
				cast.setId(result.getString("id"));
				cast.setMovieId(result.getString("movId"));
				cast.setActorId(result.getString("actorId"));
				cast.setCharacterName(result.getString("characterName"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cast;			
	}
	
	// f. update a particular cast
	public void updateCast(String castId, Cast newCast)
	{
		String sql = "update cast set id = ?, movId = ?, actorId = ?, characterName = ? where id = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newCast.getId());
			statement.setString(2, newCast.getMovieId());
			statement.setString(3, newCast.getActorId());
			statement.setString(4, newCast.getCharacterName());
			statement.setString(5, castId);
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// g. delete a particular Cast
	public void deleteCast(String castId)
	{
		String sql = "delete from cast where id = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, castId);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
