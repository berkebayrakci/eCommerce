package com.etiya.ecommerceDemo.business.dtos.responses.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserResponse {
    private Long id;

    private String first_name;

    private String last_name;

    private String email;

    private String password;
}
