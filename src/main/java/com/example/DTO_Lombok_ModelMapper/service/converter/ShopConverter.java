package com.example.DTO_Lombok_ModelMapper.service.converter;

import com.example.DTO_Lombok_ModelMapper.entity.Shop;
import com.example.DTO_Lombok_ModelMapper.entity.ShopDTO;
import org.springframework.stereotype.Service;

@Service
public class ShopConverter {
    public ShopDTO convertToDTO(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setId(shop.getId());
        shopDTO.setCity(shop.getCity());
        shopDTO.setStreet(shop.getStreet());
        shopDTO.setNameShop(shop.getNameShop());
        shopDTO.setHasWebsite(shop.isHasWebsite());

        return shopDTO;
    }

    public Shop convertToEntity(ShopDTO shopDTO) {
        Shop shop = new Shop();
        shop.setId(shopDTO.getId());
        shop.setCity(shopDTO.getCity());
        shop.setStreet(shopDTO.getStreet());
        shop.setNameShop(shopDTO.getNameShop());
        shop.setHasWebsite(shopDTO.isHasWebsite());

        return shop;
    }
}
