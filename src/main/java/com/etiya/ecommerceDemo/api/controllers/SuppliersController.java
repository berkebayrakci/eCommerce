package com.etiya.ecommerceDemo.api.controllers;

import com.etiya.ecommerceDemo.business.abstracts.SupplierService;
import com.etiya.ecommerceDemo.business.dtos.requests.supplier.AddSupplierRequest;
import com.etiya.ecommerceDemo.business.dtos.requests.supplier.UpdateSupplierRequest;
import com.etiya.ecommerceDemo.business.dtos.responses.supplier.AddSupplierResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.supplier.ListSupplierResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.supplier.SupplierDetailResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.supplier.UpdateSupplierResponse;
import com.etiya.ecommerceDemo.core.utils.result.DataResult;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/suppliers")
@AllArgsConstructor
public class SuppliersController {
    private SupplierService supplierService;

    @GetMapping
    public DataResult<List<ListSupplierResponse>> getAll() {
        return supplierService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<SupplierDetailResponse> getById(@PathVariable Long id) {
        return supplierService.getById(id);
    }

    @PostMapping
    public DataResult<AddSupplierResponse> addProduct(@RequestBody @Valid AddSupplierRequest addSupplierRequest) throws Exception {
        return supplierService.addSupplier(addSupplierRequest);
    }

    @PutMapping("/{id}")
    public DataResult<UpdateSupplierResponse> updateSupplier(@RequestBody @Valid UpdateSupplierRequest updateSupplierRequest, @PathVariable long id) throws Exception {
        return supplierService.updateSupplier(updateSupplierRequest, id);
    }
}
