package com.shourya.demo.helper.validator;

import com.shourya.demo.model.enums.MovieDataEnum;

import java.util.Map;
import java.util.Objects;

public class MovieValidator {
    public boolean validateData(Map<String, String> processedData) {
        if (Objects.isNull(processedData.get(MovieDataEnum.DIRECTED_BY.getValue()))) {
            return false;
        }
        if (Objects.isNull(processedData.get(MovieDataEnum.PRODUCED_BY.getValue()))) {
            return false;
        }
        if (Objects.isNull(processedData.get(MovieDataEnum.PRODUCTION_HOUSE.getValue())) &&
                Objects.isNull(processedData.get(MovieDataEnum.PRODUCTION_HOUSE_2.getValue()))) {
            return false;
        }
        if (Objects.isNull(processedData.get(MovieDataEnum.MUSIC_BY.getValue()))) {
            return false;
        }
        if (Objects.isNull(processedData.get(MovieDataEnum.STARRING.getValue()))) {
            return false;
        }
        if (Objects.isNull(processedData.get(MovieDataEnum.RUNNING_TIME.getValue()))) {
            return false;
        }
        if (Objects.isNull(processedData.get(MovieDataEnum.LANGUAGE.getValue()))) {
            return false;
        }
        if (Objects.isNull(processedData.get(MovieDataEnum.BUDGET.getValue()))) {
            return false;
        }
        if (Objects.isNull(processedData.get(MovieDataEnum.BOX_OFFICE.getValue()))) {
            return false;
        }

        return true;
    }
}
