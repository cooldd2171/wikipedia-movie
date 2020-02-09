package com.shourya.demo.core.Transformer;

import com.shourya.demo.helper.helper.CommonFunctions;
import com.shourya.demo.model.enums.MovieDataEnum;
import com.shourya.demo.persistance.document.Movie;
import org.jsoup.nodes.Document;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class MovieTransformer {
    public Movie transform(Map<String, String> processedData, Document document) throws ParseException {
        String date = this.computeReleaseDate(processedData.get(MovieDataEnum.RELEASE_DATE.getValue()));
        Date releaseDate = CommonFunctions.getDate(date);
        Movie movie = Movie.builder()
                .director(processedData.get(MovieDataEnum.DIRECTED_BY.getValue()))
                .producer(processedData.get(MovieDataEnum.PRODUCED_BY.getValue()))
                .actors(processedData.get(MovieDataEnum.STARRING.getValue()))
                .musicComposer(processedData.get(MovieDataEnum.MUSIC_BY.getValue()))
                .productionHouse(Objects.nonNull(processedData.get(MovieDataEnum.PRODUCTION_HOUSE.getValue())) ? processedData.get(MovieDataEnum.PRODUCTION_HOUSE.getValue()) : processedData.get(MovieDataEnum.PRODUCTION_HOUSE_2.getValue()))
                .releaseDate(releaseDate)
                .duration(processedData.get(MovieDataEnum.RUNNING_TIME.getValue()))
                .language(processedData.get(MovieDataEnum.LANGUAGE.getValue()))
                .budget(processedData.get((MovieDataEnum.BUDGET.getValue())))
                .boxOfficeCollection(processedData.get(MovieDataEnum.BOX_OFFICE.getValue()))
                .build();
        String description = getMovieDescription(document);

        movie.setDescription(description);
        return movie;
    }

    private String computeReleaseDate(String release) {
        if (Objects.nonNull(release)) {
            int l1 = release.indexOf("(");
            int l2 = release.indexOf(")");
            return release.substring(l1 + 1, l2);
        }
        return null;
    }

    private String getMovieDescription(Document document) {
        String description = "";

        for (int i = 0; i < document.select("p").size(); i++) {
            if (!document.select("p").get(i).text().isEmpty()) {
                description = document.select("p").get(i).text().toString();
                break;
            }
        }
        return description;
    }
}
