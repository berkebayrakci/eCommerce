package com.etiya.ecommerceDemo.repositories.abstracts;

import com.etiya.ecommerceDemo.business.dtos.responses.category.CategoryDetailResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommerceDemo.entities.concretes.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category, Long> {

    boolean existsCategoriesByName(String name);

    boolean existsCategoriesById(Long id);

    @Query(value = "select new" +
            " com.etiya.ecommerceDemo.business.dtos.responses.category.CategoryDetailResponse(c.id,c.name)" +
            " from Category c where c.id = :id", nativeQuery = false)
    CategoryDetailResponse getCategoryById(Long id);

    @Query(value = "select new" +
            " com.etiya.ecommerceDemo.business.dtos.responses.category.ListCategoryResponse(c.id,c.name)" +
            " from Category c", nativeQuery = false)
    List<ListCategoryResponse> getAll();

    @Query(value = "select new com.etiya.ecommerceDemo.business.dtos.responses.category.ListCategoryResponse(c.id, c.name) from Category c")
    Slice<ListCategoryResponse> getAll(Pageable pageable);
}
