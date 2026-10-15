package uz.easy.app_warehouse.entity;

import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import uz.easy.app_warehouse.entity.template.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@Entity
public class Measurement extends AbsEntity {
}
