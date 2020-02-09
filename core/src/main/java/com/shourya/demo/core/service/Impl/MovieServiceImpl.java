package com.shourya.demo.core.service.Impl;

import com.shourya.demo.core.service.MovieService;
import com.shourya.demo.helper.helper.RestService;
import com.shourya.demo.helper.validator.MovieValidator;
import com.shourya.demo.model.Movie.MovieModel;
import com.shourya.demo.core.Transformer.MovieTransformer;
import com.shourya.demo.model.enums.MovieDataEnum;
import com.shourya.demo.persistance.document.Movie;
import com.shourya.demo.persistance.repository.MovieRepository;
import org.apache.commons.collections4.MapUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.util.*;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private RestService restService;
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Collection<String> getMetaData(Collection<String> movieNames) throws ParseException {
        MovieTransformer movieTransformer = new MovieTransformer();
        MovieValidator movieValidator = new MovieValidator();
        Collection<String> movies = new ArrayList<>();
        for (String movieName : movieNames) {
            String wikiData = restService.getData(movieName);
            Document doc = Jsoup.parse(wikiData);
            Map<String, String> processedData = processData(doc);
            if (MapUtils.isNotEmpty(processedData)) {
                if (movieValidator.validateData(processedData)) {
                    Movie movie = movieTransformer.transform(processedData, doc);
                    movie.setName(movieName);
                    movieRepository.save(movie);
                    movies.add(movieName);
                }
            }
        }
        return movies;
    }

    @Override
    public Collection<String> findAllMovieNames(Integer sortByTitle, Integer sortByDate) {
        List<Movie> movies = new ArrayList<>();

        if (Objects.nonNull(sortByDate)) {
            Sort.Direction dateSort = sortByDate == 1 ? Sort.Direction.ASC : Sort.Direction.DESC;
            movies = movieRepository.findAll(Sort.by(dateSort, "releaseDate"));
        } else if (Objects.nonNull(sortByTitle)) {
            Sort.Direction titleSort = sortByTitle == 1 ? Sort.Direction.ASC : Sort.Direction.DESC;
            movies = movieRepository.findAll(Sort.by(titleSort, "name"));
        } else {
            movies = movieRepository.findAll();
        }
        Collection<String> titles = new ArrayList<>();
        for (Movie movie : movies) {
            titles.add(movie.getName());
        }
        return titles;
    }

    @Override
    public MovieModel getData(String title) {
        return movieRepository.findByName(title);
    }


    private Map<String, String> processData(Document doc) {
        Collection<String> keys = Arrays.asList(
                MovieDataEnum.DIRECTED_BY.getValue(),
                MovieDataEnum.PRODUCED_BY.getValue(),
                MovieDataEnum.STARRING.getValue(),
                MovieDataEnum.MUSIC_BY.getValue(),
                MovieDataEnum.PRODUCTION_HOUSE.getValue(),
                MovieDataEnum.PRODUCTION_HOUSE_2.getValue(),
                MovieDataEnum.RELEASE_DATE.getValue(),
                MovieDataEnum.RUNNING_TIME.getValue(),
                MovieDataEnum.LANGUAGE.getValue(),
                MovieDataEnum.BUDGET.getValue(),
                MovieDataEnum.BOX_OFFICE.getValue());
        Map<String, String> map = new HashMap<>();
        if (CollectionUtils.isEmpty(doc.select("table"))) {
            return null;
        }
        Element table = doc.select("table").get(0);
        if (Objects.isNull(table.select("tr"))) {
            return null;
        }
        Elements rows = table.select("tr");
        for (Element row : rows) {
            Elements key = row.select("th");
            Elements values = row.select("td");
            if (!key.isEmpty() && keys.contains(key.get(0).text())) {
                String value = computeValue(values);
                map.put(key.get(0).text(), value);
            }
        }
        return map;
    }

    private String computeValue(Elements values) {
        String value = values.text();
        String[] chunks = value.split("\\s+");
        value = "";
        int i = 1;
        for (String chunk : chunks) {
            if (i % 2 == 0) {
                value += chunk + ",";
            } else {
                value += chunk + " ";
            }
            i++;
        }
        return value;
    }

}
