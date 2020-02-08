package com.shourya.demo.core.controller;

import com.shourya.demo.core.service.MovieService;
import com.shourya.demo.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "movie/")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("meta")
    public ApiResponse getData(@RequestBody Collection<String> movieNames){
        movieService.getMetaData(movieNames);
        return null;
    }
}
