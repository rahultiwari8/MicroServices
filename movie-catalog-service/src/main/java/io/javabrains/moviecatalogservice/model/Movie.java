package io.javabrains.moviecatalogservice.model;

public class Movie {
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	
	private String MovieId;
	private String MovieName;
	
	public Movie(String movieId, String movieName) {
		this.MovieId = movieId;
		this.MovieName = movieName;
	}
	
	
	public String getMovieId() {
		return MovieId;
	}
	public void setMovieId(String movieId) {
		MovieId = movieId;
	}
	public String getMovieName() {
		return MovieName;
	}
	public void setMovieName(String movieName) {
		MovieName = movieName;
	}
	
	
	

}
