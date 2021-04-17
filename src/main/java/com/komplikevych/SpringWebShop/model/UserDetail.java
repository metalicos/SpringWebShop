package com.komplikevych.SpringWebShop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class UserDetail extends AbstractEntity {

    private String phone;
    private int zipCode;
    private String surname;
    private String firstName;
    private String patronymic;
    private String country;
    private String city;
    private String street;
    private String building;
    private String flat;
    private String userPhoto;

    @OneToOne
    private User user;
}
