package com.shourya.demo.model.Luggage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LuggageDTO {
    private String name;
    private Integer userId;
    private Integer luggageId;
    private String luggagePoint;
    private String timeCaptured;
}
