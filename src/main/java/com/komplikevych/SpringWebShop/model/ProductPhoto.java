package com.komplikevych.SpringWebShop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class ProductPhoto extends AbstractEntity {

    @ManyToOne
    private Product product;

    @Lob
    private String photo;
}
