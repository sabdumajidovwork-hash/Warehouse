package uz.easy.app_warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.easy.app_warehouse.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    boolean existsByPhoneNumber(String phoneNumber);

}
