package uz.easy.app_warehouse.dto;

import lombok.Data;

@Data
public class ProductDto {
    private boolean active;
    private String name;
    private String code;
    private  Long categoryId;
    private  Long photoId;
    private  Long measurementId;

}
