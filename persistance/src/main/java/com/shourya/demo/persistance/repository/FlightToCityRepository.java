package com.shourya.demo.persistance.repository;

import com.shourya.demo.model.Flight.FlightToCityMappingDTO;
import com.shourya.demo.persistance.entity.FlightToCityMapping;

import java.util.Collection;

public interface FlightToCityRepository extends BaseRepo<FlightToCityMapping,Integer> {

    Collection<FlightToCityMapping> findByRefernceIdAndIsActive(Integer refernceId,Integer isActive);
    FlightToCityMapping findByFlightNumber(Integer connectedReference);
}
