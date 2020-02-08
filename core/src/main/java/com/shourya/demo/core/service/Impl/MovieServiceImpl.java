package com.shourya.demo.core.service.Impl;

import com.shourya.demo.core.service.MovieService;
import com.shourya.demo.helper.helper.RestService;
import com.shourya.demo.model.enums.MovieDataEnum;
import com.shourya.demo.persistance.document.Movie;
import com.shourya.demo.persistance.repository.MovieRepository;
import org.apache.commons.collections4.MapUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private RestService restService;
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void getMetaData(Collection<String> movieNames) {

        for (String movieName : movieNames) {
            String wikiData = restService.getData(movieName);
            Document doc = Jsoup.parse(wikiData);
            Map<String, String> processedData = processData(doc);
            if (MapUtils.isNotEmpty(processedData)) {
                Movie movie = Movie.builder()
                        .name(movieName)
                        .director(processedData.get(MovieDataEnum.DIRECTED_BY.getValue()))
                        .producer(processedData.get(MovieDataEnum.PRODUCED_BY.getValue()))
                        .actors(processedData.get(MovieDataEnum.STARRING.getValue()))
                        .musicComposer(processedData.get(MovieDataEnum.MUSIC_BY.getValue()))
                        .productionHouse(Objects.nonNull(processedData.get(MovieDataEnum.PRODUCTION_HOUSE.getValue())) ? processedData.get(MovieDataEnum.PRODUCTION_HOUSE.getValue()) : processedData.get(MovieDataEnum.PRODUCTION_HOUSE_2.getValue()))
                        .releaseDate(this.computeReleaseDate(processedData.get(MovieDataEnum.RELEASE_DATE.getValue())))
                        .duration(processedData.get(MovieDataEnum.RUNNING_TIME.getValue()))
                        .language(processedData.get(MovieDataEnum.LANGUAGE.getValue()))
                        .budget(processedData.get((MovieDataEnum.BUDGET.getValue())))
                        .boxOfficeCollection(processedData.get(MovieDataEnum.BOX_OFFICE.getValue()))
                        .description(doc.select("p").get(1).text().toString())
                        .build();
                movieRepository.save(movie);
            }
        }
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

    private String computeReleaseDate(String release) {
        int l1 = release.indexOf("(");
        int l2 = release.indexOf(")");
        return release.substring(l1 + 1, l2);
    }
}
