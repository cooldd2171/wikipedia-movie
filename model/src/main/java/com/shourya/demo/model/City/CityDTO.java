package com.shourya.demo.model.City;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityDTO {
    private Integer id;
    private String sourceCity;
    private String destinationCity;
    private Integer deleted;
    private Date date;


}
