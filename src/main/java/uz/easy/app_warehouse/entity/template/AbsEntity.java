package uz.easy.app_warehouse.entity.template;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public class AbsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean active = true;

}
