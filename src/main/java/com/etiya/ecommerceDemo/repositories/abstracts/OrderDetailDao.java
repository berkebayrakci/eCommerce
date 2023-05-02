package com.etiya.ecommerceDemo.repositories.abstracts;

import com.etiya.ecommerceDemo.entities.concretes.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailDao extends JpaRepository<OrderDetail,Long> {

    @Query(value = "SELECT od.* FROM order_details od INNER JOIN orders o ON o.id = od.order_id", nativeQuery = true)
    List<OrderDetail> getAllOrderDetails();
}
