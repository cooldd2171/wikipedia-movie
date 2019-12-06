package com.shourya.demo.persistance.repository;


import com.shourya.demo.persistance.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

public  interface UserRepository extends BaseRepo<User,Integer> {

     User findByIdAndDeleted(Integer id,Byte deleted);
     User findByUserNameAndDeleted(String userName,byte deleted);
}
