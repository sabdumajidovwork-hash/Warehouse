package uz.easy.app_warehouse.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.easy.app_warehouse.dto.CategoryDto;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.service.CategoryService;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public Result addCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.addCategoryService(categoryDto);
    }

    @GetMapping
    public Result getCategories() {
        return categoryService.getCategoriesService();
    }

    @GetMapping("/{id}")
    public Result getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryByIdService(id);
    }

    @PutMapping("/{id}")
    public Result updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        return categoryService.updateCategoryService(id, categoryDto);
    }

    @DeleteMapping("/{id}")
    public  Result removeCategory(@PathVariable Long id){
        return  categoryService.removeCategoryService(id);
    }
}
