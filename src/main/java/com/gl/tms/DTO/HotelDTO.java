package com.gl.tms.DTO;

import com.gl.tms.entity.HotelCategory;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class HotelDTO {

    private Long hotelId;
    @NotBlank(message = "hotelName should not be null or blank")
    @Valid
    private String hotelName;
    @NotBlank(message = "hotelLocation should not be null or blank")
    private String hotelLocation;
    @NotBlank(message = "pricePerNight should not be null or blank")
    private Double pricePerNight;

}
