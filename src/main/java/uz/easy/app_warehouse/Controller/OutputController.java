package uz.easy.app_warehouse.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.easy.app_warehouse.dto.OutputDto;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.service.OutputService;

@RestController
@RequestMapping("/output")
@RequiredArgsConstructor
public class OutputController {
    private final OutputService outputService;

    @PostMapping
    public Result createOutput(@RequestBody OutputDto outputDto) {
        return outputService.createOutputService(outputDto);
    }

}
