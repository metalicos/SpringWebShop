package com.komplikevych.SpringWebShop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Category extends AbstractEntity {
    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
