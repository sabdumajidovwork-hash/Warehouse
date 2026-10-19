package uz.easy.app_warehouse.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.easy.app_warehouse.dto.ProductDto;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.service.ProductService;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public Result addProduct(@RequestBody ProductDto productDto) {
        return productService.addProductService(productDto);
    }

    @GetMapping
    public Result getProducts() {
        return productService.getProductsService();
    }

    @GetMapping("/{id}")
    public Result getProductById(@PathVariable Long id) {
        return productService.getProductByIdService(id);
    }

    @PatchMapping("/{id}")
    public Result updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return productService.updateProductService(id, productDto);
    }

    @DeleteMapping("/{id}")
    public Result removeProduct(@PathVariable Long id) {
        return productService.removeProductService(id);
    }
}
