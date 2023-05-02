package com.etiya.ecommerceDemo.repositories.abstracts;

import com.etiya.ecommerceDemo.entities.concretes.Installment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InstallmentDao extends JpaRepository<Installment,Long> {
    @Query(value = "SELECT ins.* FROM installments ins INNER JOIN payments p ON ins.payment_id = p.id", nativeQuery = true)
    List<Installment> getInstallmentByPaymentId();

    @Query(value = "SELECT ins.* FROM installments ins INNER JOIN orders o ON ins.order_id = o.id", nativeQuery = true)
    List<Installment> getInstallmentByOrderId();
}
