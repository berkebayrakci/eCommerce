package com.etiya.ecommerceDemo.repositories.abstracts;

import com.etiya.ecommerceDemo.entities.concretes.Product;
import com.etiya.ecommerceDemo.entities.concretes.ProductDiscount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDiscountDao extends JpaRepository<ProductDiscount,Long> {
    @Query(value = "SELECT * FROM product_discount", nativeQuery = true)
    List<Product> getProductDiscount();
    @Query(value = "SELECT * FROM product_discount pd where pd.discount_amount = (select MAX(pd2.discount_amount) FROM product_discount pd2)",nativeQuery = true)
    List<ProductDiscount> getMaxProductDiscount();

}
