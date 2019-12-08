package com.shourya.demo.core.controller;

import com.shourya.demo.core.service.LuggageService;
import com.shourya.demo.helper.error.ApiException;
import com.shourya.demo.model.ApiResponse;
import com.shourya.demo.model.Flight.BookFlight;
import com.shourya.demo.model.Luggage.LuggageDTO;
import com.shourya.demo.persistance.entity.UserToLuggageMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "luggage/")
public class LuggageController {


    @Autowired
    private LuggageService luggageService;

    @PostMapping("book")
    public ApiResponse<Collection<LuggageDTO>> bookLuggage(@RequestBody Collection<LuggageDTO> luggageDTO) throws ApiException {
        return new ApiResponse<>(luggageService.bookLuggage(luggageDTO));
    }


    @GetMapping("userId")
    public ApiResponse<Collection<LuggageDTO>> findLuggage(@RequestParam("id") Integer userId) throws ApiException {
        return new ApiResponse<>(luggageService.findLuggageForUser(userId));
    }
}
