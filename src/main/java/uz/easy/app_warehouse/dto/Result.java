package uz.easy.app_warehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private String message;
    private boolean success;
    private Object data;

    public Result(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

}
