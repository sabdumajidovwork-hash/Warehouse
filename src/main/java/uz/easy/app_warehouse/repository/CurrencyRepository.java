package uz.easy.app_warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.easy.app_warehouse.entity.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency,Long> {
    boolean existsByName(String name);
}
