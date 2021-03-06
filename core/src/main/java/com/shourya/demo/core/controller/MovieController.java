package com.shourya.demo.core.controller;

import com.shourya.demo.core.service.MovieService;
import com.shourya.demo.helper.error.ApiException;
import com.shourya.demo.model.ApiResponse;
import com.shourya.demo.model.Movie.MovieModel;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Collection;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "movie/")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("meta")
    public ApiResponse getData(@RequestBody Collection<String> movieNames) throws ParseException {
        Collection<String> movies=movieService.getMetaData(movieNames);
        return new ApiResponse<>(movies);
    }
    @GetMapping("list")
    public ApiResponse getAllMoviesList(@Nullable @RequestParam("sortByTitle") Integer sortByTitle,
                                        @Nullable @RequestParam("sortByDate") Integer sortByDate){
        Collection<String> movieNames= movieService.getAllMovieNames(sortByTitle,sortByDate);
        return new ApiResponse<>(movieNames);
    }
    @GetMapping(path = "find",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ApiResponse findMovie(@RequestParam("title") String title) throws ApiException {
        MovieModel movie= movieService.getData(title);
        return new ApiResponse<>(movie);
    }
}
