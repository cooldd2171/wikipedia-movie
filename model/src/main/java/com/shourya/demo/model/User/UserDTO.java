package com.shourya.demo.model.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.math.BigInteger;
import java.security.Timestamp;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private String userName;
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String city;
    private Date dateOfBirth;
    private String gender;
    /*private Integer updatedBy;
    private Integer createdBy;
    private Timestamp createdAt;
    private Timestamp updatedAt;*/
    private byte deleted;
    private String contactNumber;


    private Integer flightId;
    private Integer price;
    private String date;
}
