package com.chi.service;

import java.util.List;

import com.chi.film.Movie;

public interface SearchMovieService {
	public List<Movie> searchAll();
	public boolean minusNumber();
}
