package com.shourya.demo.model.Flight;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightToCityMappingDTO {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private Integer refernceId;
    private Integer flightNumber;
    private Integer active;
    private Integer limit;
    private String startTime;
    private String endTime;
    private Integer duration;
    private Integer currentCount;
    private Integer connectedReference;
    private ConnectedFlight connectedFlight;
    private Integer price;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ConnectedFlight{
        private Integer flightNumber;
        private Integer duration;
        private String startTime;
        private String endTime;
    }


}
