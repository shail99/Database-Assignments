<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="edu.neu.cs5200.assg4.ds.dao.*,edu.neu.cs5200.assg4.ds.model.*,java.text.SimpleDateFormat,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World</h1>
	
	<%
	
		SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
		Date parsed = ft.parse("04/11/1989");
		java.sql.Date data = new java.sql.Date(parsed.getTime());
		//UserManager userDAO = new UserManager();
		//MovieManager movieDAO = new MovieManager();
		//ActorManager actorDAO = new ActorManager();
		//CommentManager commentDAO = new CommentManager();
		CastManager castDAO = new CastManager();
		/* Create user from jsp
		User user = new User ();
		user.setUsername("rama2312");
		user.setPassword("def@123");
		user.setFirstName("Rama");
		user.setLastName("Iyer");
		user.setEmail("ramaiyer@gmail.com");
		user.setDateOfBirth(data);
		
		userDAO.createUser(user); */
	
		/* Create movie from jsp	
		Movie movie = new Movie ();
		movie.setId("o11");
		movie.setTitle("Oceans Eleven");
		movie.setPosterImage("They are back");
		movie.setReleaseDate(data);
		
		movieDAO.createMovie(movie); */
		
		/* Create actor from jsp 	
		Actor actor = new Actor();
		actor.setId("a1");
		actor.setFirstName("John");
		actor.setLastName("Travolta");
		actor.setDateOfBirth("23 Oct 1959");
		
		actorDAO.createActor(actor);
		
		actor.setId("a2");
		actor.setFirstName("Shahrukh");
		actor.setLastName("Khan");
		actor.setDateOfBirth("21 Sept 1969");
		
		actorDAO.createActor(actor);
		
		actor.setId("a3");
		actor.setFirstName("Brad");
		actor.setLastName("Pitt");
		actor.setDateOfBirth("13 Apr 1965");
		
		actorDAO.createActor(actor);

		*/
		
		/* Create comments from jsp 	
		Comment comment = new Comment ();
		comment.setId("c1");
		comment.setUsername("shail174");
		comment.setMovieId("t25");
		comment.setComment("Awesome Movie");
		comment.setDate(data);
		
		commentDAO.createComment(comment); 
		
		comment.setId("c2");
		comment.setUsername("shail174");
		comment.setMovieId("t25");
		comment.setComment("Fabulous performance by Brad Pitt");
		comment.setDate(data);
		
		commentDAO.createComment(comment); 
*/

	/* Create cast from jsp 	
	Cast cast = new Cast();
	cast.setId("ca1");
	cast.setMovieId("t25");
	cast.setActorId("a3");
	cast.setCharacterName("Achillies");

	castDAO.createCast(cast);

	cast.setId("ca2");
	cast.setMovieId("t25");
	cast.setActorId("a4");
	cast.setCharacterName("Bob");

	castDAO.createCast(cast);

	cast.setId("ca3");
	cast.setMovieId("t26");
	cast.setActorId("a3");
	cast.setCharacterName("robert");

	castDAO.createCast(cast);
*/
		
	/*	
		Read all users from jsp
		List<User> users = userDAO.readAllUsers();
		for(User u : users)
		{
			out.println(u.getUsername());
			out.println(u.getPassword());
			out.println(u.getFirstName());
			out.println(u.getLastName());
			out.println(u.getEmail());
			out.println(u.getDateOfBirth());
		} 
		
		*/
		
		//Read all movies from jsp
		/*
		List<Movie> movies = movieDAO.readAllMovies();
		for(Movie m : movies)
		{
			out.println(m.getId());
			out.println(m.getTitle());
			out.println(m.getPosterImage());
			out.println(m.getReleaseDate());
			
		} 
		*/
		
		/* Read all actors from jsp 
		List<Actor> actors = actorDAO.readAllActors();
		for(Actor a : actors)
		{
			out.println(a.getId());
			out.println(a.getFirstName());
			out.println(a.getLastName());
			out.println(a.getDateOfBirth());
			
		} */
		
		/*	
		Read all comments from jsp 
		List<Comment> comments = commentDAO.readAllComments();
		for(Comment c : comments)
		{
			out.println(c.getId());
			out.println(c.getUsername());
			out.println(c.getMovieId());
			out.println(c.getComment());
			out.println(c.getDate());
		} 
		*/
	
		/*	
		Read all casts from jsp 
		List<Cast> casts = castDAO.readAllCast();
		for(Cast c : casts)
		{
			out.println(c.getId());
			out.println(c.getMovieId());
			out.println(c.getActorId());
			out.println(c.getCharacterName());
		} 
		
		*/
		/*	
		Read all comments from jsp for username 
		List<Comment> comments = commentDAO.readAllCommentsForUsername("shail174");
		for(Comment c : comments)
		{
			out.println(c.getId());
			out.println(c.getUsername());
			out.println(c.getMovieId());
			out.println(c.getComment());
			out.println(c.getDate());
		} 
		*/
		
		/*	
		Read all casts from jsp for actor 
		 
		List<Cast> casts = castDAO.readAllCastForActor("a3");
		for(Cast c : casts)
		{
			out.println(c.getId());
			out.println(c.getMovieId());
			out.println(c.getActorId());
			out.println(c.getCharacterName());
		} 
		*/
		
		/*	
		Read all comments from jsp for movieId 
		List<Comment> comments = commentDAO.readAllCommentsForMovie("t26");
		for(Comment c : comments)
		{
			out.println(c.getId());
			out.println(c.getUsername());
			out.println(c.getMovieId());
			out.println(c.getComment());
			out.println(c.getDate());
		}
		*/
		
		/*	
		Read all casts from jsp for movieId 
	
		List<Cast> casts = castDAO.readAllCastForMovie("t26");
		for(Cast c : casts)
		{
			out.println(c.getId());
			out.println(c.getMovieId());
			out.println(c.getActorId());
			out.println(c.getCharacterName());
		}
		*/
		
		/*
		Read a particular user
		User u = userDAO.readUser("shail174");
		out.println(u.getUsername());
		out.println(u.getPassword());
		out.println(u.getFirstName());
		out.println(u.getLastName());
		out.println(u.getEmail());
		out.println(u.getDateOfBirth());*/
		
		/*
		
		/* Read a particular movie 
		Movie m = movieDAO.readMovie("o11");
		out.println(m.getId());
		out.println(m.getTitle());
		out.println(m.getPosterImage());
		out.println(m.getReleaseDate());
		*/
		
		/* Read a particular actor  
		Actor a = actorDAO.readActor("a1");
		out.println(a.getId());
		out.println(a.getFirstName());
		out.println(a.getLastName());
		out.println(a.getDateOfBirth());
		*/
		
		/* Read a particular comment 
		Comment c = commentDAO.readComment("c1");
		out.println(c.getId());
		out.println(c.getUsername());
		out.println(c.getMovieId());
		out.println(c.getComment());
		out.println(c.getDate());
		*/
		
		/* Read a particular comment 
		Cast c = castDAO.readCastForId("ca1");
		out.println(c.getId());
		out.println(c.getMovieId());
		out.println(c.getActorId());
		out.println(c.getCharacterName());

		*/
		
		/*
		update a particular user
		
		User user = new User ();
		user.setUsername("rahul445");
		user.setPassword("ghi@123");
		user.setFirstName("Rahul");
		user.setLastName("Thakkar");
		user.setEmail("digitalrahul@gmail.com");
		user.setDateOfBirth(data);
		
		userDAO.updateUser("rama2312", user); */
		
		/* update a particular movie 
		
		Movie movie = new Movie ();
		movie.setId("t25");
		movie.setTitle("Troy");
		movie.setPosterImage("Achillies");
		movie.setReleaseDate(data);
		
		movieDAO.updateMovie("o11",movie); */
		
		/* update a particular actor 
		
		Actor actor = new Actor();
		actor.setId("a4");
		actor.setFirstName("Tom");
		actor.setLastName("Cruise");
		actor.setDateOfBirth("6 Apr 1966");
		actorDAO.updateActor("a1",actor); 
		*/
		
		
		/* update a particular comment */ 
		
	
		//commentDAO.updateComment("c1","Role of Achillies was awesome"); 
		
		
	/* 
	update a particular cast 
		
		Cast cast = new Cast();
		cast.setId("ca4");
		cast.setMovieId("t26");
		cast.setActorId("a4");
		cast.setCharacterName("Michael");
		
		castDAO.updateCast("ca1", cast);*/
		// delete a particular user
		//userDAO.deleteUser("rahul445");
		
		// delete a particular movie
		// movieDAO.deleteMovie("t12");
	
		//delete a particular actor
	 	//actorDAO.deleteActor("a2");
		
		//delete a particular comment
	  	//commentDAO.deleteComment("c2");
		
		//delete a particular cast
		//castDAO.deleteCast("ca5");
	%>
	
</body>
</html>