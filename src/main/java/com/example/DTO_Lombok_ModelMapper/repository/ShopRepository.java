package com.example.DTO_Lombok_ModelMapper.repository;

import com.example.DTO_Lombok_ModelMapper.entity.Shop;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends CrudRepository<Shop, Long> {
}
