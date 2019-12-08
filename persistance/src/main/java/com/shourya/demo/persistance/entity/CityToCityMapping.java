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
@Table(name="CityToCityMapping")
public class CityToCityMapping {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="sourceCity")
    private String sourceCity;

    @Column(name ="destinationCity")
    private String destinationCity;

    @Column(name ="deleted")
    private Integer deleted;

    @Column(name ="date")
    private Date date;
}
