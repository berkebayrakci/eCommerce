package com.etiya.ecommerceDemo.business.dtos.responses.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailResponse {
    private Long id;

    private String name;

    private double unitPrice;

    private String categoryName;
}
