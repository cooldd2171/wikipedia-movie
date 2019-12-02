package com.example.my_project.model.User;

import com.example.my_project.model.Enums.City;
import com.example.my_project.model.Enums.Gender;
import lombok.*;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Integer id;

    private String name;


    private String email;


    private String password;


    private City city;


    private Date dob;

    private Gender gender;


    private Integer updated_by;


    private Integer created_by;


    private Timestamp created_at;


    private Timestamp updated_at;


    private Boolean active;

    private BigDecimal contact_no;


}
