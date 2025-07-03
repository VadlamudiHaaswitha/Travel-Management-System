package com.gl.tms.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserProfileDTO {

    private Long profileId;
    @NotBlank(message = "fullName should not be null or blank!")
    @Pattern(regexp = "[A-Z][]a-z]+\\s[A-Z][a-z]+", message = "Name should be exactly 2 words!")
    private String fullName;
    @NotBlank(message = "phoneNumber should not be null or blank!")
    @Pattern(regexp = "^[6-9]\\d{9}$",message="PhoneNumber should be exactly 10 digits")
    private String phoneNumber;
    @NotBlank(message = "address should not be null or blank!")
    private String address;


}
