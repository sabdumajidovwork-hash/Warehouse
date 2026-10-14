package uz.easy.app_warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.easy.app_warehouse.entity.Output;

@Repository
public interface OutputRepository extends JpaRepository<Output, Long> {

    boolean existsByCode(String code);

}
