package net.nvsoftware.iProductService.service;

import net.nvsoftware.iProductService.model.ProductRequest;
import net.nvsoftware.iProductService.model.ProductResponse;

public interface ProductService {
    Long createProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);

    void reductQuantity(long productId, long quantity);
}
