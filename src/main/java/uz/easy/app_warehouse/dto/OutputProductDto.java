package uz.easy.app_warehouse.dto;

import lombok.Data;

@Data
public class OutputProductDto {
    private Long productId;
    private Double amount;
    private Double price;
    private Long outputId;

}
