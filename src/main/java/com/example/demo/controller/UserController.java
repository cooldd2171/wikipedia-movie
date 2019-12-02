package com.example.demo.controller;



import com.example.demo.service.userService;
import com.example.demo.error.ApiException;
import com.example.demo.model.ApiResponse;
import com.example.demo.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "user/")

public class UserController {

    @Autowired
    public userService us;

    @RequestMapping("get/{id}")
    public ApiResponse<UserModel> getUser(@PathVariable(value="id")int userId) throws  ApiException{

        return new ApiResponse<>(us.getUserDetailsById(userId));

    }



    @RequestMapping("get")
    public ApiResponse<UserModel> getUserWithRequestParamEmail(@RequestParam(value="email")String email) throws ApiException {



        return new ApiResponse<>(us.getUserDetailsByEmail(email));
    }



    @PostMapping("create")
    public ApiResponse<UserModel> create(@RequestBody UserModel userModel) throws ApiException {



        return new ApiResponse<>(us.createUser(userModel));
    }


    @PostMapping("update")
    public ApiResponse<UserModel> update(@RequestBody UserModel userModel) throws ApiException {



        return new ApiResponse<>(us.updateUser(userModel));
    }


}
