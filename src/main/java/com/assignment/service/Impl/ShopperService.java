package com.assignment.service.Impl;

import com.assignment.dto.ShelfItemDto;
import com.assignment.dto.ShopperDTO;
import com.assignment.entity.Product;
import com.assignment.entity.ShelfItem;
import com.assignment.entity.Shopper;
import com.assignment.repository.ProductRepository;
import com.assignment.repository.ShopperRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopperService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ShopperRepository shopperRepository;

    @Autowired
    private ProductRepository productRepository;

    public void saveShopper(String shopperId, List<ShelfItemDto> shelfItemsDto) {
        Shopper shopper = new Shopper();
        shopper.setShopperId(shopperId);

        List<ShelfItem> shelfItems = new ArrayList<>();
        for (ShelfItemDto shelfItemDto : shelfItemsDto) {
            ShelfItem shelfItem = new ShelfItem();
            // Retrieve the Product entity based on productId
            Product product = productRepository.findById(shelfItemDto.getProductId()).orElse(null);
            if (product == null) {
                // Handle case where Product does not exist
                // You can choose to skip or log this scenario
                continue;
            }
            shelfItem.setProduct(product);
            shelfItem.setRelevancyScore(shelfItemDto.getRelevancyScore());
            shelfItem.setShopper(shopper); // Set the relationship with the shopper
            shelfItems.add(shelfItem);
        }
        shopper.setShelf(shelfItems); // Set the shelf items for the shopper

        shopperRepository.save(shopper);
    }
}
//    private final ShopperRepository shopperRepository;
//
//
//    @Autowired
//    public ShopperService(ShopperRepository shopperRepository) {
//        this.shopperRepository = shopperRepository;
//
//    }

//    public void saveShopperProducts(ShopperProductDTO shopperProductDTO) {
//        Shopper shopper = new Shopper();
//        shopper.setShopperId(shopperProductDTO.getShopperId());
//
//        List<ShopperProduct> shelf = new ArrayList<>();
//        for (ShopperProductDTO productDTO : shopperProductDTO.getShelf()) {
//            ShopperProduct shopperProduct = new ShopperProduct();
//            shopperProduct.setProductId(productDTO.getProductId());
//            shopperProduct.setRelevancyScore(productDTO.getRelevancyScore());
//            shelf.add(shopperProduct);
//        }
//        shopper.setShelf(shelf);
//
//        shopperRepository.save(shopper);
//    }





