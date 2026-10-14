package uz.easy.app_warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.easy.app_warehouse.dto.ProductDto;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.entity.Attachment;
import uz.easy.app_warehouse.entity.Category;
import uz.easy.app_warehouse.entity.Measurement;
import uz.easy.app_warehouse.entity.Product;
import uz.easy.app_warehouse.repository.AttachmentRepository;
import uz.easy.app_warehouse.repository.CategoryRepository;
import uz.easy.app_warehouse.repository.MeasurementRepository;
import uz.easy.app_warehouse.repository.ProductRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final AttachmentRepository attachmentRepository;
    private final MeasurementRepository measurementRepository;


    public Result addProductService(ProductDto productDto) {
        boolean existsByNameAndCategoryId = productRepository.existsByNameAndCategoryId(productDto.getName(), productDto.getCategoryId());
        if (existsByNameAndCategoryId) {
            return new Result("Bunday mahsulot ushbu categoriyada bor", false);
        } else {
            Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
            if (!optionalCategory.isPresent()) {
                return new Result("Bunday categoriya mavjud emas", false);
            }

            Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
            if (!optionalAttachment.isPresent()) {
                return new Result("Bunday rasm mavjud emas", false);
            }

            Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDto.getMeasurementId());
            if (!optionalMeasurement.isPresent()) {
                return new Result("Bunday og'irlig birligi mavjud emas", false);
            }


            Product product = new Product();
            product.setName(productDto.getName());
            product.setCode("1"); ///TODO
            product.setCategory(optionalCategory.get());
            product.setPhoto(optionalAttachment.get());
            product.setMeasurement(optionalMeasurement.get());
            productRepository.save(product);
            return new Result("Mahsulot saqlandi", true);
        }
    }
}
