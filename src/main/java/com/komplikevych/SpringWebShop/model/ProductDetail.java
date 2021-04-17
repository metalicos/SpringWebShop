package com.komplikevych.SpringWebShop.model;

import com.komplikevych.SpringWebShop.model.enums.Color;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class ProductDetail extends AbstractEntity {

    private String brand;

    private Double heightMm;
    private Double widthMm;
    private Double lengthMm;

    @Enumerated(EnumType.ORDINAL)
    private Color color;

    private String about;

    private Integer warrantyInDays;

    @OneToOne
    private Product product;

}
