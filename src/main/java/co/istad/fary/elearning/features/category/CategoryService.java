package co.istad.fary.elearning.features.category;

import co.istad.fary.elearning.features.category.dto.CategoryCreateRequest;
import co.istad.fary.elearning.features.category.dto.CategoryResponse;
import co.istad.fary.elearning.features.category.dto.CategoryUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    CategoryResponse createCategory(CategoryCreateRequest request);

    CategoryResponse getCategoryById(Integer id);

    Page<CategoryResponse> getAllCategories(Pageable pageable);

    CategoryResponse updateCategory(Integer id, CategoryUpdateRequest request);

    void deleteCategory(Integer id);

    void softDeleteCategory(Integer id);
}
