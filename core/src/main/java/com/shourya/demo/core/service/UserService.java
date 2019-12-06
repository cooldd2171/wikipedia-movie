package com.shourya.demo.core.service;

import com.shourya.demo.helper.error.ApiException;
import com.shourya.demo.model.User.UserDTO;

public interface UserService {
    UserDTO getUserDetailsById(Integer id) throws ApiException;
    UserDTO createUser(UserDTO userDTO) throws ApiException;
    UserDTO updateUser(UserDTO userDTO) throws ApiException;
}
