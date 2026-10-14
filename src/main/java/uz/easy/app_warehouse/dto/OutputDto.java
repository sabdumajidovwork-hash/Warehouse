package uz.easy.app_warehouse.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OutputDto {
    private Timestamp date;
    private Long warehouseId;
    private String factureNumber;
    private String code;
    private Long currencyId;
    private Long clientId;
}
