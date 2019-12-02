package com.example.my_project.repository;


import com.example.my_project.entity.User;

public  interface UserRepository extends BaseRepo<User,Integer> {

     User findByIdAndDeleted(Integer id,Byte deleted);
}
