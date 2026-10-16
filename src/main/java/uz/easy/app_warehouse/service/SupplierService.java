package uz.easy.app_warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.dto.SupplierDto;
import uz.easy.app_warehouse.entity.Supplier;
import uz.easy.app_warehouse.repository.SupplierRepository;

import java.util.List;
import java.util.Optional;

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

    public Result getSuppliersService() {
        List<Supplier> supplierList = supplierRepository.findAll();

        if (supplierList.isEmpty()) return new Result("Yetkazib beruvchilar topilmadi", false);

        return new Result("Yetkazib beruvchilar ro'yxati", true, supplierList);

    }

    public Result getSupplierById(Long id) {

        Optional<Supplier> supplierOptional = supplierRepository.findById(id);

        if (supplierOptional.isEmpty()) return new Result("Bunday Yetkazib beruvchi topilmadi", false);

        return new Result("Yetkazib beruvchi topildi", true, supplierOptional.get());

    }

    public Result updateSupplierService(Long id, SupplierDto dto) {

        Optional<Supplier> supplierOptional = supplierRepository.findById(id);

        if (supplierOptional.isEmpty()) return new Result("Yetkazib beruchi topilmadi", false);

        Supplier supplier = supplierOptional.get();

        supplier.setActive(dto.isActive());
        supplier.setName(dto.getName());
        supplier.setPhoneNumber(dto.getPhoneNumber());

        supplierRepository.save(supplier);

        return new Result("Yetkazib beruvchi tahrirlandi", true);

    }

    public Result removeSupplierService(Long id) {
        boolean existsById = supplierRepository.existsById(id);

        if (!existsById) return new Result("Yetkazib beruvchi topilmadi", false);

        supplierRepository.deleteById(id);

        return new Result("Yetkazib beruvchi o'chirildi", true);

    }

}
