package edu.neu.cs5200.assg4.ds.model;

import java.sql.Date;

public class Comment {
	private String id;
	private String username;
	private String movieId;
	private String comment;
	private Date date;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Comment(String username, String movieId, String comment, Date date) {
		super();
		this.username = username;
		this.movieId = movieId;
		this.comment = comment;
		this.date = date;
	}
	public Comment() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
