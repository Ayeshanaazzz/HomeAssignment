package com.assignment.service.Impl;

import com.assignment.dto.ProductDTO;
import com.assignment.entity.Product;
import com.assignment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProductDTO> createProducts(List<ProductDTO> productDtoList) {
        List<ProductDTO> savedProductDtos = new ArrayList<>();
        for (ProductDTO productDto : productDtoList) {
            Product product = new Product();
            product.setProductId(productDto.getProductId());
            product.setCategory(productDto.getCategory());
            product.setBrand(productDto.getBrand());

            // Save the product
            product = productRepository.save(product);

            // Create ProductDTO from saved Product and add to list
            ProductDTO savedProductDto = new ProductDTO();
            savedProductDto.setProductId(product.getProductId());
            savedProductDto.setCategory(product.getCategory());
            savedProductDto.setBrand(product.getBrand());
            savedProductDtos.add(savedProductDto);
        }
        return savedProductDtos;
    }
}

//
//    @Autowired
//    public ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//
//    public List<ProductDTO> getProducts(GetProductsRequest request) {
//        Pageable pageable = PageRequest.of(0, request.getLimit(), Sort.by(Sort.Direction.DESC, "relevancyScore"));
//        List<Product> products;
//        if (request.getCategory() != null && request.getBrand() != null) {
//            products = productRepository.findByCategoryAndBrand(request.getCategory(), request.getBrand(), pageable);
//        } else if (request.getCategory() != null) {
//            products = productRepository.findByCategory(request.getCategory(), pageable);
//        } else if (request.getBrand() != null) {
//            products = productRepository.findByBrand(request.getBrand(), pageable);
//        } else {
//            products = productRepository.findAll(pageable).getContent();
//        }
//        return mapProductsToDTOs(products);
//    }

//    private List<ProductDTO> mapProductsToDTOs(List<Product> products) {
//        List<ProductDTO> productDTOs = new ArrayList<>();
//        for (Product product : products) {
//            ProductDTO productDTO = new ProductDTO();
//            productDTO.setProductId(product.getProductId());
//            productDTO.setCategory(product.getCategory());
//            productDTO.setBrand(product.getBrand());
//            productDTO.setRelevancyScore(product.getRelevancyScore());
//
//            productDTOs.add(productDTO);
//        }
//        return productDTOs;
//    }



