package com.komplikevych.SpringWebShop.model;

import com.komplikevych.SpringWebShop.model.enums.Color;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 500)
    private String brand;

    @Enumerated(EnumType.ORDINAL)
    private Color color;

    @Column(length = 5000)
    private String about;

    @OneToOne
    private Product product;

}
