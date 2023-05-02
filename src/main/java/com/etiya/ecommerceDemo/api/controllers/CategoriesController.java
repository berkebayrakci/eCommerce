package com.etiya.ecommerceDemo.api.controllers;

import com.etiya.ecommerceDemo.business.abstracts.CategoryService;
import com.etiya.ecommerceDemo.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommerceDemo.business.dtos.requests.category.UpdateCategoryRequest;
import com.etiya.ecommerceDemo.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.category.CategoryDetailResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.category.UpdateCategoryResponse;
import com.etiya.ecommerceDemo.core.utils.result.DataResult;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
@AllArgsConstructor
public class CategoriesController {

    private CategoryService categoryService;

    @GetMapping
    public List<ListCategoryResponse> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<CategoryDetailResponse> getById(@PathVariable Long id) {
        return categoryService.getById(id);
    }

    @PostMapping
    public DataResult<AddCategoryResponse> addCategory(@RequestBody @Valid AddCategoryRequest addCategoryRequest) throws Exception {
        return categoryService.addCategory(addCategoryRequest);
    }

    @PutMapping("/{id}")
    public DataResult<UpdateCategoryResponse> updateCategory(@RequestBody @Valid UpdateCategoryRequest updateCategoryRequest, @PathVariable Long id) throws Exception {
        return categoryService.updateCategory(updateCategoryRequest, id);
    }
}
