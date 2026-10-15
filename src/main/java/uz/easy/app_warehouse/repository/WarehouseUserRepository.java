package uz.easy.app_warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.easy.app_warehouse.entity.WarehouseUser;

import java.util.List;

@Repository
public interface WarehouseUserRepository extends JpaRepository<WarehouseUser, Long> {

    List<WarehouseUser> findByWarehouseId(Long id);

    List<WarehouseUser> findByUserId(Long id);
}
