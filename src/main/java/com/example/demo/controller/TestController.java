package com.example.demo.controller;

import com.example.demo.model.ApiResponse;
import com.example.demo.model.TestPostData;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path= "test/")
public class TestController {

    @GetMapping(value = "get", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ApiResponse<String> TestController(){
        return new ApiResponse<>("hi");

    }

    @PostMapping (value = "post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ApiResponse<TestPostData> testPostApi(@RequestBody TestPostData testPostData){
        return new ApiResponse<>(testPostData);

    }


}
