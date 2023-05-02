package com.etiya.ecommerceDemo.business.abstracts;

import com.etiya.ecommerceDemo.business.dtos.requests.supplier.AddSupplierRequest;
import com.etiya.ecommerceDemo.business.dtos.requests.supplier.UpdateSupplierRequest;
import com.etiya.ecommerceDemo.business.dtos.responses.supplier.AddSupplierResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.supplier.ListSupplierResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.supplier.SupplierDetailResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.supplier.UpdateSupplierResponse;
import com.etiya.ecommerceDemo.core.utils.result.DataResult;

import java.util.List;

public interface SupplierService {
    DataResult<List<ListSupplierResponse>> getAll();

    DataResult<SupplierDetailResponse> getById(Long id);

    DataResult<AddSupplierResponse> addSupplier(AddSupplierRequest addSupplierRequest) throws Exception;

    DataResult<UpdateSupplierResponse> updateSupplier(UpdateSupplierRequest updateSupplierRequest, Long id) throws Exception;
}
