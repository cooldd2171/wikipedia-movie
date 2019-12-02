package com.example.demo.covertor;

import com.example.demo.entity.Department;
import com.example.demo.model.DepartmentModel;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentConvertor implements convertor<Department, DepartmentModel> {


    @Autowired
    DepartmentRepository dr;

    @Override
    public Department convertToEntity(DepartmentModel model) {

        Department dp=new Department();
        dp.setId(model.getDepartmentId());
        dp.setDepartmentName(model.getDepartmentName());
        dp.setId(model.getUserId());

        return dp;
    }

    @Override
    public DepartmentModel converToModel(Department entity) {

        DepartmentModel dm=new DepartmentModel();
        dm.setUserId(entity.getUserId());
        dm.setDepartmentId(entity.getId());
        dm.setDepartmentName(entity.getDepartmentName());

        return dm;
    }



}
