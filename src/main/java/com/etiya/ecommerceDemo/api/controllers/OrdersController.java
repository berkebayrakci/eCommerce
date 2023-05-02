package com.etiya.ecommerceDemo.api.controllers;

import com.etiya.ecommerceDemo.business.abstracts.OrderService;
import com.etiya.ecommerceDemo.business.dtos.requests.order.AddOrderRequest;
import com.etiya.ecommerceDemo.business.dtos.requests.order.UpdateOrderRequest;
import com.etiya.ecommerceDemo.business.dtos.responses.order.AddOrderResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.order.OrderDetailResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.order.UpdateOrderResponse;
import com.etiya.ecommerceDemo.core.utils.result.DataResult;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
@AllArgsConstructor
public class OrdersController {

    private OrderService orderService;

    @GetMapping
    public DataResult<List<ListOrderResponse>> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<OrderDetailResponse> getById(@PathVariable Long id) {
        return orderService.getById(id);
    }

    @PostMapping
    public DataResult<AddOrderResponse> addCategory(@RequestBody AddOrderRequest addOrderRequest) {
        return orderService.addOrder(addOrderRequest);
    }

    @PutMapping("/{id}")
    public DataResult<UpdateOrderResponse> updateOrder(@RequestBody @Valid UpdateOrderRequest updateOrderRequest, @PathVariable Long id) throws Exception {
        return orderService.updateOrder(updateOrderRequest, id);
    }
}
