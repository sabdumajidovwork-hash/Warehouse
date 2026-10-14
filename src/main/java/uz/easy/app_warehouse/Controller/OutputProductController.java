package uz.easy.app_warehouse.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.easy.app_warehouse.dto.OutputProductDto;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.service.OutputProductService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/outputProduct")
public class OutputProductController {
    private  final OutputProductService outputProductService;

    @PostMapping
    public Result createOutputProduct(@RequestBody OutputProductDto outputProductDto){
        return outputProductService.createOutputProductService(outputProductDto);
    }
}
