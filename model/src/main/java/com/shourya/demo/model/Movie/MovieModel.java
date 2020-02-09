package com.shourya.demo.model.Movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieModel {
    private String name;
    private String director;
    private String producer;
    private String actors;
    private String musicComposer;
    private String productionHouse;
    private Date releaseDate;
    private String duration;
    private String language;
    private String budget;
    private String boxOfficeCollection;
    private String description;
}
