package com.shourya.demo.persistance.repository;

import com.shourya.demo.model.Movie.MovieModel;
import com.shourya.demo.persistance.document.Movie;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
    MovieModel findByTitle(String name);
}
