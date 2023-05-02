package com.etiya.ecommerceDemo.business.concretes;

import com.etiya.ecommerceDemo.business.abstracts.ProductService;
import com.etiya.ecommerceDemo.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommerceDemo.business.dtos.requests.product.UpdateProductRequest;
import com.etiya.ecommerceDemo.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.product.UpdateProductResponse;
import com.etiya.ecommerceDemo.core.utils.mapper.ModelMapperService;
import com.etiya.ecommerceDemo.core.utils.result.DataResult;
import com.etiya.ecommerceDemo.core.utils.result.SuccessDataResult;
import com.etiya.ecommerceDemo.entities.concretes.Product;
import com.etiya.ecommerceDemo.repositories.abstracts.ProductDao;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;
    private ModelMapperService modelMapperService;
    private MessageSource messageSource;

    @Override
    public DataResult<List<ListProductResponse>> getAll() {
        return new SuccessDataResult<>(productDao.getAll(), messageSource.getMessage("successListProduct", null, LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<ProductDetailResponse> getById(Long id) {
        if (productDao.getProductById(id) == null) {
            return new SuccessDataResult<>(productDao.getProductById(id), messageSource.getMessage("errorOneProduct", null, LocaleContextHolder.getLocale()));
        }
        return new SuccessDataResult<>(productDao.getProductById(id), messageSource.getMessage("successOneProduct", null, LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<AddProductResponse> addProduct(AddProductRequest addProductRequest) {

        Product product = this.modelMapperService.getMapper().map(addProductRequest, Product.class);
        productDao.save(product);

        AddProductResponse addProductResponse = this.modelMapperService.getMapper().map(product, AddProductResponse.class);
        return new SuccessDataResult<>(addProductResponse, messageSource.getMessage("successAddProduct", null, LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<UpdateProductResponse> updateProduct(UpdateProductRequest updateProductRequest, Long id) throws Exception {

        if (!productDao.existsById(id)) {
            throw new Exception(messageSource.getMessage("errorOneProduct", null, LocaleContextHolder.getLocale()));
        }

        Product product = this.modelMapperService.getMapper().map(updateProductRequest, Product.class);

        product.setId(id);
        productDao.save(product);

        UpdateProductResponse updateProductResponse = this.modelMapperService.getMapper().map(product, UpdateProductResponse.class);


        return new SuccessDataResult<>(updateProductResponse, messageSource.getMessage("successUpdateProduct", null, LocaleContextHolder.getLocale()));
    }
}
