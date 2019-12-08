package com.shourya.demo.core.service.Impl;

import com.shourya.demo.core.service.CityService;
import com.shourya.demo.model.City.CityDTO;
import com.shourya.demo.persistance.entity.CityToCityMapping;
import com.shourya.demo.persistance.repository.CityToCityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityToCityRepository cityToCityRepository;

    @Override
    public Collection<CityDTO> getCityDetails() {
       Collection<CityToCityMapping> cityToCityMappings= cityToCityRepository.findAll();
       Collection<CityDTO> cityDTOS=new ArrayList<>();

       for(CityToCityMapping cityToCityMapping:cityToCityMappings){
           CityDTO cityDTO=CityDTO.builder().
                   destinationCity(cityToCityMapping.getDestinationCity())
                   .sourceCity(cityToCityMapping.getSourceCity())
                   .date(cityToCityMapping.getDate())
                   .id(cityToCityMapping.getId()).build();
           cityDTOS.add(cityDTO);
       }

       return cityDTOS;
    }
}
