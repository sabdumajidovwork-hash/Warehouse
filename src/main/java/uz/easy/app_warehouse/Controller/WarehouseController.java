package uz.easy.app_warehouse.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.entity.Warehouse;
import uz.easy.app_warehouse.service.WareHouseService;

@RestController
@RequestMapping("/warehouse")
@RequiredArgsConstructor
public class WarehouseController {
    private final WareHouseService wareHouseService;

    @PostMapping
    public Result createWarehouse(@RequestBody Warehouse warehouse){
        return wareHouseService.createWarehouse(warehouse);
    }

}
