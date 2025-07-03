package com.gl.tms.DTO;

import com.gl.tms.entity.Hotel;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TravelPackageDTO {


    private Long packageId;

    @NotBlank(message = "Name should not be null or blank!")
    private String packageName;
    @NotBlank(message = "packageName should not be null or blank!")
    private String destination;
    @NotBlank(message = "durationDays should not be null or blank!")
    private Integer durationDays;
    @NotBlank(message = "price should not be null or blank!")
    private Double price;
    @NotBlank(message = "description should not be null or blank!")
    private String description;
    @NotEmpty(message = "HotelDTO should not be empty!!")
    @Valid
    private List<HotelDTO> hotelsDTO;
}
