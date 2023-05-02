package com.etiya.ecommerceDemo.business.dtos.requests.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddUserRequest {
    @NotBlank(message = "First name can not be empty")
    private String first_name;

    @NotBlank(message = "Last name can not be empty")
    private String last_name;

    @Email
    @NotEmpty(message = "Email can not be empty")
    private String email;

    @NotEmpty(message = "Password can not be empty")
    private String password;
}
