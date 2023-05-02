package com.etiya.ecommerceDemo.api.controllers;

import com.etiya.ecommerceDemo.business.abstracts.ProductService;
import com.etiya.ecommerceDemo.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommerceDemo.business.dtos.requests.product.UpdateProductRequest;
import com.etiya.ecommerceDemo.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.product.UpdateProductResponse;
import com.etiya.ecommerceDemo.core.utils.result.DataResult;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@AllArgsConstructor
public class ProductsController {

    private ProductService productService;

    @GetMapping
    public DataResult<List<ListProductResponse>> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<ProductDetailResponse> getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PostMapping
    public DataResult<AddProductResponse> addProduct(@RequestBody AddProductRequest addProductRequest) {
        return productService.addProduct(addProductRequest);
    }

    @PutMapping("/{id}")
    public DataResult<UpdateProductResponse> updateProduct(@RequestBody @Valid UpdateProductRequest updateProductRequest, @PathVariable Long id) throws Exception {
        return productService.updateProduct(updateProductRequest, id);
    }
}
