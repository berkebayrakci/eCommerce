package com.etiya.ecommerceDemo.business.dtos.responses.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListOrderResponse {

    private Long id;
    private Date orderDate;
    private Long userId;
}
