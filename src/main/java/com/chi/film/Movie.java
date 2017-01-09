package com.chi.film;

/**
 * Movie entity. @author MyEclipse Persistence Tools
 */

public class Movie implements java.io.Serializable {

	// Fields

	private Integer id;
	private String movieName;
	private Integer movieNumber;

	// Constructors

	/** default constructor */
	public Movie() {
	}

	/** full constructor */
	public Movie(Integer id, String movieName, Integer movieNumber) {
		this.id = id;
		this.movieName = movieName;
		this.movieNumber = movieNumber;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMovieName() {
		return this.movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Integer getMovieNumber() {
		return this.movieNumber;
	}

	public void setMovieNumber(Integer movieNumber) {
		this.movieNumber = movieNumber;
	}

}