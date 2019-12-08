package com.shourya.demo.core.controller;

import com.shourya.demo.core.service.CityService;
import com.shourya.demo.helper.error.ApiException;
import com.shourya.demo.model.ApiResponse;
import com.shourya.demo.model.City.CityDTO;
import com.shourya.demo.model.User.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "city/")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("get")
    public ApiResponse<Collection<CityDTO>> getCityDetails() throws ApiException {
        return new ApiResponse<>(cityService.getCityDetails());
    }

}
