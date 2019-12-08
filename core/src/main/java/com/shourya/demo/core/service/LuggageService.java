package com.shourya.demo.core.service;

import com.shourya.demo.model.Luggage.LuggageDTO;

import java.util.Collection;

public interface LuggageService {
    Collection<LuggageDTO> bookLuggage(Collection<LuggageDTO> luggageDTO);
    Collection<LuggageDTO> findLuggageForUser(Integer userId);
}
