package com.example.DTO_Lombok_ModelMapper.service.impl;

import com.example.DTO_Lombok_ModelMapper.entity.Shop;
import com.example.DTO_Lombok_ModelMapper.entity.ShopDTO;
import com.example.DTO_Lombok_ModelMapper.repository.ShopRepository;
import com.example.DTO_Lombok_ModelMapper.service.ShopService;
import com.example.DTO_Lombok_ModelMapper.service.converter.ShopConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ShopConverter shopConverter;

    @Override
    public Shop addShop(ShopDTO shopDTO) {
        if (shopDTO == null) {
            throw new IllegalArgumentException("Магазин не може бути null");
        }
        return shopRepository.save(shopConverter.convertToEntity(shopDTO));
    }

    @Override
    public List<ShopDTO> findAllShop() {
        List<ShopDTO> shopDTOList = new ArrayList<>();
        shopRepository.findAll().forEach(shop -> shopDTOList.add(shopConverter.convertToDTO(shop)));
        return shopDTOList;
    }

    @Override
    public ShopDTO findShopById(Long id) {
        Shop shop = shopRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Магазину з id " + id + " не знайдено"));
        return shopConverter.convertToDTO(shop);
    }
}
