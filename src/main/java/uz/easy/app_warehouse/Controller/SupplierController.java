package uz.easy.app_warehouse.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.dto.SupplierDto;
import uz.easy.app_warehouse.service.SupplierService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/supplier")
public class SupplierController {
    private final SupplierService supplierService;

    @PostMapping
    public Result createSupplier(@RequestBody SupplierDto supplierDto) {
        return supplierService.createSupplierService(supplierDto);
    }

    @GetMapping
    public Result getSuppliers() {
        return supplierService.getSuppliersService();
    }

    @GetMapping("/{id}")
    public Result getSupplierById(@PathVariable Long id) {
        return supplierService.getSupplierById(id);
    }

    @PutMapping("/{id}")
    public Result updateSupplier(@PathVariable Long id, @RequestBody SupplierDto supplierDto) {
        return supplierService.updateSupplierService(id, supplierDto);
    }

    @DeleteMapping("/{id}")
    public Result removeSupplier(@PathVariable Long id){
        return supplierService.removeSupplierService(id);
    }
}
