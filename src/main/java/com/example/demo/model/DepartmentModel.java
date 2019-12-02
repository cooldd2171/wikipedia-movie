package com.example.demo.model;

public class DepartmentModel {

    private int DepartmentId;
    private int UserId;
    private String DepartmentName;

    public int getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(int departmentId) {
        DepartmentId = departmentId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }
}
