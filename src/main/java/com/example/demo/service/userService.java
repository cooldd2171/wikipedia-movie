package com.example.demo.service;

import com.example.demo.covertor.UserConvertor;
import com.example.demo.entity.User;
import com.example.demo.error.ApiException;
import com.example.demo.error.ErrorCode;
import com.example.demo.model.UserModel;
import com.example.demo.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//comment

@Service

public class userService {

    @Autowired
    public userRepository ur;
    @Autowired
    public UserConvertor uc;


    public UserModel getUserDetailsByEmail(String email) throws ApiException {



         User user= ur.findByEmail(email);

        if(user==null)
            throw  new ApiException(ErrorCode.USER_NOT_FOUND);



        return uc.converToModel(user);

    }

    public UserModel getUserDetailsById(int id) throws ApiException {



        User user1= ur.findById(id);

        if(user1==null)
            throw  new ApiException(ErrorCode.USER_NOT_FOUND);



        return uc.converToModel(user1);

    }


    public UserModel createUser(UserModel userModel){

        User user=uc.convertToEntity(userModel);



        user.setCreated_by(1);
        user.setUpdated_by(1);
        user.setActive(true);
        user=ur.save(user);


        return uc.converToModel(user);


    }

    public UserModel updateUser(UserModel userModel) throws ApiException {




        User user=ur.findById(userModel.getId()).orElse(null);

        if(user==null){
            throw new ApiException(ErrorCode.USER_NOT_FOUND);
        }

        User persist=uc.merge(user,userModel);



        user.setUpdated_by(1);
        user.setActive(true);
        user=ur.save(persist);


        return uc.converToModel(persist);


    }






}
