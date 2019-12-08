package com.shourya.demo.core.controller;

import com.shourya.demo.core.service.FlightService;
import com.shourya.demo.helper.error.ApiException;
import com.shourya.demo.model.ApiResponse;
import com.shourya.demo.model.Flight.BookFlight;
import com.shourya.demo.model.Flight.FlightToCityMappingDTO;
import com.shourya.demo.model.User.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "flight/")
public class FlightController {

    @Autowired
    private FlightService flightService;


    @GetMapping("get")
    public ApiResponse<Collection<FlightToCityMappingDTO>> getUser(@RequestParam(value="referenceId")Integer referenceId) throws ApiException {
        return new ApiResponse<>(flightService.findByReferenceId(referenceId));
    }

    @PostMapping("book")
    public ApiResponse<BookFlight> bookFlight(@RequestBody BookFlight bookFlight) throws ApiException {
        return new ApiResponse<>(flightService.bookFlight(bookFlight));
    }






}
