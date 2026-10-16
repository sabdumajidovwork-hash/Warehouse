package uz.easy.app_warehouse.dto;

import lombok.Data;

@Data
public class ClientDto {
    private  boolean active;
    private String name;
    private String phoneNumber;
}
