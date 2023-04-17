package com.example.DTO_Lombok_ModelMapper.entity;

import lombok.Data;

@Data
public class ShopDTO {
    private Long id;
    private String city;
    private String street;
    private String nameShop;
    private boolean hasWebsite;
}
