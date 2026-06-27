package co.istad.fary.elearning.features.category.dto;

public record CategoryResponse(
        Integer id,
        String name,
        Boolean isDeleted
) {
}