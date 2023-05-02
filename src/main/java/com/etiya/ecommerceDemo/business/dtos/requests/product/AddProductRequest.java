package com.etiya.ecommerceDemo.business.dtos.requests.product;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddProductRequest {

    @NotEmpty(message = "Product name can not be empty!")
    private String name;

    @NotEmpty(message = "Unit price can not be empty!")
    private double unitPrice;

    @NotEmpty(message = "Category can not be empty!")
    private Long categoryId;
}
