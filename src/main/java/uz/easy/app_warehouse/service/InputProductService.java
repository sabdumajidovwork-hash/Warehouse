package uz.easy.app_warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.easy.app_warehouse.dto.InputProductDto;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.entity.Input;
import uz.easy.app_warehouse.entity.InputProduct;
import uz.easy.app_warehouse.entity.Product;
import uz.easy.app_warehouse.repository.InputProductRepository;
import uz.easy.app_warehouse.repository.InputRepository;
import uz.easy.app_warehouse.repository.ProductRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InputProductService {
    private final InputProductRepository inputProductRepository;
    private final ProductRepository productRepository;
    private final InputRepository inputRepository;

    public Result createInputProductService(InputProductDto dto) {
        Optional<Product> productOptional = productRepository.findById(dto.getProductId());
        Optional<Input> inputOptional = inputRepository.findById(dto.getInputId());

        if (!(productOptional.isPresent() && inputOptional.isPresent())) {
            return new Result(" 'Input' Product yaratishda xatolik", false);
        }

        InputProduct inputProduct = new InputProduct();

        inputProduct.setProduct(productOptional.get());
        inputProduct.setInput(inputOptional.get());
        inputProduct.setAmount(dto.getAmount());
        inputProduct.setPrice(dto.getPrice());
        inputProduct.setExpireDate(dto.getExpireDate());

        inputProductRepository.save(inputProduct);

        return new Result(" 'Input' Product yaratildi", true);

    }
}
