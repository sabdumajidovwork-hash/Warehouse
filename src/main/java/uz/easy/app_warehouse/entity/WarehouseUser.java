package uz.easy.app_warehouse.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class WarehouseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Warehouse warehouse;
}
