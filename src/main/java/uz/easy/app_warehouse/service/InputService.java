package uz.easy.app_warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.easy.app_warehouse.dto.InputDto;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.entity.Currency;
import uz.easy.app_warehouse.entity.Input;
import uz.easy.app_warehouse.entity.Supplier;
import uz.easy.app_warehouse.entity.Warehouse;
import uz.easy.app_warehouse.repository.CurrencyRepository;
import uz.easy.app_warehouse.repository.InputRepository;
import uz.easy.app_warehouse.repository.SupplierRepository;
import uz.easy.app_warehouse.repository.WarehouseRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InputService {
    private final InputRepository inputRepository;
    private final WarehouseRepository warehouseRepository;
    private final SupplierRepository supplierRepository;
    private final CurrencyRepository currencyRepository;

    public Result createInputService(InputDto dto) {
        boolean existsByCode = inputRepository.existsByCode(dto.getCode());
        Optional<Warehouse> warehouseOptional = warehouseRepository.findById(dto.getWarehouseId());
        Optional<Supplier> supplierOptional = supplierRepository.findById(dto.getSupplierId());
        Optional<Currency> currencyOptional = currencyRepository.findById(dto.getCurrencyId());
        if (existsByCode) {
            return new Result("Bunday code bilan 'Input' yaratilgan", false);
        }
        if (!(warehouseOptional.isPresent() && supplierOptional.isPresent() && currencyOptional.isPresent())) {
            return new Result("'Input' yaratishda xatolik", false);
        }
        Input input = new Input();
        input.setDate(dto.getDate());
        input.setCode(dto.getCode());
        input.setFacture_number(dto.getFactureNumber());
        input.setWarehouse(warehouseOptional.get());
        input.setSupplier(supplierOptional.get());
        input.setCurrency(currencyOptional.get());

        inputRepository.save(input);
        return new Result("'Input' yaratildi", true);
    }

}
