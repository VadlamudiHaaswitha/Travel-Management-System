package com.gl.tms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class HotelCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="category_id",unique = true, nullable = false)
    private Long categoryId;

    @Column(nullable = false)
    private String categoryName; // e.g., Budget, Deluxe, Luxury

    @Column(nullable = false)
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
