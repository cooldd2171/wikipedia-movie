package com.shourya.demo.model.Flight;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class BookFlight {

    private Integer userId;
    private Integer flightId;
    private Integer status;
    private Object details;
    private Integer price;
    private String date;


}
