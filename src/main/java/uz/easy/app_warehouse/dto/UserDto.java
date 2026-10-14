package uz.easy.app_warehouse.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private String code;
    private Set<Long> warehouses;
}
