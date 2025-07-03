package com.gl.tms.DTO;

import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HotelCategoryDTO {


    private Long categoryId;
    @NotBlank(message = "categoryName should not be null or blank")
    private String categoryName; // e.g., Budget, Deluxe, Luxury
    @NotBlank(message = "description should not be null or blank")
    private String description;

    @NotNull(message = "HotelDTO should not be null!")
    @Valid
    private HotelDTO hotelDTO;
}
