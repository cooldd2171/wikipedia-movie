package com.example.demo.service;

import com.example.demo.covertor.DepartmentConvertor;
import com.example.demo.entity.Department;
import com.example.demo.error.ErrorCode;
import com.example.demo.error.ApiException;
import com.example.demo.model.DepartmentModel;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartmentService {

    @Autowired
    public DepartmentRepository dr;


    @Autowired
    public DepartmentConvertor dc;




    public DepartmentModel[] getDepartmentById(Integer userId) throws ApiException{


        Department dp[]= dr.findByUserId(userId);

        if(dp==null)
            throw  new ApiException(ErrorCode.USER_NOT_FOUND);


        DepartmentModel dm[] = new DepartmentModel[dp.length];

        for(int i=0;i<dp.length;i++){
           dm[i] = dc.converToModel(dp[i]);
        }

        return dm;

    }


}
