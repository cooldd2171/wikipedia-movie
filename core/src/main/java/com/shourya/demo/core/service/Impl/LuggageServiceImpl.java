package com.shourya.demo.core.service.Impl;

import com.shourya.demo.core.service.LuggageService;
import com.shourya.demo.model.Luggage.LuggageDTO;
import com.shourya.demo.persistance.entity.Luggage;
import com.shourya.demo.persistance.entity.UserToLuggageMap;
import com.shourya.demo.persistance.repository.LuggageRepository;
import com.shourya.demo.persistance.repository.UserToLuggageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Service

public class LuggageServiceImpl implements LuggageService {

    @Autowired
    private UserToLuggageRepository userToLuggageRepository;

    @Autowired
    private LuggageRepository luggageRepository;

    @Override
    public java.util.Collection<LuggageDTO> bookLuggage(Collection<LuggageDTO> luggageDTO) {


        for (LuggageDTO luggageDTO1 : luggageDTO) {
            Luggage luggage = new Luggage();
            luggage.setName(luggageDTO1.getName());
            luggage.setDeleted(0);
            luggage = luggageRepository.save(luggage);
            luggageDTO1.setLuggageId(luggage.getId());

            UserToLuggageMap userToLuggageMap = new UserToLuggageMap();
            userToLuggageMap.setUserId(luggageDTO1.getUserId());
            userToLuggageMap.setLuggageId(luggageDTO1.getLuggageId());
            userToLuggageMap.setLuggagePoint("drop luggage at point A");
            userToLuggageMap.setStatus(0);
            userToLuggageMap.setTimeCaptured(String.valueOf(new Date()));
            userToLuggageRepository.save(userToLuggageMap);
        }

        return null;
    }

    @Override
    public Collection<LuggageDTO> findLuggageForUser(Integer userId) {

        Collection<LuggageDTO> luggageDTOS=new ArrayList<>();
        Collection<UserToLuggageMap> userToLuggageMaps = userToLuggageRepository.findByUserId(userId);

       for(UserToLuggageMap userToLuggageMap:userToLuggageMaps){
           Optional<Luggage> luggage=luggageRepository.findById(userToLuggageMap.getLuggageId());
           LuggageDTO luggageDTO = new LuggageDTO();
           luggageDTO.setLuggagePoint(userToLuggageMap.getLuggagePoint());
           luggageDTO.setName(luggage.get().getName());
           luggageDTO.setTimeCaptured(userToLuggageMap.getTimeCaptured());
           luggageDTOS.add(luggageDTO);
       }

        return luggageDTOS;
    }

}
