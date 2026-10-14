package uz.easy.app_warehouse.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.easy.app_warehouse.dto.InputProductDto;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.service.InputProductService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/inputProduct")
public class InputProductController {
    private final InputProductService inputProductService;

    @PostMapping
    public Result createInputProduct(@RequestBody InputProductDto inputProductDto){
        return  inputProductService.createInputProductService(inputProductDto);
    }

}
