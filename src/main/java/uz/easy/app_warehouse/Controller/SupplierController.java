package uz.easy.app_warehouse.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
