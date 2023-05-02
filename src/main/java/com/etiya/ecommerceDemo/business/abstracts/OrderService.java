package com.etiya.ecommerceDemo.business.abstracts;

import com.etiya.ecommerceDemo.business.dtos.requests.order.AddOrderRequest;
import com.etiya.ecommerceDemo.business.dtos.requests.order.UpdateOrderRequest;
import com.etiya.ecommerceDemo.business.dtos.responses.order.AddOrderResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.order.OrderDetailResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.order.UpdateOrderResponse;
import com.etiya.ecommerceDemo.core.utils.result.DataResult;

import java.util.List;

public interface OrderService {
    DataResult<List<ListOrderResponse>> getAll();

    DataResult<OrderDetailResponse> getById(Long id);

    DataResult<AddOrderResponse> addOrder(AddOrderRequest addOrderRequest);

    DataResult<UpdateOrderResponse> updateOrder(UpdateOrderRequest updateOrderRequest, Long id) throws Exception;
}
