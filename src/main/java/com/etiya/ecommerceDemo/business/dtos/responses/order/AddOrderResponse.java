package com.etiya.ecommerceDemo.business.dtos.responses.order;

import com.etiya.ecommerceDemo.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderResponse {
    private Long id;
    private Date orderDate;
    private User user;
}
