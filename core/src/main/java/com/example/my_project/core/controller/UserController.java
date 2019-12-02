package com.example.my_project.core.controller;

import com.example.my_project.core.service.UserService;
import com.example.my_project.helper.error.ApiException;
import com.example.my_project.model.ApiResponse;
import com.example.my_project.model.User.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "users/")

public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("get/{id}")
    public ApiResponse<UserDTO> getUser(@PathVariable(value="id")int userId) throws ApiException {
        return new ApiResponse<>(userService.getUserDetailsById(userId));
    }

    @PostMapping("create")
    public ApiResponse<UserDTO> create(@RequestBody UserDTO userModel) throws ApiException {
        return new ApiResponse<>(userService.createUser(userModel));
    }

    @PostMapping("update")
    public ApiResponse<UserDTO> update(@RequestBody UserDTO userModel) throws ApiException {
        return new ApiResponse<>(userService.updateUser(userModel));
    }

    @DeleteMapping
    public ApiResponse<UserDTO> delete(@RequestParam(value = "id")Integer id) throws ApiException{
        return null;
    }


}
