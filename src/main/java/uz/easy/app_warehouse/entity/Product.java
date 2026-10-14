package uz.easy.app_warehouse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.easy.app_warehouse.entity.template.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends AbsEntity {


    @ManyToOne(optional = false)
    private Category category;

    @ManyToOne(optional = false)
    private Measurement measurement;

    private String code;

    @OneToOne
    private Attachment photo;

}
