package net.nvsoftware.iProductService.controller;

import net.nvsoftware.iProductService.model.ProductRequest;
import net.nvsoftware.iProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping
    public ResponseEntity<Long> createProduct(@RequestBody ProductRequest productRequest){
        Long productId = productService.createProduct(productRequest);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }



}
