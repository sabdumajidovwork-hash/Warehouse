package uz.easy.app_warehouse.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.easy.app_warehouse.dto.InputDto;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.service.InputService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/input")
public class InputController {
    private final InputService inputService;

    @PostMapping
    public Result createInput(@RequestBody InputDto inputDto) {
        return inputService.createInputService(inputDto);
    }

}
