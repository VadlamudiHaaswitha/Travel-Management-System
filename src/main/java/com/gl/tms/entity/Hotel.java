package com.gl.tms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hotels")
@Getter
@Setter
@NoArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="hotel_id")
    private Long hotelId;

    @Column(nullable = false)
    private String hotelName;

    @Column(nullable = false)
    private String hotelLocation;

    @Column(nullable = false)
    private Double pricePerNight;

}
