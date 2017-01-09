package com.chi.dao;

import java.util.List;

import com.chi.film.Movie;

public interface SearchMovieDao {
	public List<Movie> searchAll();
	public boolean minusNumber();
}
