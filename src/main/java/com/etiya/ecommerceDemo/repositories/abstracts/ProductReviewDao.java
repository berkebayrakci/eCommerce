package com.etiya.ecommerceDemo.repositories.abstracts;

import com.etiya.ecommerceDemo.entities.concretes.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductReviewDao extends JpaRepository<ProductReview,Long> {
    @Query(value = "SELECT pr.* FROM product_reviews pr INNER JOIN products p ON p.id = pr.product_id WHERE p.id = :product_id", nativeQuery = true)
    List<ProductReview> getProductReviewsByProductId();

}
