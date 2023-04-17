package com.example.DTO_Lombok_ModelMapper.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String street;
    private String nameShop;
    private int numberEmployees;
    private boolean hasWebsite;
}
