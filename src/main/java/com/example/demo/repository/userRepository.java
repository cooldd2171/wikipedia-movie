package com.example.demo.repository;


import com.example.demo.entity.User;


public  interface userRepository extends BaseRepo<User,Integer> {

     User findById(int id);

     User findByEmail(String email);




}
