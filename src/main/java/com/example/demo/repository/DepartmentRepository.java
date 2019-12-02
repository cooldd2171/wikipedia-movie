package com.example.demo.repository;

import com.example.demo.entity.Department;

public interface DepartmentRepository extends BaseRepo<Department,Integer> {

    Department[] findByUserId(Integer userId);





}
