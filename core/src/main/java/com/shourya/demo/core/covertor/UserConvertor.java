package com.shourya.demo.core.covertor;

import com.shourya.demo.persistance.entity.User;
import com.shourya.demo.model.User.UserDTO;
import com.shourya.demo.persistance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserConvertor implements convertor<User, UserDTO> {

    @Autowired
    public UserRepository userRepository;

    @Override

    public User convertToEntity(UserDTO model) {
        User user = new User();
        user.setId(model.getId());
        user.setUserName(model.getUserName());
        user.setCity(model.getCity());
        user.setEmail(model.getEmail());
        user.setContactNumber(model.getContactNumber());
        user.setDateOfBirth(model.getDateOfBirth());
        user.setName(model.getName());
        user.setGender(model.getGender());
        user.setPassword(model.getPassword());
        return user;
    }

    @Override
    public UserDTO convertToModel(User entity) {
        return UserDTO.builder()
                .contactNumber(entity.getContactNumber())
                .city(entity.getCity())
                .email(entity.getEmail())
                .dateOfBirth(entity.getDateOfBirth())
                .id(entity.getId())
                .name(entity.getName())
                .password(entity.getPassword()).build();
    }



}
