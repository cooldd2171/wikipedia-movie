package com.example.my_project.model.Enums;

public enum City {

    DELHI(1,"DELHI"),
    MUMBAI(2,"MUMBAI"),
    KOLKATA(3,"KOLKATA"),
    BANGALORE(4,"BANGALORE");

    private final Integer id;
    private final String cityName;

    City(Integer id, String cityName) {
        this.id = id;
        this.cityName = cityName;
    }
}
