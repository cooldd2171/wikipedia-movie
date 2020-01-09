package com.shourya.demo.persistance.repository;

import com.shourya.demo.persistance.entity.User;

public  interface UserRepository extends BaseRepo<User,Integer> {

     User findByUserName(String userName);
     User findByUserNameAndPasswordAndDeleted(String userName, String password, byte deleted);
}
