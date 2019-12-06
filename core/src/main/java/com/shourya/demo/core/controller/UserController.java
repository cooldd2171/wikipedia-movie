package com.shourya.demo.core.controller;

import com.shourya.demo.core.service.UserService;
import com.shourya.demo.helper.error.ApiException;
import com.shourya.demo.model.ApiResponse;
import com.shourya.demo.model.User.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "users/")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("get")
    public ApiResponse<UserDTO> getUser(@RequestParam(value="id")int userId) throws ApiException {
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
