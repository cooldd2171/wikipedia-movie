package com.example.my_project.core.covertor;

import com.example.my_project.entity.User;
import com.example.my_project.model.User.UserDTO;
import com.example.my_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserConvertor implements convertor<User, UserDTO> {

    @Autowired
    public UserRepository userRepository;

    @Override

    public User convertToEntity(UserDTO model) {

        User user = new User();
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
    public UserDTO convertToModel(User entity) {

        UserDTO userModel = new UserDTO();

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



}
