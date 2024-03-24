package com.assignment.controller;


import com.assignment.service.Impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/external")
public class ExternalController {
    private final ProductService productService;

    @Autowired
    public ExternalController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping("/products")
//    public ResponseEntity<GetProductsResponse> getProducts(@RequestParam String shopperId,
//                                                           @RequestParam(required = false) String category,
//                                                           @RequestParam(required = false) String brand,
//                                                           @RequestParam(defaultValue = "10") int limit) {
//        GetProductsRequest request = new GetProductsRequest();
//        request.setShopperId(shopperId);
//        request.setCategory(category);
//        request.setBrand(brand);
//        request.setLimit(limit);

//        List<ProductDTO> products = productService.getProducts(request);
//        GetProductsResponse response = new GetProductsResponse();
//        response.setProducts(products);
//        return ResponseEntity.ok(response);

}

