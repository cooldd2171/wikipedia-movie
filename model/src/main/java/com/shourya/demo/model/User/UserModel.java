package com.shourya.demo.model.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel {
    private String userName;
    private String name;
    private String email;
    private String city;
    private String dateOfBirth;
    private String contactNumber;
}
