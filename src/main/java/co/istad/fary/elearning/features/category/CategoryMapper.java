package co.istad.fary.elearning.features.category;


import co.istad.fary.elearning.features.category.dto.CategoryRequest;
import co.istad.fary.elearning.features.category.dto.CategoryResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category categoryRequestToCategory(CategoryRequest categoryRequest);

    CategoryResponse categoryToCategoryResponse(Category category);

}
