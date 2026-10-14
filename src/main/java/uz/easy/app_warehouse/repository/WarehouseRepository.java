package uz.easy.app_warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.easy.app_warehouse.entity.Warehouse;

import java.util.Set;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    long countByIdIn(Set<Long> ids);

    boolean existsByName(String name);

    default boolean existsAllById(Set<Long> ids) {
        return countByIdIn(ids) == ids.size();
    }
}
