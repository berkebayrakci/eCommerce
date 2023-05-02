package com.etiya.ecommerceDemo.business.dtos.requests.category;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryRequest {

    @NotEmpty(message = "Category name can not be empty")
    private String name;
}
