package uz.easy.app_warehouse.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.dto.WarehouseDto;
import uz.easy.app_warehouse.entity.Warehouse;
import uz.easy.app_warehouse.service.WareHouseService;


@RestController
@RequestMapping("/warehouse")
@RequiredArgsConstructor
public class WarehouseController {
    private final WareHouseService wareHouseService;

    @PostMapping
    public Result createWarehouse(@RequestBody WarehouseDto warehouseDto) {
        return wareHouseService.createWarehouseService(warehouseDto);
    }

    @GetMapping
    public Result getWarehouses() {
        return wareHouseService.getWarehousesService();
    }

    @GetMapping("/{id}")
    public Result getWerhauseById(@PathVariable Long id) {
        return wareHouseService.getWarehouseByIdService(id);


    }

    @PutMapping("/{id}")
    public Result updateWarehouse(@RequestBody WarehouseDto warehouseDto, @PathVariable Long id) {
        return wareHouseService.updateWarehouseService(warehouseDto, id);
    }

    @DeleteMapping("/{id}")
    public Result removeWarehouse(@PathVariable Long id){
        return wareHouseService.removeWarehouseService(id);
    }

}
