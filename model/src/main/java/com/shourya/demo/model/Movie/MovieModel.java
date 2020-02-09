package com.shourya.demo.model.Movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement
public class MovieModel {
    private String title;
    private String director;
    private String producer;
    private String actors;
    private String musicComposer;
    private String productionHouse;
    private String releaseDate;
    private String duration;
    private String language;
    private String budget;
    private String boxOfficeCollection;
    private String description;
}
