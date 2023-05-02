package com.etiya.ecommerceDemo.business.abstracts;

import com.etiya.ecommerceDemo.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommerceDemo.business.dtos.requests.category.UpdateCategoryRequest;
import com.etiya.ecommerceDemo.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.category.CategoryDetailResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.category.UpdateCategoryResponse;
import com.etiya.ecommerceDemo.core.utils.result.DataResult;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface CategoryService {

    List<ListCategoryResponse> getAll();

    DataResult<Slice<ListCategoryResponse>> getAllWithPagination(Pageable pageable);

    DataResult<CategoryDetailResponse> getById(Long id);

    DataResult<AddCategoryResponse> addCategory(AddCategoryRequest addCategoryRequest) throws Exception;

    DataResult<UpdateCategoryResponse> updateCategory(UpdateCategoryRequest updateCategoryRequest, Long id) throws Exception;
}
