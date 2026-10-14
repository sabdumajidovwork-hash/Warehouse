package uz.easy.app_warehouse.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.easy.app_warehouse.entity.template.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Currency extends AbsEntity {
}
