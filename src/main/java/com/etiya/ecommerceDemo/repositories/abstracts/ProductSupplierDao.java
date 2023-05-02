package com.etiya.ecommerceDemo.repositories.abstracts;

import com.etiya.ecommerceDemo.entities.concretes.ProductSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductSupplierDao extends JpaRepository<ProductSupplier,Long> {
    @Query(value = "SELECT ps.* FROM product_suppliers ps INNER JOIN suppliers s ON s.id = ps.supplier_id ", nativeQuery = true)
    List<ProductSupplier> getProductSuppliersByCountry();

}
