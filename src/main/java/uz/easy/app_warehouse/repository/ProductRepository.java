package uz.easy.app_warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.easy.app_warehouse.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByNameAndCategoryId(String name, Long category_id);

}
