package com.example.demo.entity;

import com.example.demo.model.City;
import com.example.demo.model.Gender;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;


@Entity
@Table(name="User")

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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getContact_no() {
        return contact_no;
    }

    public void setContact_no(BigDecimal contact_no) {
        this.contact_no = contact_no;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(Integer updated_by) {
        this.updated_by = updated_by;
    }

    public Number getCreated_by() {
        return created_by;
    }

    public void setCreated_by(Integer created_by) {
        this.created_by = created_by;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}

