package uz.easy.app_warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.easy.app_warehouse.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByNameAndCategoryId(String name, Long category_id);

}
