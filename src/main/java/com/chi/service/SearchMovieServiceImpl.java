package com.chi.service;

import java.util.List;

import com.chi.dao.SearchMovieDao;
import com.chi.film.Movie;

public class SearchMovieServiceImpl implements SearchMovieService {
	private SearchMovieDao searchMovieDao;

	public SearchMovieDao getSearchMovieDao() {
		return searchMovieDao;
	}

	public void setSearchMovieDao(SearchMovieDao searchMovieDao) {
		this.searchMovieDao = searchMovieDao;
	}

	@Override
	public List<Movie> searchAll() {
		return searchMovieDao.searchAll();
	}

	@Override
	public boolean minusNumber() {
		// TODO Auto-generated method stub
		return searchMovieDao.minusNumber();
	}		

}
