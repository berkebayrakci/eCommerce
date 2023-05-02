package com.etiya.ecommerceDemo.repositories.abstracts;

import com.etiya.ecommerceDemo.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.order.OrderDetailResponse;
import com.etiya.ecommerceDemo.entities.concretes.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDao extends JpaRepository<Order, Long> {

    @Query(value = "select new" +
            " com.etiya.ecommerceDemo.business.dtos.responses.order.OrderDetailResponse(o.id,o.orderDate,o.user.id)" +
            " from Order o where o.id = :id", nativeQuery = false)
    OrderDetailResponse getOneOrder(Long id);

    @Query(value = "select new" +
            "  com.etiya.ecommerceDemo.business.dtos.responses.order.ListOrderResponse(o.id,o.orderDate,o.user.id)" +
            " from Order o", nativeQuery = false)
    List<ListOrderResponse> getAll();


}
