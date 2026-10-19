package uz.easy.app_warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.easy.app_warehouse.dto.CategoryDto;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.entity.Category;
import uz.easy.app_warehouse.repository.CategoryRepository;

import java.util.List;
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
            categoryRepository.save(category);
            return new Result("Category yaratildi. Ota kategoriya mavjud emas", true);
        }
    }

    public Result getCategoriesService() {
        List<Category> categoryList = categoryRepository.findAll();

        if (categoryList.isEmpty()) return new Result("Categorylar topilmadi", false);

        return new Result("Categorylar ro'yxati", true, categoryList);
    }

    public Result getCategoryByIdService(Long id) {

        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isEmpty()) return new Result("Kategoriya topilmadi", false);

        return new Result("Kategoriya topildi", true, categoryOptional.get());

    }

    public Result updateCategoryService(Long id, CategoryDto dto) {

        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isEmpty()) return new Result("Kategoriya topilmadi", false);
        if (dto.getParentCategoryId() != null) {
            Optional<Category> parentCategoryOptional = categoryRepository.findById(dto.getParentCategoryId());
            if (parentCategoryOptional.isPresent()) {
                Category category = categoryOptional.get();
                category.setName(dto.getName());
                category.setActive(dto.isActivate());
                category.setParentCategory(parentCategoryOptional.get());
                categoryRepository.save(category);
                return new Result("Kategoriya tahrirlandi", true);
            }
        }

        Category category = categoryOptional.get();
        category.setName(dto.getName());
        category.setActive(dto.isActivate());
        categoryRepository.save(category);


        return new Result("Kategoriya tahrirlandi", true);


    }

    public Result removeCategoryService(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);              // ✅ bitta so'rov yetarli (existsById olib tashlandi)
        if (categoryOptional.isEmpty())
            return new Result("Kategoriya topilmadi", false);   // ✅ Optional orqali tekshirish

        recursiveDelete(categoryOptional.get());                                            // ✅ eski kommentlar tozalandi
        return new Result("Kategoriya o'chirildi", true);
    }

    private void recursiveDelete(Category category) {
        List<Category> children = categoryRepository.findByParentCategoryId(category.getId());
        for (Category child : children) {
            recursiveDelete(child);
        }
        categoryRepository.delete(category);
    }
}
