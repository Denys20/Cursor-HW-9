package com.example.DTO_Lombok_ModelMapper.web;

import com.example.DTO_Lombok_ModelMapper.entity.ShopDTO;
import com.example.DTO_Lombok_ModelMapper.service.impl.ShopServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shops")
public class ShopController {
    @Autowired
    private ShopServiceImpl shopService;

    @Autowired ObjectMapper objectMapper;

    @PostMapping
    public void createShop(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            BufferedReader reader = request.getReader();
            String shopJson = reader.lines().collect(Collectors.joining());
            ShopDTO shopDTO = objectMapper.readValue(shopJson, ShopDTO.class);
            shopService.addShop(shopDTO);
            response.setStatus(HttpStatus.CREATED.value());
            response.getWriter().write(shopJson);
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.getWriter().write(e.getMessage());
        }
    }

    @GetMapping
    public String findAllShop(HttpServletResponse response) throws IOException {
        try {
            List<ShopDTO> shopDTOList = shopService.findAllShop();
            response.setStatus(HttpStatus.OK.value());
            return objectMapper.writeValueAsString(shopDTOList);
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return e.getMessage();
        }
    }

    @GetMapping("/{id}")
    public String findShopById(@PathVariable Long id, HttpServletResponse response) throws IOException {
        try {
            ShopDTO shopById = shopService.findShopById(id);
            response.setStatus(HttpStatus.OK.value());
            return objectMapper.writeValueAsString(shopById);
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return e.getMessage();
        }
    }

}
