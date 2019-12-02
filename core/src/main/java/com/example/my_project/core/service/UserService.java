package com.example.my_project.core.service;

import com.example.my_project.helper.error.ApiException;
import com.example.my_project.model.User.UserDTO;

public interface UserService {
    UserDTO getUserDetailsById(Integer id) throws ApiException;

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(UserDTO userDTO) throws ApiException;
}
