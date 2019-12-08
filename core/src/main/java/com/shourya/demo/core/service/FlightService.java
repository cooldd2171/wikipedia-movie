package com.shourya.demo.core.service;

import com.shourya.demo.model.Flight.BookFlight;
import com.shourya.demo.model.Flight.FlightToCityMappingDTO;

import java.util.Collection;

public interface FlightService {

    Collection<FlightToCityMappingDTO> findByReferenceId(Integer referenceId);

    BookFlight bookFlight(BookFlight bookFlight);
}
