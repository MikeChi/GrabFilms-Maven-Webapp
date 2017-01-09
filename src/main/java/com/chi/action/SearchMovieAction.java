package com.chi.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chi.film.Movie;
import com.chi.util.SimpleMailSender;
import com.chi.service.SearchMovieService;
import com.chi.util.Struts2Utils;

public class SearchMovieAction {
	private Map<String, Object> result = new HashMap<String, Object>();
	private SearchMovieService searchMovieService;

	public SearchMovieService getSearchMovieService() {
		return searchMovieService;
	}

	public void setSearchMovieService(SearchMovieService searchMovieService) {
		this.searchMovieService = searchMovieService;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public String searchAll() {
		List<Movie> list = null;
		list = searchMovieService.searchAll();
		result.put("list", list);

		return "JSONRESULT";
	}
	
	public String minusNumber(){
		String mailAddress = Struts2Utils.getHttpServletRequest().getParameter("mailAddress");
		boolean flag = searchMovieService.minusNumber();
		if(flag){
			SimpleMailSender.send("mikechi2016@163.com", "czc1491625",
					mailAddress,"您的购票信息","您已购票");
		}
		result.put("falg", flag);
		return "JSONRESULT";
	}
}
