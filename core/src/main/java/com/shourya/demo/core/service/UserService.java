package com.shourya.demo.core.service;

import com.shourya.demo.helper.error.ApiException;
import com.shourya.demo.model.User.UserDTO;
import com.shourya.demo.model.User.UserModel;

public interface UserService {
    UserDTO getUserDetailsByUserName(String userName) throws ApiException;
    UserDTO createUser(UserDTO userDTO) throws ApiException;
    UserModel updateUser(UserModel userModel) throws ApiException;
    UserDTO deleteUser(String userName) throws ApiException;
    UserDTO verifyLogin(String userName, String password) throws ApiException;
    boolean verifyUserName(String userName);
}
