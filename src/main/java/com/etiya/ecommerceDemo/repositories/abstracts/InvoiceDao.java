package com.etiya.ecommerceDemo.repositories.abstracts;

import com.etiya.ecommerceDemo.entities.concretes.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceDao extends JpaRepository<Invoice,Long> {
    @Query(value = "SELECT inv.* FROM invoices inv INNER JOIN orders o ON inv.order_id = o.id", nativeQuery = true)
    List<Invoice> getInvoiceByOrderId();
}
