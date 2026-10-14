package uz.easy.app_warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.easy.app_warehouse.dto.CategoryDto;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.entity.Category;
import uz.easy.app_warehouse.repository.CategoryRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Result addCategoryService(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        if (categoryDto.getParentCategoryId() != null) {
            Optional<Category> optional = categoryRepository.findById(categoryDto.getParentCategoryId());
            optional.ifPresent(category::setParentCategory);
            categoryRepository.save(category);
            return new Result("Categoriya qo'shildi", true);
        } else {
            return new Result("Bunday ota kategoriya mavjud emas", false);
        }
    }
}
