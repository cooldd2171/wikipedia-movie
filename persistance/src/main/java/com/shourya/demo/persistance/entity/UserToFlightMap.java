package com.shourya.demo.persistance.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="UserToFlightMap")
public class UserToFlightMap {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name ="userId")
    private Integer userId;

    @Column(name ="flightId")
    private Integer flightId;

    @Column(name ="status")
    private Integer status;

    @Column(name ="price")
    private Integer price;

    @Column(name ="date")
    private String date;

    @Column(name ="details")
    private String details;

}
