package com.gl.tms.DTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import com.gl.tms.entity.UserProfile;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersDTO {

    private Long userId;
    @NotBlank(message="Name should not be null or blank!")
    private String userName;
    @NotBlank(message="Password should not be null or blank!")
    private String password;
    @NotBlank(message="Email should not be null or blank!")
    @Email(message = "EMail should be in valid format")
    private String email;

    @NotNull(message = "UserDTO should not be null")
    @Valid
    private UserProfileDTO userProfileDTO;
}
