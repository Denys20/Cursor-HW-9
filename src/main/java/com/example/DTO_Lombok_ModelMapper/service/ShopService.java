package com.example.DTO_Lombok_ModelMapper.service;

import com.example.DTO_Lombok_ModelMapper.entity.Shop;
import com.example.DTO_Lombok_ModelMapper.entity.ShopDTO;

import java.util.List;

public interface ShopService {
    Shop addShop(ShopDTO shopDTO);

    List<ShopDTO> findAllShop();

    ShopDTO findShopById(Long id);
}
