package uz.easy.app_warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.easy.app_warehouse.entity.OutputProduct;

@Repository
public interface OutputProductRepository extends JpaRepository<OutputProduct, Long> {

}
