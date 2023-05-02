package com.etiya.ecommerceDemo.repositories.abstracts;

import com.etiya.ecommerceDemo.entities.concretes.ProductVariation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVariationDao extends JpaRepository<ProductVariation,Long> {
}
