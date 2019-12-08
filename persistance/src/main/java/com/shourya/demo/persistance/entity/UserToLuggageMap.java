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
@Table(name="UserToLuggageMap")
public class UserToLuggageMap {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name ="userId")
    private Integer userId;

    @Column(name ="luggageId")
    private Integer luggageId;

    @Column(name ="luggagePoint")
    private String luggagePoint;

    @Column(name ="status")
    private Integer status;

    @Column(name ="timeCaptured")
    private String timeCaptured;
}
