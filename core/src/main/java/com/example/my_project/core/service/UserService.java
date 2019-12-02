package com.example.my_project.core.service;

import com.example.my_project.core.covertor.UserConvertor;
import com.example.my_project.entity.User;
import com.example.my_project.helper.error.ApiException;
import com.example.my_project.helper.error.ErrorCode;
import com.example.my_project.model.User.UserDTO;
import com.example.my_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

//comment

@Service

public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    public UserConvertor userConvertor;

    public UserDTO getUserDetailsByEmail(String email) throws ApiException {

        User user = userRepository.findByEmail(email);
        if (Objects.isNull(user))
            throw new ApiException(ErrorCode.USER_NOT_FOUND);

        return userConvertor.convertToModel(user);

    }

    public UserDTO getUserDetailsById(int id) throws ApiException {

        User user = userRepository.findById(id);
        if (Objects.isNull(user))
            throw new ApiException(ErrorCode.USER_NOT_FOUND);

        return userConvertor.convertToModel(user);

    }

    @Transactional
    public UserDTO createUser(UserDTO userDTO) {

        User user = userConvertor.convertToEntity(userDTO);
        user.setCreated_by(1);
        user.setUpdated_by(1);
        user.setActive(true);
        user = userRepository.save(user);
        return userConvertor.convertToModel(user);


    }

    public UserDTO updateUser(UserDTO userDTO) throws ApiException {

        User user = userRepository.findById(userDTO.getId()).orElse(null);

        if (Objects.isNull(user))
            throw new ApiException(ErrorCode.USER_NOT_FOUND);

        return null;
    }


}
