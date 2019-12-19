package com.shourya.demo.core.covertor;

import com.shourya.demo.persistance.entity.User;
import com.shourya.demo.model.User.UserDTO;
import com.shourya.demo.persistance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class UserConverter implements convertor<User, UserDTO> {

    @Override
    public User convertToEntity(UserDTO model) {
        User user = new User();
        user.setId(model.getId());
        user.setUserName(model.getUserName());
        user.setCity(model.getCity());
        user.setEmail(model.getEmail());
        user.setContactNumber(new BigInteger(model.getContactNumber()));
        user.setDateOfBirth(model.getDateOfBirth());
        user.setName(model.getName());
        user.setGender(model.getGender());
        user.setPassword(model.getPassword());
        return user;
    }

    @Override
    public UserDTO convertToModel(User entity) {
        return UserDTO.builder()
                .contactNumber(String.valueOf(entity.getContactNumber()))
                .city(entity.getCity())
                .email(entity.getEmail())
                .dateOfBirth(entity.getDateOfBirth())
                .id(entity.getId())
                .name(entity.getName())
                .userName(entity.getUserName())
                .password(entity.getPassword()).build();
    }

}
