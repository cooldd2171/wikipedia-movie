package com.example.my_project.entity;

import com.example.my_project.model.Enums.City;
import com.example.my_project.model.Enums.Gender;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="com.example.my_project.User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="name")
    private String name;

    @Column(name ="email")
    private String email;

    @Column(name ="password")
    private String password;


    @Column(name="contact_no")
    private BigDecimal contact_no;

    @Column(name ="city")
    @Enumerated(EnumType.STRING)
    private City city;

    @Column(name ="dob")
    private Date dob;

    @Column(name ="gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name ="updated_by")
    private Integer updated_by;

    @Column(name ="created_by")
    private Integer created_by;

    @Column(name ="created_at")
    @CreationTimestamp
    private Timestamp created_at;

    @Column(name ="updated_at")
    @UpdateTimestamp
    private Timestamp updated_at;

    @Column(name ="active")
    private Boolean active;

}

