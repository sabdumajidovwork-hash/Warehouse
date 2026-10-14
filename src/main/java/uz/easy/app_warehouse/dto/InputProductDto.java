package uz.easy.app_warehouse.dto;

import lombok.Data;

import java.util.Date;

@Data
public class InputProductDto {
    private Long productId;
    private Double amount;
    private Double price;
    private Date expireDate;
    private Long inputId;

}
