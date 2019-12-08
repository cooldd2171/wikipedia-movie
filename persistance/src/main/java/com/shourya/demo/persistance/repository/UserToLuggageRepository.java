package com.shourya.demo.persistance.repository;

import com.shourya.demo.persistance.entity.UserToLuggageMap;

import java.util.Collection;

public interface UserToLuggageRepository extends BaseRepo<UserToLuggageMap,Integer> {

    Collection<UserToLuggageMap> findByUserId(Integer userId);
}
