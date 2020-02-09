package com.shourya.demo.persistance.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Movie")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie extends BaseDocumentStringID {
    private String title;
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
