package uz.easy.app_warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.dto.WarehouseDto;
import uz.easy.app_warehouse.entity.Warehouse;
import uz.easy.app_warehouse.entity.WarehouseUser;
import uz.easy.app_warehouse.repository.UserRepository;
import uz.easy.app_warehouse.repository.WarehouseRepository;
import uz.easy.app_warehouse.repository.WarehouseUserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WareHouseService {
    private final WarehouseRepository warehouseRepository;
    private final WarehouseUserRepository warehouseUserRepository;
    private final UserRepository userRepository;


    public Result createWarehouseService(WarehouseDto warehouseDto) {
        if (warehouseRepository.existsByName(warehouseDto.getName())) {
            return new Result("Bunday ombor mvjud", false);
        } else {
            Warehouse ware = new Warehouse();
            ware.setName(warehouseDto.getName());
            warehouseRepository.save(ware);
            return new Result("Omborxona yaratildi", true);
        }
    }

    public Result getWarehousesService() {
        List<Warehouse> warehouses = warehouseRepository.findAll();
        if (warehouses.isEmpty()) {
            return new Result("Omborxonalar topilmadi", false, warehouses);
        }
        return new Result("Omborxonalar ro'yxati", true, warehouses);
    }

    public Result getWarehouseByIdService(Long id) {
        Optional<Warehouse> warehouseOptional = warehouseRepository.findById(id);
        if (warehouseOptional.isEmpty()) {
            return new Result("Bunday id li Omborxona topilmadi", false);
        }
        return new Result("Omborxona topildi", true, warehouseOptional.get());
    }

    public Result updateWarehouseService(WarehouseDto warehouseDto, Long id) {
        Optional<Warehouse> warehouseOptional = warehouseRepository.findById(id);
        if (warehouseOptional.isEmpty()) {
            return new Result("Bunday id li Omborxona topilmadi", false);
        }

        Warehouse warehouse = warehouseOptional.get();
        warehouse.setName(warehouseDto.getName());
        warehouse.setActive(warehouseDto.isActive());

        warehouseRepository.save(warehouse);
        return new Result("Omborxona tahrirlandi", true);
    }

    public Result removeWarehouseService(Long id) {
        List<WarehouseUser> byWarehouseId = warehouseUserRepository.findByWarehouseId(id);

        warehouseUserRepository.deleteAll(byWarehouseId);

        for (WarehouseUser warehouseUser : byWarehouseId) {
            userRepository.deleteById(warehouseUser.getUser().getId());
        }

        warehouseRepository.deleteById(id);

        return new Result("Ombor o'chiridi", true);
    }


}
