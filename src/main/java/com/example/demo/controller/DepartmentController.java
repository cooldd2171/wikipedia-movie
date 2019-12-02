package com.example.demo.controller;


import com.example.demo.error.ApiException;
import com.example.demo.model.ApiResponse;
import com.example.demo.model.DepartmentModel;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="my_department/")

public class DepartmentController {

    @Autowired
    public DepartmentService ds;

    @RequestMapping("get")
    public ApiResponse<DepartmentModel[]> getDepartmentById(@RequestParam(value="user_id")Integer userId) throws ApiException {

        return new ApiResponse<DepartmentModel[]>(ds.getDepartmentById(userId));
    }



}
