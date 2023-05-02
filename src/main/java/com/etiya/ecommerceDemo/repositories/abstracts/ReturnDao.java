package com.etiya.ecommerceDemo.repositories.abstracts;

import com.etiya.ecommerceDemo.entities.concretes.Return;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReturnDao extends JpaRepository<Return,Long> {

    @Query(value = "SELECT r.* FROM orders o INNER JOIN returns r ON o.id = r.order_id", nativeQuery = true)
    List<Return> getOrderByReturns();
}
