package uz.easy.app_warehouse.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class InputDto {

    private Timestamp date;
    private Long warehouseId;
    private Long supplierId;
    private String factureNumber;
    private String code;
    private Long currencyId;
}
