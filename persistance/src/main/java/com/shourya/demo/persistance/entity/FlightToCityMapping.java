package com.shourya.demo.persistance.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="FlightToCityMapping")
public class FlightToCityMapping {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name ="refernceId")
    private Integer refernceId;
    @Column(name ="flightNumber")
    private Integer flightNumber;
    @Column(name ="isActive")
    private Integer isActive;
    @Column(name ="threshold")
    private Integer threshold;
    @Column(name ="startTime")
    private String startTime;
    @Column(name ="endTime")
    private String endTime;
    @Column(name ="duration")
    private Integer duration;
    @Column(name ="currentCount")
    private Integer currentCount;
    @Column(name ="connectedReference")
    private Integer connectedReference;
    @Column(name ="price")
    private Integer price;

}
