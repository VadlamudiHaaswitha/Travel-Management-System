package com.gl.tms.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "travel_packages")
@Getter
@Setter
@NoArgsConstructor
public class TravelPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="package_id")
    private Long packageId;

    @Column(nullable = false)
    private String packageName;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private Integer durationDays;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="hotel_id")
    private List<Hotel> hotels;

}
