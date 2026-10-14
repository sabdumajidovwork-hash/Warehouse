package uz.easy.app_warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.easy.app_warehouse.dto.OutputProductDto;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.entity.Output;
import uz.easy.app_warehouse.entity.OutputProduct;
import uz.easy.app_warehouse.entity.Product;
import uz.easy.app_warehouse.repository.OutputProductRepository;
import uz.easy.app_warehouse.repository.OutputRepository;
import uz.easy.app_warehouse.repository.ProductRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OutputProductService {
    private final OutputProductRepository outputProductRepository;
    private final ProductRepository productRepository;
    private final OutputRepository outputRepository;

    public Result createOutputProductService(OutputProductDto dto) {
        Optional<Product> productOptional = productRepository.findById(dto.getProductId());
        Optional<Output> outputOptional = outputRepository.findById(dto.getOutputId());

        if (productOptional.isEmpty()) {
            return new Result("Product topilmadi", false);
        }
        if (outputOptional.isEmpty()) {
            return new Result("Chiqim topilmadi", false);
        }

        OutputProduct outputProduct = new OutputProduct();

        outputProduct.setProduct(productOptional.get());
        outputProduct.setOutput(outputOptional.get());
        outputProduct.setAmount(dto.getAmount());
        outputProduct.setPrice(dto.getPrice());

        outputProductRepository.save(outputProduct);

        return new Result("Chiqim mahsuloti yaratildi", true);

    }
}
