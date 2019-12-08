package com.shourya.demo.persistance.repository;

import com.shourya.demo.persistance.entity.UserToFlightMap;

import java.util.Collection;

public interface UserToFlightRepository extends  BaseRepo<UserToFlightMap,Integer> {

    Collection<UserToFlightMap> findByUserId(Integer userId);
}
