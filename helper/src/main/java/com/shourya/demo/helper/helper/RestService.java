package com.shourya.demo.helper.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.shourya.demo.model.Movie.Data;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class RestService {
    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getData(String movieName) {
        String json = restTemplate.getForObject("https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page="+movieName, String.class);
        String apiData= "";
        try {
            JSONObject jsonObject=new JSONObject(json);
            Object data=jsonObject.getJSONObject("parse").getJSONObject("text").get("*");
            apiData=data.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return apiData;
    }
}
