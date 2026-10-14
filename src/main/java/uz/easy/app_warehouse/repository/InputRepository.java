package uz.easy.app_warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.easy.app_warehouse.entity.Input;

@Repository
public interface InputRepository extends JpaRepository<Input, Long> {

    boolean existsByCode(String code);

}
