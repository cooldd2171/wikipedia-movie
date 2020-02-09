package com.shourya.demo.core.service;

import com.shourya.demo.helper.error.ApiException;
import com.shourya.demo.model.Movie.MovieModel;

import java.text.ParseException;
import java.util.Collection;

public interface MovieService {
    Collection<String> getMetaData(Collection<String> movieNames) throws ParseException;
    Collection<String> getAllMovieNames(Integer sortByTitle,Integer sortByDate);
    MovieModel getData(String title) throws ApiException;
}
