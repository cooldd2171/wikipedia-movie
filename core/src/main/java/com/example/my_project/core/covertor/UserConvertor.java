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

        UserDTO userDTO= UserDTO.builder()
                .contact_no(entity.getContact_no())
                .city(entity.getCity())
                .email(entity.getEmail())
                .dob(entity.getDob())
                .id(entity.getId())
                .name(entity.getName())
                .password(entity.getPassword()).build();

        return userDTO;
    }



}
