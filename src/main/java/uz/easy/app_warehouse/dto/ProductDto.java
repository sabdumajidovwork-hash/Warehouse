package uz.easy.app_warehouse.dto;

import lombok.Data;

@Data
public class ProductDto {

    private String name;
    private  Long categoryId;
    private  Long photoId;
    private  Long measurementId;

}
