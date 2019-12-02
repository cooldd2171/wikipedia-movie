package com.example.demo.covertor;

import com.example.demo.entity.User;
import com.example.demo.model.UserModel;
import com.example.demo.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserConvertor implements convertor<User, UserModel>
{

    @Autowired
    public userRepository ur;

    /*
    Only for new user
     */
    @Override
    public User convertToEntity(UserModel model) {

        User user=new User();
        user.setId(model.getId());
        user.setCity(model.getCity());

        user.setEmail(model.getEmail());
        user.setContact_no(model.getContact_no());
        user.setDob(model.getDob());
        user.setName(model.getName());
        user.setGender(model.getGender());
        user.setPassword(model.getPassword());

        return user;
    }

    @Override
    public UserModel converToModel(User entity) {

        UserModel userModel=new UserModel();

        userModel.setContact_no(entity.getContact_no());

        userModel.setEmail(entity.getEmail());
        userModel.setCity(entity.getCity());
        userModel.setDob(entity.getDob());
        userModel.setGender(entity.getGender());
        userModel.setId(entity.getId());
        userModel.setName(entity.getName());
        userModel.setPassword(entity.getPassword());


        return userModel;
    }


    public User merge(User entity, UserModel model) {


        if(model!=null&&entity!=null){
            if(model.getEmail()!=null&& !Objects.equals(model.getEmail(),entity.getEmail())){
                entity.setEmail(model.getEmail());
            }

            if(model.getGender()!=null&& !Objects.equals(model.getGender(),entity.getGender())){
                entity.setGender(model.getGender());
            }

            if(model.getContact_no()!=null&& !Objects.equals(model.getContact_no(),entity.getContact_no())){
                entity.setContact_no(model.getContact_no());
            }

            if(model.getCity()!=null&& !Objects.equals(model.getCity(),entity.getCity())){
                entity.setCity(model.getCity());
            }

            if(model.getName()!=null&& !Objects.equals(model.getName(),entity.getName())){
                entity.setName(model.getName());
            }

            if(model.getPassword()!=null&& !Objects.equals(model.getPassword(),entity.getPassword())){
                entity.setPassword(model.getPassword());
            }




        }








        return entity;
    }


}
