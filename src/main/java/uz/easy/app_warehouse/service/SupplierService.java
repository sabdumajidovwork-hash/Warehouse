package uz.easy.app_warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.dto.SupplierDto;
import uz.easy.app_warehouse.entity.Supplier;
import uz.easy.app_warehouse.repository.SupplierRepository;

@Service
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public Result createSupplierService(SupplierDto supplierDto) {
        if (supplierRepository.existsByPhoneNumber(supplierDto.getPhoneNumber())) {
            return new Result("Bunday telefon raqam bilan Yetkaziv beruvchi yaratilgan", false);
        } else {
            Supplier supplier = new Supplier();
            supplier.setName(supplierDto.getName());
            supplier.setPhoneNumber(supplierDto.getPhoneNumber());
            supplierRepository.save(supplier);
            return new Result("Yetkazib beruvchi yaratildi", true);
        }

    }

}
