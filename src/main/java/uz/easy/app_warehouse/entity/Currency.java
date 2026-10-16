package uz.easy.app_warehouse.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.easy.app_warehouse.entity.template.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Currency extends AbsEntity {
}
