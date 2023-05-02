package com.etiya.ecommerceDemo.business.abstracts;

import com.etiya.ecommerceDemo.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommerceDemo.business.dtos.requests.product.UpdateProductRequest;
import com.etiya.ecommerceDemo.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.product.UpdateProductResponse;
import com.etiya.ecommerceDemo.core.utils.result.DataResult;
import com.etiya.ecommerceDemo.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    DataResult<List<ListProductResponse>> getAll();

    DataResult<ProductDetailResponse> getById(Long id);

    DataResult<AddProductResponse> addProduct(AddProductRequest addProductRequest);

    DataResult<UpdateProductResponse> updateProduct(UpdateProductRequest updateProductRequest, Long id) throws Exception;
}
