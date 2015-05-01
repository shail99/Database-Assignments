package edu.neu.cs5200.assg4.ds.model;

public class Cast {
	private String id;
	private String movId;
	private String actorId;
	private String characterName;
	public String getMovieId() {
		return movId;
	}
	public void setMovieId(String movieId) {
		this.movId = movieId;
	}
	public String getActorId() {
		return actorId;
	}
	public void setActorId(String actorId) {
		this.actorId = actorId;
	}
	public String getCharacterName() {
		return characterName;
	}
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	public Cast(String movieId, String actorId, String characterName) {
		super();
		this.movId = movieId;
		this.actorId = actorId;
		this.characterName = characterName;
	}
	public Cast() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	
}
