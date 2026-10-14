package uz.easy.app_warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.entity.Warehouse;
import uz.easy.app_warehouse.repository.WarehouseRepository;

@Service
@RequiredArgsConstructor
public class WareHouseService {
    private final WarehouseRepository warehouseRepository;

    public Result createWarehouseService(Warehouse warehouse) {
        if (warehouseRepository.existsByName(warehouse.getName())) {
            return new Result("Bunday ombor mvjud", false);
        } else {
            Warehouse ware = new Warehouse();
            ware.setName(warehouse.getName());
            warehouseRepository.save(ware);
            return new Result("Omborxona yaratildi", true);
        }
    }

}
