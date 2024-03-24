package com.assignment.controller;

import com.assignment.dto.ProductDTO;
import com.assignment.dto.ShelfItemDto;
import com.assignment.dto.ShopperDTO;
import com.assignment.entity.Product;
import com.assignment.entity.Shopper;
import com.assignment.service.Impl.ProductService;
import com.assignment.service.Impl.ShopperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/internal")
public class InternalController {

    @Autowired
    private ShopperService shopperService;
    @Autowired
    private ProductService productService;


    @PostMapping("/save/shoppers")
    public void saveShoppers(@RequestBody Map<String, Object> requestBody) {
        try {
            String shopperId = (String) requestBody.get("shopperId");
            List<Map<String, Object>> shelfItems = (List<Map<String, Object>>) requestBody.get("shelf");

            List<ShelfItemDto> shelfItemsDto = new ArrayList<>();
            for (Map<String, Object> shelfItem : shelfItems) {
                String productId = (String) shelfItem.get("product"); // Corrected key to "productId"
                Double relevancyScore = (Double) shelfItem.get("relevancyScore");
                // Create ShelfItemDto object and add it to the list
                shelfItemsDto.add(new ShelfItemDto(productId, relevancyScore));
            }

            shopperService.saveShopper(shopperId, shelfItemsDto);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid data format", e);
        }
    }


    @PostMapping("/products")
  public List<ProductDTO> createProducts(@RequestBody List<ProductDTO> productDtoList) {
        return productService.createProducts(productDtoList);
        }
}



