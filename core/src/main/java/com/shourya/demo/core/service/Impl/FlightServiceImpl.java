package com.shourya.demo.core.service.Impl;

import com.shourya.demo.core.service.FlightService;
import com.shourya.demo.model.Flight.BookFlight;
import com.shourya.demo.model.Flight.ConnectedFlight;
import com.shourya.demo.model.Flight.FlightToCityMappingDTO;
import com.shourya.demo.persistance.entity.FlightToCityMapping;
import com.shourya.demo.persistance.entity.UserToFlightMap;
import com.shourya.demo.persistance.repository.FlightToCityRepository;
import com.shourya.demo.persistance.repository.UserToFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Service

public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightToCityRepository flightToCityRepository;

    @Autowired
    private UserToFlightRepository userToFlightRepository;



    @Override
    public Collection<FlightToCityMappingDTO> findByReferenceId(Integer referenceId) {

        Collection<FlightToCityMappingDTO> flightToCityMappingDTOS = new ArrayList<>();
        Collection<FlightToCityMapping> flightToCityMappings = flightToCityRepository.findByRefernceIdAndIsActive(referenceId, 1);

        for (FlightToCityMapping flightToCityMapping : flightToCityMappings) {
            if (flightToCityMapping.getIsActive() == 0) {
                continue;
            }

            if(Objects.nonNull(flightToCityMapping.getConnectedReference())){
                FlightToCityMapping flightToCityMapping1=flightToCityRepository.findByFlightNumber(flightToCityMapping.getConnectedReference());
                Integer duration=flightToCityMapping.getDuration()+flightToCityMapping1.getDuration();
                FlightToCityMappingDTO.ConnectedFlight connectedFlight=new FlightToCityMappingDTO.ConnectedFlight();
                connectedFlight.setFlightNumber(flightToCityMapping1.getFlightNumber());
                connectedFlight.setDuration(flightToCityMapping1.getDuration());
                connectedFlight.setStartTime(flightToCityMapping1.getStartTime());
                connectedFlight.setEndTime(flightToCityMapping1.getEndTime());

                FlightToCityMappingDTO flightToCityMappingDTO = FlightToCityMappingDTO.builder()
                        .flightNumber(flightToCityMapping.getFlightNumber())
                        .duration(duration)
                        .endTime(flightToCityMapping.getEndTime())
                        .refernceId(flightToCityMapping.getRefernceId())
                        .startTime(flightToCityMapping.getStartTime())
                        .price(flightToCityMapping.getPrice())
                        .build();
                flightToCityMappingDTOS.add(flightToCityMappingDTO);

            }
            else {
                FlightToCityMappingDTO flightToCityMappingDTO = FlightToCityMappingDTO.builder()
                        .flightNumber(flightToCityMapping.getFlightNumber())
                        .duration(flightToCityMapping.getDuration())
                        .endTime(flightToCityMapping.getEndTime())
                        .refernceId(flightToCityMapping.getRefernceId())
                        .startTime(flightToCityMapping.getStartTime())
                        .price(flightToCityMapping.getPrice())
                        .build();
                flightToCityMappingDTOS.add(flightToCityMappingDTO);
            }
        }
        return flightToCityMappingDTOS;
    }

    @Override
    public BookFlight bookFlight(BookFlight bookFlight) {

        FlightToCityMapping flightToCityMapping=flightToCityRepository.findByFlightNumber(bookFlight.getFlightId());
        int currentCount =bookFlight.getFlightId();
        currentCount++;
        flightToCityMapping.setCurrentCount(currentCount);
        flightToCityRepository.save(flightToCityMapping);


        UserToFlightMap userToFlightMap=new UserToFlightMap();
        userToFlightMap.setFlightId(bookFlight.getFlightId());
        userToFlightMap.setStatus(0);
        userToFlightMap.setUserId(bookFlight.getUserId());
        userToFlightMap.setPrice(bookFlight.getPrice());
        userToFlightMap.setDate(bookFlight.getDate());
        userToFlightMap.setDetails(String.valueOf(bookFlight.getDetails()));

        userToFlightRepository.save(userToFlightMap);


        return null;

    }
}
