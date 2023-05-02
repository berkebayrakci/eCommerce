package com.etiya.ecommerceDemo.business.dtos.responses.product;

import com.etiya.ecommerceDemo.entities.concretes.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductResponse {
    private Long id;

    private String name;

    private double unitPrice;

    private Category category;
}
