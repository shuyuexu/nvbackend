package net.nvsoftware.iProductService.service;

import net.nvsoftware.iProductService.model.ProductRequest;

public interface ProductService {
    Long createProduct(ProductRequest productRequest);
}
