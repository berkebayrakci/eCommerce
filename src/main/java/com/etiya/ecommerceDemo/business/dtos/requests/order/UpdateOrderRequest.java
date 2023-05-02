package com.etiya.ecommerceDemo.business.dtos.requests.order;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderRequest {

    private Date orderDate;

    private Long userId;
}
