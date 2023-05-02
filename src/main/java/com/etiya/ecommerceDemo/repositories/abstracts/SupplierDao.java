package com.etiya.ecommerceDemo.repositories.abstracts;

import com.etiya.ecommerceDemo.business.dtos.responses.supplier.ListSupplierResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.supplier.SupplierDetailResponse;
import com.etiya.ecommerceDemo.entities.concretes.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SupplierDao extends JpaRepository<Supplier, Long> {

    boolean existsSupplierBySupplierName(String name);

    @Query(value = "select new" +
            " com.etiya.ecommerceDemo.business.dtos.responses.supplier.SupplierDetailResponse(s.id,s.supplierName)" +
            " from Supplier s where s.id = :id", nativeQuery = false)
    SupplierDetailResponse getOneSupplierById(Long id);

    @Query(value = "select new" +
            "  com.etiya.ecommerceDemo.business.dtos.responses.supplier.ListSupplierResponse(s.id,s.supplierName)" +
            " from Supplier s", nativeQuery = false)
    List<ListSupplierResponse> getAll();
}
