package uz.easy.app_warehouse.dto;

import lombok.Data;

@Data
public class CategoryDto {
    private String name;
    private Long parentCategoryId;
}
